package automation.tests;

import automation.page_object_model.LoginPage;
import automation.page_object_model.ProductsPage;
import automation.properties.ConfigProvider;
import automation.runner.BaseTest;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

@Epic("About page")
public class AboutPageTest  extends BaseTest {

    @Test(groups = "testVisualContent")
    @Story("US_03.03 Checking that the page is loaded and has title with nearest descriptions")
    @Description("Checking  title of page")
    public void testPageTitle() {
        String titleOfPage = new LoginPage(getDriver())
                .login(ConfigProvider.LOGIN, ConfigProvider.PASSWORD)
                .clickMenu()
                .goToAboutPage()
                .showTitleOfPage();
        final String title = "Sauce Labs: Cross Browser Testing, Selenium Testing & Mobile Testing";

        Allure.step("Expected result: " + "The title is contain information -> 'About' page");

        Assert.assertEquals(titleOfPage, title);

    }

    @Test(groups = "testVisualContent")
    @Story("US_03.04 Checking that the page is loaded and has menu")
    @Description("Checking menu content")
    public void testHeaderMenuContent() {
      List<String> itemList = new LoginPage(getDriver())
              .login(ConfigProvider.LOGIN, ConfigProvider.PASSWORD)
              .clickMenu()
              .goToAboutPage()
              .showMenuList();


    }

}
