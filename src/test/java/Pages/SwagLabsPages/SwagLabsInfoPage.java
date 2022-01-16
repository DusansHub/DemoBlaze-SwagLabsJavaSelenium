package Pages.SwagLabsPages;

import helpers.BaseHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SwagLabsInfoPage extends BaseHelper
{
    @FindBy (id="first-name")
    WebElement firstNameTextBox;
    @FindBy (id="last-name")
    WebElement lastNameTextBox;
    @FindBy (id="postal-code")
    WebElement postalCodeTextBox;
    @FindBy (id="continue")
    WebElement continueButton;

    WebDriver driver;
    public SwagLabsInfoPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private void enterFirstName(String firstName) {
        wdWait.until(ExpectedConditions.visibilityOf(firstNameTextBox));
        firstNameTextBox.sendKeys(firstName);
    }
    private void enterLastName(String lastName) {
        lastNameTextBox.sendKeys(lastName);
    }
    private void enterPostalCode(String postCode) {
        postalCodeTextBox.sendKeys(postCode);
    }
    private void clickOnTheContinueButton() {
        continueButton.click();
    }
    public void enterInfoPage(String firstName, String lastName, String postCode){
        enterFirstName(firstName);
        enterLastName(lastName);
        enterPostalCode(postCode);
        clickOnTheContinueButton();
    }
}
