package pom.eurotech.test.day07_TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.eurotech.utilities.WebDriverFactory;

public class GoogleTest {
    WebDriver driver;
    @BeforeMethod
    public void setUp() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http:www.google.com");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]/div")).click(); // Accept All Button



    }
    @Test
    public void googleTitleTest(){

        String title = driver.getTitle();
        System.out.println("\"Title\" = " + "title");
    }
    @Test
    public void googleGmailTest(){
    boolean b = driver.findElement(By.xpath("//a[text()='Gmail']")).isDisplayed(); // Finds if Gmail link is displayed or not
    }
    @Test
    public void googleLogoTest(){
        boolean b1 = driver.findElement(By.xpath("//img[@class='lnXdpd']")).isDisplayed(); // Check if the logo is present or not

    }
    @Test
    public void googleSearchTest(){
        driver.findElement(By.xpath("//textarea[@title='Search']")).sendKeys("Laptop");
        driver.findElement(By.xpath("//input[@class = 'gNO89b']")).click();

    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }



}
