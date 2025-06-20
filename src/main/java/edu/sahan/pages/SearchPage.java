package edu.sahan.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchPage {

    private final static By  searchField  = By.cssSelector("input[name='search']");
    private final static By searchButton = By.xpath("//button[contains(text(),'Search')]");
    private final WebDriver webDriver;
    private final WebDriverWait wait;

    public SearchPage(WebDriver webDriver){
        this.webDriver = webDriver;
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
    }

    public SearchResults searchByText(String searchText) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchField)).sendKeys(searchText);
        webDriver.findElement(searchButton).click();
        return new SearchResults(webDriver);
    }

}
