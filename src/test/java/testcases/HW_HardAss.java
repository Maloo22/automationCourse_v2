package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class HW_HardAss extends BaseTest {




    String expPageTitle = "Quizzes list";
    String actPageTitle;

    String tabsList = "//body/div[@id='app']/div[2]/div[2]//div";
    int expListSize = 5;
    int actListSize;

    String headerText = "//div[@class='quiz-section-title']";






    @Test
    public void hardAssertionsHW ()  {

    driver.get("https://test.my-fork.com/quizzes-list");

    actPageTitle = driver.getTitle();
        System.out.println(actPageTitle);

        Assert.assertEquals(actPageTitle,expPageTitle);
//        System.out.println("title is the same!!!!!!");

        List <WebElement> ListOfTabs = driver.findElements(By.xpath(tabsList));
//        System.out.println(ListOfTabs);
        actListSize = ListOfTabs.size();

        Assert.assertEquals(actListSize,expListSize,"if list is not the same");


        System.out.println(driver.findElement(By.xpath(headerText)).getText());

        boolean headerIsExist = driver.findElement(By.xpath(headerText)).getText().contains("Choose your ar4ea of expertise");
        System.out.println(headerIsExist);

        Assert.assertTrue(headerIsExist);



    }









}
