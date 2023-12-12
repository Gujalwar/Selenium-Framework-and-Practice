package pom.eurotech.test.day15_POM1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pom.eurotech.utilities.ConfigurationReader;
import pom.eurotech.test.TestBase;

/**
 * Class task
 * go to url http://eurotech.study/login
 * enter username
 * enter password
 * click login
 */
public class LoginTest extends TestBase {

    @Test
    public void test() {
        driver.get(ConfigurationReader.get("url"));
        WebElement understandBtn = driver.findElement(By.id("rcc-confirm-button"));
        understandBtn.click();
        WebElement usernameInput = driver.findElement(By.id("loginpage-input-email"));
        WebElement passwordInput = driver.findElement(By.id("loginpage-form-pw-input"));
        WebElement loginBtn = driver.findElement(By.id("loginpage-form-btn"));

        usernameInput.sendKeys(ConfigurationReader.get("usernameTeacher"));
        passwordInput.sendKeys(ConfigurationReader.get("passwordTeacher"));
        loginBtn.click();


    }
}


