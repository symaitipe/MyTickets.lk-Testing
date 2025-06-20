package edu.sahan.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class MyTicketsLoginResults {


    private final WebDriverWait wait;

    private final static By targetedChangeVisibleArea = By.cssSelector("nav button span.hidden.lg\\:block");

    private final static By alertArea = By.xpath("//div[@data-title and text()='Invalid credentials']");


    public MyTicketsLoginResults(WebDriver webDriver) {
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));

    }


    public String getSuccessResults(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(targetedChangeVisibleArea)).getText();
    }


    public String getErrorMessage(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(alertArea)).getText();
    }


}
