package pom.eurotech.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pom.eurotech.utilities.Driver;

import java.util.List;

public class DashboardPage extends BasePage {

    @FindBy(id = "dashboard-h1")
    public WebElement dashboardText;

    @FindBy(xpath = "//p[contains(text(),'Welcome')]")
    public WebElement welcomeMessage;

    @FindBy(css = ".btn.btn-light")
    public List<WebElement> dashboardList;

    @FindBy(xpath = "//a[text()='Edit Profile']")
    public WebElement editProfile;

    @FindBy(xpath = "//tr[@id='dashboard-education-item-raw']/td[1]")
    public WebElement school;

    @FindBy(xpath = "(//tr[@id='dashboard-experince-item-raw'])[1]/td[1]")
    public WebElement companyName;
    @FindBy(xpath = "//button[@class = 'btn btn-danger'][1]")
    public WebElement deleteExperience;

    @FindBy(xpath = "//a[@class = 'btn btn-light'][2]")
    public WebElement addExperience;
    @FindBy(id = "addexperience-jobtitle-input")
    public  WebElement jobTitle;

    @FindBy(id = "addexperience-company-input")
    public  WebElement company;
    @FindBy(id = "addexperience-location-input")
    public WebElement location;
    @FindBy(id = "addexperience-date-input")
    public WebElement fromDate;

    @FindBy(id = "addexperience-status-input")
    public WebElement currentJob;

    @FindBy(xpath = "//input[@name = 'to']")
    public WebElement toDate;

    @FindBy(id = "addexperience-description-input")
    public WebElement jobDescrription;

    @FindBy(xpath = "//input[@type = 'submit']")
    public WebElement submitBtn;

    @FindBy(xpath = "//div[text() = 'Experience Removed']")
    public WebElement popUpSucess;




    public String getTitle(String companyName) {
        return Driver.get().findElement(By.xpath("//td[text()='" + companyName + "']/../td[2]")).getText();


    }
}