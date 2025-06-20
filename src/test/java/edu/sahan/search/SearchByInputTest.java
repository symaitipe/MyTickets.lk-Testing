package edu.sahan.search;

import edu.sahan.SearchDictionary;
import edu.sahan.base.AbstractTest;
import edu.sahan.pages.SearchPage;
import edu.sahan.pages.SearchResults;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchByInputTest extends AbstractTest {

    @Test
    public void searchByArtist() {
        SearchPage searchPage = homePage.goToSearhPage();
        SearchResults searchResults = searchPage.searchByText(SearchDictionary.searchArtist);
        List<WebElement> results = searchResults.getSearchByArtistResults();
        for (WebElement result : results) {
            assertTrue(result.getText().toLowerCase().contains(SearchDictionary.searchArtist.toLowerCase()));
        }
    }
    @Test
    public void searchByEvent(){
        SearchPage searchPage = homePage.goToSearhPage();
        SearchResults searchResults = searchPage.searchByText(SearchDictionary.searchEvent);
        List<WebElement> results =  searchResults.getSearchByEventResults();
        for (WebElement result : results) {
            assertTrue(result.getText().contains(SearchDictionary.searchEvent));
        }

    }

    @Test
    public void searchByVenue(){
        SearchPage searchPage = homePage.goToSearhPage();
        SearchResults searchResults = searchPage.searchByText(SearchDictionary.searchVenue);
        List<WebElement> results =  searchResults.getSearchByVenueResults();
        for (WebElement result : results) {
            assertTrue(result.getText().contains(SearchDictionary.searchVenue));
        }

    }


    @Test
    public void searchByInvalidInput(){
        SearchPage searchPage = homePage.goToSearhPage();
        SearchResults searchResults = searchPage.searchByText(SearchDictionary.searchInvalidInput);
        assertEquals("Sorry, we couldn't find any result",searchResults.getSearchByInvalidInputResults().getText());

    }


}
