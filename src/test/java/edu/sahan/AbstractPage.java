package edu.sahan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractPage {

    private final static int TIMEOUT = 30;

    private final WebDriver webDriver;
    private final  WebDriverWait webDriverWait;


    public AbstractPage(WebDriver webDriver){
        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(TIMEOUT));
    }

    public WebDriver getDriver(){
        return webDriver;
    }

    public WebDriverWait getWebDriverWait() {
        return webDriverWait;
    }


}
