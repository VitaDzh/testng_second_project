package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class UnitedAirlinesPage {
    public UnitedAirlinesPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "div[class*='globalBottomNav--2aHvD']>a")
    public List<WebElement> mainMenuNavigationItems;

    @FindBy(css = "div[class*='globalBottomNav--2aHvD']>a>span")
    public List<WebElement> mainMenuNavigationItemsText;

    @FindBy(css = "ul[class$='__travelNav--3RNBj'] h2") // ul[class$='__travelNav--3RNBj']/li- doesn't work;
    public List<WebElement> bookTravelMenuNavigationItems;

    @FindBy(css = "div[class$='radioContainer--3WXQM'] label")
    public List<WebElement> radioButtonsLabel;

    @FindBy(css = "div[class$='radioContainer--3WXQM'] input")
    public List<WebElement> radioButtonsInput;

    @FindBy(css = "div[class$='__formHeader--2Hpvk']>div")
    public List<WebElement> checkBoxesInput;

    @FindBy(css = "div[class$='__formHeader--2Hpvk']>div>input")
    public List<WebElement> getCheckBoxesInput;

    @FindBy(css = "div[class$='__formHeader--2Hpvk']>div>label")
    public List<WebElement> checkBoxesLabel;

    @FindBy(id = "bookFlightOriginInput")
    public WebElement fromInputBox;

    @FindBy(id = "bookFlightDestinationInput")
    public WebElement toInputBox;

    @FindBy(id = "DepartDate")
    public WebElement departDateInputBox;

    @FindBy(css = "#passengerSelector>button")
    public WebElement passengerSelectorButton;

    @FindBy(css = "button[aria-label='Substract one Adult']")
    public WebElement addOneMoreAdultButton;

    @FindBy(id = "cabinType")
    public WebElement cabinTypeDropdown;

    @FindBy(css = "li[id^='cabinType_item-']")
    public List<WebElement> cabinTypeOptions;

    public void clickOnCabinTypeOption(String optionText){
        for(WebElement element : cabinTypeOptions){
            if(element.getText().equals(optionText)){
                element.click();
                break;
            }
        }
    }

    @FindBy(css = "button[class*='bookFlightForm__findFlightBtn']")
    public WebElement findFlightsButton;

}

















