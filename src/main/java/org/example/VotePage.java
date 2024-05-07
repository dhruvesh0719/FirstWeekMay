package org.example;

import org.openqa.selenium.Alert;
import org.testng.Assert;

public class VotePage extends Utils
{
        //Object of LoadProp class
        LoadProp loadProp = new LoadProp();

        //Capture text of pop up alert & compare with Expected
        public void verifyVoteText()
        {
            Alert alert = driver.switchTo().alert();
            String alertText1 = alert.getText();
            Assert.assertEquals(alertText1,loadProp.getProperty("alertTextVote"),"Alert Message is wrong");
        }
}
