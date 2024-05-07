package org.example;

import org.openqa.selenium.Alert;
import org.testng.Assert;

public class SearchPage extends Utils
{
    //Object of LoadProp class
    LoadProp loadProp = new LoadProp();

    //Capture text of pop alert & verify with expected one
    public void textOfAlert()
    {
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        Assert.assertEquals(alertText,loadProp.getProperty("alertText"),"Alert Message is wrong");
    }
}
