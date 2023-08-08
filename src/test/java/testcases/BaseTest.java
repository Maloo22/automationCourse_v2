package testcases;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageObjects.HomePage;
import pageObjects.QuizzersListAndTestPage;
import pageObjects.SignInPage;
import pageObjects.SignUpPage;

import java.time.Duration;



public class BaseTest {



    public ChromeDriver driver;
    HomePage homePage;
    SignInPage signInPage;
    SignUpPage signUpPage;
    QuizzersListAndTestPage quizzersListAndTestPage;



    @BeforeMethod (groups = {"testInclude", "testIncludeTWO", "testExclude"}, alwaysRun = true)

    public void startAndFullScreen () {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Andrew\\IdeaProjects\\automationCourse\\src\\test\\resources\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();


        homePage = new HomePage(driver);
        signInPage = new SignInPage(driver);
        signUpPage = new SignUpPage(driver);
        quizzersListAndTestPage = new QuizzersListAndTestPage(driver);



       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod (groups = {"testInclude", "testIncludeTWO", "testExclude"}, alwaysRun = true)
    public void closeBrowser(){

    //        driver.quit();
    }
}


