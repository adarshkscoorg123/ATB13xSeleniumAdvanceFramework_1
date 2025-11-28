package com.thetestingacademy.pages.pageObjectModel.vwo;

import com.thetestingacademy.utils.PropertiesReader;
import com.thetestingacademy.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    // Page Class
    WebDriver driver;

    // Step 0-Parametrized constructor
   public LoginPage(WebDriver driver) {
      this.driver = driver;
   }

    //input[@id="login-username"]
    //name="password"
    //button[@id="js-login-btn"]
    //id="js-notification-box-msg"
    //button[contains(text(),"Sign in using SSO")]

    // Step 1 - Page locators
   private By userName = By.xpath("//input[@id=\"login-username\"]");
   private By password = By.name("password");
   private By SignIn   = By.xpath("//button[@id=\"js-login-btn\"]");
   private By error_message = By.id("js-notification-box-msg");
   private By ssoLogin = By.xpath("//button[contains(text(),\"Sign in using SSO\")]");

   // Step 2 - Page Actions
   public String loginToVWOInvalidCredentials(String user, String pwd){
      driver.get(PropertiesReader.readKey("url"));
      driver.findElement(userName).sendKeys(user);
      driver.findElement(password).sendKeys(pwd);
      driver.findElement(SignIn).click();

      WaitHelpers.checkVisibility(driver,error_message);

      String error_message_text = driver.findElement(error_message).getText();
      return error_message_text;

   }

   public void loginToVWOValidCredentials(String user, String pwd) throws InterruptedException {
      driver.get(PropertiesReader.readKey("url"));
      driver.manage().window().maximize();
      driver.findElement(userName).sendKeys(user);
      driver.findElement(password).sendKeys(pwd);
      driver.findElement(SignIn).click();
      WaitHelpers.waitJVM(5000);
   }


}
