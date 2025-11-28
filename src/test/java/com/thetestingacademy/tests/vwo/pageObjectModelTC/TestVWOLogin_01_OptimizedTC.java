package com.thetestingacademy.tests.vwo.pageObjectModelTC;

import com.thetestingacademy.pages.pageObjectModel.vwo.DashboardPage;
import com.thetestingacademy.pages.pageObjectModel.vwo.LoginPage;
import com.thetestingacademy.utils.PropertiesReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestVWOLogin_01_OptimizedTC {

    // D - Driver
    // L - Locators
    // V - Validation


    @Owner("Adarsh")
    @Description("Verify that with invalid email, password, error message is displayed")
    @Test
    public void test_negative_vwo_login(){

        //Driver manager code-1 - D
        WebDriver driver = new ChromeDriver();

        //Page Class Code(POM Code)-2 - L
        LoginPage loginPage = new LoginPage(driver);
        String error_msg = loginPage.loginToVWOInvalidCredentials
                (PropertiesReader.readKey("invalid_username"),PropertiesReader.readKey("invalid_password"));

        //Assertions-3 - V
        assertThat(error_msg).isNotNull().isNotBlank().isNotEmpty();
        Assert.assertEquals(error_msg, PropertiesReader.readKey("error_message"));

        driver.quit();
    }

    @Owner("Adarsh")
    @Description("Verify that with valid email, password, dashboard page is displayed")
    @Test
    public void test_login_positive_vwo() throws InterruptedException {

        //Driver manager code-1 - D
        WebDriver driver = new ChromeDriver();

        //Page Class Code(POM Code)-2 - L
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToVWOValidCredentials(PropertiesReader.readKey("username"), PropertiesReader.readKey("password"));


        DashboardPage dashboardPage = new DashboardPage(driver);
        String userNameLoggedIn = dashboardPage.dashBoardName();

        assertThat(userNameLoggedIn).isNotNull().isNotBlank().isNotEmpty();
        Assert.assertEquals(userNameLoggedIn,PropertiesReader.readKey("expected_username"));


        driver.quit();
    }


}
