package testcases;

import org.testng.annotations.Test;


public class Automation_Selenium extends BaseTest {


    @Test
    public void openHomePageAndClickSignInBtn () {

        homePage.clickSignIn();
    }

    @Test
    public void validInputFieldsOnSignInPage () {

        homePage.clickSignIn();
        signInPage.validateSignInForm();

    }

    @Test
    public void inputCredentialOnSignInPage () {

        homePage.clickSignIn();
        signInPage.fillSignInForm();
    }

    @Test
    public void validateCheckbox () {

        homePage.clickSignIn();
        signInPage.checkBoxIsSelected();
    }

}