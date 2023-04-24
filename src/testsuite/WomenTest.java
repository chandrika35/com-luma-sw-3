package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.Utilities;

public class WomenTest extends Utilities {
    String baseUrl = " https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyTheSortByProductNameFilter() {
        WebElement Women = driver.findElement(By.xpath("//a[@id='ui-id-4']//span[contains(text(),'Women')]"));
        //strong[@class='title']//span[contains(text(),'Tops')]
        WebElement Tops = driver.findElement(By.xpath("//span[contains(text(),'Tops')]"));
        WebElement Jackets = driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/nav[1]/ul[1]/li[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]/span[1]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(Women).build().perform();
        actions.moveToElement(Tops).build().perform();
       actions.moveToElement(Jackets).click().build().perform();
        WebElement SortBy = driver.findElement(By.xpath("//div[@class='page-wrapper']//div[2]//div[3]//label[1]"));
        WebElement dropDown = driver.findElement(By.id("sorter"));
       Select select = new Select(dropDown);//find the correct element only and pass the value
        //select by visible text

        //select by
        select.selectByValue("name");


        //select by index number counting starts from '0'...array list

    }
    @Test
    public void verifyTheSortByPriceFilter(){
        WebElement Women = driver.findElement(By.xpath("//a[@id='ui-id-4']//span[contains(text(),'Women')]"));
        ////strong[@class='title']//span[contains(text(),'Tops')]
        WebElement Tops = driver.findElement(By.xpath("//span[contains(text(),'Tops')]"));
        WebElement Jackets = driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/nav[1]/ul[1]/li[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]/span[1]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(Women).build().perform();
        actions.moveToElement(Tops).build().perform();
        actions.moveToElement(Jackets).click().build().perform();
        WebElement SortBy = driver.findElement(By.xpath("//div[@class='page-wrapper']//div[2]//div[3]//label[1]"));
        WebElement dropDown = driver.findElement(By.id("sorter"));
        Select select = new Select(dropDown);//find the correct element only and pass the value
        //select by visible text

        //select by va
        select.selectByValue("price");
        //verifying the products are displayed in alphabetical order

    }
    @After
    public void tearDown() {
        driver.close();
    }
}
