package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utilities;


public class GearTest extends Utilities {
    @Before
    public void setUp() {
        String baseUrl = "https://magento.softwaretestingboard.com/";
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart() {
        WebElement Gear = driver.findElement(By.id("ui-id-6"));
        WebElement Bags = driver.findElement(By.xpath("//span[normalize-space()='Bags']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(Gear).build().perform();
        actions.moveToElement(Bags).click().build().perform();
        WebElement OvernightDuffle = driver.findElement(By.xpath("//a[contains(text(),'Overnight Duffle')]"));
        OvernightDuffle.click();
        String expectedMessage = "Overnight Duffle";
        WebElement actualTextElement = driver.findElement(By.xpath("//span[@class='base']"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals("Error message not displayed", expectedMessage, actualMessage);
        WebElement Qty = driver.findElement(By.id("qty"));
        Qty.clear();
        Qty.sendKeys("3");
        WebElement AddtoCart = driver.findElement(By.xpath("//span[contains(text(),'Add to Cart')]"));
        AddtoCart.click();
        WebElement YouaddedOverDUffletoyourshoppingcart = driver.findElement(By.xpath("//body/div[1]/main[1]/div[1]/div[2]/div[1]/div[1]/div[1]"));
        Assert.assertEquals("Message not displayed.", expectedMessage, actualMessage);
        WebElement shoppingcart = driver.findElement(By.xpath("//a[contains(text(),'shopping cart')]"));
        shoppingcart.click();
        WebElement OverNgt = driver.findElement(By.linkText("Overnight Duffle"));
        Assert.assertEquals("Message is notVerified.", expectedMessage, actualMessage);
        WebElement qty = driver.findElement(By.xpath("//tbody/tr[1]/td[3]/div[1]/div[1]/label[1]"));
        Assert.assertEquals("Text is not Verified.", expectedMessage, actualMessage);
        WebElement Price = driver.findElement(By.xpath("//tbody/tr[3]/td[1]/strong[1]/span[1]"));
        Assert.assertEquals("Price is not Verified.", expectedMessage, actualMessage);
        WebElement Qty1 = driver.findElement(By.xpath("//input[@id='cart-103669-qty']"));
        Qty.clear();
        Qty.sendKeys("5");
        WebElement UpdateShoppingCart = driver.findElement(By.xpath("//span[contains(text(),'Update Shopping Cart')]"));
        UpdateShoppingCart.click();
        WebElement Subtotal = driver.findElement(By.xpath("//tbody/tr[1]/td[4]/span[1]/span[1]/span[1]"));
        Assert.assertEquals("Total cost is not Verified.", expectedMessage, actualMessage);
    }

    @After
    public void tearDown() {
        driver.close();
    }
}