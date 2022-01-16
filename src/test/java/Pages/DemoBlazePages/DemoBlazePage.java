package Pages.DemoBlazePages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class DemoBlazePage extends BaseHelper

{
    @FindBy (id="navbarExample")
    WebElement upperMenu;
    @FindBy (id="loginusername")
    WebElement usernameField;
    @FindBy (id="loginpassword")
    WebElement passwordField;

    WebDriver driver;
    public DemoBlazePage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private void navigateToTheHomepage()
    {
        driver.get("https://www.demoblaze.com/");
    }
    private void clickOnTheLogInButton()
    {
        wdWait.until(ExpectedConditions.visibilityOf(upperMenu));
        List<WebElement> upperMenuOptions = upperMenu.findElements(By.className("nav-item"));
        WebElement logInButton = upperMenuOptions.get(4);
        wdWait.until(ExpectedConditions.visibilityOf(logInButton));
        logInButton.click();
    }
    private void enterUsername(String username)
    {
        wdWait.until(ExpectedConditions.visibilityOf(usernameField));
        usernameField.sendKeys(username);
    }
    private void enterPassword(String password)
    {
        wdWait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.sendKeys(password);
    }
    private void clickOnTheBlueLogInButton()
    {
        WebElement blueLogButton = driver.findElement(By.cssSelector("button[onclick='logIn()']"));
        wdWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[onclick='logIn()']")));
        blueLogButton.click();
        //js.executeScript("arguments[0].click();", blueLogInButton);

    }
    public void homepageCheckIn(String username, String password)
    {
        navigateToTheHomepage();
        clickOnTheLogInButton();
        enterUsername(username);
        enterPassword(password);
        clickOnTheBlueLogInButton();
    }
}
