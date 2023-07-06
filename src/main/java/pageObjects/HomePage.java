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


        // Open website + full screen
        openWebSite();
        driver.findElement(By.xpath(signInBtn)).click();

    }

    public void clickSignUpButton () {

        driver.findElement(By.xpath(signUpButton)).click();
    }


    public void openWebSite(){
        // Open website + full screen
        driver.get(WebsiteURL);
        driver.manage().window().maximize();

    }

}