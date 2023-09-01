package pageObjects;

import org.openqa.selenium.*;

import java.net.HttpURLConnection;
import java.net.URL;
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




    public List<Integer> verifyLinkActive(){

        List<WebElement> linkElements = driver.findElements(By.xpath("//a")); //collect all links from page
        List<String> collectedURLs = new ArrayList<>(); //this List will have actual URLs
        List<Integer> codes = new ArrayList<>(); //this List will have codes that each URL will return
        int resultCode; //initialize variable for a resulting code value and providing default value

        for (WebElement linkElement: linkElements){ //this loop takes each element from LinkElements and takes href attribute (since each item is a link it will have it)
            collectedURLs.add(linkElement.getAttribute("href"));
        }


        for(String collectedURL: collectedURLs) { // this loop will execute actions below to fill up codes List with actual values
            System.out.println("Starting verification of " + collectedURL);
            try { //making sure that exception won't fail the execution to carry execution on
                URL url = new URL(collectedURL); //initializes URL instance for provided URL
                HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection(); //initialize HTTP Connection
                httpURLConnect.setConnectTimeout(3000); //set timeout value
                httpURLConnect.connect(); //establish connection to provided URL to execute a call
                resultCode = httpURLConnect.getResponseCode(); //providing actual value into a value of a variable to be returned
                System.out.println(resultCode);
                codes.add(resultCode); //writing the result in resultCode array to return it
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return codes; //a return of a list with codes for further verification
    }


}



