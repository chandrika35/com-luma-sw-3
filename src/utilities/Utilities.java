package utilities;

import browserfactory.BaseTest;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Utilities extends BaseTest {
    /**
     * This method will click on element
     */
    public void clickOnElement(By by) {
        driver.findElement(by).click();

    }

    /**
     * This method will send Text to element
     */
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();//return as a string get type method returns string
    }

    /*
        This method will mouse hover over any element
         */
    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        WebElement text1 = driver.findElement(by);
        WebElement text2 = driver.findElement(by);
        actions.moveToElement(text1).moveToElement(text2).build().perform();
    }

    /**
     * This method will get number from element and check
     * whether it is displayed or not.
     */
    public boolean getNumberFromElement(By by, int expectedNumber) {
        int actualNumber = driver.findElements(by).size();
        assert actualNumber == expectedNumber : "Expected Number is not found" + expectedNumber;
        return true;
    }

    public void selectByVisibleTextFromDropDown(By by, String text) {
        //WebElement dropDown =
    }
    public void getActualStringText(){

    }
    public void varifyTheProductsNameDisplayInAlphabeticalOrder(){
        getActualStringText();


    }

    @After
    public void tearDown() {
       driver.close();
//**************************************Alert Methods********************************
//Homework Create 5 Methods

        ///*************************** Select Class Methods ***************************************//
        // public void selectByVisibleTextFromDropDown(By by, String text) {
        // WebElement dropDown = driver.findElement(by);
        // Select select = new Select(dropDown);
        // Select by visible text
        //select.selectByVisibleText(text);
    }

}