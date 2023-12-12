package pom.eurotech.test.day03_WebElementIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.eurotech.utilities.WebDriverFactory;

public class VerifyUrlNotChanged {
    public static void main(String[] args) throws InterruptedException {
        /* Open Chrome browser
          -go to "http://eurotecg.study/login
          -click login button
          --verify that url is not changed
          -once you get any test case,
          1.first read and try to understand
          2. Manually execute the test cases
             -Functionality should not be broken
             -it should be automatable with selenium
             -should pass manually first

         */
        WebDriver driver = WebDriverFactory.getDriver("chrome");
      driver.get("http://eurotech.study/login");
      WebElement understandBtn = driver.findElement(By.id("rcc-confirm-button"));

      understandBtn.click();
      String expectedUrl = driver.getCurrentUrl();

      WebElement loginBtn= driver.findElement(By.id("loginpage-form-btn"));
      loginBtn.click();
      // 1st way
      //String expectedUrl = "http://eurotech.study/login";

      String actualUrl = driver.getCurrentUrl();
      if(expectedUrl.equals(actualUrl)){
          System.out.println("Passed");
      }else
          System.out.println("Failed");

      Thread.sleep(2000);
      driver.close();

    }

}
