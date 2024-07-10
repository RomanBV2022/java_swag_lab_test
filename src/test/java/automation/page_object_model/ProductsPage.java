package automation.page_object_model;

import automation.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ProductsPage extends BasePage {
    private static final String URL = "https://www.saucedemo.com/";

    private static final String BACK_PACK_PRODUCT = "sauce-labs-fleece-jacket";
    @FindBy
    WebElement title = getDriver().findElement(By.xpath("//div[@class='app_logo']"));

    @FindBy
    WebElement menu = getDriver().findElement(By.id("react-burger-menu-btn"));

    @FindBy
    WebElement dropDownMenu = getDriver().findElement(By.xpath("//select[@class = 'product_sort_container']"));

    @FindBy
    WebElement dropDownMenu_1 = getDriver().findElement(By.xpath("//select[@class = 'product_sort_container']/option[1]"));

    @FindBy
    WebElement dropDownMenu_2 = getDriver().findElement(By.xpath("//select[@class = 'product_sort_container']/option[2]"));

    @FindBy
    WebElement dropDownMenu_3 = getDriver().findElement(By.xpath("//select[@class = 'product_sort_container']/option[3]"));

    @FindBy
    WebElement dropDownMenu_4 = getDriver().findElement(By.xpath("//select[@class = 'product_sort_container']/option[4]"));

    @FindBy
    List<WebElement> priceList = getDriver().findElements(By.xpath("//div[@class= 'inventory_item_price']"));

    @FindBy
    WebElement productFirstItem = getDriver().findElement(By.xpath("//div[@class = 'inventory_list']/div[@class='inventory_item'][1]/div[@class = 'inventory_item_description']//div[@class ='inventory_item_name ']"));


    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy
    List<WebElement> allProducts = getDriver().findElements(By.xpath("//div[@class = 'inventory_item']"));

    @FindBy
    List<WebElement> getPriceList = getDriver().findElements(By.xpath("//div[@class = 'inventory_item']//div[@class = 'pricebar']"));


    @FindBy
    List<WebElement> menuItems = getDriver().findElements(By.xpath("//nav[@class= 'bm-item-list']/a"));

    @FindBy
    WebElement logOutButton = getDriver().findElement(By.xpath("//a[@id = 'logout_sidebar_link']"));
    @FindBy
    WebElement addToCart = getDriver().findElement(By.id("add-to-cart-sauce-labs-fleece-jacket"));

    //    @FindBy
//    WebElement shoppingCartBadge = getDriver().findElement(By.xpath("//span[@class = 'shopping_cart_badge']"));
    @Step("Shows all products on page")
    public int howMuchElements() {

        return allProducts.size();
    }

    public String getUrl(String url) {
        waitElementVisible(title, 3);

        if (url == getDriver().getPageSource()) {
            return getDriver().getPageSource();
        } else return null;
    }

    public String getTitle() {


        return title.getText();
    }

    public ProductsPage clickmenu() {
        menu.click();

        return this;
    }

    public int getMenuItem() {

        return menuItems.size();
    }

    public HomePage logOut() {

        logOutButton.click();

        return new HomePage(getDriver());
    }


    public ProductsPage dropDownMenuClick() {
        dropDownMenu_4.click();

        return this;
    }

    public Boolean selectItemTrue() {
        getWait5().until(ExpectedConditions.visibilityOf(productFirstItem));
        if (productFirstItem.getText() == "Sauce Labs Fleece Jacket") {
            return true;
        } else {
            return false;
        }

    }

    public String selectItem() {
        getWait5().until(ExpectedConditions.visibilityOf(productFirstItem));

        return productFirstItem.getText();

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

    public static List itemListHashSet() {
       HashSet<Integer> hashSetList = new HashSet<>();
        hashSetList.add(23);
        hashSetList.add(23);
        hashSetList.add(23);
        hashSetList.add(23);

        return  hashSetList.stream().toList();
    }

    public static void main(String[] args) {
        System.out.println(itemListHashSet());

    }

//    public String checkCart() {
//        waitElementVisible(shoppingCartBadge, 3);
//
//        return shoppingCartBadge.getText();
//
//
//    }

//    public <T> T selectProjectAndClickOk(T page, String nameOfProject) {
//        getDriver()
//                .findElements(By.xpath("//li[contains(text(),'" + nameOfProject+ "')]"));
//
//        okButton.click();
//
//        return page;
//    }


}
