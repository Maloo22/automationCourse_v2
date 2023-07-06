package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;



public class validDrpDwnCntntTest extends BaseTest{

    @Test
    public void openSignUpPage () throws InterruptedException{

        homePage.openWebSite();
        homePage.clickSignUpButton();
    }

    @Test
    public void list () throws InterruptedException{

        homePage.openWebSite();
        homePage.clickSignUpButton();
        signUpPage.getDropDownContent();

    }



}