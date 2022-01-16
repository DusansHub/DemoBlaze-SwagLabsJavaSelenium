package Pages.DemoBlazePages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class DemoBlazeHomePage extends BaseHelper {
    @FindBy (id="cat")
    WebElement categories;
    @FindBy (id="tbodyid")
    WebElement phonesList;

    WebDriver driver;
    public DemoBlazeHomePage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private void navigateToHomepage()
    {
        driver.get("https://www.demoblaze.com/");
    }
    private void clickOnThePhones()
    {
        //wdWait.until(ExpectedConditions.visibilityOf(categories));
        //List<WebElement> categoriesList = categories.findElements(By.className("list-group-item"));
        //System.out.println(categoriesList.size());
        wdWait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='Phones'])")));
        WebElement phones = driver.findElement(By.xpath("(//a[normalize-space()='Phones'])"));
        phones.click();
    }
    private void chooseNexus6()
    {
        //wdWait.until(ExpectedConditions.visibilityOf(phonesList));
        //List<WebElement> listOfPhones = phonesList.findElements(By.className("col-md-6"));
        //System.out.println("Number of phones found on the list is: "+listOfPhones.size());
        //WebElement nexusPhone = listOfPhones.get(2);
        wdWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Nexus 6']")));
        WebElement nexusTitle = driver.findElement(By.xpath("//a[normalize-space()='Nexus 6']"));
        nexusTitle.click();
        //js.executeScript("arguments[0].click();", nexusTitle);
    }
    public void homepagePhoneSelection()
    {
        navigateToHomepage();
        clickOnThePhones();
        chooseNexus6();
    }
}
