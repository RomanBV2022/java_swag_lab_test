package automation.tests;


import automation.page_object_model.LoginPage;
import automation.utils.ConfigProvider;
import automation.runner.BaseTest;
import automation.utils.ListeningClass;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import static io.qameta.allure.SeverityLevel.CRITICAL;


@Epic("Create account")
@Feature("Login")
public class LoginTest extends BaseTest {
    @DataProvider
    Object[][] loginData() {
        return new Object[][]{
                {"standard_user", "secret_sauce"},
                {"problem_user", "secret_sauce"},
                {"performance_glitch_user", "secret_sauce"},
                {"error_user", "secret_sauce"},
                {"visual_user", "secret_sauce"}
        };
    }

    @Test
    @Story("login in with {username} and {password}")
    @Description("login to account")
    @Severity(CRITICAL)
    public void loginTest() {
        String items = new LoginPage(getDriver())
                .login(ConfigProvider.LOGIN, ConfigProvider.PASSWORD)
                .clickMenu()
                .loginConfirm();
        Allure.step("login with {login} and {password}");
        Assert.assertEquals(items, "Logout");

    }

    @Test(dataProvider = "loginData")
    @Story("login")
    @Description("Testing login to website")
    @Severity(CRITICAL)
    public void testLoginDataProvider(String name, String password) {
        String items = new LoginPage(getDriver())
                .loginWithDataParameters(name, password)
                .clickMenu()
                .loginConfirm();
        Allure.step("Expected result: User is login");
        Assert.assertEquals(items, "Logout");
    }

    @Ignore
    @Test
    @Story("login")
    @Description("Testing login to website without out password")
    public void testLoginWithOutPassword(String name, String password) {
        String login = new LoginPage(getDriver())
                .loginWithOutOfPassword(name, password);

        Assert.assertEquals(login, "Epic sadface: Password is required");


    }

    @Test
    @Story("logout")
    @Description("Testing logout from website")
    @Severity(CRITICAL)
    public void logOutTest() {
        String logOut = new LoginPage(getDriver())
                .login(ConfigProvider.LOGIN, ConfigProvider.PASSWORD)
                .clickMenu()
                .logOut()
                .logOutString();

        Allure.step("Expected result: User is logout ");
        Assert.assertEquals(logOut, "Login", "Error message : Your are not logout");
    }


}