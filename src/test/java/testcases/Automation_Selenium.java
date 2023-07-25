package testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;




public class Automation_Selenium extends BaseTest {


<<<<<<< Updated upstream
=======

>>>>>>> Stashed changes
    @Test
    public void openHomePageAndClickSignInBtn () throws InterruptedException{

        homePage.clickSignIn();
    }

    @Test
    public void validInputFieldsOnSignInPage () throws InterruptedException{

        homePage.clickSignIn();
        signInPage.validateSignInForm();

    }

    @Test
    public void inputCredentialOnSignInPage () throws InterruptedException{

        homePage.clickSignIn();
        signInPage.fillSignInForm();
    }

    @Test
    public void errorMassageOnAfterInputOnSingInPage () throws  InterruptedException {

        homePage.clickSignIn();
        signInPage.fillSignInForm();
        Thread.sleep(5000);
        signInPage.errorMessageAfterInvalidCredential();
    }

    @Test
    public void validateCheckbox () throws InterruptedException {
        homePage.clickSignIn();
        signInPage.checkBoxIsSelected();
    }



}