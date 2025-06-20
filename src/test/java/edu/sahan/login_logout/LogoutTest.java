package edu.sahan.login_logout;


import edu.sahan.Secrets;
import edu.sahan.base.AbstractTest;
import edu.sahan.pages.MyTicketsLoginPage;
import edu.sahan.pages.MyTicketsLoginResults;
import edu.sahan.pages.MyTicketsLogoutPage;
import edu.sahan.pages.MyTicketsLogoutResults;
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
