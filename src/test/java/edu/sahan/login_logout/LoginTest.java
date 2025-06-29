package edu.sahan.login_logout;


import edu.sahan.SearchDictionary;
import edu.sahan.Secrets;
import edu.sahan.base.AbstractTest;
import edu.sahan.pages.HomePage;
import edu.sahan.pages.LoginPage;
import edu.sahan.pages.LoginResults;
import edu.sahan.pages.LogoutPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoginTest extends AbstractTest {

    @AfterEach
    public void resetBrowserState() {
        // Navigate to login page and clear fields
        driver.get("https://mytickets.lk/login");
        driver.manage().deleteAllCookies(); // Clear cookies to reset session
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clearFields(); // Clear email and password fields
        homePage = new HomePage(driver); // Reinitialize HomePage for next test
    }


    @Test
    @Order(7)
    public void loginWithCorrectCredentials(){

        LoginPage loginPage =  homePage.goToLoginPage();
        LoginResults loginResults = loginPage.submitLoginDetails(Secrets.email,Secrets.password);
        assertEquals(Secrets.expectedUsername,loginResults.getSuccessResults());


    }

    @Test
    @Order(1)
    public void loginWithIncorrectPassword() {
        LoginPage loginPage = homePage.goToLoginPage();
        LoginResults loginResults = loginPage.submitLoginDetails(Secrets.email, SearchDictionary.wrongPassword);

        String actualMessage = loginResults.getErrorMessage();
        assertEquals("Invalid credentials", actualMessage);
    }

    @Test
    @Order(2)
    public void loginWithIncorrectEmail() {
        LoginPage loginPage = homePage.goToLoginPage();
        LoginResults loginResults = loginPage.submitLoginDetails(SearchDictionary.wrongEmail, Secrets.password);

        String actualMessage = loginResults.getErrorMessage();
        assertEquals("Invalid credentials", actualMessage);
    }

    @Test
    @Order(3)
    public void loginWithIncorrectEmailAndIncorrectPassword() {
        LoginPage loginPage = homePage.goToLoginPage();
        LoginResults loginResults = loginPage.submitLoginDetails(SearchDictionary.wrongEmail,SearchDictionary.wrongPassword);

        String actualMessage = loginResults.getErrorMessage();
        assertEquals("Invalid credentials", actualMessage);
    }

    @Test
    @Order(4)
    public void loginWithEmptyEmailAndPassword() {
        LoginPage loginPage = homePage.goToLoginPage();
        boolean isDisabled = loginPage.getSubmitButtonStates("","");
        assertTrue(isDisabled);
    }

    @Test
    @Order(5)
    public void loginWithEmptyEmailAndCorrectPassword() {
        LoginPage loginPage = homePage.goToLoginPage();
        boolean isDisabled = loginPage.getSubmitButtonStates("",Secrets.password);
        assertTrue(isDisabled);
    }

    @Test
    @Order(6)
    public void loginWithCorrectEmailAndEmptyPassword() {
        LoginPage loginPage = homePage.goToLoginPage();
        boolean isDisabled = loginPage.getSubmitButtonStates(Secrets.email,"");
        assertTrue(isDisabled);
    }
}
