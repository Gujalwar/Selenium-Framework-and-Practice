package pom.eurotech.test.day10_TypeOfElements3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.eurotech.utilities.WebDriverFactory;

public class IframeTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @Test
    public void iframe() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/iframe");
        //switch with name or id
        driver.switchTo().frame("mce_0_ifr");
        Thread.sleep(1000);
        WebElement bodyInput = driver.findElement(By.cssSelector("#tinymce"));
        bodyInput.clear();
        bodyInput.sendKeys("Eurotech was here");

        //goes back to first one (main html)
        driver.switchTo().defaultContent();

        WebElement title = driver.findElement(By.tagName("h3"));
        System.out.println("title.getText() = " + title.getText());

        //switch iframe again with index
        driver.switchTo().frame(0);
        bodyInput.clear();
        bodyInput.sendKeys("Mike Smith ");

        //second way to switch parent
        driver.switchTo().parentFrame();
        System.out.println("title.getText() second time = " + title.getText());

        //switch iframe with web element
        WebElement iframeElement =driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframeElement);
        bodyInput.clear();
        bodyInput.sendKeys("Last message for today");

    }

    @Test
    public void nestedIframe() {
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");

        WebElement middleFrame = driver.findElement(By.cssSelector("#content"));
        System.out.println("middleFrame.getText() = " + middleFrame.getText());

        driver.switchTo().parentFrame();


        driver.switchTo().frame("frame-left");
        WebElement leftFrame = driver.findElement(By.xpath("//body[contains(text(),'LEFT')]"));
        System.out.println("leftFrame.getText() = " + leftFrame.getText());

        driver.switchTo().parentFrame();
        driver.switchTo().frame(2);
        WebElement rightFrame = driver.findElement(By.xpath("//body[contains(text(),'RIGHT')]"));
        System.out.println("rightFrame.getText() = " + rightFrame.getText());

        //Print Bottom
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-bottom");
        // driver.switchTo().frame(1);
        WebElement bottom = driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]"));
        System.out.println("bottom.getText() = " + bottom.getText());
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}