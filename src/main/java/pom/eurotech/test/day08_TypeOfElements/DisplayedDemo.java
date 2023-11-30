package pom.eurotech.test.day08_TypeOfElements;




import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pom.eurotech.test.Utilities.WebDriverFactory;

public class DisplayedDemo {


    @Test
    public void testName() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //verify that Hello World! is not visible
        WebElement helloWorld = driver.findElement(By.cssSelector("#finish>h4"));
        //isDisplayed() method
        System.out.println("helloWorld.isDisplayed() = " + helloWorld.isDisplayed()); //false
        Assert.assertFalse(helloWorld.isDisplayed());

        WebElement startBtn = driver.findElement(By.cssSelector("#start>button"));
        System.out.println("startBtn.isDisplayed() = " + startBtn.isDisplayed());    //true

        startBtn.click();
        Thread.sleep(6000);

        System.out.println("helloWorld.isDisplayed() = " + helloWorld.isDisplayed()); //true
        Assert.assertTrue(helloWorld.isDisplayed());


        Thread.sleep(2000);
        driver.close();

    }
}

