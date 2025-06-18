package edu.sahan;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchByEventTest extends AbstractTest{

    @Test
    public void searchByEvent(){
         MyTicketSearchPage searchPage = homePage.goToSearhPage();
          MyTicketsSearchResults searchResults = searchPage.searchByText(SearchDictionary.searchEvent);
          List<WebElement> results =  searchResults.getSearchByEventResults();
            for (WebElement result : results) {
                assertTrue(result.getText().contains(SearchDictionary.searchEvent));
            }

    }

}
