package net.nh.t3;

import net.nh.constants.PageUrl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Illustrates how to interact with a variety of HTML elements, including text boxes, buttons, radio groups, and combo boxes.
 */
class InteractingWithPageTest {

    private static WebDriver webDriver;

    @BeforeAll
    static void initialise() {
        System.setProperty("webdriver.gecko.driver", "/Users/ukcco1nha/Projects/selenium-drivers/geckodriver");
        webDriver = new FirefoxDriver();
    }

    @AfterEach
    void closeWebdriver() {
        // purposefully commented out to allow you to visualise
//        webDriver.quit();
    }

    @Test
    void name() {
        webDriver.get(PageUrl.INTERACTING_WITH_PAGE_URL);

        // use send keys to enter text into an input box
        webDriver.findElement(By.id("nameTxt")).sendKeys("Nabil");

        // radio buttons with the same value for the name attribute are bound to radio button group
        //  - in the best case scenario, the radio button has an id and can be selected directly
        webDriver.findElement(By.id("genderFemale")).click();
        //  - if not, we can access it using a css selector based on the radio button group name and radio button value
        webDriver.findElement(By.cssSelector("input[name='gender'][value='Male']")).click();

        // for dropdown lists, we must wrap the element in a new Select object and call selectByVisibleText()
        new Select(webDriver.findElement(By.id("professionCbx"))).selectByVisibleText("Policeman");

        // for checkboxes, select by id (or css selector)
        webDriver.findElement(By.id("smsCbx")).click();
        webDriver.findElement(By.id("emailCbx")).click();

        // submit the form and validate the outcome
        webDriver.findElement(By.id("submitBtn")).click();
        assertEquals("You are a Male, named Nabil and you are a Policeman", webDriver.findElement(By.id("submitMessage")).getText());
    }
}
