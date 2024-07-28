package automation.tests;

import automation.page_object_model.LoginPage;
import automation.runner.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckPageContentTest extends BaseTest {
    private static final String TITLE_OF_PAGE = "Swag Labs";
    @Test
    public void loginCheckItemsTest() {
        int items = new LoginPage(getDriver())
                .login()
                .howMuchElements();

        Assert.assertEquals(items, 6);
    }

    @Test
    public void checkTitleTest() {
        String title = new LoginPage(getDriver())
                .login()
                .getTitle();

        Assert.assertEquals(title, TITLE_OF_PAGE);
    }

    @Test
    @Story("US_0004.1 Header Menu")
    @Description("Check  content header menu")
    @Owner("Roman Burlaka")
    @Link(name= "WebSite", url = "https://www.saucedemo.com/")
    public void checkHeaderMenuTest() {
        int itemMenuList = new LoginPage(getDriver())
                .login()
                .clickMenu()
                .getMenuItem();

        Allure.step(("Expected result: 4"));

        Assert.assertEquals(itemMenuList, 4);
    }


}