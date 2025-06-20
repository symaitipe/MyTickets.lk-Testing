package edu.sahan.login_logout;


import edu.sahan.Secrets;
import edu.sahan.base.AbstractTest;
import edu.sahan.pages.LoginPage;
import edu.sahan.pages.LoginResults;
import edu.sahan.pages.LogoutPage;
import edu.sahan.pages.LogoutResults;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogoutTest extends AbstractTest {

    @Test
    public void logout(){

        LoginPage loginPage = homePage.goToLoginPage();
         LoginResults loginResults= loginPage.submitLoginDetails(Secrets.email,Secrets.password);
        LogoutPage logoutPage = homePage.goToLogoutPage();
         LogoutResults logoutResults= logoutPage.submitLogout();
        assertEquals("Sign In",logoutResults.getLogoutResults());


    }
}
