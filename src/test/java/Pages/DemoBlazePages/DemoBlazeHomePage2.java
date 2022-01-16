package Pages.DemoBlazePages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DemoBlazeHomePage2 extends BaseHelper {

    WebDriver driver;
    public DemoBlazeHomePage2 (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private void clickOnTheLaptopsOption(){
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//a[normalize-space()='Laptops'])")));
        WebElement laptops = driver.findElement(By.xpath("(//a[normalize-space()='Laptops'])"));
        laptops.click();
    }
    private void clickOnTheSonyVaioI7(){
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[normalize-space()='Sony vaio i7']")));
        WebElement vaioI7Title = driver.findElement(By.xpath("//a[normalize-space()='Sony vaio i7']"));
        //wdWait.until(ExpectedConditions.elementToBeClickable(vaioI7Title));
        //vaioI7Title.click();
        js.executeScript("arguments[0].click();", vaioI7Title);
    }
    public void homepageLaptopSelection(){
        clickOnTheLaptopsOption();
        clickOnTheSonyVaioI7();
    }
}
