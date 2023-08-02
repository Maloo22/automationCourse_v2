package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;








public class HW_17_EndToEndTest extends BaseTest {


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











//    Scenario 3. Quiz progress bar functionality.
//
//    1. Open main page
//    2. Open Course Gallery page
//    3. Note the total number of questions in the “SQL 101 (Basic)” quiz
//    4. Click the “Start” button on “SQL 101 (Basic)”
//    5. Select an answer for the first question
//    6. Validate that the progress bar now has the correct value (correct value = number of answered questions / total number of questions)
//    7. Click the “Next” button
//    8. Validate progress bar has changed value
//    9. Validate new changed value is correct


    String startBTN = "//body[1]/div[1]/div[2]/div[3]/div[2]/div[2]/a[1]";
    String counter = "//body/div[@id='app']/div[2]/div[3]/div[2]/div[2]/div[1]";
    String nextBTN = "//div[contains(text(),'Next')]";

    @Test
    public void ScenarioTHREE() throws InterruptedException {

        homePage.openWebSite();
        homePage.openCourseGalleryPageByClickButton();


        // Ищем каунтер
        WebElement element = driver.findElement(By.xpath(counter));

        // Получаем текст из каунтера
        String elementText = element.getText();


        // Разделяем строку по символу "/"
        String[] values = elementText.split("/");

        // Обрезаем пробелы в значениях и делаем из стринги инты
        int firstValue = Integer.parseInt(values[0].trim());
        int secondValue = Integer.parseInt(values[1].trim());

        System.out.println("Первое значение: " + firstValue);
        System.out.println("Второе значение: " + secondValue);

        //////////////-- начало теста --////////////////////


        driver.findElement(By.xpath(startBTN)).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//div[contains(text(),'A')]")).click(); //div[contains(text(),'A')] - рабочий для первого ответа
        Thread.sleep(1000);
        driver.findElement(By.xpath(nextBTN)).click();   // -- место фейла





    }
}