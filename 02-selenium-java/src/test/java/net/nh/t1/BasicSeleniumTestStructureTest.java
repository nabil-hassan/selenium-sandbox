package net.nh.t1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * Demonstrates the fundamentals of a Selenium test.
 */
class BasicSeleniumTestStructureTest {

    // ====================================================================================================
    //                              BASIC OUTLINE OF STEPS
    // ====================================================================================================

    // Set the path to the driver of the browser you wish to use (see README.md for help)

    // Instantiate new driver instance

    // Open the webpage by specifying the base url

    // Find element and potentially enter input

    // Make assertions e.g. element is present/not present, and element has/does not have value

    // After all tests complete, close the driver

    // ====================================================================================================
    //                                     TEST SETUP AND TEARDOWN
    // ====================================================================================================
    private static WebDriver webDriver;

    @BeforeAll
    static void setupWebDriver() {
        System.setProperty("webdriver.gecko.driver", "/Users/ukcco1nha/Projects/selenium-drivers/geckodriver");

        // this will create a headless driver
        //... var firefoxOptions = new FirefoxOptions().setHeadless(true);
        //... webDriver = new FirefoxDriver(firefoxOptions);

        webDriver = new FirefoxDriver();
    }

    @AfterEach
    void stopWebDriver() {
        // close the browser and all windows - you can comment this out if you wish the browser to stay open so you can see what happened
//        webDriver.quit();
    }

    // ====================================================================================================
    //                                     TEST EXECUTION
    // ====================================================================================================
    @Test
    void openPageAndCheckTitle() {
        // the get method opens a new browser window
        webDriver.get("https://automationintesting.online");

        // the web page under test requires you to click a button to access the initial booking form
        webDriver.findElement(By.cssSelector("#collapseBanner > div > div:nth-child(3) > div.col-2.text-center > button")).click();

        // enter form data
        webDriver.findElement(By.id("name")).sendKeys("Nabil Hassan");
        webDriver.findElement(By.id("email")).sendKeys("nabil.hassan@faker.com");
        webDriver.findElement(By.id("phone")).sendKeys("07909909909");
        webDriver.findElement(By.id("subject")).sendKeys("Let me go");
        webDriver.findElement(By.id("description")).sendKeys("I would like to use this form in a Selenium test");

        // submit the form
        webDriver.findElement(By.id("submitContact")).click();

        // verify we got a message that indicates we were successful in our booking
        var successMessageLookup = webDriver.findElements(By.cssSelector("div.col-sm-5:nth-child(2) > div:nth-child(1) > h2:nth-child(1)"));
        assertFalse(successMessageLookup.isEmpty(), "Unable to find confirmation message.");
        assertEquals(1, successMessageLookup.size(), "More than one elements found using confirmation message CSS selector");
        assertEquals("Thanks for getting in touch Nabil Hassan!", successMessageLookup.get(0).getText());
    }

}
