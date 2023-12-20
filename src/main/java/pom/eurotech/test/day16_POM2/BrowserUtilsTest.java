package pom.eurotech.test.day16_POM2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pom.eurotech.test.TestBase;
import pom.eurotech.utilities.BrowserUtils;

import java.util.List;


public class BrowserUtilsTest extends TestBase {

    @Test
    public void window() {
        driver.get("https://the-internet.herokuapp.com/windows");
        WebElement clickHere = driver.findElement(By.xpath("//a[text()='Click Here']"));
        String beforeClick = driver.getTitle();
        System.out.println("beforeClick = " + beforeClick);
        clickHere.click();

        BrowserUtils.switchToWindow("New Window");
        System.out.println("driver.getTitle() = " + driver.getTitle());
    }

    @Test
    public void actions() {
        driver.get("https://the-internet.herokuapp.com/hovers");
        WebElement img1 = driver.findElement(By.xpath("(//div[@class='figure'])[1]"));

        BrowserUtils.hover(img1);
    }

    @Test
    public void list() {
        driver.get("https://the-internet.herokuapp.com/");
        List<WebElement> menuList= driver.findElements(By.tagName("li"));

        System.out.println("BrowserUtils.getElementsText(menuList) = " + BrowserUtils.getElementsText(menuList));
    }
}

