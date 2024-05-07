package org.example;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class BrowserManager extends Utils
{
    LoadProp loadProp = new LoadProp();

    //Provide browser name
    String browser = loadProp.getProperty("browser");

    //Choose browser depend on given variable
    public void openTheBrowser()
    {
        if(browser.equalsIgnoreCase("Chrome"))
        {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox"))
        {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge"))
        {
            driver = new EdgeDriver();
        }else
        {
            System.out.println("Your browser name is wrong :" +browser);
        }


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(loadProp.getProperty("url"));
    }

    //Close the browser
    public void closeTheBrowser()
    {
        driver.quit();
    }
}
