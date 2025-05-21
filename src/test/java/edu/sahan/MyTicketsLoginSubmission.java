package edu.sahan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyTicketsLoginSubmission extends AbstractPage{


    public final static By signInButton = By.cssSelector("[href='/login']");
    public final static By emailInput = By.name("email");
    public final static By passwordInput = By.name("password");
    public final static By submitLoginButton = By.cssSelector("button[type='submit']");

    public MyTicketsLoginSubmission(WebDriver webDriver){
        super(webDriver);
    }


    public void loadPage(){

        getDriver().get("https://mytickets.lk/");
        getDriver().manage().window().fullscreen();
        System.out.println("Page title: " + getDriver().getTitle());
    }


    public void submitLoginDetails(String email, String password){
            getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(signInButton)).click();
            getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(emailInput)).
                    sendKeys(email);
            getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(passwordInput)).
                    sendKeys(password);
            getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(submitLoginButton)).click();
    }



}


