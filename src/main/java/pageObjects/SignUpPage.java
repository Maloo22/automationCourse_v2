package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
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

/*

public void compareDropDownContent() {
    WebElement dropDownElement = driver.findElement(By.id("job-title"));
    Select searchDropDown = new Select(dropDownElement);
    List<WebElement> options = searchDropDown.getOptions();

    List<String> existingList = Arrays.asList("Option 1", "Option 2", "Option 3"); // Ваш существующий список значений

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
            System.out.println("Списки равны");
        } else {
            System.out.println("Списки не равны");
        }
    } else {
        System.out.println("Списки не равны");
    }
}

 */






}