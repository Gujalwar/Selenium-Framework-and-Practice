package pom.eurotech.test.day07_TestNG;

import org.testng.annotations.*;

public class BeforeAfterMethod {


    @BeforeClass
    public void setupClass(){
        System.out.println("-----BEFORE CLASS---");
    }
    @BeforeMethod
    public void setUp(){
        System.out.println("Web driver,Opening browser");
    }
    @Test
    public void test1() {

        System.out.println("First test case");

    }
    @Ignore
    @Test
    public void test2() {
        System.out.println("My Second Test Case");
    }

    @Test
    public void test3() {
        System.out.println("My third test case");
    }
    @Test
    public void test4(){
        System.out.println("My Last Test Case");
    }
    @AfterMethod
    public void tearDown(){
        System.out.println("Closing browser,quit");
    }
    @AfterClass
    public void tearDownClass(){
        System.out.println("------AFTER CLASS------");
        System.out.println("Some reporting Code Here ");
    }
}