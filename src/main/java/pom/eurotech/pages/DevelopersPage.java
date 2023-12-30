package pom.eurotech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DevelopersPage extends BasePage{
@FindBy(xpath = "//input[@value = 'Skill']")
public WebElement skillBtn;

@FindBy(id = "singlefilter-input")
public WebElement addSkills;

@FindBy(xpath = "//input[@value = 'Filter']")
public WebElement filterBtn;

@FindBy()
public WebElement filterResults;


}
