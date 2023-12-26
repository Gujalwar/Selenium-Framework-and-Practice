package pom.eurotech.test.day19_Review;

import org.testng.Assert;
import org.testng.annotations.Test;
import pom.eurotech.pages.DashboardPage;
import pom.eurotech.pages.LoginPage;
import pom.eurotech.pages.ProfilePage;
import pom.eurotech.test.TestBase;
import pom.eurotech.utilities.ConfigurationReader;

public class VerifyUserInfo extends TestBase {


    /*
--Login as a teacher
-- Verify that login successful
-- Click on Edit Profile button
-- Verify that Github name is teacher23
-- Click on Go Back button
-- Verify that school is Eurotech Study
 */

    @Test
    public void userInfo() {
        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = new DashboardPage();
        ProfilePage profilePage = new ProfilePage();

        extentLogger= report.createTest("User Info Verification");

        extentLogger.info("Click Understand Button");
        loginPage.understandBtn.click();

        extentLogger.info("Enter Username");
        loginPage.usernameInput.sendKeys(ConfigurationReader.get("usernameTeacher"));

        extentLogger.info("Enter Password");
        loginPage.passwordInput.sendKeys(ConfigurationReader.get("passwordTeacher"));

        extentLogger.info("Click Login Button");
        loginPage.loginBtn.click();

        //                      Dashboard               //
        String expectedMessage = "Welcome Teacher";
        String actualMessage = dashboardPage.welcomeMessage.getText();

        extentLogger.info("Verify that message is " +expectedMessage);
        Assert.assertEquals(actualMessage,expectedMessage);

        extentLogger.info("Click on Edit Profile Button");
        dashboardPage.editProfile.click();

        String expectedGithubName= "teacher23";
        String actualGithubName= profilePage.githubInputBox.getAttribute("value");
        System.out.println("actualGithubName = " + actualGithubName);

        extentLogger.info("Verify that github username is "+expectedGithubName);
        Assert.assertEquals(actualGithubName,expectedGithubName);

        extentLogger.info("Click on go back button");
        profilePage.goBackBtn.click();

        String expectedSchool= "Eurotech Study";
        String actualSchool= dashboardPage.school.getText();

        extentLogger.info("Verify that school is "+expectedSchool);
        Assert.assertEquals(actualSchool,expectedSchool);

        extentLogger.pass("Passed");







    }
}