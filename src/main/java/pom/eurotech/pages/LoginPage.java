package pom.eurotech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pom.eurotech.utilities.ConfigurationReader;
import pom.eurotech.utilities.Driver;

public class LoginPage {
    public LoginPage() {
       PageFactory.initElements(Driver.get(),this);
    }

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
        String username= ConfigurationReader          .get("usernameTeacher");
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



