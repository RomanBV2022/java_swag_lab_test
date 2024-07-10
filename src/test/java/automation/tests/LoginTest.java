package automation.tests;


import automation.page_object_model.HomePage;
import automation.page_object_model.ProductsPage;
import automation.runner.BaseTest;
import io.qameta.allure.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.List;

import static io.qameta.allure.SeverityLevel.CRITICAL;

@Epic("Login")
public class LoginTest extends BaseTest {
    private static final String URL = "https://www.saucedemo.com/inventory.html";
    WebElement dropDownMenu_1;

    @Test
    @Story("")
    @Description("")
    @Severity(CRITICAL)
    public void loginTest() {
        String items = new HomePage(getDriver())
                .login()
                .clickmenu()
                .loginConfirm();
        Allure.step("Expected result: ");
        Assert.assertEquals(items, "Logout");
    }

    @Test
    @Story("")
    @Description("")
    @Severity(CRITICAL)
    public void logOutTest() {
        Boolean logOut = new HomePage(getDriver())
                .login()
                .clickmenu()
                .logOut()
                .logOutCheckBoolean("https://www.saucedemo.com/");

        Allure.step("Expected result: ");
        Assert.assertTrue(logOut, "Your are not logout!!");
    }


}
