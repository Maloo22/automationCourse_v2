package testcases;


import org.testng.annotations.Test;





public class ValidDrpDwnCntntTest extends BaseTest{


    @Test(groups = {"testInclude"})
    public void openSignUpPage ()  {

        homePage.openWebSite();
        homePage.clickSignUpButton();

    }




    @Test(groups = {"testInclude"})

    public void list ()  {

        homePage.openWebSite();
        homePage.clickSignUpButton();
        signUpPage.getDropDownContent();

    }

    @Test(groups = {"testIncludeTWO"})
    public void list2 ()  {

        homePage.openWebSite();
        homePage.clickSignUpButton();
        signUpPage.compareDropDownContentWithMatch();


    }

}