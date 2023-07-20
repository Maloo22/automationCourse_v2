package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class errorMessValidTest extends BaseTest {



    public String validMessDisp = "//body/div[@id='app']/div[1]/div[2]/div[2]/p[contains(text(),'Error: email is incorrect')]";

    @Test
    public void errorMassageOnAfterInputOnSingInPage () {

        homePage.openWebSite();
        homePage.clickSignIn();
        signInPage.fillSignInForm();

        WebDriverWait waitForMessage = new WebDriverWait(driver,Duration.ofSeconds(100));
        waitForMessage.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(validMessDisp)));

        signInPage.errorMessageAfterInvalidCredential();

    }




}



