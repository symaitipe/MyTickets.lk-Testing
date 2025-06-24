package edu.sahan.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;

public class RegisterPage {

    WebDriver webDriver;
    WebDriverWait wait;

    RegisterPage(WebDriver webDriver){
        this.webDriver = webDriver;
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    }

    private final static By firstNameField = By.id(":r8n:-form-item");
    private final static By lastNameField = By.id(":r8o:-form-item");
    private final static By contactNumberField = By.id(":Rqqjtt5ja:-form-item");
    private final static By NICField = By.name("id");
    // Error message element
    private final static By NICErrorMessage = By.xpath("//p[text()=\"Please enter a valid NIC number that corresponds to your country\"]");

    private final static By countryField = By.id("country");
    private final static By emailField = By.name("email");
    private final static By emailVerificationMethodField = By.id("verification-method");
    private final static By passwordField = By.id(":R5qqjtt5ja:-form-item");
    private final static By confirmPasswordField = By.id(":R7qqjtt5ja:-form-item");
    private final static By getStartedBtn = By.cssSelector("button[type='submit']");




    public void enterNIC(String nicNo) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(NICField)).sendKeys(nicNo);
    }

    public String isNICErrorDisplayed() {
        try {
            webDriver.findElement(emailField).click();
           return wait.until(ExpectedConditions.visibilityOfElementLocated(NICErrorMessage)).getText();
        } catch (NoSuchElementException e) {
            return "";
        }
    }

}
