package edu.sahan.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginPage {

    private final WebDriver webDriver;
    private final WebDriverWait wait;

    private final static By passwordInput = By.name("password");
    private final static By emailInput = By.name("email");
    private final static By submitLoginButton = By.cssSelector("button[type='submit']");

    public LoginPage(WebDriver webDriver){
        this.webDriver = webDriver;
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
    }

    public LoginResults submitLoginDetails(String email, String password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput)).sendKeys(email);
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput)).sendKeys(password);
        wait.until(ExpectedConditions.visibilityOfElementLocated(submitLoginButton)).click();
        return new LoginResults(webDriver);
    }


    public boolean getSubmitButtonStates(String email, String password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput)).sendKeys(email);
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput)).sendKeys(password);
        WebElement loginButton = webDriver.findElement(submitLoginButton);
        return !loginButton.isEnabled();
    }

    public void clearFields() {
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput));
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
        emailField.clear();
        passwordField.clear();
    }

}


