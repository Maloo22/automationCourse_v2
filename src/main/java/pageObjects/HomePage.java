package pageObjects;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;




public class HomePage extends BaseMain{

    public HomePage (WebDriver driver, Logger log) {

        super(driver, log);
    }


    //locators
    public String WebsiteURL = "https://test.my-fork.com/";
    public String signInBtn = "//a[@class='menu-item log-in-button']";
    public String signUpButton = "//div[@class='menu']/a[3]";
    public String courseGalleryBTN = "//a[@href='/quizzes-list']";


    public void clickSignIn(){
        clickUsingXpath(signInBtn,"sign in btn");

        //driver.findElement(By.xpath(signInBtn)).click();

    }


    public void clickSignUpButton () {

        driver.findElement(By.xpath(signUpButton)).click();
    }

    public void openCourseGalleryPageByClickButton () {
        clickUsingXpath(courseGalleryBTN,"Course Gallery btn");
        //driver.findElement(By.xpath(courseGalleryBTN)).click();
    }

    public void openWebSite(){

        driver.get(WebsiteURL);

    }

    public void homePageScroll(){

        scrollPage(2500);
        scrollPage(-2500);
        scrollPage(5500);

    }

    public void switchToTabs (){

        switchToWindow(0);

    }







    // end 2 end HW

    String historyBTN = "//a[contains(text(),'History')]";

    public boolean historyBtnValidation () {


        try {
            WebElement button = driver.findElement(By.xpath(historyBTN));

            // если кнопка есть
            System.out.println("кнопка есть. Путь завершен, человек!");
            Assert.assertTrue(button.isDisplayed(), "Кнопка не отображается, хотя ожидалось что будет.");


        } catch (NoSuchElementException e) {
            // если кнопка нэт
            System.out.println("кнопки нет. Иди своей дорогой, Сталкер!");

        } catch (AssertionError e) {
            System.out.println(e.getMessage());


        }
        return false;
    }



    public void signingInToTheSystem () {

        clickUsingXpath(signInBtn, "Sign In BTN");

    }



    String tabList = "//div[@class='expertise-areas-list']";

    public void getTabsList () {

        WebElement tadSelector = driver.findElement(By.xpath(tabList));
        List<WebElement> tabs = tadSelector.findElements(By.tagName("div"));

        List<String> actualTabsList = new ArrayList<>();

        // Текст из каждого таба
        for (WebElement element : tabs) {
            String text = element.getText();
            actualTabsList.add(text);
            //System.out.println(text);
        }

        // трушный список      “Development”, “Testing”, “Business Analysis”, “Agile”, “Project Management”
        List<String> expectedTabsList = new ArrayList<>();
        expectedTabsList.add("Development");
        expectedTabsList.add("Testing");
        expectedTabsList.add("Business Analysis");
        expectedTabsList.add("Agile");
        expectedTabsList.add("Project Management");


        Assert.assertEquals(actualTabsList, expectedTabsList, "Списки не совпадают");

    }

}

