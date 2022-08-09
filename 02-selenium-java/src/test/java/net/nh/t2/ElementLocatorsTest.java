package net.nh.t2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ElementLocatorsTest {

    private static WebDriver webDriver;

    @BeforeAll
    static void setupWebDriver() {
        System.setProperty("webdriver.gecko.driver", "/Users/ukcco1nha/Projects/selenium-drivers/geckodriver");
        webDriver = new FirefoxDriver();
    }

    @AfterEach
    void stopWebDriver() {
        webDriver.quit();
    }

    /**
     * Illustrates how to find and interact with form elements. For a full list of locator types, refer to README.md.
     */
    @Test
    void verifyValidFormSubmission() {
        webDriver.get("https://automationintesting.online");

        // this uses a css selector, and is required to open the booking form webpage
        webDriver.findElement(By.cssSelector("#collapseBanner > div > div:nth-child(3) > div.col-2.text-center > button")).click();

        // this finds an anchor element (<a>) by the text it displays
        var findByLinkTestResult = webDriver.findElements(By.linkText("Mark Winteringham"));
        assertEquals(1, findByLinkTestResult.size());

        // this finds a heading element, using an xpath selector:
        var elementByXPath = webDriver.findElement(By.xpath("/html/body/div/div/div/div[4]/div/div/div[3]/h3"));
        System.out.println(elementByXPath.getText());

        // this finds form components and enters form data, using the id of the components
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


