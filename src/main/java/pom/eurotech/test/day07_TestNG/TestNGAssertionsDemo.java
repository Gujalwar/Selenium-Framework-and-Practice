package pom.eurotech.test.day07_TestNG;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAssertionsDemo {
    @BeforeMethod
    public void setup(){
        System.out.println("Opening Browser");
    }
    @Test
    public void test1(){

        System.out.println("First Assertion");
        Assert.assertEquals("Title","title");

        System.out.println("Second Assertion");
        Assert.assertEquals("URL","URL");

        //   System.out.println("Close Browser");

    }

    @Test
    public void test2() {
        String email = "eurotech@gmail.com";
        System.out.println("Test 2 Assertion");
        Assert.assertEquals("Welcome teacher","Welcome teacher");
        //   System.out.println("Close Browser");
        Assert.assertTrue(email.contains("@"));

    }

    @Test
    public void test3() {

        String expectedName = "hey";
        String actualName = "Eurotech";
        //   Assert.assertEquals(actualName,expectedName);
        Assert.assertTrue(actualName.startsWith(expectedName),"NOT starting with expected name");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("Log out method");
        System.out.println("Close Browser");
    }
}

