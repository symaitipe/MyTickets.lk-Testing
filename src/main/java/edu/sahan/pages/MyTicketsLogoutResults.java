package edu.sahan.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyTicketsLogoutResults {

    private final WebDriverWait wait;

    private final static By targetedChangeVisibleArea = By.xpath("//a[contains(text(),'Sign In')]");

    public MyTicketsLogoutResults(WebDriver webDriver) {
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));

    }


    public String getLogoutResults(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(targetedChangeVisibleArea)).getText();
    }

}
