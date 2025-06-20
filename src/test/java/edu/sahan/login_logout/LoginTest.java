package edu.sahan.login_logout;


import edu.sahan.SearchDictionary;
import edu.sahan.Secrets;
import edu.sahan.base.AbstractTest;
import edu.sahan.pages.MyTicketsLoginPage;
import edu.sahan.pages.MyTicketsLoginResults;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends AbstractTest {


    @Test
    public void loginWithCorrectCredentials(){

        MyTicketsLoginPage loginPage =  homePage.goToLoginPage();
        MyTicketsLoginResults loginResults = loginPage.submitLoginDetails(Secrets.email,Secrets.password);
        assertEquals(Secrets.expectedUsername,loginResults.getSuccessResults());

    }

    @Test
    public void loginWithIncorrectPassword() {
        MyTicketsLoginPage loginPage = homePage.goToLoginPage();
        MyTicketsLoginResults loginResults = loginPage.submitLoginDetails(Secrets.email, SearchDictionary.wrongPassword);

        String actualMessage = loginResults.getErrorMessage();
        assertEquals("Invalid credentials", actualMessage);
    }

    @Test
    public void loginWithIncorrectEmail() {
        MyTicketsLoginPage loginPage = homePage.goToLoginPage();
        MyTicketsLoginResults loginResults = loginPage.submitLoginDetails(SearchDictionary.wrongEmail, Secrets.password);

        String actualMessage = loginResults.getErrorMessage();
        assertEquals("Invalid credentials", actualMessage);
    }

    @Test
    public void loginWithIncorrectEmailAndIncorrectPassword() {
        MyTicketsLoginPage loginPage = homePage.goToLoginPage();
        MyTicketsLoginResults loginResults = loginPage.submitLoginDetails(SearchDictionary.wrongEmail,SearchDictionary.wrongPassword);

        String actualMessage = loginResults.getErrorMessage();
        assertEquals("Invalid credentials", actualMessage);
    }

    @Test
    public void loginWithEmptyEmailAndPassword() {
        MyTicketsLoginPage loginPage = homePage.goToLoginPage();
        boolean isDisabled = loginPage.getSubmitButtonStates("","");
        assertTrue(isDisabled);
    }

    @Test
    public void loginWithEmptyEmailAndCorrectPassword() {
        MyTicketsLoginPage loginPage = homePage.goToLoginPage();
        boolean isDisabled = loginPage.getSubmitButtonStates("",Secrets.password);
        assertTrue(isDisabled);
    }

    @Test
    public void loginWithCorrectEmailAndEmptyPassword() {
        MyTicketsLoginPage loginPage = homePage.goToLoginPage();
        boolean isDisabled = loginPage.getSubmitButtonStates(Secrets.email,"");
        assertTrue(isDisabled);
    }
}
