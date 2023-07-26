package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    /*********************************************CONSTRUCTORS****************************************************/

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    /*********************************************WEB_ELEMENTS******************************************************/

    /*Some notations regarding variables naming:
1) variables' suffix "Li" means it's an ordered-list-item element.
2) variables' suffix "Categ" means it's a category element.
3) variables' suffix "Chbox" means it's a checkbox element.
4) variables' suffix "Rdo" means it's a checkbox element
     */

    @FindBy(id = "SIvCob")
    WebElement localizationBtn;

    @FindBy(xpath = "//a[@dir='ltr'][contains(text(),'English')]")
    WebElement englishLangLink;

    @FindBy(id = "APjFqb")
    WebElement searchTxt;



    /*******************************************METHODS**********************************************************/


    public void changeLanguage()
    {
        if (localizationBtn.getText().contains("English"))
        {
            englishLangLink.click();
        }
        

    }

    public void search(String searchInput)
    {
        searchTxt.sendKeys(searchInput);
        searchTxt.submit();
    }

}