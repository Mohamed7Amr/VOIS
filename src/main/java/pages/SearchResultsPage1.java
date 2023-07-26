package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchResultsPage1 {

    /*********************************************GLOBAL_VARIABLES************************************************/
    protected WebDriver driver;

    /*********************************************CONSTRUCTORS****************************************************/

    public SearchResultsPage1(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /*********************************************WEB_ELEMENTS******************************************************/

    /*Some notations regarding variables naming:
1) variables' suffix "Li" means it's an ordered-list-item element.
2) variables' suffix "Categ" means it's a category element.
3) variables' suffix "Chbox" means it's a checkbox element.
4) variables' suffix "Rdo" means it's a checkbox element
     */

    @FindBy(xpath = "//span[contains(text(),'Next')]")
    WebElement nextPageBtn;

    @FindBy(xpath = "//h3[@class='LC20lb MBeuO DKV0Md']")
    List<WebElement> searchResults;


    /*******************************************METHODS**********************************************************/

    public void jsClick(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click", element);
    }

    public void jsScroll(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()", element);
    }

    public void clickNextPage() throws InterruptedException {
        jsScroll(nextPageBtn);
        Thread.sleep(2000);
        nextPageBtn.click();
    }

    public int searchResultsSize()
    {
       return searchResults.size();
    }




}









