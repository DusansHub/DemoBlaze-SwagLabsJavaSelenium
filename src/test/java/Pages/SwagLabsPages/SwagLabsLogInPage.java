package Pages.SwagLabsPages;

import helpers.BaseHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SwagLabsLogInPage extends BaseHelper {
    @FindBy(id = "user-name")
    WebElement usernameField;
    @FindBy(id = "password")
    WebElement passwordField;
    @FindBy(id = "login-button")
    WebElement loginButton;

    WebDriver driver;

    public SwagLabsLogInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private void navigateToSwaglabsHomepage() {
        driver.get("https://www.saucedemo.com/");
    }

    private void enterGivenUsername(String username) {
        wdWait.until(ExpectedConditions.visibilityOf(usernameField));
        usernameField.sendKeys(username);
    }

    private void enterGivenPassword(String password) {
        passwordField.sendKeys(password);
    }

    private void clickOnTheLoginButton() {
        loginButton.click();
    }

    public void SwaglabsLogin(String username, String password) {
        navigateToSwaglabsHomepage();
        enterGivenUsername(username);
        enterGivenPassword(password);
        clickOnTheLoginButton();
    }
}
