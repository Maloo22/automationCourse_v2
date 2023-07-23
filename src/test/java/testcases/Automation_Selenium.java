package testcases;


import org.testng.annotations.Test;



public class Automation_Selenium extends BaseTest {



    @Test(priority = 2)
    public void openHomePageAndClickSignInBtn() {

        homePage.openWebSite();
        homePage.clickSignIn();
    }


    @Test(priority = 2,groups = {"testExclude"})
    public void validInputFieldsOnSignInPage() {

        homePage.openWebSite();
        homePage.clickSignIn();
        signInPage.validateSignInForm();

    }

    @Test(priority = 1,groups = {"testInclude"})
    public void inputCredentialOnSignInPage() {

        homePage.openWebSite();
        homePage.clickSignIn();
        signInPage.fillSignInForm();
    }

    @Test(priority = 3, groups = {"testInclude"})
    public void validateCheckbox() {

        homePage.openWebSite();
        homePage.clickSignIn();
        signInPage.checkBoxIsSelected();
    }


}
