package automation.page_object_model;


import automation.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage {


    public static final String USER_NAME = "standard_user";
    public static final String PASSWORD = "secret_sauce";

    @FindBy()
    WebElement userName = getDriver().findElement(By.id("user-name"));

    @FindBy
    WebElement password = getDriver().findElement(By.id("password"));

    @FindBy
    WebElement loginButton = getDriver().findElement(By.id("login-button"));

    public HomePage(WebDriver driver) {
        super(driver);

    }


    public LoginPage login() {
        userName.sendKeys(USER_NAME);
        password.sendKeys(PASSWORD);
        loginButton.click();

        return new LoginPage(getDriver());
    }



}

