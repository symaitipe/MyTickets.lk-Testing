package edu.sahan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class MyTicketsLoginPage{

    private final WebDriver webDriver;
    private final WebDriverWait wait;

    private final static By passwordInput = By.name("password");
    private final static By emailInput = By.name("email");
    private final static By submitLoginButton = By.cssSelector("button[type='submit']");

    public MyTicketsLoginPage(WebDriver webDriver){
        this.webDriver = webDriver;
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
    }

    public MyTicketsLoginResults submitLoginDetails(String email, String password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput)).sendKeys(email);
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput)).sendKeys(password);
        wait.until(ExpectedConditions.visibilityOfElementLocated(submitLoginButton)).click();
        return new MyTicketsLoginResults(webDriver);
    }


    public boolean getSubmitButtonStates(String email, String password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput)).sendKeys(email);
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput)).sendKeys(password);
        WebElement loginButton = webDriver.findElement(submitLoginButton);
        return !loginButton.isEnabled();
    }



}


