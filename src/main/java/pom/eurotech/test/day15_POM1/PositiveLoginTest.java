package pom.eurotech.test.day15_POM1;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pom.eurotech.pages.DashboardPage;
import pom.eurotech.pages.LoginPage;
import pom.eurotech.test.TestBase;
import pom.eurotech.utilities.ConfigurationReader;

public class PositiveLoginTest extends TestBase {

    //http://eurotech.study/dashboard
    LoginPage loginPage;
    DashboardPage dashboardPage;
    @Test
    public void loginTest() {
        loginPage=new LoginPage();
        dashboardPage=new DashboardPage();
        driver.get(ConfigurationReader.get("url"));
        loginPage.understandBtn.click();
        loginPage.usernameInput.sendKeys(ConfigurationReader.get("usernameTeacher"));
        loginPage.passwordInput.sendKeys(ConfigurationReader.get("passwordTeacher"));
        loginPage.loginBtn.click();
        wait.until(ExpectedConditions.visibilityOf(dashboardPage.dashboardText));
        Assert.assertEquals(driver.getCurrentUrl(),"http://eurotech.study/dashboard");
    }
    @Test
    public void loginWithMethod() {
        loginPage=new LoginPage();
        dashboardPage=new DashboardPage();
        driver.get(ConfigurationReader.get("url"));
        loginPage.login("sparrowjack@gmail.com","sparrow1");
        wait.until(ExpectedConditions.visibilityOf(dashboardPage.dashboardText));
        Assert.assertEquals(driver.getCurrentUrl(),"http://eurotech.study/dashboard");
    }
    @Test
    public void loginAsTeacherTest() {
        loginPage=new LoginPage();
        dashboardPage=new DashboardPage();
        driver.get(ConfigurationReader.get("url"));
        loginPage.loginAsTeacher();
        wait.until(ExpectedConditions.visibilityOf(dashboardPage.dashboardText));
        Assert.assertEquals(driver.getCurrentUrl(),"http://eurotech.study/dashboard");
    }

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

}
