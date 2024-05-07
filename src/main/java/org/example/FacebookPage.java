package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;


public class FacebookPage extends Utils
{
    LoadProp loadProp = new LoadProp();

    private String _faceBookButton = "//div[@class='social']/ul/li[1]";

    //Click on Face book button
    public void clickOnFaceBookButton()
    {
        clickOnElement(By.xpath(_faceBookButton));

    }

    //Accept cookies
    public void acceptCookies()
    {
      clickOnElement(By.xpath("//div[@role='dialog']/div/div[2]/div/div[2]/div[1]/div/div/div"));
    }

    //Verify URL
    public void verifyURL()
    {
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL,loadProp.getProperty("expectedURLatFacebookPage"),"URL you are getting is not correct");
    }

    //Verify NopCommerce title
    public void verifyNopCommerceTitle()
    {
        String actualTitle=captureTextOfTheElement(By.xpath("//div[@class='x1e56ztr x1xmf6yo']"));
        Assert.assertEquals(actualTitle,loadProp.getProperty("expectedTitleFaceBookPage"),"The Title is Wrong");
    }
}
