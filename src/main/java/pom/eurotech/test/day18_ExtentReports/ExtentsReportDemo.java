package pom.eurotech.test.day18_ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.eurotech.utilities.ConfigurationReader;

public class ExtentsReportDemo {

    //This class is used for building reports
    ExtentReports report;
    // this class is used to create report files
    ExtentHtmlReporter htmlReporter;

    // this will define a test, enable adding logs, authors and test steps
    ExtentTest extentLogger;

    @BeforeMethod
    public void setUp(){
        report = new ExtentReports();
        String projectPath = System.getProperty("user.dir");
        String path = projectPath+"/test-output/report.html";
        //initilize the html report to the report object
        htmlReporter = new ExtentHtmlReporter(path);
        //attach the html report to the object
        report.attachReporter(htmlReporter);
        htmlReporter.config().setReportName("Eurotech Smoke Test");
        report.setSystemInfo("Environment","Production");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS",System.getProperty("os.name"));
        report.setSystemInfo("Test Engineer","Pooja");

    }
@Test
    public void testName(){
        //give a name to the current test
    extentLogger = report.createTest("TC001 Login Test");
    //Test Steps
    extentLogger.info("Open Chrome Browser");

    extentLogger.info("Go to http://eurotech.study/login");

    extentLogger.info("click understand button");

    extentLogger.info("Enter Teacher Credentials");

    extentLogger.info("Click Login Button");

    extentLogger.info("Verify logged in");

    extentLogger.info("TC001 is passed");

}

    @AfterMethod
    public void tearDown() {
        //this is when the report is actually created
        report.flush();
    }
}





