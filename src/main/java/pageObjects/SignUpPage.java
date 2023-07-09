package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SignUpPage extends BaseMain{


    public SignUpPage(WebDriver driver) {
        super(driver);
    }

//55
    public void getDropDownContent () {
        WebElement DropDownElement;
        DropDownElement = driver.findElement(By.id("job-title"));
        Select searchDropDown = new Select(DropDownElement);
        List<WebElement> options = new ArrayList<>();
        options = searchDropDown.getOptions();
        int listSize = options.size();
        for (int i = 0; i < listSize; i++) {
            System.out.println(options.get(i).getText());
        }
    }



public void compareDropDownContentWithMatch() {
    WebElement dropDownElement = driver.findElement(By.id("job-title"));
    Select searchDropDown = new Select(dropDownElement);
    List<WebElement> options = searchDropDown.getOptions();

    List<String> existingList = Arrays.asList("Junior level Developer", "Middle level Developer", "Senior level Developer",
            "Leading Developer", "QA Analyst", "Software Tester", "QA Engineer", "Senior QA Engineer", "Automation QA Engineer",
            "Test Lead", "Automation Test Lead", "Business Analyst", "Senior Business Analyst", "Designer");

    if (options.size() == existingList.size()) {
        boolean match = true;
        for (int i = 0; i < options.size(); i++) {
            String optionText = options.get(i).getText();
            if (!optionText.equals(existingList.get(i))) {
                match = false;
                break;
            }
        }
        if (match) {
            System.out.println("similar lists !!!");
        } else {
            System.out.println("NOT !!! similar lists");
        }
    } else {
        System.out.println("NOT !!! similar lists");
    }
}








}