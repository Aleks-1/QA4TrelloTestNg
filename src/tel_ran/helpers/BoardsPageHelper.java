package tel_ran.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static tel_ran.tests.TestBase.quantityBeg;

import static tel_ran.tests.TestBase.quantityEnd;

public class BoardsPageHelper extends PageBase{



    public BoardsPageHelper(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitUntilPageIsLoaded() {
        waitUntilElementIsClickable(By
                .xpath("//button[@data-test-id='header-boards-menu-button']"),30);

    }

    public boolean verifyIfBoardsIconIsDisplayed(){
        return driver.findElement(By
                .xpath("//button[@data-test-id='header-boards-menu-button']"))
                .isDisplayed();
    }

    public boolean verifyIfPersonalBoardsHeaderIsDisplayed(){
        return driver.findElement(By
                .xpath("//h3[@class='boards-page-board-section-header-name']"))
                .getText().equals("Personal Boards");
    }

    public void enterMyBoard(){
        waitUntilElementIsVisible(By.xpath("//div[@title='QA4 Auto']/.."), 20);
        driver.findElement(By.xpath("//div[@title='QA4 Auto']/..")).click();
    }


    public void quantityCheckBefore(){

        waitUntilElementIsVisible(By.xpath("//span[@class='placeholder']"),20);
        quantityBeg = driver.findElements(By.xpath("//textarea[@class='list-header-name mod-list-name js-list-name-input']")).size();
    }

    public void quantityCheckAfter(){

        waitUntilElementIsVisible(By.xpath("//span[@class='placeholder']"),20);
        quantityEnd = driver.findElements(By.xpath("//textarea[@class='list-header-name mod-list-name js-list-name-input']")).size();
    }

    public void creatIfNotLists(){


        if(quantityBeg == 0){

            waitUntilElementIsClickable(By.xpath("//span[@class='placeholder']"),30);
            driver.findElement(By.xpath("//span[@class='placeholder']")).click();
            waitUntilElementIsVisible(By.xpath("//input[@class='list-name-input']"),30);
            driver.findElement(By.xpath("//input[@class='list-name-input']")).clear();
            driver.findElement(By.xpath("//input[@class='list-name-input']")).sendKeys("NewList");
            waitUntilElementIsClickable(By.xpath("//input[@class='primary mod-list-add-button js-save-edit']"),20);
            driver.findElement(By.xpath("//input[@class='primary mod-list-add-button js-save-edit']")).click();
            quantityBeg++;


        }

    }

    public void copyList(){
        waitUntilElementIsClickable(By.xpath("//a[@class='list-header-extras-menu dark-hover js-open-list-menu icon-sm icon-overflow-menu-horizontal']"),30);
        driver.findElement(By.xpath("//a[@class='list-header-extras-menu dark-hover js-open-list-menu icon-sm icon-overflow-menu-horizontal']")).click();
        waitUntilElementIsVisible(By.xpath("//a[@class='js-copy-list']"),30);
        driver.findElement(By.xpath("//a[@class='js-copy-list']")).click();
        waitUntilElementIsClickable(By.xpath("//input[@class='primary wide js-submit']"),20);
        driver.findElement(By.xpath("//input[@class='primary wide js-submit']")).click();

        waitUntilElementIsClickable(By.xpath("//textarea[@class='list-header-name mod-list-name js-list-name-input']"),20);


    }

    public boolean  copyValidation(){

        waitUntilElementIsClickable(By.xpath("//textarea[@class='list-header-name mod-list-name js-list-name-input']"),20);

        int quantityEnd = driver.findElements(By.xpath("//textarea[@class='list-header-name mod-list-name js-list-name-input']")).size();
        System.out.println(quantityEnd);

        List<WebElement> list = driver.findElements(By.xpath("//textarea[@class='list-header-name mod-list-name js-list-name-input']"));

        int i = list.size();

        return list.get(i-2).getText().equals(list.get(i-1).getText());

    }


}