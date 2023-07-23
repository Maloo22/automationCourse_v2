package testcases;


import org.testng.annotations.Test;





public class ValidDrpDwnCntntTest extends BaseTest{

    @Test
    public void openSignUpPage ()  {

        homePage.openWebSite();
        homePage.clickSignUpButton();
    }

    @Test
    public void list ()  {

        homePage.openWebSite();
        homePage.clickSignUpButton();
        signUpPage.getDropDownContent();

    }

    @Test
    public void list2 ()  {

        homePage.openWebSite();
        homePage.clickSignUpButton();
        signUpPage.compareDropDownContentWithMatch();

    }

}