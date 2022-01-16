package Pages.DemoBlazePages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DemoBlazeVaioPage extends BaseHelper {

    @FindBy (id="cartur")
    WebElement cartTab;

    WebDriver driver;
    public DemoBlazeVaioPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private void clickOnAddToCartButton(){
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("btn-success")));
        WebElement addToCartButton = driver.findElement(By.className("btn-success"));
        addToCartButton.click();
    }
    private void closePopup(){
        wdWait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }
    private void clickOnTheCartTab(){
        cartTab.click();
    }
    public void addVaioAndProcedeToCart(){
        clickOnAddToCartButton();
        closePopup();
        clickOnTheCartTab();
    }
}
