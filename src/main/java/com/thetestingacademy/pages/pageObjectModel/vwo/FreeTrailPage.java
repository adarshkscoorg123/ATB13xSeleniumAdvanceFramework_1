package com.thetestingacademy.pages.pageObjectModel.vwo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FreeTrailPage {

    WebDriver driver;

    public FreeTrailPage(WebDriver driver) {
        this.driver = driver;
    }

    //input[@id="page-v1-step1-email"]

    private By email_input =  By.id("page-v1-step1-email");
    private By checkBox = By.id("page-free-trial-step1-cu-gdpr-consent-checkbox");
    private By subButton = By.xpath("//button[text()=\"Create a Free Trial Account\"]");
    private By error_message_xpath = By.xpath("//div[contains(@class,\"invalid-reason\")]");


    public String enterDetailsInvalid(String email){

        driver.get("https://vwo.com/free-trial");
        driver.findElement(email_input).sendKeys(email);
        driver.findElement(checkBox).click();
        driver.findElement(subButton).click();
        String error_message = driver.findElement(error_message_xpath).getText();
        return error_message;

    }

    public void enterDetailsValid(String email){
        driver.get("https://vwo.com/free-trial");
        driver.findElement(email_input).sendKeys(email);
        driver.findElement(checkBox).click();
        driver.findElement(subButton).click();

    }
    
}
