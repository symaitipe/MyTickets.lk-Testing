package edu.sahan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyTicketsLogoutPage {

    WebDriver webDriver;
    WebDriverWait webDriverWait;

    private final static By logoutButton = By.xpath("//div[contains(text(),'Log out')]");

    public MyTicketsLogoutPage(WebDriver webDriver){
        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
    }


    public MyTicketsLogoutResults submitLogout(){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(logoutButton)).click();
        return new MyTicketsLogoutResults(webDriver);
    }

}
