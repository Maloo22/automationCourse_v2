package testcases;

import org.testng.annotations.Test;

public class HW_17_EndToEnt_Part_2_Ex_3_TEST extends BaseTest{





    @Test
    public void ScenarioThree () {
        //  1 + 2. Open main page + Open Course Gallery page
        homePage.openWebSite();
        homePage.openCourseGalleryPageByClickButton();

        // 3. Note the total number of questions in the “SQL 101 (Basic)” quiz
        quizzersListAndTestPage.takingTotalNum();


        // 4. Click the “Start” button on “SQL 101 (Basic)”

        quizzersListAndTestPage.pressStartBtn();
        quizzersListAndTestPage.switchToTestTab();

//        5. Select an answer for the first question
//        6. Validate that the progress bar now has the correct value (correct value = number of answered questions / total number of questions)
//        7. Click the “Next” button
//        8. Validate progress bar has changed value
//        9. Validate new changed value is correct

        quizzersListAndTestPage.passingTestAndProgressBarValidation();
    }
}
