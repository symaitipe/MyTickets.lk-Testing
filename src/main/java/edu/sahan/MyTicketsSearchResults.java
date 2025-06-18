package edu.sahan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MyTicketsSearchResults {

    private final static By searchResultsTitleElements = By.cssSelector("p[class='font-semibold body truncate']");
    private final static By searchResultsVenueElements = By.cssSelector("p[class='small truncate']");


    private final WebDriverWait webDriverWait;

    public MyTicketsSearchResults(WebDriver webDriver){
        this.webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    }

    public List<WebElement> getSearchByVenueResults(){
        List<WebElement> searchResults =  webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(searchResultsVenueElements));
        System.out.println("Total results: " + searchResults.size());
        return searchResults;
    }

    public List<WebElement> getSearchByArtistResults(){
        List<WebElement> searchResults =  webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(searchResultsTitleElements));
        System.out.println("Total results: " + searchResults.size());
        return searchResults;
    }

    public List<WebElement> getSearchByEventResults() {
        List<WebElement> searchResults = webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(searchResultsTitleElements));
        System.out.println("Total results: " + searchResults.size());
        return searchResults;
    }

    public WebElement getSearchByInvalidInputResults(){
        By searchResultsNothingFoundElement = By.cssSelector("p[class='body']");
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(searchResultsNothingFoundElement));
    }


}
