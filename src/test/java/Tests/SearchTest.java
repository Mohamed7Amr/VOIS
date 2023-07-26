package Tests;


import data.LoadProperties;
import org.testng.Assert;
import org.testng.annotations.*;

import pages.HomePage;
import pages.SearchResultsPage1;


public class SearchTest extends TestBase{

    HomePage hp;
    SearchResultsPage1 srp;

    String searchInput = LoadProperties.userData.getProperty("input");


    @Test(description = "user google-search for Vodafone", enabled = true)//, dataProvider = "testData")
    public void googleSearch() throws InterruptedException
    {
    	hp = new HomePage(driver);
    	srp = new SearchResultsPage1(driver);
    	
        hp.changeLanguage();
        hp.search(searchInput);
        srp.clickNextPage();
        int firstPageCount = srp.searchResultsSize();
        System.out.println(firstPageCount);
        srp.clickNextPage();
        int secondPageCount = srp.searchResultsSize();
        System.out.println(secondPageCount);
        Assert.assertEquals(firstPageCount,secondPageCount);
    }







}
