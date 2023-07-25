package testcases;


import org.testng.annotations.Test;



public class Automation_Selenium extends BaseTest {




    @Test
    public void openHomePageAndClickSignInBtn() {

        homePage.openWebSite();
        homePage.clickSignIn();
    }

<<<<<<< Updated upstream
    @Test
=======
    @Test(priority = 2,groups = {"testExclude"})
>>>>>>> Stashed changes
    public void validInputFieldsOnSignInPage() {

        homePage.openWebSite();
        homePage.clickSignIn();
        signInPage.validateSignInForm();

    }

    @Test
    public void inputCredentialOnSignInPage() {

        homePage.openWebSite();
        homePage.clickSignIn();
        signInPage.fillSignInForm();
    }

    @Test
    public void validateCheckbox() {

        homePage.openWebSite();
        homePage.clickSignIn();
        signInPage.checkBoxIsSelected();
    }


}

