package edu.sahan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestRunner {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();


        try {
            // Step 1: Load the Login Page
          MyTicketsLoginSubmission loginPage = new MyTicketsLoginSubmission(driver);
          loginPage.loadPage();

            // Step 2: Submit login details
            loginPage.submitLoginDetails(Secrets.email,Secrets.password);

            // Step 3: Validate login result
            MyTicketsLoginResults loginResults = new MyTicketsLoginResults(driver);
            String username = loginResults.getResults();


            // Manual validation (basic, console-based)
            if (username.contains(Secrets.expectedUsername)) {
                System.out.println("Login successful. Username displayed: " + username);
            } else {
                System.out.println("Login failed or username mismatch. Text found: " + username);
            }

        } catch (Exception e) {
            System.out.println("Test failed with exception: " + e.getMessage());
        } finally {
            // Clean up
            driver.quit();
        }
    }
}
