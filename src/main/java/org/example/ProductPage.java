package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class ProductPage extends Utils
{
    //Object of LoadProp class
    LoadProp loadProp = new LoadProp();

    //All necessary web elements of the page
    private String _productNames = "//div[@class='item-grid']//div[2]/h2";

    //All product should have product name with their titles
    public void verifyProductNameHaveSearchNameContent()
    {
        List<WebElement> productName = driver.findElements(By.xpath(_productNames));

        for (WebElement element:productName)
        {
           String actualProductName = element.getText();
           Assert.assertTrue(actualProductName.contains("Nike"), "Product name does not contains search product content");
        }
    }

    //Verify URL
    public void verifyProductURL()
    {
        String actual = driver.getCurrentUrl();
        Assert.assertTrue(actual.endsWith("Nike"),"URL does not have product name at the endpoint");
    }
}
