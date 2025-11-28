package com.thetestingacademy.tests.vwo.pageObjectModelTC;

import com.thetestingacademy.pages.pageObjectModel.vwo.DashboardPage;
import com.thetestingacademy.pages.pageObjectModel.vwo.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class TestVWOLogin_01_Normal_POM {

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
        String error_msg = loginPage.loginToVWOInvalidCredentials("admin@admin.com","123");

        //Assertions-3 - V
        assertThat(error_msg).isNotNull().isNotBlank().isNotEmpty();
        Assert.assertEquals(error_msg, "Your email, password, IP address or location did not match");

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
        loginPage.loginToVWOValidCredentials("hebiva477@amcret.com", "Test@4321");

        DashboardPage dashboardPage = new DashboardPage(driver);
        String userNameLoggedIn = dashboardPage.dashBoardName();

        assertThat(userNameLoggedIn).isNotNull().isNotBlank().isNotEmpty();
        Assert.assertEquals(userNameLoggedIn,"Amcret");

        driver.quit();
    }


}
