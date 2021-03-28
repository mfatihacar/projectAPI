package com.sky.step_definitions;

import com.google.gson.Gson;
import com.sky.URLHelper;
import com.sky.dto.articles.Request.ArticleRequest;
import com.sky.dto.articles.response.ArticleResponse;
import com.sky.utilities.Requests;
import com.sky.utilities.SharedObjects;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.assertj.core.util.Lists;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ArticlesStepDefinitions {

    @When("I get articles from the articles service")
    public void iGetArticlesFromTheArticlesService() {
        SharedObjects.response = Requests.getRequest(URLHelper.ARTICLES_SERVICE);
    }

    @Then("the response code is {int}")
    public void theResponseCodeIs(int expectedResponseCode) {
        assertThat(SharedObjects.response.statusCode()).isEqualTo(expectedResponseCode);
    }

    @Then("multiple articles are returned from the articles service")
    public void multipleArticlesAreReturnedFromTheArticlesService() {
        ArticleResponse[] articleResponses = this.articleResponses();
        assertThat(articleResponses.length).isGreaterThan(1);
    }

    @Then("all articles have a unique id")
    public void allArticlesHaveAUniqueId() {
        List<String> ids = Lists.newArrayList();
        ArticleResponse[] articleResponses = this.articleResponses();
        for (ArticleResponse articleResponse : articleResponses) {
            assertThat(articleResponse.getId()).isNotNull();
            assertThat(ids).doesNotContain(articleResponse.getId());
            ids.add(articleResponse.getId());
        }
    }

    @When("I get article {string} from the articles service")
    public void iGetArticleFromTheArticlesService(String articleId) {
        SharedObjects.response = Requests.getRequest(URLHelper.ARTICLES_SERVICE + "/" + articleId);
    }

    @Then("the article id matches the {string}")
    public void theArticleIdMatchesThe(String expectedArticleId) {
        assertThat(this.articleResponse().getId()).isEqualTo(expectedArticleId);
    }

    @Then("the article details are returned from the articles service")
    public void theArticleDetailsAreReturnedFromTheArticlesService() {
        ArticleResponse articleResponse = this.articleResponse();
        assertThat(articleResponse.getId()).isNotNull();
        assertThat(articleResponse.getSensitive() || !articleResponse.getSensitive()).isTrue();
        assertThat(articleResponse.getTopics()).isNotNull();
    }

    @When("I create a new article")
    public void iCreateANewArticle() {
        String body = new Gson().toJson(ArticleRequest.newInstance("6", "2021-01-27T13:09:32.347Z", "new title", false, null, null, 40));
        SharedObjects.alternativeResponse = Requests.postRequest(URLHelper.ARTICLES_SERVICE, body);
    }

    private ArticleResponse[] articleResponses() {
        return new Gson().fromJson(SharedObjects.response.getBody().asString(), ArticleResponse[].class);
    }

    private ArticleResponse articleResponse() {
        return new Gson().fromJson(SharedObjects.response.getBody().asString(), ArticleResponse.class);
    }

    @Then("the response code for the alternative request is {int}")
    public void theResponseCodeForTheAlternativeRequestIs(int expectedResponseCode) {
        assertThat(SharedObjects.alternativeResponse.statusCode()).isEqualTo(expectedResponseCode);
    }

    @Given("I have the total number of articles")
    public void iHaveTheTotalNumberOfArticles() {
        this.iGetArticlesFromTheArticlesService();
        ArticleResponse[] articleResponses = this.articleResponses();
        SharedObjects.numberOfArticles = articleResponses().length;
    }

    @When("I delete article {string}")
    public void iDeleteArticle(String articleId) {
        SharedObjects.alternativeResponse = Requests.deleteRequest(URLHelper.ARTICLES_SERVICE + "/" + articleId);
    }

    @Then("the total number of articles has not changed")
    public void theTotalNumberOfArticlesHasNotChanged() {
        Response response = Requests.getRequest(URLHelper.ARTICLES_SERVICE);
        ArticleResponse[] finalArticleResponse = new Gson().fromJson(response.getBody().asString(), ArticleResponse[].class);
        assertThat(finalArticleResponse.length).isEqualTo(SharedObjects.numberOfArticles);
    }
}
