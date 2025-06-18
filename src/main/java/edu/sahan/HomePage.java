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

    private final static By userButton = By.xpath("//span[contains(text(),'Sahan')]");

    private final static By searchField = By.cssSelector("input[name='search']");

    public HomePage(WebDriver webDriver){
        this.webDriver = webDriver;
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
    }


    //============= Login Logout ===========================================
    public MyTicketsLoginPage goToLoginPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(signInButton)).click();
        return new MyTicketsLoginPage(webDriver);
    }

    public MyTicketsLogoutPage goToLogoutPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(userButton)).click();
        return new MyTicketsLogoutPage(webDriver);
    }

    //=============  Search ===========================================
    public MyTicketSearchPage goToSearhPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchField));
        return new MyTicketSearchPage(webDriver);
    }


}
