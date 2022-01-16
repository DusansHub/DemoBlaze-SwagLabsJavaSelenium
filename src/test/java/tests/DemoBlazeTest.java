package tests;

import Pages.DemoBlazePages.*;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DemoBlazeTest extends BaseTest

{
    @Test

    public void loginTest() throws InterruptedException {

        String username = "dusan123";
        String password = "dusan123";
        DemoBlazePage homepage = new DemoBlazePage(driver);
        homepage.homepageCheckIn(username, password);

        wdWait.until(ExpectedConditions.elementToBeClickable(By.id("logout2")));
        WebElement logOutButton = driver.findElement(By.id("logout2"));
        WebElement usersName = driver.findElement(By.id("nameofuser"));
        System.out.println("Name of user shown in the welcome tab: "+usersName.getText());
        String welcomeNote = usersName.getText();
        String expectedMessage = "dusan123";

        Assert.assertTrue("Log out button is not displayed.",logOutButton.isDisplayed());
        Assert.assertTrue("User's name is not present.", welcomeNote.contains(expectedMessage));

        Thread.sleep(5000); // left due to better visual perception
    }

    @Test

    public void purchaseTest() throws InterruptedException {
        DemoBlazeHomePage homePage = new DemoBlazeHomePage(driver);
        homePage.homepagePhoneSelection();

        DemoBlazeNexusPage nexusPage = new DemoBlazeNexusPage(driver);
        nexusPage.nexusAddingPage();

        DemoBlazeHomePage2 homepage2 = new DemoBlazeHomePage2(driver);
        homepage2.homepageLaptopSelection();

        DemoBlazeVaioPage vaioPage = new DemoBlazeVaioPage(driver);
        vaioPage.addVaioAndProcedeToCart();

        //td[normalize-space()='Sony vaio i7']/following-sibling::td[1] alternative xpath using sibling
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[normalize-space()='790']")));
        WebElement sonyVaioI7Price = driver.findElement(By.xpath("//td[normalize-space()='790']"));
        int vaioI7Price = Integer.parseInt(sonyVaioI7Price.getText());
        System.out.println("Sony Vaio I7 price is: "+vaioI7Price);
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[normalize-space()='650']")));
        WebElement nexus6Price = driver.findElement(By.xpath("//td[normalize-space()='650']"));
        int nexusPrice = Integer.parseInt(nexus6Price.getText());
        System.out.println("Nexus 6 price is: "+nexusPrice);
        int totalPrice = Integer.parseInt(driver.findElement(By.id("totalp")).getText());
        System.out.println("Total price is: "+totalPrice);
        Assert.assertTrue("Unit prices sum is not equal to total sum.", nexusPrice + vaioI7Price == totalPrice);

        String name = "Dusan";
        String country = "Serbia";
        String city = "Belgrade";
        String creditCard = "0123456789";
        String month = "03";
        String year = "22";

        DemoBlazeProductsPage productsPage = new DemoBlazeProductsPage(driver);
        productsPage.placingOrder(name, country, city, creditCard, month, year);

        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body > div:nth-child(19) > h2:nth-child(6)")));
        WebElement endPurchaseNote = driver.findElement(By.cssSelector("body > div:nth-child(19) > h2:nth-child(6)"));
        String thankYouNote = endPurchaseNote.getText();
        System.out.println("The end purchase note is: "+thankYouNote);
        String expectedNote = "Thank you for your purchase!";
        Assert.assertTrue("The end note does not match expected one.", thankYouNote.contains(expectedNote));

        Thread.sleep(5000); // left due to better visual perception
    }
}

