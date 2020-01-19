package com.vytrack.pages;


import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class CreateCalendarEventsPage extends BasePage {

    public CreateCalendarEventsPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "[id^='recurrence-repeat-view']")
    public WebElement repeat;

    @FindBy(css = "[id^='recurrence-repeats-view']")
    public WebElement repeatOptions;

    @FindBy(className = "select2-chosen")
    public WebElement selectedOwner;

    @FindBy(css = "input[id^='oro_calendar_event_form_title-']")
    public WebElement title;

    @FindBy(css = "[id^='date_selector_oro_calendar_event_form_start']")
    public WebElement startDate;

    @FindBy(css = "[id^='date_selector_oro_calendar_event_form_end']")
    public WebElement endDate;

    @FindBy(css = "[id^='time_selector_oro_calendar_event_form_start']")
    public WebElement startTime;

    @FindBy(css = "[id^='time_selector_oro_calendar_event_form_end']")
    public WebElement endTime;

    @FindBy(xpath = "//*[@data-name='recurrence-daily']/div/div/div[2]/div[1]/label/input[1]")
    public WebElement days;

    @FindBy(xpath = "(//input[@type='radio'])[2]")
    public WebElement weekday;

    @FindBy(xpath = "(//input[@type='radio'])[3]")
    public WebElement never;

    @FindBy(xpath = "(//input[@type='radio'])[4]")
    public WebElement after;

    @FindBy(xpath = "(//input[@type='radio'])[5]")
    public WebElement by;

    @FindBy(xpath = "//div/button[@type='submit']/following-sibling::a")
    public WebElement saveAndCloseDropdown;

    @FindBy(xpath = "//div/button[@type='submit']/following-sibling::ul/li")
    public List<WebElement> saveAndCloseOptions;

    @FindBy(xpath = "//a[@title='Cancel']")
    public WebElement cancelButton;

    @FindBy(xpath = "//input[@class='input-small timepicker-input start ui-timepicker-input']/preceding-sibling::span/input")
    public WebElement startTimeValue;

    @FindBy(xpath = "//input[@class='input-small timepicker-input end ui-timepicker-input']/preceding-sibling::span/input")
    public WebElement endTimeValue;

    @FindBy(xpath = "//div/ul[@class='ui-timepicker-list']/li[43]")
    public WebElement ninePM;

    @FindBy(xpath = "//body/div[8]/ul/li[.='10:00 PM']")
    public WebElement tenPM;

    @FindBy(xpath = "//*[@data-name='field__all-day']")
    public WebElement allDayEvent;

    @FindBy(xpath = "(//input[@type='radio'])[3]/parent::*/parent::*/parent::*/parent::*/div/label")
    public WebElement endsRadio;

    @FindBy(xpath = "//*[@data-name='recurrence-summary']/div/span")
    public WebElement summaryMessage;

    @FindBy(xpath = "//*[@data-name='recurrence-summary']/parent::*/div/label")
    public WebElement summary;

    public Select repeatOptionsList(){
        return new Select(repeatOptions);
    }


}
