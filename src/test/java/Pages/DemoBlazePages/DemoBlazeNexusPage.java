package Pages.DemoBlazePages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DemoBlazeNexusPage extends BaseHelper {

    @FindBy (id="nava")
    WebElement logo;

    WebDriver driver;
    public DemoBlazeNexusPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private void clickOnAddButton()
    {
        WebElement addButton = driver.findElement(By.className("btn-success"));
        addButton.click();
    }
    private void closePopup(){
        wdWait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }
    private void clickOnTheLogo()
    {
        logo.click();
    }
    public void nexusAddingPage(){
        clickOnAddButton();
        closePopup();
        clickOnTheLogo();
    }
}
