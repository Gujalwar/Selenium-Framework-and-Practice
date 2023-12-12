package pom.eurotech.test.day13_WebTables;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.eurotech.utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTablePractice {
    WebDriver driver;
    int row;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.techlistic.com/2017/02/automate-demo-web-table-with-selenium.html");
        driver.findElement(By.id("ez-accept-all")).click();

        WebElement table1 = driver.findElement(By.xpath("//span[text()= 'Demo Webtable 1 (Static Table)']"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);",table1);
        List<WebElement> allRows = driver.findElements(By.xpath("//table[@id = 'customers']/tbody/tr"));
        row = allRows.size();
        System.out.println("row = " + row);
    }

    @Test
    public void printAllElements(){
        WebElement table = driver.findElement(By.id("customers"));
        System.out.println("table.getText() = " + table.getText());


    }
    @Test
    public void printCompanyColumn() throws InterruptedException {
        /*   //*[@id="customers"]/tbody/tr[2]/td[1]
             //*[@id="customers"]/tbody/tr[3]/td[1]
             //*[@id="customers"]/tbody/tr[4]/td[1]
             //*[@id="customers"]/tbody/tr[5]/td[1]
             //*[@id="customers"]/tbody/tr[6]/td[1]
             //*[@id="customers"]/tbody/tr[7]/td[1]
         */

        String xpath1 = "//*[@id=\"customers\"]/tbody/tr[";
        String xpath2 = "]/td[1]";
        for(int i = 2; i <= row; i++){
        String actualXpath = xpath1+ i +xpath2;
        WebElement element = driver.findElement(By.xpath(actualXpath));
        System.out.println("element.getText() = " + element.getText());

        // To check if Amazon is present in the column
            if(element.getText().equals("Amazon")){
                System.out.println("Company Name :"+element.getText() + " is found at position: " + (i-1));

            }



        }


    }

    @Test
    public void printContactColumn(){
        /*  //*[@id="customers"]/tbody/tr[2]/td[2]/span
            //*[@id="customers"]/tbody/tr[3]/td[2]/span
            //*[@id="customers"]/tbody/tr[4]/td[2]/span
            //*[@id="customers"]/tbody/tr[5]/td[2]/span
            //*[@id="customers"]/tbody/tr[6]/td[2]/span
            //*[@id="customers"]/tbody/tr[7]/td[2]/span
         */


        String xpath1 = "//*[@id=\"customers\"]/tbody/tr[";
        String xpath2 = "]/td[2]/span";
        for (int i = 2; i<=row;i++){

            String xpath = xpath1 + i + xpath2;
            WebElement element = driver.findElement(By.xpath(xpath));
            System.out.println("element.getText() = " + element.getText());
            if(element.getText().equals("Roland Mendel")){
                System.out.println("Contact:" +element.getText() + " is found at a position " + i);
            }
        }


    }


    @Test
    public void printCountryColumn(){
        /*  //*[@id="customers"]/tbody/tr[2]/td[3]/span
            //*[@id="customers"]/tbody/tr[3]/td[3]/span
            //*[@id="customers"]/tbody/tr[4]/td[3]/span
            //*[@id="customers"]/tbody/tr[5]/td[3]/span
            //*[@id="customers"]/tbody/tr[6]/td[3]/span
            //*[@id="customers"]/tbody/tr[7]/td[3]/span
         */


        String xpath1 = "//*[@id=\"customers\"]/tbody/tr[";
        String xpath2 = "]/td[3]/span";
        for (int i = 2; i<=row;i++){

            String xpath = xpath1 + i + xpath2;
            WebElement element = driver.findElement(By.xpath(xpath));
            System.out.println("element.getText() = " + element.getText());

            if(element.getText().equals("Germany")){
                System.out.println("Country:" +element.getText() + " is found at a position " + i);
            }
        }


    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
}
}
