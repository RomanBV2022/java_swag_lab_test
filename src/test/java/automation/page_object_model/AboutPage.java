package automation.page_object_model;

import automation.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AboutPage extends BasePage {
    public AboutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[@class ='MuiTypography-root MuiTypography-buttonLabelNav css-1pj3is7']")
    List<WebElement> headerMenuList;

    @Step("Return a title of page")
    public  String showTitleOfPage() {

         return getDriver().getTitle();
    }

    public List<String> showMenuList() {
        return headerMenuList.stream()
                .map(WebElement::getText)
                .map(permalink -> permalink.split(",")[0].trim())
                .toList();

    }


}
