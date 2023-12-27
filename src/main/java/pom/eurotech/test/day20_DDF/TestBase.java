package pom.eurotech.test.day20_DDF;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pom.eurotech.utilities.BrowserUtils;
import pom.eurotech.utilities.ConfigurationReader;
import pom.eurotech.utilities.Driver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase {
    protected WebDriver driver;
    protected Actions actions;
    protected WebDriverWait wait;

    protected ExtentReports report;
    protected ExtentHtmlReporter htmlReporter;
    protected ExtentTest extentLogger;


    @BeforeTest
    public void setupTest(){
        report=new ExtentReports();
        String projectPath = System.getProperty("user.dir");
        String path= projectPath+"/test-output/report.html";

        //initialize the html report to the report object
        htmlReporter = new ExtentHtmlReporter(path);

        //attach the html report to the report object
        report.attachReporter(htmlReporter);

        htmlReporter.config().setReportName("Eurotech Smoke Test");

        report.setSystemInfo("Environment","Production");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS",System.getProperty("os.name"));
        report.setSystemInfo("Test Engineer","Kılıç");
    }
    @BeforeMethod
    public void setUp() {

        driver= Driver.get();
        driver.manage().window().maximize();
        //   driver.get(ConfigurationReader.get("url"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        actions= new Actions(driver);
        wait= new WebDriverWait(driver,10);
    }
    @AfterMethod
    public void tearDown(ITestResult result) throws InterruptedException, IOException {

        //if test fails
        if(result.getStatus()==ITestResult.FAILURE){

            //record the name of failed test case
            extentLogger.fail(result.getName());

            //take screenshot and return location of the screenshot
            String screenShotPath = BrowserUtils.getScreenshot(result.getName());

            //add your screenshot to your report
            extentLogger.addScreenCaptureFromPath(screenShotPath);

            //capture the exception and put it inside the report
            extentLogger.fail(result.getThrowable());
        }

        Thread.sleep(1000);
        Driver.closeDriver();
    }
    @AfterTest
    public void tearDownTest(){
        report.flush();
    }
}

