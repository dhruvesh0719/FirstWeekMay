package org.example;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends Utils
{
    BrowserManager browserManager = new BrowserManager();

    @BeforeMethod
    public void setup()
    {
        browserManager.openTheBrowser();
    }

    @AfterMethod
    public void tearDown(ITestResult result)
    {
        if (!result.isSuccess())
        {
            takeScreenShot(result.getName());
        }
        browserManager.closeTheBrowser();
    }

}
