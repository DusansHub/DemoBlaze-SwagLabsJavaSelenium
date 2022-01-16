package Pages.SwagLabsPages;

import helpers.BaseHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SwagLabsCartPage extends BaseHelper
{

    @FindBy (id="checkout")
    WebElement checkoutButton;

    WebDriver driver;
    public SwagLabsCartPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnCheckoutButton(){
        wdWait.until(ExpectedConditions.visibilityOf(checkoutButton));
        checkoutButton.click();
    }
}
