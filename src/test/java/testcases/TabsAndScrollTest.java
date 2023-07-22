package testcases;

import org.testng.annotations.Test;

public class TabsAndScrollTest extends BaseTest {

    @Test
    public void scrollingHomePage () {

        homePage.openWebSite();
        homePage.homePageScroll();
    }



    @Test
    public void tabsAndSelection ()  {

        homePage.openWebSite();
        homePage.switchToTabs();
    }
}

