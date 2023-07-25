package testcases;


import org.testng.annotations.Test;




<<<<<<< Updated upstream:src/test/java/testcases/validDrpDwnCntntTest.java
public class validDrpDwnCntntTest extends BaseTest{
=======
public class ValidDrpDwnCntntTest extends BaseTest{
>>>>>>> Stashed changes:src/test/java/testcases/ValidDrpDwnCntntTest.java

    @Test(groups = {"testInclude"})
    public void openSignUpPage ()  {

        homePage.openWebSite();
        homePage.clickSignUpButton();
        System.out.println("va;id 1");
    }

<<<<<<< Updated upstream:src/test/java/testcases/validDrpDwnCntntTest.java

    @Test
=======
    @Test(groups = {"testInclude"})
>>>>>>> Stashed changes:src/test/java/testcases/ValidDrpDwnCntntTest.java
    public void list ()  {

        homePage.openWebSite();
        homePage.clickSignUpButton();
        signUpPage.getDropDownContent();
        System.out.println("va;id 2");

    }

    @Test(groups = {"testIncludeTWO"})
    public void list2 ()  {

        homePage.openWebSite();
        homePage.clickSignUpButton();
        signUpPage.compareDropDownContentWithMatch();
        System.out.println("va;id 3");

    }

}