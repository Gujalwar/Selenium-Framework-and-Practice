package pom.eurotech.test.day12_action_JSE;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.eurotech.utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class ActionTest {
    WebDriver driver;


    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void hoverTest(){
        driver.get("https://the-internet.herokuapp.com/hovers");
        WebElement img1 = driver.findElement(By.xpath("(//div[@class = 'figure'])[1]"));
        //Actions --> class that contains all the user interactions
        //to create action object and pass driver as a constructor
        Actions actions = new Actions(driver);
        actions.moveToElement(img1).perform();
        WebElement imgText = driver.findElement(By.xpath("//h5[text()='name: user1']/.."));
        String actualText = img1.getText();
        System.out.println("imgText.getText() = " + imgText.getText());
        String expectedText = "name: user1\n" + "View profile";
        Assert.assertEquals(actualText,expectedText);


    }

    @Test
    public void dragDrop() {
        driver.get("https://demoqa.com/droppable");
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, target).perform();

        WebElement message = driver.findElement(By.xpath("//p[text()='Dropped!']"));
        String expectedMessage = "Dropped!";
        Assert.assertEquals(message.getText(), expectedMessage);
        Assert.assertTrue(message.isDisplayed());
    }

    @Test
    public void dragDrop2() {
        driver.get("https://demoqa.com/droppable");
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

        Actions actions = new Actions(driver);
        actions.moveToElement(source).clickAndHold().moveToElement(target).pause(4000).release().perform();
        WebElement message = driver.findElement(By.xpath("//p[text()='Dropped!']"));
        Assert.assertTrue(message.isDisplayed());
    }



    @AfterMethod
    public  void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }


}
