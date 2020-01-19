package com.vytrack.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //to show cucumber the data to create the json report file after each test
        plugin = {"json:target/cucumber.json"},
        //to tell the runner file where my feature files are located
        features = "src/test/resources/features/",
        //to show the runner where the step definitions are located
        glue = "com/vytrack/step_definitions/",
        //to check if there are any undefined steps
        dryRun = false,
        //to run a certain TAGGED test scenario
        tags = "@wip"
)
public class CukesRunner {

}
