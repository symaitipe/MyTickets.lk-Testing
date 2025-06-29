package edu.sahan.base;

import edu.sahan.pages.HomePage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AbstractTest {


    protected WebDriver driver;
    protected HomePage homePage;



    @BeforeAll
    public void getInit(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://mytickets.lk/");
        driver.manage().window().fullscreen();



        homePage = new HomePage(driver);
    }


    @AfterAll
    public void quitDriver(){
        driver.quit();
    }


}
