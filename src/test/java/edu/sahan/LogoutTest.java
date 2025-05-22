package edu.sahan;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogoutTest extends AbstractTest {

    public void logout(){

        MyTicketsLogoutPage logoutPage = homePage.goToLogoutPage();
         MyTicketsLogoutResults logoutResults= logoutPage.submitLogout();
        assertEquals("Sign In",logoutResults.getLogoutResults());


    }
}
