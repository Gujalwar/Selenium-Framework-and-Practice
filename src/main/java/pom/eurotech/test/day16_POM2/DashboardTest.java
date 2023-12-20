package pom.eurotech.test.day16_POM2;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pom.eurotech.pages.DashboardPage;
import pom.eurotech.pages.LoginPage;
import pom.eurotech.test.TestBase;
import pom.eurotech.utilities.BrowserUtils;
import pom.eurotech.utilities.ConfigurationReader;

import java.util.ArrayList;
import java.util.List;




public class DashboardTest extends TestBase {

    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();

    @Test
    public void dashboardMenu() {
        /**
         * Task
         *  Go to http://eurotech.study/login
         *  Login with teacher credentials
         *  Get the text of the welcome message and verify following menu
         *                       Developers
         *                       All Posts
         *                       My Account
         *
         */
        driver.get(ConfigurationReader.get("url"));
        loginPage.loginAsTeacher();
        String expectedMessage = "Welcome Teacher";
        Assert.assertEquals(dashboardPage.welcomeMessage.getText(), expectedMessage);

        ArrayList<String> expectedList = new ArrayList<>();
        expectedList.add("Developers");
        expectedList.add("All Posts");
        expectedList.add("My Account");

        //1st way
        ArrayList<String> actualList = new ArrayList<>();
        List<WebElement> dashboardMenu = dashboardPage.menuList;
        for (WebElement menu : dashboardMenu) {
            System.out.println("menu.getText() = " + menu.getText());
            actualList.add(menu.getText());
        }
        System.out.println("actualList = " + actualList);
        Assert.assertEquals(actualList, expectedList);

        //2nd way
        List<String> actualList1 = BrowserUtils.getElementsText(dashboardPage.menuList);
        Assert.assertEquals(actualList1, expectedList);

        //3rd way
        Assert.assertEquals(BrowserUtils.getElementsText(dashboardPage.menuList), expectedList);
    }

    @Test
    public void navigateMenu() {
        /** Class Task - Duration is 10min
         *  Go to http://eurotech.study/login
         *  Login with teacher credentials
         *  Navigate to All Posts menu and verify url is http://eurotech.study/posts
         *  Navigate to Developers menu and verify url is http://eurotech.study/profiles
         */
        driver.get(ConfigurationReader.get("url"));
        loginPage.loginAsTeacher();
        String expectedMessage = "Welcome Teacher";
        Assert.assertEquals(dashboardPage.welcomeMessage.getText(), expectedMessage);
        //BrowserUtils.waitFor(1);
        dashboardPage.allPosts.click();
        Assert.assertEquals(driver.getCurrentUrl(), "http://eurotech.study/posts");
        //BrowserUtils.waitFor(1);
        dashboardPage.developers.click();
        Assert.assertEquals(driver.getCurrentUrl(), "http://eurotech.study/profiles");
    }

    @Test
    public void navigateMenu2() {
        driver.get(ConfigurationReader.get("url"));
        loginPage.loginAsTeacher();
        String expectedMessage = "Welcome Teacher";
        Assert.assertEquals(dashboardPage.welcomeMessage.getText(), expectedMessage);
        dashboardPage.navigateToMenu("All Posts");
        Assert.assertEquals(driver.getCurrentUrl(), "http://eurotech.study/posts");
        dashboardPage.navigateToMenu("Developers");
        Assert.assertEquals(driver.getCurrentUrl(), "http://eurotech.study/profiles");
    }

    @Test
    public void navigate3() {
        driver.get(ConfigurationReader.get("url"));
        loginPage.loginAsTeacher();
        Assert.assertEquals(dashboardPage.welcomeMessage.getText(), "Welcome Teacher");
        dashboardPage.navigateToSubMenu("My Posts");
        dashboardPage.navigateToSubMenu("Logout");
    }
}



