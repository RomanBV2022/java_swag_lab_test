package automation.tests;


import automation.page_object_model.HomePage;
import automation.page_object_model.ProductsPage;
import automation.runner.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.List;

public class LoginTest extends BaseTest {
    private static final String TITLE_OF_PAGE = "Swag Labs";
    private static final String URL = "https://www.saucedemo.com/";

    @Test
    public void loginTest() {
        int items = new HomePage(getDriver())
                .login()
                .howMuchElements();

        Assert.assertEquals(items, 6);
    }

    @Test
    public void checkTitleTest() {
        loginTest();
        String title = new ProductsPage(getDriver())
                .getTitle();

        Assert.assertEquals(title, TITLE_OF_PAGE);
    }


    @Test
    public void checkHeaderMenuTest() {
        loginTest();

        int itemMenuList = new ProductsPage(getDriver())
                .clickmenu()
                .getMenuItem();

        Assert.assertEquals(itemMenuList, 4);
    }

    @Test
    public void logOut() {
        loginTest();

        Boolean logOut = new ProductsPage(getDriver())
                .clickmenu()
                .logOut()
                .logOutCheckBoolean("https://www.saucedemo.com/");

        Assert.assertTrue(logOut, "Your are not logout!!");
    }

}
