package automation.tests;


import automation.page_object_model.HomePage;
import automation.runner.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    private static final String HOME_PAGE = "DEMOQA";

    @Test
    public void testLogin() {
        String homePage = new HomePage(getDriver())
                .getTitleOfPage();

        Assert.assertEquals(homePage, HOME_PAGE);




    }

}
