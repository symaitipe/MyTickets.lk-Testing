package edu.sahan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class HomePage {
    private final WebDriver webDriver;
    private final WebDriverWait wait;

    private final static By signInButton = By.cssSelector("[href='/login']");

    public HomePage(WebDriver webDriver){
        this.webDriver = webDriver;
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
    }


    public MyTicketsLoginPage goToLoginPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(signInButton)).click();
        return new MyTicketsLoginPage(webDriver);
    }

}
