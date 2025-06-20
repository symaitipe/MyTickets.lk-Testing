package edu.sahan.login_logout;


import edu.sahan.SearchDictionary;
import edu.sahan.Secrets;
import edu.sahan.base.AbstractTest;
import edu.sahan.pages.LoginPage;
import edu.sahan.pages.LoginResults;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends AbstractTest {


    @Test
    public void loginWithCorrectCredentials(){

        LoginPage loginPage =  homePage.goToLoginPage();
        LoginResults loginResults = loginPage.submitLoginDetails(Secrets.email,Secrets.password);
        assertEquals(Secrets.expectedUsername,loginResults.getSuccessResults());

    }

    @Test
    public void loginWithIncorrectPassword() {
        LoginPage loginPage = homePage.goToLoginPage();
        LoginResults loginResults = loginPage.submitLoginDetails(Secrets.email, SearchDictionary.wrongPassword);

        String actualMessage = loginResults.getErrorMessage();
        assertEquals("Invalid credentials", actualMessage);
    }

    @Test
    public void loginWithIncorrectEmail() {
        LoginPage loginPage = homePage.goToLoginPage();
        LoginResults loginResults = loginPage.submitLoginDetails(SearchDictionary.wrongEmail, Secrets.password);

        String actualMessage = loginResults.getErrorMessage();
        assertEquals("Invalid credentials", actualMessage);
    }

    @Test
    public void loginWithIncorrectEmailAndIncorrectPassword() {
        LoginPage loginPage = homePage.goToLoginPage();
        LoginResults loginResults = loginPage.submitLoginDetails(SearchDictionary.wrongEmail,SearchDictionary.wrongPassword);

        String actualMessage = loginResults.getErrorMessage();
        assertEquals("Invalid credentials", actualMessage);
    }

    @Test
    public void loginWithEmptyEmailAndPassword() {
        LoginPage loginPage = homePage.goToLoginPage();
        boolean isDisabled = loginPage.getSubmitButtonStates("","");
        assertTrue(isDisabled);
    }

    @Test
    public void loginWithEmptyEmailAndCorrectPassword() {
        LoginPage loginPage = homePage.goToLoginPage();
        boolean isDisabled = loginPage.getSubmitButtonStates("",Secrets.password);
        assertTrue(isDisabled);
    }

    @Test
    public void loginWithCorrectEmailAndEmptyPassword() {
        LoginPage loginPage = homePage.goToLoginPage();
        boolean isDisabled = loginPage.getSubmitButtonStates(Secrets.email,"");
        assertTrue(isDisabled);
    }
}
