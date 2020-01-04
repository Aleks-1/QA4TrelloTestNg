package tel_ran.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.xml.bind.Element;
import java.util.List;

public class CurrentBoardPageTests extends TestBase {

    @BeforeMethod
    public void initTest() {
        WebElement loginIcon = driver.findElement(By
                .xpath("//a[@class='btn btn-sm btn-link text-white']"));

        loginIcon.click();
        waitUntilElementIsClickable(By.id("login"), 30);
        WebElement userField = driver.findElement(By.id("user"));
        userField.click();
        userField.clear();
        userField.sendKeys("451f@mail.ru");
        driver.findElement(By.id("login")).click();

        waitUntilElementIsClickable(By.id("login-submit"), 30);
        driver.findElement(By.id("login-submit")).click();

        waitUntilElementIsClickable(By.id("password"), 30);
        waitUntilElementIsClickable(By.id("login-submit"), 30);
        driver.findElement(By.id("password")).sendKeys("androm26");
        driver.findElement(By.id("login-submit")).click();

        waitUntilElementIsClickable(By
                .xpath("//button[@data-test-id='header-boards-menu-button']"), 30);

    }

    @Test

    public void testCopyFirstList(){

        waitUntilElementIsVisible(By.xpath("//div[@title='QA4 Auto']/.."), 20);
        driver.findElement(By.xpath("//div[@title='QA4 Auto']/..")).click();

//        waitUntilElementIsVisible(By.xpath("//textarea[@class='list-header-name mod-list-name js-list-name-input']"),10);
        waitUntilElementIsVisible(By.xpath("//span[@class='placeholder']"),20);
        int quantityBeg = driver.findElements(By.xpath("//textarea[@class='list-header-name mod-list-name js-list-name-input']")).size();
        System.out.println(quantityBeg);

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
        waitUntilElementIsClickable(By.xpath("//a[@class='list-header-extras-menu dark-hover js-open-list-menu icon-sm icon-overflow-menu-horizontal']"),30);
        driver.findElement(By.xpath("//a[@class='list-header-extras-menu dark-hover js-open-list-menu icon-sm icon-overflow-menu-horizontal']")).click();
        waitUntilElementIsVisible(By.xpath("//a[@class='js-copy-list']"),30);
        driver.findElement(By.xpath("//a[@class='js-copy-list']")).click();
        waitUntilElementIsClickable(By.xpath("//input[@class='primary wide js-submit']"),20);
        driver.findElement(By.xpath("//input[@class='primary wide js-submit']")).click();

        waitUntilElementIsClickable(By.xpath("//textarea[@class='list-header-name mod-list-name js-list-name-input']"),20);

        int quantityEnd = driver.findElements(By.xpath("//textarea[@class='list-header-name mod-list-name js-list-name-input']")).size();
        System.out.println(quantityEnd);

        List<WebElement> list = driver.findElements(By.xpath("//textarea[@class='list-header-name mod-list-name js-list-name-input']"));

        int i = list.size();





        Assert.assertEquals(quantityBeg + 1  , quantityEnd);

        Assert.assertEquals(list.get(i-2).getText(), list.get(i-1).getText());






    }



}
