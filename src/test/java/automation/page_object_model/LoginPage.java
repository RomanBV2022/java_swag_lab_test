package automation.page_object_model;

import automation.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy
    List<WebElement> allProducts = getDriver().findElements(By.xpath("//div[@class = 'inventory_item']"));


    public int howMuchElements() {

        return allProducts.size();
    }



}
