package edu.sahan;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogoutTest extends AbstractTest {

    @Test
    public void logout(){

        MyTicketsLoginPage loginPage = homePage.goToLoginPage();
         MyTicketsLoginResults loginResults= loginPage.submitLoginDetails(Secrets.email,Secrets.password);
        MyTicketsLogoutPage logoutPage = homePage.goToLogoutPage();
         MyTicketsLogoutResults logoutResults= logoutPage.submitLogout();
        assertEquals("Sign In",logoutResults.getLogoutResults());


    }
}
