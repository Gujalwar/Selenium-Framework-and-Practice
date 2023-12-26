package pom.eurotech.test.day17_POM3;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pom.eurotech.pages.DashboardPage;
import pom.eurotech.pages.LoginPage;
import pom.eurotech.pages.PostPage;
import pom.eurotech.test.TestBase;
import pom.eurotech.utilities.BrowserUtils;
import pom.eurotech.utilities.ConfigurationReader;

import java.util.ArrayList;
import java.util.List;

public class DashboardTest2 extends TestBase {

    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    PostPage postsPage = new PostPage();

    @Test

    public void verifyList() {
        driver.get(ConfigurationReader.get("url"));
        loginPage.loginAsTeacher();
        String expectedMessage = "Welcome Teacher";
        String actualMessage = dashboardPage.welcomeMessage.getText();
        Assert.assertEquals(actualMessage, expectedMessage, "Login verification is Failed");

        List<String> expectedList = new ArrayList<>();
        expectedList.add("Edit Profile");
        expectedList.add("Add Experience");
        expectedList.add("Add Education");
        List<String> actualList = new ArrayList<>();
        //1st way
//        for (WebElement listItem : dashboardPage.dashboardList) {
//            actualList.add(listItem.getText());
//        }
//        System.out.println("expectedList = " + expectedList);
//        System.out.println("actualList = " + actualList);
//        Assert.assertEquals(actualList,expectedList,"Verification of dashboard list is Failed");

        //2nd way
        List<WebElement> dashboardList = dashboardPage.dashboardList;
        for (WebElement listItem : dashboardList) {
            actualList.add(listItem.getText());
        }
        Assert.assertEquals(actualList, expectedList, "Verification of dashboard list is Failed 2");

        //3rd way
        Assert.assertEquals(BrowserUtils.getElementsText(dashboardPage.dashboardList), expectedList);

    }

        /** Class Task - Duration: 10min
         go to "http://eurotech.study/login"
         Login with teacher credentials
         Verify login is successful
         Verify following menu
         - Edit Profile
         - Add Experience
         - Add Education
         */

        @Test
        public void logout() {
            /** Class Task - Duration: 15min
             go to "http://eurotech.study/login"
             Login with teacher credentials
             Verify login is successful
             Navigate to My Account and My Posts and verify that submit button is visible
             Navigate to Logout  and verify that logout successful
             */
            driver.get(ConfigurationReader.get("url"));
            loginPage.loginAsTeacher();
            Assert.assertEquals(dashboardPage.welcomeMessage.getText(),"Welcome Teacher","Login verification is Failed");
            dashboardPage.navigateToSubMenu("My Posts");

            //1st way to verify Submit button is visible
            Assert.assertTrue(postsPage.submitBtn.isDisplayed());

            //2nd way to verify Submit button is visible
            BrowserUtils.verifyElementDisplayed(postsPage.submitBtn);

            //3rd way to verify Submit button is visible with getAttribute method
            Assert.assertEquals(postsPage.submitBtn.getAttribute("value"),"Submit");

            postsPage.navigateToSubMenu("Logout");

            // verify that log out
            Assert.assertTrue(driver.getCurrentUrl().contains("login"));
        }

    @Test
    public void postComment() {
        /**
         Go to http://www.eurotech.study/
         Login with student credentials
         Navigate to My Account and navigate to My Posts
         Fill the title and post area
         Click submit button
         Verify that post saved successfully
         */

        driver.get(ConfigurationReader.get("url"));
        loginPage.loginAsStudent();
        Assert.assertEquals(dashboardPage.welcomeMessage.getText(),"Welcome Jack");
        dashboardPage.navigateToSubMenu("My Posts");

        String titleText = "Page Object Model";
        String postText = "Page Object Model, also known as POM, is a design pattern in Selenium that creates an object repository for storing all web elements.";

//        postsPage.titleInput.sendKeys(titleText);
//        postsPage.postInput.sendKeys(postText);
//        postsPage.submitBtn.click();
//        Assert.assertEquals(postsPage.postCreatedMsg.getText(),"Post Created");
        postsPage.postComment(titleText,postText);
    }
}


