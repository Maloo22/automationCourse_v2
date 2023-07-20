package testcases;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageObjects.HomePage;
import pageObjects.SignInPage;
import pageObjects.SignUpPage;

import java.time.Duration;


public class BaseTest {


    public ChromeDriver driver;
    HomePage homePage;
    SignInPage signInPage;
    SignUpPage signUpPage;



    @BeforeMethod
    public void startAndFullScreen () {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Andrew\\IdeaProjects\\automationCourse\\src\\test\\resources\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();


        homePage = new HomePage(driver);
        signInPage = new SignInPage(driver);
        signUpPage = new SignUpPage(driver);


       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
    }

    @AfterMethod
    public void closeBrowser(){
        driver.close();
    }
}


