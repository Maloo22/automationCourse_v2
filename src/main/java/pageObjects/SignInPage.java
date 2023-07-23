package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class SignInPage extends BaseMain {



    public SignInPage (WebDriver driver) {

        super(driver);
    }



    //locators
    public String emailField = "//input[@id='email']";
    public String passwordField = "//input[@id='password']";
    public String logInBtn = "//button[contains(text(),'Log In')]";
    public String validMessDisp = "//body/div[@id='app']/div[1]/div[2]/div[2]/p[contains(text(),'Error: email is incorrect')]";     //"//div[@class='test-login-errors']";
    public String checkbox = "//input[@id='auth-page-remember-me']";

    //values
    public String emailValue = "efimovich@gmail.com";
    public String passwordValue = "password";


    public void validateSignInForm(){


        System.out.println("Email Field is ...  " + driver.findElement(By.xpath(emailField)).isDisplayed());
        System.out.println("Password Field is ... " + driver.findElement(By.xpath(passwordField)).isDisplayed());
        System.out.println("Log in page is ... " + driver.findElement(By.xpath(logInBtn)).isDisplayed());

    }


    public void fillSignInForm (){
        driver.findElement(By.xpath(emailField)).sendKeys(emailValue);
        driver.findElement(By.xpath(passwordField)).sendKeys(passwordValue);
        driver.findElement(By.xpath(logInBtn)).sendKeys(Keys.ENTER);
    }

    public void errorMessageAfterInvalidCredential (){
        System.out.println("Validation message is displayed is ... " + driver.findElement(By.xpath(validMessDisp)).isDisplayed());
    }

    public void checkBoxIsSelected (){
        System.out.println("checkbox is ... " + driver.findElement(By.xpath(checkbox)).isSelected());
    }
}