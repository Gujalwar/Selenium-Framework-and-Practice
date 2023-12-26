package pom.eurotech.test.day18_ExtentReports;

import org.testng.Assert;
import org.testng.annotations.Test;
import pom.eurotech.pages.LoginPage;
import pom.eurotech.test.TestBase;
import pom.eurotech.utilities.ConfigurationReader;

public class NegativeLoginTest extends TestBase {
    @Test
    public void wrongPassword(){
        extentLogger = report.createTest("Invalid Passsword Test");
        extentLogger.info("Navigate to the url http://eurotech.study/login");
        driver.get(ConfigurationReader.get("url"));

        extentLogger.info("Click I Understand Button");
        LoginPage loginPage = new LoginPage();
        loginPage.understandBtn.click();
        extentLogger.info("Enter valid email/username");
        loginPage.usernameInput.sendKeys(ConfigurationReader.get("usernameTeacher"));
        extentLogger.info("Enter invalid Password");
        loginPage.usernameInput.sendKeys("password");
        extentLogger.info("Click login button");
        loginPage.loginBtn.click();
        String actualMessage = loginPage.warningMessage.getText();
        extentLogger.info("Verify that user can not login");
        Assert.assertEquals(actualMessage,"Invalid Credentials!");

    }

    @Test
    public void wrongUsername() {
        LoginPage loginPage = new LoginPage();
        extentLogger = report.createTest("Invalid Username Test");

        extentLogger.info("Navigate the url http://eurotech.study/login");
        driver.get(ConfigurationReader.get("url"));

        extentLogger.info("Click I understand button");
        loginPage.understandBtn.click();

        extentLogger.info("Enter invalid username");
        loginPage.usernameInput.sendKeys("euro@gmail.com");

        extentLogger.info("Enter valid password");
        loginPage.passwordInput.sendKeys(ConfigurationReader.get("passwordTeacher"));

        extentLogger.info("Click login button");
        loginPage.loginBtn.click();

        String actualMessage= loginPage.warningMessage.getText();

        extentLogger.info("Verify that user cannot login");
        Assert.assertEquals(actualMessage,"Invalid Credentials!");

        extentLogger.pass("Passed");


    }

}




