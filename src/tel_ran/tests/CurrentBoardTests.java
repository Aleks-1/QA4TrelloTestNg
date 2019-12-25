package tel_ran.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class CurrentBoardTests extends TestBase{

    @Test
    public void  createNewList() throws InterruptedException {

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


        driver.findElement(By.xpath("//div[@title='QA4 Auto']/..")).click();

        Thread.sleep(5000);



        try {



            if(driver.findElement(By.xpath("//a[@class='list-header-extras-menu dark-hover js-open-list-menu icon-sm icon-overflow-menu-horizontal']")).isDisplayed()){

                driver.findElement(By.xpath("//a[@class='list-header-extras-menu dark-hover js-open-list-menu icon-sm icon-overflow-menu-horizontal']")).click();

                driver.findElement(By.xpath("//a[@class='js-close-list']")).click();

            }
        }catch (Exception e){


            driver.findElement(By.xpath("//span[@class='placeholder']")).click();
            driver.findElement(By.xpath("//input[@placeholder='Enter list title...']")).sendKeys("1");
            driver.findElement(By.xpath("//input[@class='primary mod-list-add-button js-save-edit']")).click();
            Thread.sleep(5000);
            driver.findElement(By.xpath("//a[@class='list-header-extras-menu dark-hover js-open-list-menu icon-sm icon-overflow-menu-horizontal']")).click();

            Thread.sleep(5000);

            driver.findElement(By.xpath("//a[@class='js-close-list']")).click();


            System.out.println("Ok");
        }

        Thread.sleep(5000);



    }


    @Test
    public void addFirstCardInNewList() throws InterruptedException {
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

        driver.findElement(By.xpath("//div[@title='QA4 Auto']/..")).click();


        Thread.sleep(5000);

        String tmp = driver.findElement(By.xpath("//textarea[@class='list-header-name mod-list-name js-list-name-input']")).getText();
//        System.out.println(tmp);

        List<WebElement> list = driver.findElements(By.xpath("//textarea[@class='list-header-name mod-list-name js-list-name-input']"));
        String a = tmp + (int)(Math.random()*100);
        for(int i = 0; i < list.size(); i++){

            System.out.println(list.get(i).getText());
            System.out.println(list.get(i).getText().equals(a));

            if(list.get(i).getText().equals(a)){
                a = tmp + (int)(Math.random()*100);
                i = 0;
            }
        }



        System.out.println(a);


        driver.findElement(By.xpath("//span[@class='placeholder']")).click();
        Thread.sleep(5000);

        driver.findElement(By.xpath("//input[@placeholder='Enter list title...']")).sendKeys(a);
        Thread.sleep(5000);

        driver.findElement(By.xpath("//input[@class='primary mod-list-add-button js-save-edit']")).click();
        Thread.sleep(5000);


        Thread.sleep(5000);

    }




}
