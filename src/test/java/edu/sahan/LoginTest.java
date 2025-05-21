package edu.sahan;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest extends AbstractTest {


    @Test
    public void loginWithCorrectCredentials(){

        MyTicketsLoginPage loginPage =  homePage.goToLoginPage();
        MyTicketsLoginResults loginResults = loginPage.submitLoginDetails(Secrets.email,Secrets.password);
        assertEquals(Secrets.expectedUsername,loginResults.getResults());




    }
}
