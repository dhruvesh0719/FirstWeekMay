package org.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;


public class Utils extends BasePage
{


    //All reusable variables & methods

    //Store the email address
    static String email = "firstPartEmail"+random()+"fj@gmail.com";

    //Store password
    static String password = "Dhruvesh285";


    //1) Click on element method
    public static void clickOnElement(By by)
    {
        driver.findElement(by).click();
    }

    //2) Type a text inside Text Box
    public static void typeText(By by, String text)
    {
        driver.findElement(by).sendKeys(text);
    }

    //3) Capture a text from the element
    public static String captureTextOfTheElement(By by)
    {
        return driver.findElement(by).getText();
    }

    //4) Method to generate Random String
    public static String random()
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyyddmmhms");
        Date date = new Date();
        return dateFormat.format(date);
    }

    //5) Explicit wait until visibility of the element located
    public static void waitForVisibilityOfElementLocated(By by, int time)
    {
        WebElement element = driver.findElement(by);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    //6) Select by Visible  text
    public static void selectByVisibleText(By by, String text)
    {
        WebElement element = driver.findElement(by);
        Select dropDown = new Select(element);
        dropDown.selectByVisibleText(text);

    }

    //7) Select By index
    public static void selectByIndex(By by, int i)
    {
        WebElement element = driver.findElement(by);
        Select dropDown = new Select(element);
        dropDown.deselectByIndex(i);
    }

    //8) Select By value
    public static void selectByValue(By by, String text)
    {
        WebElement element = driver.findElement(by);
        Select dropDown = new Select(element);
        dropDown.selectByValue(text);
    }

    //9) Fluent wait
    public static void fluentWait()
    {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30L))
                .pollingEvery(Duration.ofSeconds(5L))
                .ignoring(NoSuchElementException.class);
    }

    //10) Implicitly wait
    public static void implicitWait(int time)
    {
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }

    //11) take a screenshot method
    public static void takeScreenShot(String text)
    {
        //Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot = ((TakesScreenshot) driver);

        //Call getScreenshotAs method to create image file
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

        //Move image file to new destination
        try {
            FileUtils.copyFile(SrcFile, new File("src\\ScreenShots\\"+text+random()+".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    //12) Explicit Wait till element to be clickable
    public static void waitForElementToBeClickable(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(by));
    }

    //13 Get the attribute value
    public String getAttributeValue(By by, String text)
    {
        return driver.findElement(by).getAttribute(text);
    }

    //14 Get he css value
    public String getCssValue(By by, String text)
    {
        return driver.findElement(by).getCssValue(text);
    }
}
