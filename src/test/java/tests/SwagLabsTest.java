package tests;

import Pages.SwagLabsPages.*;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static helpers.TestData.*;

public class SwagLabsTest extends BaseTest

{
    @Test

    public void swagLabsLogInTest() throws InterruptedException {
        String username = "problem_user";
        String password = "secret_sauce";

        SwagLabsLogInPage logInPage = new SwagLabsLogInPage(driver);
        logInPage.SwaglabsLogin(username, password);

        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("inventory_list")));
        WebElement products = driver.findElement(By.className("inventory_list"));
        List<WebElement> productsList = products.findElements(By.className("inventory_item_description"));
        System.out.println("Number of products: " + productsList.size());
        Assert.assertTrue("There are no products.",productsList.size()>0);

        int productCounter = 0;
        for (WebElement product:productsList)
        {
            productCounter++;
            System.out.println(productCounter);
            System.out.println(product.getText());
        }

        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("react-burger-menu-btn")));
        WebElement leftCornerMenu = driver.findElement(By.id("react-burger-menu-btn"));
        leftCornerMenu.click();
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("logout_sidebar_link")));
        WebElement logoutButton = driver.findElement(By.id("logout_sidebar_link"));
        Assert.assertTrue("The LOGOUT button is not visible.", logoutButton.isDisplayed());

        Thread.sleep(4000); //put due to better visual exception
    }

    @Test

    public void swagLabsPurchaseTest() throws InterruptedException {
        SwagLabsLogInPage firstPage = new SwagLabsLogInPage(driver);
        SwagLabsProductsPage productsPage = new SwagLabsProductsPage(driver);
        SwagLabsCartPage cartPage = new SwagLabsCartPage(driver);
        SwagLabsInfoPage infoPage = new SwagLabsInfoPage(driver);
        SwagLabsOverviewPage overviewPage = new SwagLabsOverviewPage(driver);

        firstPage.SwaglabsLogin(STANDARD_USER, STANDARD_PASSWORD);

        ArrayList<String> prices = productsPage.addingProducts();
        String initialBackpackPrice = prices.get(0);
        String initialOnesiePrice = prices.get(1);

        cartPage.clickOnCheckoutButton();

        infoPage.enterInfoPage(FIRST_NAME, LAST_NAME, POST_CODE);

        ArrayList<String> checkoutPrices = overviewPage.finishThePurchase();
        String checkoutBackpackPrice = checkoutPrices.get(0);
        String checkoutOnesiePrice = checkoutPrices.get(1);

        Assert.assertEquals("Initial and checkout prices for given product is not equal.", initialBackpackPrice, checkoutBackpackPrice);
        Assert.assertEquals("Initial and checkout prices for given product is not equal.", initialOnesiePrice, checkoutOnesiePrice);

        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("complete-header")));
        WebElement completionMessage = driver.findElement(By.className("complete-header"));
        System.out.println("End message is: "+completionMessage.getText());
        String expectedMessage = "Thank you for your order";

        Assert.assertEquals("End message does not contain expected text.", completionMessage.getText(), expectedMessage.toUpperCase(Locale.ROOT));

        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("back-to-products")));
        WebElement backHomeButton = driver.findElement(By.id("back-to-products"));

        Assert.assertTrue("BACK HOME button is not displayed", backHomeButton.isDisplayed());

        Thread.sleep(4000); //put due to better visual exception
    }
}
