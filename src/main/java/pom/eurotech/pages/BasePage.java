package pom.eurotech.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pom.eurotech.utilities.BrowserUtils;
import pom.eurotech.utilities.Driver;

import java.util.List;

public class BasePage {

        public BasePage() {
            PageFactory.initElements(Driver.get(),this);
        }
        @FindBy(className = "nav__menu-item")
        public List<WebElement> menuList;
        @FindBy(linkText = "All Posts")
        public WebElement allPosts;
        @FindBy(linkText = "Developers")
        public WebElement developers;
        @FindBy(linkText = "My Account")
        public WebElement myAccount;

        public void navigateToMenu(String menuName){
            Driver.get().findElement(By.xpath("//*[text()='"+menuName+"']")).click();
        }
        public void navigateToSubMenu(String subMenu){
            BrowserUtils.hover(myAccount);
            Driver.get().findElement(By.xpath("//span[text()='"+subMenu+"']")).click();
        }
    }

