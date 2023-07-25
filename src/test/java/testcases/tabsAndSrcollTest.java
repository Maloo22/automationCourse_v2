package testcases;

import org.testng.annotations.Test;

public class tabsAndSrcollTest extends BaseTest {

    @Test
    public void scrollingHomePage () {

        homePage.openWebSite();
        homePage.homePageScroll();
    }


<<<<<<< Updated upstream:src/test/java/testcases/tabsAndSrcollTest.java


    @Test
=======
    @Test ( groups = {"testIncludeTWO2 "} )
>>>>>>> Stashed changes:src/test/java/testcases/TabsAndScrollTest.java
    public void tabsAndSelection ()  {

        homePage.openWebSite();
        homePage.switchToTabs();
    }
}

