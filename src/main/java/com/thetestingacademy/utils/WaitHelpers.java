package com.thetestingacademy.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

public class WaitHelpers {

    // JVM wait-Thread.sleep
        public static void waitJVM(int time) {

            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        // Implicit Wait
        public static void waitImplicitWait(WebDriver driver, int time) {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
        }

        // Explicit Waits( Below are the different conditions for explicit waits

        //1.checkVisibility with time variable
        public static void checkVisibility(WebDriver driver, By locator, int time) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        }

        //2.checkVisibility without time variable
        public static void checkVisibility(WebDriver driver, By locator) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        }

        //3.checkVisibility of element and text to be present in Element
        public static void checkVisibilityofAndTextToBePresentInElement(WebDriver driver, WebElement element) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
            wait.until(ExpectedConditions.visibilityOf(element));
            wait.until(ExpectedConditions.textToBePresentInElement(element, "Your email, password, IP address or location did not match"));
        }

        //4.checkVisibility with time and xpath
        public static void waitForVisibility(WebDriver driver, String xpath, int time) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        }


        // FluentWait

        public static void waitFluentVisibility(WebDriver driver, int pollingTime, int time, String classname) {
            FluentWait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(time))
                    .pollingEvery(Duration.ofSeconds(pollingTime)).ignoring(NoSuchElementException.class);

            WebElement error_message = wait.until(new Function<WebDriver, WebElement>() {
                @Override
                public WebElement apply(WebDriver driver) {
                    return driver.findElement(By.className(classname));
                }
            });

        }

    }

