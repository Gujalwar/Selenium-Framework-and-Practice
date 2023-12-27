package pom.eurotech.test.day20_DDF;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pom.eurotech.pages.DashboardPage;
import pom.eurotech.pages.LoginPage;
import pom.eurotech.test.TestBase;
import pom.eurotech.utilities.ConfigurationReader;
import pom.eurotech.utilities.ExcelUtil;


public class DDFLoginTest extends TestBase {


    @DataProvider
    public Object[][] userData(){

        ExcelUtil testData = new ExcelUtil("src/test/resources/EurotechTest.xlsx","Login Test");

        String[][] dataArray = testData.getDataArrayWithoutFirstRow();


        return dataArray;

    }

    @Test(dataProvider = "userData")
    public void ddfLoginTest(String username,String password,String title,String company,String name) {

        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = new DashboardPage();

        extentLogger = report.createTest(name+" 's login test");
        driver.get(ConfigurationReader.get("url"));

        extentLogger.info("User enter username and password");
        loginPage.login(username,password);

        String expectedMessage = "Welcome "+name;
        String actualMessage = dashboardPage.welcomeMessage.getText();
        Assert.assertEquals(actualMessage,expectedMessage);

        extentLogger.info("Verify Company name that "+company);
        String actualCompany = dashboardPage.companyName.getText();
        Assert.assertEquals(actualCompany,company);

        extentLogger.info("Verify "+name+"'s title is "+title);
        String actualTitle = dashboardPage.getTitle(company);
        Assert.assertEquals(actualTitle,title);


    }
}

