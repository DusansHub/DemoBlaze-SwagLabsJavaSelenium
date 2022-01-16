package Pages.DemoBlazePages;

import helpers.BaseHelper;
import org.kohsuke.rngom.parse.host.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DemoBlazeProductsPage extends BaseHelper {

    @FindBy (id="name")
    WebElement nameTextbox;
    @FindBy (id="country")
    WebElement countryTextbox;
    @FindBy (id="city")
    WebElement cityTextbox;
    @FindBy (id="card")
    WebElement creditCardTextbox;
    @FindBy (id="month")
    WebElement monthTextbox;
    @FindBy (id="year")
    WebElement yearTextbox;

    WebDriver driver;
    public DemoBlazeProductsPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private void clickOnThePlaceOrderButton(){
        wdWait.until(ExpectedConditions.elementToBeClickable(By.className("btn-success")));
        WebElement placeOrderButton = driver.findElement(By.className("btn-success"));
        placeOrderButton.click();
    }
    private void enterName (String name){
        wdWait.until(ExpectedConditions.visibilityOf(nameTextbox));
        nameTextbox.sendKeys(name);
    }
    private void enterCountry (String country){
        countryTextbox.sendKeys(country);
    }
    private void enterCity (String city){
        cityTextbox.sendKeys(city);
    }
    private void enterCreditCard (String creditCard){
        creditCardTextbox.sendKeys(creditCard);
    }
    private void enterMonth (String month){
        monthTextbox.sendKeys(month);
    }
    private void enterYear (String year){
        yearTextbox.sendKeys(year);
    }
    private void clickOnThePurchaseButton(){
        wdWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[onclick='purchaseOrder()']")));
        WebElement purchaseButton = driver.findElement(By.cssSelector("button[onclick='purchaseOrder()']"));
        purchaseButton.click();
    }
    public void placingOrder (String name, String country, String city, String creditCard, String month, String year){
        clickOnThePlaceOrderButton();
        enterName(name);
        enterCountry(country);
        enterCity(city);
        enterCreditCard(creditCard);
        enterMonth(month);
        enterYear(year);
        clickOnThePurchaseButton();
    }

}
