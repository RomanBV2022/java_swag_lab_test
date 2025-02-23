package automation.page_object_model;


import automation.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import java.io.IOException;


public class LoginPage extends BasePage {


    @FindBy(id = "user-name")
    WebElement userName;

    @FindBy(id = "password")
    WebElement passwordElement;

    @FindBy(id = "login-button")
    WebElement loginButton;

    @FindBy(xpath = "")
    WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);

    }

    @Step("login with {login} and {password}")
    public ProductsPage login(String login, String password) {
        userName.sendKeys(login);
        this.passwordElement.sendKeys(password);
        getWait5();
        loginButton.click();

        return new ProductsPage(getDriver());
    }

    public String loginWithOutOfPassword(String login, String pass) {
        userName.sendKeys(login);
        passwordElement.sendKeys(pass);
        loginButton.click();
        getWait5().until(ExpectedConditions.visibilityOf(errorMessage));

        return errorMessage.getText();

    }

    public static void readProperties(String valueOfProperty) throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("test.properties"));
        System.getProperty(valueOfProperty);
    }

    public ProductsPage loginWithDataParameters(String name, String pass) {
        userName.sendKeys(name);
        passwordElement.sendKeys(pass);
        loginButton.click();

        return new ProductsPage(getDriver());

    }

    public String logOutString() {
        getWait5().until(ExpectedConditions.visibilityOf(loginButton));

        return loginButton.getAttribute("value");
    }

}