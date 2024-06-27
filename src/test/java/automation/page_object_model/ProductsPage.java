package automation.page_object_model;

import automation.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductsPage extends BasePage {
    @FindBy
    WebElement title = getDriver().findElement(By.xpath("//div[@class='app_logo']"));

    @FindBy
    WebElement menu = getDriver().findElement(By.id("react-burger-menu-btn"));

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy
    List<WebElement> allProducts = getDriver().findElements(By.xpath("//div[@class = 'inventory_item']"));


    @FindBy
    List <WebElement> menuItems = getDriver().findElements(By.xpath("//nav[@class= 'bm-item-list']/a"));

    @FindBy
    WebElement logOutButton = getDriver().findElement(By.xpath("//a[@id = 'logout_sidebar_link']"));

    public int howMuchElements() {

        return allProducts.size();
    }

    public  String getTitle() {


        return  title.getText();
    }

    public ProductsPage clickmenu() {
        menu.click();

        return  this;
    }

    public  int getMenuItem() {

        return   menuItems.size();
    }

    public HomePage logOut() {

        logOutButton.click();

        return  new HomePage(getDriver());
    }


}
