package pom.eurotech.test.day14_PropertiesFile_Singleton;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pom.eurotech.utilities.ConfigurationReader;
import pom.eurotech.utilities.WebDriverFactory;

public class PropertiesTest {
    @Test
    public void testProperties(){
        String expectedBrowser= ConfigurationReader.get("browser");
        System.out.println("expectedBrowser = " + expectedBrowser);
        String expectedUrl = ConfigurationReader.get("url");
        System.out.println("expectedUrl = " + expectedUrl);
    }

    @Test
    public void openBrowserUsingConfigurationReader() {
        WebDriver driver = WebDriverFactory.getDriver(ConfigurationReader.get("browser"));

        driver.get(ConfigurationReader.get("url"));

        driver.findElement(By.id("loginpage-input-email"))
                .sendKeys(ConfigurationReader.get("usernameTeacher"));
        driver.findElement(By.id("loginpage-form-pw-input"))
                .sendKeys(ConfigurationReader.get("passwordTeacher")+ Keys.ENTER);
    }

    @Test
    public void testSingleton() {
        WebDriver driver1= WebDriverFactory.getDriver(ConfigurationReader.get("browser"));
        driver1.get(ConfigurationReader.get("url"));
        WebDriver driver2= WebDriverFactory.getDriver(ConfigurationReader.get("browser"));
        driver2.findElement(By.id("rcc-confirm-button")).click();

    }




}
