package tel_ran.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTests extends TestBase {


    @Test
    public void logintoTrelloPositive() throws InterruptedException {

        waitUntilElementIsClickable(By.xpath("//a[@class='btn btn-sm btn-link text-white']"), 20);
        driver.findElement(By.xpath("//a[@class='btn btn-sm btn-link text-white']")).click();

//        Thread.sleep(5000);
        waitUntilElementIsVisible(By.xpath("//input[@id='user']"), 20);
        driver.findElement(By.xpath("//input[@id='user']")).sendKeys("451f@mail.ru");
//        Thread.sleep(5000);
        waitUntilElementIsClickable(By.cssSelector("#login"), 20);
        driver.findElement(By.cssSelector("#login")).click();
//        Thread.sleep(5000);

        waitUntilElementIsClickable(By.xpath("//button[@id='login-submit']"), 20);
        driver.findElement(By.xpath("//button[@id='login-submit']")).click();

//        Thread.sleep(5000);
        waitUntilElementIsVisible(By.xpath("//input[@id='password']"), 20);
        waitUntilElementIsClickable(By.xpath("//button[@id='login-submit']//span[@class='css-t5emrf']"), 20);

        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(("androm26"));
        driver.findElement(By.xpath("//button[@id='login-submit']//span[@class='css-t5emrf']")).click();

//        Thread.sleep(30000);

        waitUntilElementIsClickable(By.xpath("//span[@class='MEu8ZECLGMLeab']"), 50);

        Assert.assertTrue(driver.findElement(By.xpath("//button[@data-test-id='header-boards-menu-button']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//h3[@class='boards-page-board-section-header-name']")).isDisplayed());


    }

    @Test
    public void LoginTrelloNegative() throws InterruptedException {

        waitUntilElementIsClickable(By.xpath("//a[@class='btn btn-sm btn-link text-white']"), 20);

        driver.findElement(By.xpath("//a[@class='btn btn-sm btn-link text-white']")).click();


//        Thread.sleep(5000);

        waitUntilElementIsVisible(By.xpath("//input[@id='user']"), 20);
        driver.findElement(By.xpath("//input[@id='user']")).sendKeys("4511f@mail.ru");
//        Thread.sleep(5000);
        waitUntilElementIsVisible(By.cssSelector("#login"), 20);
        driver.findElement(By.cssSelector("#login")).click();
//        Thread.sleep(5000);
        waitUntilElementIsVisible(By.xpath("//p[@class='error-message']"), 20);
        System.out.println(driver.findElement(By.xpath("//p[@class='error-message']")).getText());
//        Thread.sleep(5000);
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='error-message']")).isDisplayed());

    }

    @Test

    public void LoginTrelloNegativePas() throws InterruptedException {

        waitUntilElementIsClickable(By.xpath("//a[@class='btn btn-sm btn-link text-white']"), 20);
        driver.findElement(By.xpath("//a[@class='btn btn-sm btn-link text-white']")).click();


//        Thread.sleep(5000);

        waitUntilElementIsVisible(By.xpath("//input[@id='user']"), 20);
        driver.findElement(By.xpath("//input[@id='user']")).sendKeys("451f@mail.ru");
//        Thread.sleep(5000);
        waitUntilElementIsClickable(By.cssSelector("#login"),20);
        driver.findElement(By.cssSelector("#login")).click();
//        Thread.sleep(5000);
        waitUntilElementIsClickable(By.xpath("//button[@id='login-submit']"),20);
        driver.findElement(By.xpath("//button[@id='login-submit']")).click();

//        Thread.sleep(5000);
        waitUntilElementIsVisible(By.xpath("//input[@id='password']"),20);
        waitUntilElementIsClickable(By.xpath("//button[@id='login-submit']//span[@class='css-t5emrf']"),20);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(("androm2611"));
        driver.findElement(By.xpath("//button[@id='login-submit']//span[@class='css-t5emrf']")).click();
//        Thread.sleep(5000);

        waitUntilElementIsVisible(By.xpath("//div[@id='login-error']"),20);
        System.out.println(driver.findElement(By.xpath("//div[@id='login-error']")).getText());


//        Thread.sleep(5000);

        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='login-error']")).isDisplayed());

    }


}