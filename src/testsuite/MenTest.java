package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utilities;

public class MenTest extends Utilities {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart() {
        WebElement Men = driver.findElement(By.xpath("//a[@id='ui-id-5']//span[contains(text(),'Men')]"));
        WebElement Bottoms = driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/nav[1]/ul[1]/li[3]/ul[1]/li[2]/a[1]/span[2]"));
        //"//strong[@class='title']"
        WebElement Pants = driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/nav[1]/ul[1]/li[3]/ul[1]/li[2]/ul[1]/li[1]/a[1]/span[1]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(Men).build().perform();
        actions.moveToElement(Bottoms).build().perform();
        actions.moveToElement(Pants).click().build().perform();
        WebElement Cronus = driver.findElement(By.xpath("//a[contains(text(),'Cronus Yoga Pant')]"));
        WebElement Size32 = driver.findElement(By.xpath("//body/div[1]/main[1]/div[3]/div[1]/div[3]/ol[1]/li[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]"));
        Actions actions1 = new Actions(driver);
        actions1.moveToElement(Cronus).build().perform();
        actions1.moveToElement(Size32).click().build().perform();
        WebElement ColourBlack = driver.findElement(By.id("option-label-color-93-item-49"));
        ColourBlack.click();
        WebElement AddtoCart = driver.findElement(By.xpath("//body/div[1]/main[1]/div[3]/div[1]/div[3]/ol[1]/li[1]/div[1]/div[1]/div[3]/div[1]/div[1]/form[1]/button[1]"));
        AddtoCart.click();
        String expectedText = "You added Cronus Yoga Pant to your shopping cart.";
        WebElement actualTextElement = driver.findElement(By.xpath("//body/div[1]/main[1]/div[2]/div[2]/div[1]/div[1]"));
        String actualText = actualTextElement.getText();
        Assert.assertEquals("Text is not displayed.", expectedText, actualText);
        WebElement shoppingcart = driver.findElement(By.linkText("shopping cart"));
        shoppingcart.click();
        WebElement ShoppingCart = driver.findElement(By.xpath("//body/div[1]/main[1]/div[1]/h1[1]/span[1]"));
        Assert.assertEquals("Text is not displayed", expectedText, actualText);
        WebElement CronusYogaPant = driver.findElement(By.xpath("//a[normalize-space()='Cronus Yoga Pant']"));
        Assert.assertEquals("Text is not displayed", expectedText, actualText);
        WebElement size32 = driver.findElement(By.xpath("//dd[contains(text(),'32')]"));
        Assert.assertEquals("Text is not displayed", expectedText, actualText);
        WebElement Black = driver.findElement(By.xpath("//dd[contains(text(),'Black')]"));
        Assert.assertEquals("Text is not displayed", expectedText, actualText);


    }

    @After
    public void tearDown() {
        driver.close();

   }
}