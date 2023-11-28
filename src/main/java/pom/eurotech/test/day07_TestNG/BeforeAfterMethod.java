package pom.eurotech.test.day07_TestNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class BeforeAfterMethod {


    @Test
    public void test1(){

        System.out.println("First Test case");

    }
    @Ignore
    @Test
    public void test2(){
        System.out.println("My second test case");
    }
    @Test
    public void test3(){
        System.out.println("My third test case");
    }
   @Test public void test4(){
       System.out.println("My last test case");
   }
    @BeforeMethod
    public void setUp(){
        System.out.println("Web driver, Opening browser");
    }
    @AfterMethod
    public void tearDown(){
        System.out.println("Closing browser, quit");
    }
}
