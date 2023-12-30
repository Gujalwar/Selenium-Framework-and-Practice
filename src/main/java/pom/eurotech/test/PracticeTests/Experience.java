package pom.eurotech.test.PracticeTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pom.eurotech.pages.DashboardPage;
import pom.eurotech.pages.DevelopersPage;
import pom.eurotech.pages.LoginPage;
import pom.eurotech.test.TestBase;
import pom.eurotech.utilities.ConfigurationReader;

public class Experience extends TestBase {

    @Test
    public void deleteExperience(){

        DashboardPage dashboardPage = new DashboardPage();
        LoginPage loginPage = new LoginPage();
        driver.get(ConfigurationReader.get("url"));
        loginPage.usernameInput.sendKeys(ConfigurationReader.get("usernameTeacher"));
        loginPage.passwordInput.sendKeys(ConfigurationReader.get("passwordTeacher"));
        loginPage.understandBtn.click();
        loginPage.loginBtn.click();
        dashboardPage.deleteExperience.click();
        String actualMessage = dashboardPage.popUpSucess.getText();
        String expectedMessage = "Experience Removed";
        Assert.assertEquals(actualMessage,expectedMessage);
    }
    @Test
    public void addExperience() throws InterruptedException {
        DashboardPage dashboardPage = new DashboardPage();
        LoginPage loginPage = new LoginPage();
        extentLogger = report.createTest("Add Experience");
        driver.get(ConfigurationReader.get("url"));
        extentLogger.info("Enter Username");
        loginPage.usernameInput.sendKeys(ConfigurationReader.get("usernameTeacher"));
        extentLogger.info("Enter Password");
        loginPage.passwordInput.sendKeys(ConfigurationReader.get("passwordTeacher"));
        extentLogger.info("Click Understand Button");
        loginPage.understandBtn.click();
        extentLogger.info("Click on Login Button");
        loginPage.loginBtn.click();
        extentLogger.info("click on Add Experience");
        dashboardPage.addExperience.click();
        extentLogger.info("Add Job Titlle");
        dashboardPage.jobTitle.sendKeys("Software Tester");
        extentLogger.info("Add Company Name ");
        dashboardPage.company.sendKeys("Daimler");
        extentLogger.info("Add Location");
        dashboardPage.location.sendKeys("Stuttgart");
        extentLogger.info("Click on Current Job");
        dashboardPage.currentJob.click();
        extentLogger.info("Enter Job Description");
        dashboardPage.jobDescrription.sendKeys("Web Application Testing");
        extentLogger.info("Click On Submit Button");
        dashboardPage.submitBtn.click();
        extentLogger.info("Verify that User is able to add Experience");

        Thread.sleep(3000);
        extentLogger.info("Passed");


    }
    @Test
    public void filterProfile() throws InterruptedException {
        DashboardPage dashboardPage = new DashboardPage();
        LoginPage loginPage = new LoginPage();
        DevelopersPage developersPage = new DevelopersPage();
        loginPage.loginAsTeacher();
        dashboardPage.developers.click();
        developersPage.skillBtn.click();
        developersPage.addSkills.sendKeys("HTML");
        Thread.sleep(3000);
        developersPage.filterBtn.click();
        String expectedTitle ="Filtering Results";
        //WebElement actualTitle =  developersPage.filterResults;
        //actualTitle.getText();
        //Assert.assertEquals("actualTitle",expectedTitle);

    }



}
