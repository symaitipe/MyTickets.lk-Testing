package edu.sahan;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchByVenueTest extends AbstractTest{

    @Test
    public void searchByVenue(){
         MyTicketSearchPage searchPage = homePage.goToSearhPage();
          MyTicketsSearchResults searchResults = searchPage.searchByText(SearchDictionary.searchVenue);
          List<WebElement> results =  searchResults.getSearchByVenueResults();
            for (WebElement result : results) {
                assertTrue(result.getText().contains(SearchDictionary.searchVenue));
            }

    }

}
