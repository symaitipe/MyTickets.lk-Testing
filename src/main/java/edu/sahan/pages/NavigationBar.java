package edu.sahan.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class NavigationBar {
    private final WebDriverWait wait;

    private String latestDataState;
    private String latestAriaExpanded;

    private static final String[] OPTION_IDS = {
            "radix-:r0:-trigger-radix-:r1:",
            "radix-:r0:-trigger-radix-:r2:",
            "radix-:r0:-trigger-radix-:r3:",
            "radix-:r0:-trigger-radix-:r4:",
            "radix-:r0:-trigger-radix-:r5:",
            "radix-:r0:-trigger-radix-:r6:",
    };

    public NavigationBar(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void selectOption(int index) {
        WebElement option = getOptionElement(index);
        option.click();

        wait.until(d -> {
            latestDataState = option.getDomAttribute("data-state");
            latestAriaExpanded = option.getDomAttribute("aria-expanded");
            return "open".equals(latestDataState) && "true".equals(latestAriaExpanded);
        });
    }

    public String getLatestDataState() {
        return latestDataState;
    }

    public String getLatestAriaExpanded() {
        return latestAriaExpanded;
    }

    private WebElement getOptionElement(int index) {
        if (index < 1 || index > OPTION_IDS.length) {
            throw new IllegalArgumentException("Index must be between 1 and " + OPTION_IDS.length);
        }
        String optionId = OPTION_IDS[index - 1];
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(optionId)));
    }
}
