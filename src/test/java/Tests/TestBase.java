package Tests;

import data.LoadProperties;
import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class TestBase {

    WebDriver driver;
    String browserChoice = LoadProperties.userData.getProperty("browser");

    FileInputStream fis;

    {
        try {
            fis = new FileInputStream("src/test/java/data/VOIS Test Data.xlsx");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    XSSFWorkbook wb;

    {
        try {
            wb = new XSSFWorkbook(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    XSSFSheet sheet = wb.getSheet("Sheet1");

    XSSFRow row = sheet.getRow(0);
    String url = row.getCell(0).getStringCellValue();


    @BeforeSuite()
    public void setUpEnvironment()
    {

        if(browserChoice.equals("chrome")) {
            driver = new ChromeDriver();
        }
        else if(browserChoice.equals("firefox")) {
            driver = new FirefoxDriver();
        }

        driver.navigate().to(url);
        driver.manage().window().maximize();

        String expectedResult1 = url;
        String actualResult1 = driver.getCurrentUrl();
        Assert.assertEquals(actualResult1,expectedResult1,"SETUP ENVIRONMENT ASSERTION 1");
    }

    @AfterSuite
    public void clearUpEnvironment()
    {
        driver.quit();
    }

}
