package automation.page_object_model;


import automation.base.BasePage;
import org.openqa.selenium.WebDriver;


public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }
    public String getTitleOfPage() {

        return getDriver().getTitle();

    }
}

