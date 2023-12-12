package pom.eurotech.test.day14_PropertiesFile_Singleton;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pom.eurotech.utilities.ConfigurationReader;
import pom.eurotech.test.TestBase;


public class LoginTest extends TestBase {




    @Test
    public void openBrowserUsingConfigurationReader() {

        driver.get(ConfigurationReader.get("url"));

        driver.findElement(By.id("loginpage-input-email"))
                .sendKeys(ConfigurationReader.get("usernameTeacher"));
        driver.findElement(By.id("loginpage-form-pw-input"))
                .sendKeys(ConfigurationReader.get("passwordTeacher")+ Keys.ENTER);
    }
}



