package testcases;

import org.testng.annotations.Test;

public class TabsAndScrollTest extends BaseTest {

    @Test
    public void scrollingHomePage () {

        homePage.openWebSite();
        homePage.homePageScroll();
    }

    @Test ( groups = {"testIncludeTWO2 "} )

    public void tabsAndSelection ()  {

        homePage.openWebSite();
        homePage.switchToTabs();
    }


}

