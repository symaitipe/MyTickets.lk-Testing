package edu.sahan.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;



public class HomePage {
    private final WebDriver webDriver;
    private final WebDriverWait wait;

    private final static By signInButton = By.cssSelector("[href='/login']");

    private final static By userButton = By.xpath("//span[contains(text(),'Sahan')]");

    private final static By searchField = By.cssSelector("input[name='search']");

    private final static By navBar = By.cssSelector("div[class='container relative flex justify-between items-center max-w-screen-xl py-4']");

    private final static By registerButton = By.cssSelector("[href='/register']");


    public HomePage(WebDriver webDriver){
        this.webDriver = webDriver;
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
    }


    //============= Login Logout ===========================================
    public LoginPage goToLoginPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(signInButton)).click();
        return new LoginPage(webDriver);
    }

    public LogoutPage goToLogoutPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(userButton)).click();
        return new LogoutPage(webDriver);
    }

    //=============  Search ===========================================
    public SearchPage goToSearhPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchField));
        return new SearchPage(webDriver);
    }


    //=============  NavBar ===========================================
    public NavigationBar getNavBar() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(navBar));
        return new NavigationBar(webDriver);
    }

    //=============  Register ===========================================
    public RegisterPage getRegisterPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(registerButton)).click();
        return new RegisterPage(webDriver);
    }


}
