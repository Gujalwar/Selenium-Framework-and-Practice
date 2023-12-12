package pom.eurotech.test.day10_TypeOfElements3;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.eurotech.utilities.WebDriverFactory;

public class PopUpAlerts {

    WebDriver driver;

    @BeforeMethod
    public  void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @Test
    public  void popUp() throws InterruptedException {

        /*
        --Navigate http://primefaces.org/showcase/ui/overlay/confirmDialog.xhtml?jfwid=50eaa
        --Click "Confirm"
        --Click "Yes"
        --Verify that , you got "You have accepted" message
         */
        driver.get("http://primefaces.org/showcase/ui/overlay/confirmDialog.xhtml?jfwid=50eaa");

        driver.findElement(By.xpath("//span[text()='Confirm'][@class='ui-button-text ui-c']")).click();
        //(//span[text()='Confirm'])[1]

        driver.findElement(By.xpath("(//span[text()='Yes'])[2]")).click();
        Thread.sleep(1000);

        WebElement confirmationMessage = driver.findElement(By.xpath("//p[text()='You have accepted']"));
        String expectedMessage = "You have accepted";
        String actualMessage = confirmationMessage.getText();
        Assert.assertEquals(actualMessage,expectedMessage);

    }

    @Test
    public void JsAlerts(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement jsAlert = driver.findElement(By.cssSelector("button[onclick = 'jsAlert()']"));
        jsAlert.click();
        Alert alert1 = driver.switchTo().alert();
        alert1.accept();
        WebElement confirmationMessage= driver.findElement(By.xpath("//p[text() = 'You successfully clicked an alert']"));
        String actualMessage = confirmationMessage.getText();
        System.out.println("actualMessage = " + actualMessage);
        String expectedMessage = "You successfully clicked an alert";
        Assert.assertEquals(actualMessage,expectedMessage);


    }

    @Test
    public void JsAlerts2(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement jsConfirm = driver.findElement(By.cssSelector("button[onclick = 'jsConfirm()']"));
        jsConfirm.click();

        Alert alert2 = driver.switchTo().alert();
        alert2.dismiss();
        WebElement result = driver.findElement(By.xpath("//p[text() = 'You clicked: Cancel']"));
        String actualMessage2 = result.getText();
        System.out.println("actualMessage2 = " + actualMessage2);
        String expectedMessage2 = "You clicked: Cancel";
        Assert.assertEquals(actualMessage2,expectedMessage2);


    }

    @Test
    public void JsPrompt() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement jsPrompt = driver.findElement(By.cssSelector("button[onclick = 'jsPrompt()']"));
        jsPrompt.click();
        Alert alert2 = driver.switchTo().alert();
        alert2.sendKeys("Eurotech was here");
        Thread.sleep(2000);
        alert2.accept();
        WebElement result = driver.findElement(By.xpath("//p[@id = 'result']"));
        String actualMesage = result.getText();
        String expectedMessge = "You entered: Eurotech was here";
        Assert.assertEquals(actualMesage,expectedMessge);



    }


    @AfterMethod
    public void teatDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }



}
