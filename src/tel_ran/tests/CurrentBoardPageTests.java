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
import java.util.Random;


public class CurrentBoardPageTests extends TestBase {
    HomePageHelper homePage;
    LoginPageHelper loginPage;
    BoardsPageHelper boardsPage;


    @BeforeMethod
    public void initTest() {

        homePage = new HomePageHelper(driver);
        loginPage = new LoginPageHelper(driver);
        boardsPage = new BoardsPageHelper(driver);

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

//        Assert.assertTrue(boardsPage.copyValidation());

    }


    @Test
    public void createNewList() {

        homePage.openLoginPage();
        loginPage.waitUntilPageIsLoaded();
        loginPage.loginToTrelloAsAtlassian(LOGIN,PASSWORD);
        boardsPage.waitUntilPageIsLoaded();

        boardsPage.enterMyBoard();


        boardsPage.quantityCheckBefore();

        boardsPage.genNameListAndCreat();

        boardsPage.quantityCheckAfter();

        System.out.println(quantityBeg);
        System.out.println(quantityEnd);

        Assert.assertEquals(quantityBeg +1, quantityEnd);

//        Assert.assertEquals(driver.findElement(By.cssSelector("span.placeholder")).getText(), "Add another list");

    }

    @Test
    public void addFirstCardInNewList() {
        homePage.openLoginPage();
        loginPage.waitUntilPageIsLoaded();
        loginPage.loginToTrelloAsAtlassian(LOGIN,PASSWORD);
        boardsPage.waitUntilPageIsLoaded();

        boardsPage.enterMyBoard();

        waitUntilElementIsClickable(By.cssSelector(".placeholder"), 30);
        //--------Get qantity of 'Add another card' buttons at the beginning----
        int quantityAddAnotherButtonBeg = driver.findElements(By.xpath("//span[@class= 'js-add-another-card']")).size();

        //-----Add a new list------
        driver.findElement(By.cssSelector(".placeholder")).click();

        waitUntilElementIsVisible(By.cssSelector(".list-name-input"), 10);
        driver.findElement(By.cssSelector(".list-name-input"))
                .sendKeys("New List");
        waitUntilElementIsClickable(By.xpath("//input[@type='submit']"), 10);
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        waitUntilElementIsClickable(By.cssSelector("a.js-cancel-edit"), 10);
        driver.findElement(By.cssSelector("a.js-cancel-edit")).click();

        waitUntilElementIsVisible(By.cssSelector(".placeholder"), 10);
        //----- Get the last 'Add card' button----
        waitUntilAllElementsAreVisible(By.xpath("//span[@class = 'js-add-a-card']"), 15);
        List<WebElement> listAddCardButtons = driver.findElements(By.xpath("//span[@class = 'js-add-a-card']"));
        int sizeLstAddCardButtons = listAddCardButtons.size();
        WebElement lastAddCardButton = listAddCardButtons.get(sizeLstAddCardButtons - 1);
        //----Add a first card for any new list
        lastAddCardButton.click();


        waitUntilElementIsClickable(By
                .xpath("//input[@class='primary confirm mod-compact js-add-card']"), 10);
        driver.findElement(By
                .xpath("//textarea[@placeholder='Enter a title for this card…']")).sendKeys("text");
        driver.findElement(By
                .xpath("//input[@class='primary confirm mod-compact js-add-card']")).click();

        waitUntilElementIsClickable(By.cssSelector("a.js-cancel"), 10);
        driver.findElement(By.cssSelector("a.js-cancel")).click();

        //--------Get qantity of 'Add another card' buttons at the end----
        waitUntilAllElementsAreVisible(By.xpath("//span[@class= 'js-add-another-card']"), 10);
        int quantityAddAnotherButtonEnd = driver.findElements(By.xpath("//span[@class= 'js-add-another-card']")).size();

        Assert.assertEquals(quantityAddAnotherButtonBeg + 1, quantityAddAnotherButtonEnd);


    }

    @Test
    public void deleteList() throws InterruptedException {
        homePage.openLoginPage();
        loginPage.waitUntilPageIsLoaded();
        loginPage.loginToTrelloAsAtlassian(LOGIN,PASSWORD);
        boardsPage.waitUntilPageIsLoaded();

        boardsPage.enterMyBoard();

        waitUntilElementIsClickable(By.xpath("//a[@class='list-header-extras-menu dark-hover js-open-list-menu icon-sm icon-overflow-menu-horizontal']"),30);
        int quantityBeg = driver.findElements(By.xpath("//textarea[@class='list-header-name mod-list-name js-list-name-input']")).size();
        driver.findElement(By.xpath("//a[@class='list-header-extras-menu dark-hover js-open-list-menu icon-sm icon-overflow-menu-horizontal']")).click();


        waitUntilElementIsClickable(By.xpath("//a[@class='js-close-list']"),30);

        driver.findElement(By.xpath("//a[@class='js-close-list']")).click();


        waitUntilElementIsClickable(By.xpath("//a[@class='list-header-extras-menu dark-hover js-open-list-menu icon-sm icon-overflow-menu-horizontal']"),30);

        int quantityEnd = driver.findElements(By.xpath("//textarea[@class='list-header-name mod-list-name js-list-name-input']")).size();




        Assert.assertEquals(quantityBeg -1 , quantityEnd);


    }


//    public static String genRandomString(int num) {
//        String str = "";
//        int number;
//        Random gen = new Random();
//        for (int i = 0; i < num; i++) {
//            number = '!' + gen.nextInt('z' - '!' + 1);
//            str = str + (char) number;
//        }
//        return str;
//    }
//
//    public static String stringWithRandomNumber(int num, String str) {
//        Random gen = new Random();
//        return str + gen.nextInt(num);
//    }



}
