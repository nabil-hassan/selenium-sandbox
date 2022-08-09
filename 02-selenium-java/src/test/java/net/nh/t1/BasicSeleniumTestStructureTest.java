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
        // close the browser and all windows - you can comment this statement out if you wish the browser to stay open after the test
        webDriver.quit();
    }

    // ====================================================================================================
    //                                     TEST EXECUTION
    // ====================================================================================================
    @Test
    void openPageAndCheckTitle() {
        // the get method opens a new browser window
        webDriver.get("https://automationintesting.online");

        System.out.println(webDriver.getTitle());
    }
}
