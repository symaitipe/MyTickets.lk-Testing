package edu.sahan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class MyTicketsLoginResults {


    private final WebDriverWait wait;

    private final static By targetedChangeVisibleArea = By.cssSelector("nav button span.hidden.lg\\:block");

    public MyTicketsLoginResults(WebDriver webDriver) {
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));

    }


    public String getResults(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(targetedChangeVisibleArea)).getText();
    }


}
