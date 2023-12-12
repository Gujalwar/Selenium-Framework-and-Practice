package pom.eurotech.test.day09_TypesOfElements2;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.eurotech.utilities.WebDriverFactory;

public class Homework {


    /*
        Homework
        --navigate https://demoqa.com/select-menu
        -- Old Style Select Menu dropdown
        -- verify that default selected color is Red
        -- Print all options
        -- verify that size is 11
        -- click Yellow
        -- verify that yellow is selected
        -- click Aqua
        -- verify that Aqua is selected

        Homework 2 (optional)
        --Navigate https://demo.aspnetawesome.com/
        -- DropdownList (cascade)
        -- Print all options
        -- verify that size is 5
        --Verify that second item is Broccoli
        -- click Lettuce

         */

    WebDriver driver;

     @BeforeMethod
    public void setUp(){
         driver = WebDriverFactory.getDriver("chrome");
         driver.get(" https://demoqa.com/select-menu");
         driver.manage().window().maximize();
     }

    @Test
    public  void test1() throws InterruptedException {



}


    @AfterMethod
    public void tearDown() throws InterruptedException {
         Thread.sleep(2000);
         driver.close();

}
}
