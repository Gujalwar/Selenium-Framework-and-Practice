package pom.eurotech.test.day15_POM1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import pom.eurotech.pages.LoginPage;
import pom.eurotech.utilities.ConfigurationReader;
import pom.eurotech.test.TestBase;

public class NegativeLoginTest extends TestBase {

    @Test
    public void wrongPassword() {
        driver.get(ConfigurationReader.get("url"));
        WebElement understandBtn= driver.findElement(By.id("rcc-confirm-button"));
        understandBtn.click();
        WebElement usernameInput= driver.findElement(By.id("loginpage-input-email"));
        WebElement passwordInput= driver.findElement(By.id("loginpage-form-pw-input"));
        WebElement loginBtn= driver.findElement(By.id("loginpage-form-btn"));

        usernameInput.sendKeys(ConfigurationReader.get("usernameTeacher"));
        passwordInput.sendKeys("passwordTeacher");
        loginBtn.click();

        WebElement warningMessage= driver.findElement(By.xpath("//div[text()='Invalid Credentials!']"));

//        String expectedMessage= "Invalid Credentials!";
//        String actualMessage= warningMessage.getText();
//        Assert.assertEquals(actualMessage,expectedMessage);

        Assert.assertEquals(warningMessage.getText(),"Invalid Credentials!");
    }

    @Test
    public void wrongUsernameWithPOM() {
        LoginPage loginPage = new LoginPage();

        driver.get(ConfigurationReader.get("url"));
        loginPage.understandBtn.click();
        loginPage.usernameInput.sendKeys("eurotech@gmail");
        loginPage.passwordInput.sendKeys(ConfigurationReader.get("passwordTeacher"));
        loginPage.loginBtn.click();
        Assert.assertEquals(loginPage.emailWarningMessage.getText(),"Please include a valid email!");
    }

    @Test
    public void wrongPasswordWithPOM() {
        LoginPage loginPage = new LoginPage();

        driver.get(ConfigurationReader.get("url"));
        loginPage.understandBtn.click();
        loginPage.usernameInput.sendKeys(ConfigurationReader.get("usernameTeacher"));
        loginPage.passwordInput.sendKeys("passwordTeacher");
        loginPage.loginBtn.click();
        Assert.assertEquals(loginPage.warningMessage.getText(),"Invalid Credentials!");
    }

    @FindBy(xpath = "//div[text()='Please include a valid email!']")
    public WebElement emailWarningMessage;


    }

