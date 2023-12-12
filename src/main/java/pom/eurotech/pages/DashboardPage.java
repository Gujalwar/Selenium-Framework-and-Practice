package pom.eurotech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pom.eurotech.utilities.Driver;

public class DashboardPage {

    public DashboardPage() {
        PageFactory.initElements(Driver.get(),this);
    }
    @FindBy(id = "dashboard-h1")
    public WebElement dashboardText;
}

