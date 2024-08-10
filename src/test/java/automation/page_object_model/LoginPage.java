package automation.page_object_model;


import automation.base.BasePage;
import automation.runner.ListeningClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

import java.io.IOException;


public class LoginPage extends BasePage {

    public static final String USER_NAME = "standard_user";
    public static final String PASSWORD = "secret_sauce";

    @FindBy()
    WebElement userName = getDriver().findElement(By.id("user-name"));

    @FindBy
    WebElement password = getDriver().findElement(By.id("password"));

    @FindBy
    WebElement loginButton = getDriver().findElement(By.id("login-button"));

    public LoginPage(WebDriver driver) {
        super(driver);

    }

    public ProductsPage login(String login, String pass) {
        userName.sendKeys(login);
        password.sendKeys(pass);
        loginButton.click();

        return new ProductsPage(getDriver());
    }

    public static void readProperties(String valueOfProperty) throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("test.properties"));
        System.getProperty(valueOfProperty);
    }

    public ProductsPage loginWithDataParameters(String name, String pass) {
        userName.sendKeys(name);
        password.sendKeys(pass);
        loginButton.click();

        return new ProductsPage(getDriver());

    }

    public String logOutString() {
        getWait5().until(ExpectedConditions.visibilityOf(loginButton));

        return loginButton.getAttribute("value");
    }

}