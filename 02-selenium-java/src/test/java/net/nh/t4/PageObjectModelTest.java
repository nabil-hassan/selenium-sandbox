package net.nh.t4;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * Illustrates how to implement the Page Object Model pattern in your Selenium tests.
 * </p>
 * This design pattern recommends that areas of interaction should be modelled as separate Java classes e.g. user login, shopping cart.
 * </p>
 * The POM classes should NOT make any assertions or verifications, but instead surface any data that might be used for these purposes,
 * via public methods.
 * </p>
 * In this example, we have separate POM classes for user login and  the booking form.
 */
public class PageObjectModelTest {

    private static LoginForm loginForm;
    private static BookingForm bookingForm;

    @BeforeAll
    static void beforeAll() {
        System.setProperty("webdriver.gecko.driver", "/Users/ukcco1nha/Projects/selenium-drivers/geckodriver");
        WebDriver webDriver = new FirefoxDriver();
        loginForm = new LoginForm(webDriver);
        bookingForm = new BookingForm(webDriver);
    }

    @AfterEach
    void tearDown() {
//        webDriver.quit();
    }

    @Test
    void verifySuccessfulFormSubmission() {
        loginForm.loginUser();

        bookingForm.enterName("Nabil Hassan");
        bookingForm.enterEmail("nabil.hassan@faker.com");
        bookingForm.enterPhone("07909909909");
        bookingForm.enterSubject("Let me go");
        bookingForm.enterDescription("I would like to use this form in a Selenium test");

        bookingForm.submitForm();

        var successMessageLookup = bookingForm.findSuccessMessageElements();
        assertFalse(successMessageLookup.isEmpty(), "Unable to find confirmation message.");
        assertEquals(1, successMessageLookup.size(), "More than one elements found using confirmation message CSS selector");
        assertEquals("Thanks for getting in touch Nabil Hassan!", successMessageLookup.get(0).getText());
    }
}
