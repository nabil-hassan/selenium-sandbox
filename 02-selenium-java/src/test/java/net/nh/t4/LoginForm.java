package net.nh.t4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * POM class to represent interactions with the login form.
 */
public class LoginForm {

    private final WebDriver webDriver;

    public LoginForm(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void loginUser() {
        webDriver.get("https://automationintesting.online");
        webDriver.findElement(By.cssSelector("#collapseBanner > div > div:nth-child(3) > div.col-2.text-center > button")).click();
    }
}
