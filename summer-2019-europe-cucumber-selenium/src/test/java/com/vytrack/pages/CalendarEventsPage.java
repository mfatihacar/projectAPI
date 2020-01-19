package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class CalendarEventsPage extends BasePage {
    public CalendarEventsPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "[title='Create Calendar event']")
    public WebElement createCalendarEvent;

    @FindBy(xpath = "//*[text()='Testers meeting']/../td/div/div/a")
    public WebElement testersMeetingThreeDots;

    @FindBy(xpath = "//*[text()='Testers meeting']/../td/div/div/ul/li/ul/li/a[@title='View']")
    public WebElement viewOption;

    @FindBy(xpath = "//*[text()='Testers meeting']/../td/div/div/ul/li/ul/li/a[@title='Edit']")
    public WebElement editOption;

    @FindBy(xpath = "//body//tr[2]//ul/li/ul/li/a[@title='Delete']")
    public WebElement deleteOption;

    @FindBy(xpath = "//a[@title='Grid Settings']")
    public WebElement gridSettingsButton;

    @FindBy(xpath = "//tbody/tr/td[3]/input")
    public List<WebElement> gridSettingsCheckboxes;

    @FindBy(xpath = "//thead/tr/th/a/span[.='Title']")
    public WebElement titleColumnHead;





}
