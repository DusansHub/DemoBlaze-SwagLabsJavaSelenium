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

public class SwagLabsProductsPage extends BaseHelper

{
    @FindBy (id="add-to-cart-sauce-labs-backpack")
    WebElement sauceLabsBackpack;
    @FindBy (id="add-to-cart-sauce-labs-onesie")
    WebElement sauceLabsOnesie;
    @FindBy (id="shopping_cart_container")
    WebElement shoppingCartIcon;
    @FindBy (className = "inventory_list")
    WebElement products;

    WebDriver driver;
    public SwagLabsProductsPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    private void addSauceLabsBackpack() {
        wdWait.until(ExpectedConditions.visibilityOf(sauceLabsBackpack));
        sauceLabsBackpack.click();
    }
    private String backpackPrice(){
        List<WebElement> productsList = products.findElements(By.className("inventory_item"));
        System.out.println("Number of products: "+productsList.size());
        WebElement backpack = productsList.get(0);
        WebElement backpackCost = backpack.findElement(By.className("inventory_item_price"));
        //backpackInitialPriceString = backpackCost.getText();
        System.out.println("Initial price of backpack is: "+backpackCost.getText());
        return backpackCost.getText();
    }
    private void addSauceLabsOnesie() {
        wdWait.until(ExpectedConditions.visibilityOf(sauceLabsOnesie));
        sauceLabsOnesie.click();
    }
    private String onesiePrice(){
        List<WebElement> productsList = products.findElements(By.className("inventory_item"));
        WebElement onesie = productsList.get(4);
        WebElement onesieCost = onesie.findElement(By.className("inventory_item_price"));
        System.out.println("Initial price of onesie is: "+onesieCost.getText());
        return onesieCost.getText();
    }
    private void clickOnTheShoppingCartIcon()
    {
        shoppingCartIcon.click();
    }
    public ArrayList<String> addingProducts() {
        ArrayList<String> prices = new ArrayList<>();
        prices.add(backpackPrice());
        prices.add(onesiePrice());
        addSauceLabsBackpack();
        addSauceLabsOnesie();
        clickOnTheShoppingCartIcon();
        return prices;
    }

}
