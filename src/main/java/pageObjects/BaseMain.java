package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import java.util.ArrayList;
import java.util.List;


public class BaseMain {


    public WebDriver driver;

    public BaseMain (WebDriver driver){

        this.driver = driver;

    }
            public void scrollPage(int pixels) {

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0, " + pixels + ")", "");
        }

            public void switchToWindow(int tab) {

            driver.switchTo().newWindow(WindowType.TAB);
            driver.switchTo().newWindow(WindowType.TAB);
            driver.switchTo().newWindow(WindowType.TAB);
            driver.switchTo().newWindow(WindowType.TAB);
            driver.switchTo().newWindow(WindowType.TAB);

            List<String> tabHandler = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabHandler.get(tab));

        }

}




