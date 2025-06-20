package edu.sahan.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogoutPage {

    WebDriver webDriver;
    WebDriverWait webDriverWait;

    private final static By logoutButton = By.xpath("//div[contains(text(),'Log out')]");

    public LogoutPage(WebDriver webDriver){
        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
    }


    public LogoutResults submitLogout(){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(logoutButton)).click();
        return new LogoutResults(webDriver);
    }

}
