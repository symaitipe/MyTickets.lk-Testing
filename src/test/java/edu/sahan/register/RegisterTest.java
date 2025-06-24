package edu.sahan.register;

import edu.sahan.base.AbstractTest;
import edu.sahan.pages.RegisterPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegisterTest extends AbstractTest {


    @Test
    public void testInvalidShortNIC() {
        RegisterPage registrationPage = homePage.getRegisterPage();
        registrationPage.enterNIC("12345678"); // < 12 chars
        assertEquals("Please enter a valid NIC number that corresponds to your country", registrationPage.isNICErrorDisplayed());
    }


}
