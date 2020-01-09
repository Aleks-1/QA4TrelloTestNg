package tel_ran.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tel_ran.helpers.BoardsPageHelper;
import tel_ran.helpers.HomePageHelper;
import tel_ran.helpers.LoginPageHelper;

import java.util.List;



public class CurrentBoardPageTests extends TestBase {
    HomePageHelper homePage;
    LoginPageHelper loginPage;
    BoardsPageHelper boardsPage;


    @BeforeMethod
    public void initTest() {

        homePage = new HomePageHelper(driver);
        loginPage = new LoginPageHelper(driver);
        boardsPage = new BoardsPageHelper(driver);

//        WebElement loginIcon = driver.findElement(By
//                .xpath("//a[@class='btn btn-sm btn-link text-white']"));
//
//        loginIcon.click();
//        waitUntilElementIsClickable(By.id("login"), 30);
//        WebElement userField = driver.findElement(By.id("user"));
//        userField.click();
//        userField.clear();
//        userField.sendKeys("451f@mail.ru");
//        driver.findElement(By.id("login")).click();
//
//        waitUntilElementIsClickable(By.id("login-submit"), 30);
//        driver.findElement(By.id("login-submit")).click();
//
//        waitUntilElementIsClickable(By.id("password"), 30);
//        waitUntilElementIsClickable(By.id("login-submit"), 30);
//        driver.findElement(By.id("password")).sendKeys("androm26");
//        driver.findElement(By.id("login-submit")).click();
//
//        waitUntilElementIsClickable(By
//                .xpath("//button[@data-test-id='header-boards-menu-button']"), 30);

    }

    @Test

    public void testCopyFirstList(){

        homePage.openLoginPage();
        loginPage.waitUntilPageIsLoaded();
        loginPage.loginToTrelloAsAtlassian(LOGIN,PASSWORD);
        boardsPage.waitUntilPageIsLoaded();

        boardsPage.enterMyBoard();

        boardsPage.quantityCheckBefore();

        boardsPage.creatIfNotLists();

        boardsPage.copyList();

        boardsPage.quantityCheckAfter();

        Assert.assertEquals(quantityBeg +1, quantityEnd);

        Assert.assertTrue(boardsPage.copyValidation());






    }



}
