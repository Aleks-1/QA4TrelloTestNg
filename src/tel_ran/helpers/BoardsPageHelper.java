package tel_ran.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;
import java.util.Random;

import static tel_ran.tests.TestBase.quantityBeg;

import static tel_ran.tests.TestBase.quantityEnd;

public class BoardsPageHelper extends PageBase{



    public BoardsPageHelper(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//button[@data-test-id='header-boards-menu-button']")
    WebElement ButtonBoardsLeftCorner;

    @FindBy(xpath = "//h3[@class='boards-page-board-section-header-name']")
    WebElement TitleMainPageBoards;

    @FindBy(xpath = "//div[@title='QA4 Auto']/..")
    WebElement myBoard;

    @FindBy(xpath = "//span[@class='placeholder']")
    WebElement addAnotherListButton;

    @FindBy(xpath = "//textarea[@class='list-header-name mod-list-name js-list-name-input']")
    List<WebElement> namesList;

    @FindBy(xpath = "//input[@class='list-name-input']")
    WebElement  fieldEnterListTitle;
    @FindBy(xpath = "//input[@class='primary mod-list-add-button js-save-edit']")
    WebElement ButtonAddListSaveList;

    @FindBy(xpath = "//a[@class='list-header-extras-menu dark-hover js-open-list-menu icon-sm icon-overflow-menu-horizontal']")
    WebElement ListMenuButton;

    @FindBy(xpath = "//a[@class='js-copy-list']")
    WebElement menuItemCopyList;

    @FindBy(xpath = "//input[@class='primary wide js-submit']")
    WebElement ButtonCreateList;

    @FindBy(xpath = "//textarea[@class='list-header-name mod-list-name js-list-name-input']")
    WebElement titleList;

    @FindBy(xpath = "a.js-cancel-edit")
    WebElement buttonCancelEdit;

    @Override
    public void waitUntilPageIsLoaded() {
        waitUntilElementIsClickable(ButtonBoardsLeftCorner,30);





    }

    public boolean verifyIfBoardsIconIsDisplayed(){
        return ButtonBoardsLeftCorner.isDisplayed();
    }

    public boolean verifyIfPersonalBoardsHeaderIsDisplayed(){
        return TitleMainPageBoards.equals("Personal Boards");
    }

    public void enterMyBoard(){
        waitUntilElementIsVisible(myBoard, 20);
        myBoard.click();
    }


    public void quantityCheckBefore(){

        waitUntilElementIsVisible(addAnotherListButton,20);
        quantityBeg = namesList.size();
    }

    public void quantityCheckAfter(){

        waitUntilElementIsVisible(addAnotherListButton,20);
        quantityEnd = namesList.size();
    }

    public void creatIfNotLists(){


        if(quantityBeg == 0){

            waitUntilElementIsClickable(addAnotherListButton,30);
            addAnotherListButton.click();
            waitUntilElementIsVisible(fieldEnterListTitle,30);
            fieldEnterListTitle.clear();
            fieldEnterListTitle.sendKeys("NewList");
            waitUntilElementIsClickable(ButtonAddListSaveList,20);
            ButtonAddListSaveList.click();
            quantityBeg++;


        }

    }

    public void copyList(){
        waitUntilElementIsClickable(ListMenuButton,30);
        ListMenuButton.click();
        waitUntilElementIsVisible(menuItemCopyList,30);
        menuItemCopyList.click();
        waitUntilElementIsClickable(ButtonCreateList,20);
        ButtonCreateList.click();

        waitUntilElementIsClickable(titleList,20);


    }

    public boolean  copyValidation(){

        waitUntilElementIsClickable(titleList,20);

        int quantityEnd = namesList.size();
        System.out.println(quantityEnd);

//        List<WebElement> list = driver.findElements(By.xpath("//textarea[@class='list-header-name mod-list-name js-list-name-input']"));

        int i = namesList.size();

        return namesList.get(i-2).getText().equals(namesList.get(i-1).getText());

    }

    public void genNameListAndCreat(){

//        WebElement addListButton = driver.findElement(By.cssSelector(".placeholder"));
        String nameAddListButton = addAnotherListButton.getText();
        addAnotherListButton.click();
        waitUntilElementIsVisible(fieldEnterListTitle, 10);
        String str = genRandomString(7);
        //System.out.println("Name button - " + nameAddListButton);
        int quantityListAtFirst = namesList.size();
        if (nameAddListButton.equals("Add another list")) {
            boolean exitName = false;
            //System.out.println("Size-" + driver.findElements(By.xpath("//h2/../textarea")).size());
            for (WebElement element : namesList) {
                //System.out.println("Name - " + element.getText());
                if (element.getText().equals(str)) exitName = true;
            }
            if (exitName) str = stringWithRandomNumber(1000, str);
        }

        fieldEnterListTitle.sendKeys(str);
        ButtonAddListSaveList.click();

        waitUntilElementIsClickable(buttonCancelEdit, 10);
        buttonCancelEdit.click();
    }

public boolean VerifyQuantityLists(){

        int quantityListAtTheEnd = namesList.size();

        return true;


}








    public static String genRandomString(int num) {
        String str = "";
        int number;
        Random gen = new Random();
        for (int i = 0; i < num; i++) {
            number = '!' + gen.nextInt('z' - '!' + 1);
            str = str + (char) number;
        }
        return str;
    }

    public static String stringWithRandomNumber(int num, String str) {
        Random gen = new Random();
        return str + gen.nextInt(num);
    }


}