package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;








public class HW_17_EndToEndTest_Part_1_Ex_1_and_2_TEST extends BaseTest {


    //locators
    String historyBTN = "//a[contains(text(),'History')]";

    String tabsList = "//body/div[@id='app']/div[2]/div[2]//div";
    int expListSize = 7;
    int actListSize;




//For instances when you need to login please utilize the following credentials:
//
//        Email:     testing@my-fork.com
//        Password:  Password


//        Scenario 1. “History” is available for logged-in users only.
//
//        1. Open main page
//        2. Open Course Gallery
//        3. Validate “History” is not available in the top right corner of the page
//        4. Return to the main page
//        5. Sign In as a user
//        6. Open Course Gallery
//        7. Validate “History” is now available for logged in user

    @Test
    public void ScenarioONE() {

        homePage.openWebSite();
        homePage.openCourseGalleryPageByClickButton();


        SoftAssert softAssert = new SoftAssert();
        boolean hisBtnIsExist = historyBTN.matches("History");

        if (hisBtnIsExist) {
            System.out.println("History BTN is UNAVAILABLE !!!");
        } else {
            System.out.println("History BTN is available");
        }
        softAssert.assertTrue(hisBtnIsExist);


        driver.navigate().back();
        homePage.clickSignIn();
        signInPage.fillSignInForm("testing@my-fork.com", "Password");


        homePage.openCourseGalleryPageByClickButton();
        System.out.println("Button is displayed --- " + driver.findElement(By.xpath(historyBTN)).isDisplayed());


    }



//    Scenario 2. Course gallery options.
//
//    Open main page
//    Open Course Gallery page
//    Validate the following options in the horizontal menu: "Development", "Testing", "Business Analysis", "Agile", "Project Management"


    @Test
    public void ScenarioTWO() {

        homePage.openWebSite();
        homePage.openCourseGalleryPageByClickButton();


        List<WebElement> ListOfTabs = driver.findElements(By.xpath(tabsList));
        actListSize = ListOfTabs.size();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actListSize, expListSize, "if list is not the same");


        List<WebElement> listElements = driver.findElements(By.xpath(tabsList));
        List<String> actualListValues = new ArrayList<>();
        for (WebElement listElement : listElements) {
            actualListValues.add(listElement.getText());
        }


        List<String> expectedListValues = Arrays.asList("Development", "Testing", "Business Analysis", "Agile", "Project Management");
        Assert.assertEquals("Tabs Names Are NOT The Same", expectedListValues, actualListValues.toString());
    }











}