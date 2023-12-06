package pom.eurotech.test.day10_TypeOfElements3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.eurotech.test.Utilities.WebDriverFactory;

import java.util.Set;

public class MultipleWindows {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @Test
    public void twoTabs() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/windows");
        WebElement clickHere = driver.findElement(By.xpath("//a[text()='Click Here']"));
        String beforeClick = driver.getTitle();
        System.out.println("beforeClick = " + beforeClick);
        clickHere.click();

        String currentTabId = driver.getWindowHandle();    // I know my current window id
        System.out.println("currentTab = " + currentTabId);

        Set<String> windowsIDs = driver.getWindowHandles(); //I have all windows ids

        for (String handle : windowsIDs) {
            if(!handle.equals(currentTabId)){
                driver.switchTo().window(handle);
            }
        }

        Thread.sleep(2000);
        String afterClick= driver.getTitle();
        System.out.println("afterClick = " + afterClick);
    }

    @Test
    public void multipleWindows() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/windows");
        String parentWindowId= driver.getWindowHandle();
        WebElement clickHere = driver.findElement(By.xpath("//a[text()='Click Here']"));
        String beforeClick = driver.getTitle();
        System.out.println("beforeClick = " + beforeClick);
        clickHere.click();
        clickHere.click();
        Set<String> windowsIDs = driver.getWindowHandles();
        //loop through each window

        for (String handle : windowsIDs) {
            //one by one change it
            driver.switchTo().window(handle);
            if(driver.getTitle().equals("New Window")){
                System.out.println("After Switch = " + driver.getTitle());
                //stop on this window
                break;
            }
        }
        driver.switchTo().window(parentWindowId);
        System.out.println("driver.getTitle() = " + driver.getTitle());
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}