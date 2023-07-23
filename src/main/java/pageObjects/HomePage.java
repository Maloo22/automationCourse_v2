package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BaseMain{

    public HomePage (WebDriver driver) {

        super(driver);
    }



    //locators
    public String WebsiteURL = "https://test.my-fork.com/";
    public String signInBtn = "//a[@class='menu-item log-in-button']";
    public String signUpButton = "//div[@class='menu']/a[3]";


    public void clickSignIn(){

        driver.findElement(By.xpath(signInBtn)).click();

    }


    public void clickSignUpButton () {

        driver.findElement(By.xpath(signUpButton)).click();
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

}

