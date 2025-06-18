package edu.sahan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyTicketSearchPage {

    private final static By  searchField  = By.cssSelector("input[name='search']");
    private final static By searchButton = By.xpath("//button[contains(text(),'Search')]");
    private WebDriver webDriver;
    private WebDriverWait wait;

    public MyTicketSearchPage(WebDriver webDriver){
        this.webDriver = webDriver;
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
    }

    public SearchResults searchByVenue(String venue) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchField)).sendKeys(venue);
        webDriver.findElement(searchButton).click();
        return new SearchResults(webDriver);
    }

}
