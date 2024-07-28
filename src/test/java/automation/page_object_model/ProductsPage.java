package automation.page_object_model;

import automation.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.*;

public class ProductsPage extends BasePage {
    private static final String URL;

    static {
        URL ="https://www.saucedemo.com/";
    }

    private static final String BACK_PACK_PRODUCT = "sauce-labs-fleece-jacket";
    @FindBy
    WebElement title = getDriver().findElement(By.xpath("//div[@class='app_logo']"));

    @FindBy
    WebElement menu = getDriver().findElement(By.id("react-burger-menu-btn"));

    @FindBy
    WebElement dropDownMenu = getDriver().findElement(By.xpath("//select[@class = 'product_sort_container']"));


    @FindBy
    WebElement productFirstItem = getDriver().findElement(By.xpath("//div[@class = 'inventory_list']/div[@class='inventory_item'][1]/div[@class = 'inventory_item_description']//div[@class ='inventory_item_name ']"));



    @FindBy
    List<WebElement> allProducts = getDriver().findElements(By.xpath("//div[@class = 'inventory_item']"));

    @FindBy
    List<WebElement> getPriceList = getDriver().findElements(By.xpath("//div[@class = 'inventory_item_price']"));


    @FindBy
    List<WebElement> menuItems = getDriver().findElements(By.xpath("//nav[@class= 'bm-item-list']/a"));

    @FindBy(xpath = "//a[@id = 'logout_sidebar_link']")
    WebElement logOutButton;
    @FindBy
    WebElement addToCart = getDriver().findElement(By.id("add-to-cart-sauce-labs-fleece-jacket"));

    @FindBy(xpath = "//span[@class = 'active_option']")
    WebElement dropdownSortedName;

    @FindBy(xpath = "//a[@id= 'about_sidebar_link']")
    WebElement getAboutLink;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Shows all products on page")
    public int howMuchElements() {

        return allProducts.size();
    }

    public String getTitle() {


        return title.getText();
    }

    public ProductsPage clickMenu() {
        menu.click();

        return this;
    }

    public int getMenuItem() {

        return menuItems.size();
    }

    public LoginPage logOut() {
        getWait5().until(ExpectedConditions.visibilityOf(logOutButton)).click();

        return new LoginPage(getDriver());
    }

    public ProductsPage dropDownSelect(String value) {
        Select select = new Select(dropDownMenu);
        select.selectByValue(value);

        return this;
    }

    public String dropdownSelectGetValue(String value) {
        Select select = new Select(dropDownMenu);
        select.selectByValue(value);


        return dropdownSortedName.getText();
    }
    public ProductsPage dropdownSelectList(String value) {
        Select select = new Select(dropDownMenu);
        select.selectByValue(value);

        return this;
    }

    public ProductsPage addProduct() {
        addToCart.click();

        return this;
    }

    public List<String> sortPriceProducts() {

        return getWait10().until(ExpectedConditions.visibilityOfAllElements(getPriceList))
                .stream()
                .map(WebElement::getText)
                .map(permalink -> permalink.split(",")[0].trim())
                .toList();
    }

    public String loginConfirm() {
        waitElementVisible(logOutButton, 5);

        return logOutButton.getText();
    }

    public AboutPage goToAboutPage() {
        getAboutLink.click();

        return new AboutPage(getDriver());
    }



}
