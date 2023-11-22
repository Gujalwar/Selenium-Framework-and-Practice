package pom.eurotech.test.day03_WebElementIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.eurotech.test.Utilities.WebDriverFactory;

public class PracticeFacebook {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.facebook.com/login");
        WebElement inputEmail = driver.findElement(By.id("email"));
        inputEmail.sendKeys("poojagujalwar@rediffmail.com");
        WebElement inputPassword = driver.findElement(By.id("pass"));
        inputPassword.sendKeys("9421302556");
        Thread.sleep(1000);
        driver.findElement(By.className("42ft")).click();

        Thread.sleep(1000);
        driver.findElement(By.id("loginbutton")).click();
        Thread.sleep(1000);

        driver.close();

    }
}
