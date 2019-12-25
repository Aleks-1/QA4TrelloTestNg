package tel_ran.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    WebDriver driver;

    @BeforeMethod


    public void setup() throws InterruptedException {
        driver = new ChromeDriver();

        driver.manage().window().fullscreen();


        driver.get("https://trello.com/home/");
        Thread.sleep(10000);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}