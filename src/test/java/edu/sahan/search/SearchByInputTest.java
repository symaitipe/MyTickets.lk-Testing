package edu.sahan.search;

import edu.sahan.SearchDictionary;
import edu.sahan.base.AbstractTest;
import edu.sahan.pages.MyTicketSearchPage;
import edu.sahan.pages.MyTicketsSearchResults;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchByInputTest extends AbstractTest {

    @Test
    public void searchByArtist() {
        MyTicketSearchPage searchPage = homePage.goToSearhPage();
        MyTicketsSearchResults searchResults = searchPage.searchByText(SearchDictionary.searchArtist);
        List<WebElement> results = searchResults.getSearchByArtistResults();
        for (WebElement result : results) {
            assertTrue(result.getText().toLowerCase().contains(SearchDictionary.searchArtist.toLowerCase()));
        }
    }
    @Test
    public void searchByEvent(){
        MyTicketSearchPage searchPage = homePage.goToSearhPage();
        MyTicketsSearchResults searchResults = searchPage.searchByText(SearchDictionary.searchEvent);
        List<WebElement> results =  searchResults.getSearchByEventResults();
        for (WebElement result : results) {
            assertTrue(result.getText().contains(SearchDictionary.searchEvent));
        }

    }

    @Test
    public void searchByVenue(){
        MyTicketSearchPage searchPage = homePage.goToSearhPage();
        MyTicketsSearchResults searchResults = searchPage.searchByText(SearchDictionary.searchVenue);
        List<WebElement> results =  searchResults.getSearchByVenueResults();
        for (WebElement result : results) {
            assertTrue(result.getText().contains(SearchDictionary.searchVenue));
        }

    }


    @Test
    public void searchByInvalidInput(){
        MyTicketSearchPage searchPage = homePage.goToSearhPage();
        MyTicketsSearchResults searchResults = searchPage.searchByText(SearchDictionary.searchInvalidInput);
        assertEquals("Sorry, we couldn't find any result",searchResults.getSearchByInvalidInputResults().getText());

    }


}
