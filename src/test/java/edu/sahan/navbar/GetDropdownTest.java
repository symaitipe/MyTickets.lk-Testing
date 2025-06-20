package edu.sahan.navbar;


import edu.sahan.base.AbstractTest;
import edu.sahan.pages.NavigationBar;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetDropdownTest extends AbstractTest {


    @Test
    public void getVisibilityStateOfDropdown() {
        NavigationBar navigationBar = homePage.getNavBar();
        navigationBar.selectOption(1);

        String dataState = navigationBar.getLatestDataState();
        String ariaExpanded = navigationBar.getLatestAriaExpanded();

        System.out.println("data-state: " + dataState);
        System.out.println("aria-expanded: " + ariaExpanded);

         assertEquals("open", dataState,"Data state Closed");
         assertEquals("true", ariaExpanded, "Aria didn't expanded");
    }
}
