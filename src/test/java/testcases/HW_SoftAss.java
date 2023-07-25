package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class HW_SoftAss extends BaseTest{









    String expPageTitle = "Quizzes list";
    String actPageTitle;

    String tabsList = "//body/div[@id='app']/div[2]/div[2]//div";
    int expListSize = 7;
    int actListSize;

    String headerText = "//div[contains(text(),'Choose your area of exp7ertise')]";


    @Test
    public void softAssertionsHW () {

        driver.get("https://test.my-fork.com/quizzes-list");
        actPageTitle = driver.getTitle();

        List<WebElement> ListOfTabs = driver.findElements(By.xpath(tabsList));
//        System.out.println(ListOfTabs);
        actListSize = ListOfTabs.size();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actPageTitle,expPageTitle, "titles not the same");


        softAssert.assertNotEquals(actPageTitle,expPageTitle, "titles NOT the same");


        softAssert.assertEquals(actListSize, expListSize, "if list is not the same");


        boolean headerIsExist = headerText.contains("Choose your area of expertise");


        if (headerIsExist) {
            System.out.println("expectedHeaderSign");
        } else {
            System.out.println("UNexpectedHeaderSign");
        }
        System.out.println(headerIsExist);

//       softAssert.assertTrue(headerIsExist);

        softAssert.assertAll();

    }














}
