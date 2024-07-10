package automation.tests;

import automation.page_object_model.HomePage;
import automation.runner.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CheckProductsTest extends BaseTest {
    @Test
    public void sortProductTest() {
        List<String> dropDownSelect = new HomePage(getDriver())
                .login()
                .dropDownMenuClick()
                .sortPriceProducts();
        List<String> immutableList =
                List.of("$29.99",
                        "$49.99",
                        "2",
                        "3",
                        "5",
                        "6");

        Assert.assertEquals(dropDownSelect, immutableList);

    }

}
