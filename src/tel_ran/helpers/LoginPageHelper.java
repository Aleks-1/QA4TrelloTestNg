package tel_ran.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageHelper extends  PageBase{


    @FindBy (id = "user")
    WebElement userField;

    @FindBy (id = "login")
    WebElement loginButton;

    @FindBy(xpath = "//button[@id='login-submit']//span[contains(text(),'Log in')]")
    WebElement theSecondLoginButton;

    @FindBy (xpath = "//button[@id='login-submit']//span[contains(text(),'Continue')]")
    WebElement continueButton;

    @FindBy (id = "password")
    WebElement passwordFieldAtlassian;

    @FindBy (xpath = "//p[@class='error-message']")
    WebElement loginError;

    @FindBy(xpath = "//div[@id = 'login-error']/span")
    WebElement passwordErrorMassage;





    public LoginPageHelper(WebDriver driver){
        super(driver);
    }
    public void waitUntilPageIsLoaded(){
        waitUntilElementIsClickable(loginButton,30);
    }

    public void enterAtlLogin(String login) {

        userField.click();
        userField.clear();
        userField.sendKeys(login);
    }

    public void enterLoginWithOutAtl(String login) {

        userField.sendKeys(login);


    }

    public void clickLoginWithAtlassian() {
       loginButton.click();
    }



    public void clickLoginWithoutAtl(){
        waitUntilElementIsClickable(loginButton,10);
       loginButton.click();



    }

    public void clickContinueButton() {
        waitUntilElementIsClickable(continueButton,30);
        continueButton.click();
    }

    public void loginToTrelloAsAtlassian(String login, String password){
        this.enterAtlLogin(login);
        this.clickLoginWithAtlassian();
        this.clickContinueButton();
        this.enterAtlPasswordAndLogin(password);
    }

    public void enterAtlPasswordAndLogin(String password) {
        waitUntilElementIsClickable(passwordFieldAtlassian,30);
        waitUntilElementIsClickable(theSecondLoginButton,30);
        passwordFieldAtlassian.sendKeys(password);
        theSecondLoginButton.click();
    }

    public void waitPasswordError() {
        waitUntilElementIsVisible(passwordErrorMassage,10);
    }
    public void waitLoginError(){
        waitUntilElementIsVisible(loginError,20);

    }

    public boolean verifyIfPasswordErrorIsCorrect(){
        return passwordErrorMassage.getText()
                .contains("Incorrect email address and / or password.");
    }

    public boolean verifyIfLoginErrorIsCorrect(){

                return loginError.isDisplayed();

    }
}