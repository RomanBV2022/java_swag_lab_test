package automation.tests;


import automation.page_object_model.HomePage;
import automation.runner.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest() {

        int items = new HomePage(getDriver())
                .login()
                .howMuchElements();

        Assert.assertEquals(items,6);

    }


}
