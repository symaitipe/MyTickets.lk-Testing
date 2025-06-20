package edu.sahan.base;

import edu.sahan.pages.HomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class AbstractTest {


    WebDriver driver;
    protected HomePage homePage;



    @BeforeEach
    public void getInit(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://mytickets.lk/");
        driver.manage().window().fullscreen();



        homePage = new HomePage(driver);
    }


    @AfterEach
    public void quitDriver(){
        driver.quit();
    }


}
