package edu.sahan;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchByArtistTest extends AbstractTest{

    @Test
    public void searchByArtist(){
         MyTicketSearchPage searchPage = homePage.goToSearhPage();
          MyTicketsSearchResults searchResults = searchPage.searchByText(SearchDictionary.searchArtist);
          List<WebElement> results =  searchResults.getSearchByArtistResults();
            for (WebElement result : results) {
                assertTrue(result.getText().toLowerCase().contains(SearchDictionary.searchArtist.toLowerCase()));
            }

    }

}
