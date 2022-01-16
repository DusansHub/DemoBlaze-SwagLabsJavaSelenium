package Pages.SwagLabsPages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class SwagLabsOverviewPage extends BaseHelper {

    @FindBy (id="finish")
    WebElement finishButton;
    @FindBy (className = "cart_list")
    WebElement cartList;

    WebDriver driver;
    public SwagLabsOverviewPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private String checkoutBackpackPrice(){
        wdWait.until(ExpectedConditions.visibilityOf(cartList));
        List<WebElement> cartItems = cartList.findElements(By.className("cart_item"));
        WebElement backpack = cartItems.get(0);
        WebElement backpackCheckoutPrice = backpack.findElement(By.className("inventory_item_price"));
        System.out.println("Backpack checkout price is: "+backpackCheckoutPrice.getText());
        return backpackCheckoutPrice.getText();
    }
    private String checkoutOnesiePrice(){
        List<WebElement> cartItems = cartList.findElements(By.className("cart_item"));
        WebElement onesie = cartItems.get(1);
        WebElement onesieCheckoutPrice = onesie.findElement(By.className("inventory_item_price"));
        System.out.println("Onesie checkout price is: "+onesieCheckoutPrice.getText());
        return onesieCheckoutPrice.getText();
    }
    private void clickOnTheFinishButton(){
        wdWait.until(ExpectedConditions.visibilityOf(finishButton));
        finishButton.click();
    }
    public ArrayList<String> finishThePurchase(){
        ArrayList<String> checkoutPrices = new ArrayList<>();
        checkoutPrices.add(checkoutBackpackPrice());
        checkoutPrices.add(checkoutOnesiePrice());
        clickOnTheFinishButton();
        return checkoutPrices;
    }
}
