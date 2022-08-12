package net.nh.t4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * POM class to represent interactions with the booking form.
 */
public class BookingForm {

    private final WebDriver webDriver;

    public BookingForm(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void enterName(String name) {
        webDriver.findElement(By.id("name")).sendKeys("Nabil Hassan");
    }

    public void enterEmail(String email) {
        webDriver.findElement(By.id("email")).sendKeys("nabil.hassan@faker.com");
    }

    public void enterPhone(String phone) {
        webDriver.findElement(By.id("phone")).sendKeys("07909909909");
    }

    public void enterSubject(String subject) {
        webDriver.findElement(By.id("subject")).sendKeys("Let me go");
    }

    public void enterDescription(String description) {
        webDriver.findElement(By.id("description")).sendKeys("I would like to use this form in a Selenium test");
    }

    public void submitForm() {
        webDriver.findElement(By.id("submitContact")).click();
    }

    public List<WebElement> findSuccessMessageElements() {
        return webDriver.findElements(By.cssSelector("div.col-sm-5:nth-child(2) > div:nth-child(1) > h2:nth-child(1)"));
    }
}
