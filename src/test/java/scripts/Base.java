package scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import pages.FlightsPage;
import pages.UnitedAirlinesPage;
import utilities.Driver;

public class Base {

    WebDriver driver;
    SoftAssert softAssert;
    UnitedAirlinesPage unitedAirlinesPage;
    FlightsPage flightsPage;

    @BeforeMethod
    public void setup(){
        driver = Driver.getDriver();
        softAssert = new SoftAssert();
        unitedAirlinesPage = new UnitedAirlinesPage(driver);
        flightsPage = new FlightsPage();
    }

    @AfterMethod
    public void tearDown(){
        //TODO if there is a failure, take screenshot and attach it to the report
        softAssert.assertAll();
        Driver.quitDriver();
    }







}

