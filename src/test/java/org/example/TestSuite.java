package org.example;

import org.testng.annotations.Test;

public class TestSuite extends BaseTest
{
    //Objects of all Page classes
    HomePage homePage = new HomePage();

    FacebookPage facebookPage = new FacebookPage();

    NewsPage newsPage = new NewsPage();

    ProductPage productPage = new ProductPage();

    SearchPage searchPage = new SearchPage();

    VotePage votePage = new VotePage();

    @Test
    public void verifyAlertMessageAndAcceptAlertWhileClickOnSearchButtonWithoutEnteringAnything()
    {
        //Click on search button without entering any data
        homePage.clickOnSearchButton();

        //Verify alert message Capture text
        searchPage.textOfAlert();

        //Accept OK
        driver.switchTo().alert().accept();
    }

    @Test
    public void verifyAlertMessageAndAcceptAlertWhileClickOnVoteButton()
    {
        //Click on vote button
        homePage.clickOnVoteButton();

        //Capture text
        votePage.verifyVoteText();

        //Accept Ok
        driver.switchTo().alert().accept();
    }

    @Test
    public void verifyURLOfFacebookPageCloseThePopUpWindowVerifyNopCommerceTitleAndReturnToParentPage()
    {
        //Click on Facebook button
        facebookPage.clickOnFaceBookButton();

        //Click on Except cookies
        facebookPage.acceptCookies();

        //Verify Nop Commerce Title
        facebookPage.verifyNopCommerceTitle();

        //Verify URL
        facebookPage.verifyURL();
    }

    @Test
    public void verifyUserShouldCommentAndTitleOfCommentAndCommentMustBeAtLastOfTheList()
    {
        //Click on middle Details button on News header
        homePage.clcikOnDetailsNewsButton();

        //Verify title of the page
        newsPage.verifyTitleOfPage();

        //Verify comment is at bottom of all comments
        newsPage.checkLastCommentIsAtTheBottomOfTheListOrNot();

    }

    @Test
    public void verifyAllProductsHaveEuroSignOnceSelectEuroFromCurrencyDropBox()
    {
        //Select Euro from currency drop box
        homePage.selectEuroFromCurrencyDropBox();

        //Verify all products on home page contains Euro symbol in front of Price
        homePage.verifyAllProductHaveEuroSign();
    }

    @Test
    public void verifyUserFindAllSearchProduct()
    {
        //Type product name in search button
        homePage.entreProductNameInSearchBox();

        //Click on search button
        homePage.clickOnSearchButton();

        //Verify URL
        productPage.verifyProductURL();

        //Verify all product contains search content
        productPage.verifyProductNameHaveSearchNameContent();
    }

}
