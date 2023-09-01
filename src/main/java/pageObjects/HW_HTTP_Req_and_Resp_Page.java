package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.logging.Logger;

public class HW_HTTP_Req_and_Resp_Page extends BaseMain {


    public HW_HTTP_Req_and_Resp_Page (WebDriver driver, Logger log) {

        super(driver, log);
    }


    //String urlOne = "https://www.ttrsonline.com/";

    public void openPage (String webSIte) {
        driver.get(webSIte);
    }

    public List<Integer> urlVerification() {
        return verifyLinkActive();
    }



}
