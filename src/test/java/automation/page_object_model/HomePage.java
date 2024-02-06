package automation.page_object_model;


import automation.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "banner-image")
    WebElement banner;


    public Boolean bannerIsVisible() {
        return true ? banner.isDisplayed(): false;
    }

    public String getTitleOfPage() {

        return getDriver().getTitle();

    }




}

