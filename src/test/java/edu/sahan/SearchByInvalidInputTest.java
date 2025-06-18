package edu.sahan;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SearchByInvalidInputTest extends AbstractTest{

    @Test
    public void searchByArtist(){
         MyTicketSearchPage searchPage = homePage.goToSearhPage();
          MyTicketsSearchResults searchResults = searchPage.searchByText(SearchDictionary.searchInvalidInput);
         assertEquals("Sorry, we couldn't find any result",searchResults.getSearchByInvalidInputResults().getText());

    }

}
