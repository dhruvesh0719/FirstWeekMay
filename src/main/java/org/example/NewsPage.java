package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class NewsPage extends Utils
{
    //Object of LoadProp class
    LoadProp loadProp = new LoadProp();

    //All necessary web elements of the page
    private String _titleOfPage = "//div[@class='fieldset new-comment']/div[1]";
    private String _textBoxTitle = "AddNewComment_CommentTitle";
    private String _textBoxComment = "AddNewComment.CommentText";
    private String _newCommentButton = "add-comment";
    private String _lastComment = "(//div[@class='comments']/div)[last()]";

    //Verify title of the page
    public void verifyTitleOfPage()
    {
        String actual = captureTextOfTheElement(By.xpath(_titleOfPage));
        Assert.assertEquals(actual,loadProp.getProperty("expectedNewsTitle"),"Title is not Correct");
    }


    //Capture last comment & compare with the entered one
    public void checkLastCommentIsAtTheBottomOfTheListOrNot()
    {
        //Entre title
        typeText(By.id(_textBoxTitle),loadProp.getProperty("titleOfComment"));

        //Entre Comments
        typeText(By.name(_textBoxComment),loadProp.getProperty("comment"));

        //Click on New comment button
        clickOnElement(By.name(_newCommentButton));

       String text = captureTextOfTheElement(By.xpath(_lastComment));
       Assert.assertTrue(text.contains(loadProp.getProperty("titleOfComment")),"This is not a last message");
    }


}
