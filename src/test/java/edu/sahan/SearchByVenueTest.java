package edu.sahan;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchByVenueTest extends AbstractTest{

    @Test
    public void searchByVenue(){
         MyTicketSearchPage searchPage = homePage.goToSearhPage();
          SearchResults searchResults = searchPage.searchByVenue("Lakshapana");
          List<WebElement> results =  searchResults.getSearchResults();
            for (WebElement result : results) {
                assertTrue(result.getText().contains("Lakshapana"));
            }

    }

}
