package testcases;

import org.testng.annotations.Test;

public class HW_17_EndToEndTest_Part_1_Ex_1_and_2_v2_TEST extends BaseTest{


    @Test
    public void ScenarioONE () {

//        Scenario 1. “History” is available for logged-in users only.

//        1. Open main page
//        2. Open Course Gallery
//        3. Validate “History” is not available in the top right corner of the page
//        4. Return to the main page
//        5. Sign In as a user
//        6. Open Course Gallery
//        7. Validate “History” is now available for logged in user

        homePage.openWebSite();
        homePage.openCourseGalleryPageByClickButton();
        homePage.historyBtnValidation();

        driver.navigate().back();

        homePage.signingInToTheSystem();
        signInPage.fillSignInForm("testing@my-fork.com", "Password");
        homePage.openCourseGalleryPageByClickButton();
        homePage.historyBtnValidation();

    }



    @Test
    public void ScenarioTWO () {

//        Scenario 2. Course gallery options.

//        1. Open main page
//        2. Open Course Gallery page
//        3. Validate the following options in the horizontal menu: “Development”, “Testing”, “Business Analysis”, “Agile”, “Project Management”

        homePage.openWebSite();
        homePage.openCourseGalleryPageByClickButton();
        homePage.getTabsList();

    }




}
