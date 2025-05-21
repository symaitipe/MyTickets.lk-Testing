package edu.sahan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyTicketsLoginResults extends AbstractPage{


    private final static By targetedChangeVisibleArea = By.cssSelector("nav button span.hidden.lg\\:block");

    public MyTicketsLoginResults(WebDriver webDriver) {
        super(webDriver);
    }


    public String getResults(){
        // Wait for the username to appear in the navbar
        return getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(targetedChangeVisibleArea)).getText();

    }


}
