package pom.eurotech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class DashboardPage extends BasePage {

    @FindBy(id = "dashboard-h1")
    public WebElement dashboardText;
    @FindBy(xpath = "//p[contains(text(),'Welcome')]")
    public WebElement welcomeMessage;

    @FindBy(css = ".btn.btn-light")
    public List<WebElement> dashboardList;

}