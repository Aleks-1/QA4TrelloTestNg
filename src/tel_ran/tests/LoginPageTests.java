package tel_ran.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginPageTests extends TestBase{


    @Test
    public void logintoTrelloPositive() throws InterruptedException {


        driver.findElement(By.xpath("//a[@class='btn btn-sm btn-link text-white']")).click();


        Thread.sleep(5000);


        driver.findElement(By.xpath("//input[@id='user']")).sendKeys("451f@mail.ru");
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("#login")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@id='login-submit']")).click();



        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(("androm26"));
        driver.findElement(By.xpath("//button[@id='login-submit']//span[@class='css-t5emrf']")).click();


        Thread.sleep(30000);



    }

    @Test
    public void LoginTrelloNegative() throws InterruptedException {

        driver.findElement(By.xpath("//a[@class='btn btn-sm btn-link text-white']")).click();


        Thread.sleep(5000);


        driver.findElement(By.xpath("//input[@id='user']")).sendKeys("4511f@mail.ru");
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("#login")).click();
        Thread.sleep(5000);
        System.out.println(driver.findElement(By.xpath("//p[@class='error-message']")).getText());
        Thread.sleep(5000);

    }
    @Test

    public void LoginTrelloNegativePas() throws InterruptedException {
        driver.findElement(By.xpath("//a[@class='btn btn-sm btn-link text-white']")).click();


        Thread.sleep(5000);


        driver.findElement(By.xpath("//input[@id='user']")).sendKeys("451f@mail.ru");
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("#login")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@id='login-submit']")).click();



        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(("androm2611"));
        driver.findElement(By.xpath("//button[@id='login-submit']//span[@class='css-t5emrf']")).click();
        Thread.sleep(5000);
        System.out.println(driver.findElement(By.xpath("//div[@id='login-error']")).getText());


        Thread.sleep(5000);

    }




}