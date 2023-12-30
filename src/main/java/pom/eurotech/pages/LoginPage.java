package pom.eurotech.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import pom.eurotech.utilities.ConfigurationReader;

public class LoginPage extends BasePage {
    @FindBy(id = "rcc-confirm-button")
    public WebElement understandBtn;
    @FindBy(id = "loginpage-input-email")
    public WebElement usernameInput;
    @FindBy(id = "loginpage-form-pw-input")
    public WebElement passwordInput;
    @FindBy(id = "loginpage-form-btn")
    public WebElement loginBtn;
    @FindBy(xpath = "//div[text()='Invalid Credentials!']")
    public WebElement warningMessage;
    @FindBy(xpath = "//div[text()='Please include a valid email!']")
    public WebElement emailWarningMessage;

    ////////////////////////////////////////////////////////////////////

    // Logical OR --> true + false / false + true / true + true
    // To use multiple locator if at least one of them is matching, it will find the webElement
    @FindAll({ // like Logical OR
            @FindBy(id = "loginpage-input-email"),
            @FindBy(name = "email")
    })
    public WebElement usernameInputFindAll;

    // Logical AND --> true + true
    // If the both locators are matching, it will find the webElement
    @FindBys({ // like Logical AND
            @FindBy(id = "loginpage-form-pw-input"),
            @FindBy(xpath = "//input[@placeholder='Password']")
    })
    public WebElement passwordInputFindBys;

    // Locate a list of webElement (https://the-internet.herokuapp.com/)
    // findElements() --> we have to implement as List of WebElement
//    @FindBy(tagName = "li")
//    public List<WebElement> list;


    ////////////////////////////////////////////////////////////////////

    public void login(){
        String username= ConfigurationReader.get("usernameTeacher");
        String password= ConfigurationReader.get("passwordTeacher");
        understandBtn.click();
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }
    public void login(String username,String password){
        understandBtn.click();
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }
    public void loginAsTeacher(){
        String username= ConfigurationReader.get("usernameTeacher");
        String password= ConfigurationReader.get("passwordTeacher");
        understandBtn.click();
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }
    public void loginAsStudent(){
        String username= ConfigurationReader.get("usernameStudent");
        String password= ConfigurationReader.get("passwordStudent");
        understandBtn.click();
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }
}