package pageObjects;

import org.openqa.selenium.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


public class BaseMain {


    public Logger log;

    public WebDriver driver;

    public BaseMain (WebDriver driver, Logger logger){

        this.driver = driver;
        this.log = logger;

    }



    public void scrollPage(int pixels) {

    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollBy(0, " + pixels + ")", "");

    }


    public void switchToWindow(int tab) {

    List<String> tabHandler = new ArrayList<>(driver.getWindowHandles());
    driver.switchTo().window(tabHandler.get(tab));

    }


    // униваресальные методы с логами или с принтом в консоль которые можно юзать в любом месте передавая в них нужные данные.
    public void clickUsingXpath(String xpath, String elementName){
        driver.findElement(By.xpath(xpath)).click();
        System.out.println("Element: " + elementName + " was successfully clicked");
        log.info("Element: " + elementName + " was clicked successfully") ;
    }

    public void pressingEnterUsingXpath(String xpath, String elementName){
        driver.findElement(By.xpath(xpath)).sendKeys(Keys.ENTER);
        System.out.println("Element: " + elementName + " was successfully clicked");
        log.info("Element: " + elementName + " was clicked successfully") ;
    }


    public void clickUsingWebElement (WebElement element, String elementName){
        element.click();
        log.info("Element: " + elementName + " was successfully clicked");
    }


    public void typeUsingXpath (String xpath, String elementName, String value){
        driver.findElement(By.xpath(xpath)).sendKeys(value);
        System.out.println("Value: " + value + " was successfully pasted into " + elementName + " element");
    }



    public void getListUsingXpath (String xpath, String elementName){

        List<WebElement> Element = driver.findElements(By.xpath(xpath));
        System.out.println("Element: " + elementName + " was found");
        log.info("Element: " + elementName + " was found");
    }




}



