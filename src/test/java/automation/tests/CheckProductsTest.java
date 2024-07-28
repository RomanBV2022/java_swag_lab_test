package automation.tests;

import automation.constans.Constant;
import automation.page_object_model.LoginPage;
import automation.runner.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import java.util.List;

public class CheckProductsTest extends BaseTest {
    @DataProvider(name = "getSortValue")
    public Object[][] getSortValue() {
        Object[][] valueToSort = {
                {"lohi"},
                {"hilo"},
                {"az"},
                {"za"}
        };
        return valueToSort;
    }

    @DataProvider(name = "getSortValueResult")
    public Object[][] getSortValueResult() {
        return new Object[][]{
                {"lohi", "Price (low to high)"},
                {"hilo", "Price (high to low)"},
                {"az", "Name (A to Z)"},
                {"za", "Name (Z to A)"}
        };
    }

    @DataProvider(name = "getSortPrice")
    public Object [][] getSortPrice() {
        return new  Object[][] {
                {"lohi", List.of("$29.99", "$9.99", "$15.99", "$49.99", "$7.99", "$15.99")},
                {"hilo",List.of("$29.99", "$9.99", "$15.99", "$49.99", "$7.99", "$15.99")},
                {"az", List.of("$29.99", "$9.99", "$15.99", "$49.99", "$7.99", "$15.99")},
                {"za", List.of("$29.99", "$9.99", "$15.99", "$49.99", "$7.99", "$15.99")}
        };
    }

    @Ignore
    @Test
    public void sortProductTest() {
        List<String> dropDownSelectHighToLow = new LoginPage(getDriver())
                .login()
                .dropDownSelect(Constant.Sorted.LOW_TO_HIGH)
                .sortPriceProducts();
        System.out.println(dropDownSelectHighToLow);
        List<String> immutableList =
                List.of("$29.99",
                        "$9.99",
                        "$15.99",
                        "$49.99",
                        "$7.99",
                        "$1.99");
        System.out.println();

        Assert.assertEquals(dropDownSelectHighToLow, immutableList);

    }

    @Test
    public void sortProductLowToHighTest() {

        String dropDownSelect = new LoginPage(getDriver())
                .login()
                .dropdownSelectGetValue(Constant.Sorted.LOW_TO_HIGH);

        String listResults = "Price (low to high)";

        Assert.assertEquals(dropDownSelect, listResults);

    }

    @Test(dataProvider = "getSortValue")
    public void sortProductWithDataProviderString(String getValueOfData) {

        String dropDownSelect = new LoginPage(getDriver())
                .login()
                .dropdownSelectGetValue(getValueOfData.toString());

        String listResults = "Price (low to high), Price (high to low), Name (A to Z), Name (Z to A)";

        Assert.assertTrue(listResults.contains(dropDownSelect));

    }

    @Test(dataProvider = "getSortValueResult")
    public void sortProductWithDataProvider(String getValue, String getResult) {

        String dropDownSelect = new LoginPage(getDriver())
                .login()
                .dropdownSelectGetValue(getValue.toString());


        Assert.assertEquals(dropDownSelect, getResult);
    }

    @Test(dataProvider = "getSortPrice")
    public void sortProductToPriceWithDataProvider(String getValueOfData, List<String> result) {

        List<String> dropDownSelect = new LoginPage(getDriver())
                .login()
                .dropdownSelectList(getValueOfData.toString())
                .sortPriceProducts();


        Assert.assertEquals(dropDownSelect, result);

    }

}