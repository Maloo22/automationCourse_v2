package testcases;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageObjects.HomePage;
import pageObjects.QuizzersListAndTestPage;
import pageObjects.SignInPage;
import pageObjects.SignUpPage;

import java.io.IOException;
import java.time.Duration;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class BaseTest {



    public ChromeDriver driver;
    Logger log;
    HomePage homePage;
    SignInPage signInPage;
    SignUpPage signUpPage;
    QuizzersListAndTestPage quizzersListAndTestPage;




    @BeforeMethod (groups = {"testInclude", "testIncludeTWO", "testExclude"}, alwaysRun = true)

    public void startAndFullScreen () throws IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Andrew\\IdeaProjects\\automationCourse\\src\\test\\resources\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        log = Logger.getLogger(getClass().getName());
        saveLogs(log);

        homePage = new HomePage(driver,log);
        signInPage = new SignInPage(driver,log);
        signUpPage = new SignUpPage(driver,log);
        quizzersListAndTestPage = new QuizzersListAndTestPage(driver,log);



       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod (groups = {"testInclude", "testIncludeTWO", "testExclude"}, alwaysRun = true)
    public void closeBrowser(){

        driver.quit();
    }


    public void saveLogs(Logger log) throws IOException {
        FileHandler fileHandler;
        fileHandler = new FileHandler("C:\\Users\\Andrew\\Documents\\GitHub\\automationCources\\MyLogs.log");
        log.addHandler(fileHandler);
        SimpleFormatter formatter = new SimpleFormatter();
        fileHandler.setFormatter(formatter);
        log.info("This is beginning of the test");

    }
}


