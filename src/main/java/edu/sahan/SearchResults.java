package edu.sahan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchResults {

    private final static By searchResultsElements = By.cssSelector("p[class='font-semibold body truncate']");

    private final WebDriverWait webDriverWait;

    public SearchResults(WebDriver webDriver){
        this.webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    }

    public List<WebElement> getSearchResults(){
        List<WebElement> searchResults =  webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(searchResultsElements));
        System.out.println("Total results: " + searchResults.size());
        return searchResults;
    }

}
