package scripts;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.UnitedAirlinesPage;
import utilities.Waiter;

public class UnitedAirlinesTest extends Base {

    /*
    Test Case 1: Validate "Main menu" navigation items
    Given user is on "https://www.united.com/en/us"
    Then user should see “Main menu” navigation items
    |BOOK                	          	  |
    |MY TRIPS            	          	  |
    |TRAVEL INFO         	  |
    |MILEAGEPLUS® PROGRAM|
    |DEALS               	          	  |
    |HELP                	          	  |
     */
    @Test
    public void testMainMenuNavigationItems() {
        driver.get("https://www.united.com/en/us");
        String[] mainMenuNavigationItemsText = {"BOOK", "MY TRIPS", "TRAVEL INFO", "MILEAGEPLUS® PROGRAM", "DEALS", "HELP"};
        for (int i = 0; i < unitedAirlinesPage.mainMenuNavigationItems.size(); i++) {
            Assert.assertTrue(unitedAirlinesPage.mainMenuNavigationItems.get(i).isDisplayed());
            Assert.assertEquals(unitedAirlinesPage.mainMenuNavigationItemsText.get(i).getText(), mainMenuNavigationItemsText[i]);
        }
    }

    /*
    Test Case 2: Validate "Book travel menu" navigation items
    Given user is on "https://www.united.com/en/us"
    Then user should see "Book travel menu" navigation items
    |Book             |
    |Flight Status|
    |Check-in       |
    |My trips        |
     */
    @Test
    public void testBookTravelMenuNavigationItems() {
        driver.get("https://www.united.com/en/us");
        String[] bookTravelNavItems = {"Book", "Flight status", "Check-in", "My trips"};
        for (int i = 0; i < unitedAirlinesPage.bookTravelMenuNavigationItems.size(); i++) {
            Assert.assertTrue(unitedAirlinesPage.bookTravelMenuNavigationItems.get(i).isDisplayed());
            Assert.assertEquals(unitedAirlinesPage.bookTravelMenuNavigationItems.get(i).getText(), bookTravelNavItems[i]);
        }
    }

    /*
     Test Case 3: Validate "Round-trip" and "One-way" radio buttons
     Given user is on "https://www.united.com/en/us"
     Then validate "Roundtrip" radio button is displayed, is enabled and is selected
     And validate "One-way" radio button is displayed, is enabled but is not selected
     When user clicks on "One-way" radio button
     Then validate "One-way" radio button is selected while "Roundtrip" radio button is deselected
      */
    @Test
    public void testRoundTripAndOneWayRadioButt(){
        driver.get("https://www.united.com/en/us");
        for (int i = 0; i < unitedAirlinesPage.radioButtonsInput.size(); i++) {
            Assert.assertTrue(unitedAirlinesPage.radioButtonsLabel.get(i).isDisplayed());
            Assert.assertTrue(unitedAirlinesPage.radioButtonsInput.get(i).isEnabled());
        }
        Assert.assertTrue(unitedAirlinesPage.radioButtonsInput.get(0).isSelected());
        Assert.assertTrue(!unitedAirlinesPage.radioButtonsInput.get(1).isSelected());
        unitedAirlinesPage.radioButtonsInput.get(1).click();
        Assert.assertTrue(!unitedAirlinesPage.radioButtonsInput.get(0).isSelected() && unitedAirlinesPage.radioButtonsInput.get(1).isSelected());
}

    /*
       Test Case 4: Validate "Book with miles" and "Flexible dates" checkboxes
       Given user is on "https://www.united.com/en/us"
       Then validate "Book with miles" checkbox is displayed, is enabled but is not selected
       And validate "Flexible dates" checkbox is displayed, is enabled but is not selected
       When user clicks both checkboxes
       Then validate both checkboxes are selected
       When user clicks on both selected checkboxes again
       Then validate both checkboxes are deselected
        */
    @Test
    public void testBookWithMilesAndFlexDatesCheckBoxes(){
        driver.get("https://www.united.com/en/us");
        for (int i = 0; i < unitedAirlinesPage.checkBoxesInput.size(); i++) {
            Assert.assertTrue(unitedAirlinesPage.checkBoxesLabel.get(i).isDisplayed());
            Assert.assertTrue(unitedAirlinesPage.checkBoxesInput.get(i).isEnabled());
            Assert.assertTrue(!unitedAirlinesPage.checkBoxesInput.get(i).isSelected());
        }
        unitedAirlinesPage.checkBoxesInput.get(0).click();
        unitedAirlinesPage.checkBoxesInput.get(1).click();
        Assert.assertTrue(unitedAirlinesPage.getCheckBoxesInput.get(0).isSelected() &&unitedAirlinesPage.getCheckBoxesInput.get(1).isSelected());
        unitedAirlinesPage.checkBoxesInput.get(0).click();
        unitedAirlinesPage.checkBoxesInput.get(1).click();
        Assert.assertTrue(!(unitedAirlinesPage.getCheckBoxesInput.get(0).isSelected() && unitedAirlinesPage.getCheckBoxesInput.get(1).isSelected()));
    }

      /*
    Test Case 5: Validate One-way ticket search results "from Chicago, IL, US (ORD) to Miami, FL, US (MIA)”
    Given user is on "https://www.united.com/en/us"
    When user selects "One-way" ticket radio button
    And user enters "Chicago, IL, US (ORD)" to from input box
    And user enters "Miami, FL, US (MIA)" to to input box
    And user selects "Jan 30" to the dates input box
    And user selects "2 Adults" from travelers selector
    And user selects "Business or First" from cabin dropdown
    And user clicks on "Find Flights" button
    Then validate departure equals to "Depart: Chicago, IL, US to Miami, FL, US
     */

    @Test(priority = 5, description = "Test Case 5: Validate One-way ticket search results \"from Chicago, IL, US (ORD) to Miami, FL, US (MIA)\"")
    public void testOneWaySearchResult(){
        driver.get("https://www.united.com/en/us");

        unitedAirlinesPage.radioButtonsInput.get(1).click();
        unitedAirlinesPage.fromInputBox.clear();
        unitedAirlinesPage.fromInputBox.sendKeys("Chicago, IL, US (ORD)");
        unitedAirlinesPage.toInputBox.sendKeys("Miami, FL, US (MIA)");
        unitedAirlinesPage.departDateInputBox.clear();
        unitedAirlinesPage.departDateInputBox.sendKeys("Jan 30");
        unitedAirlinesPage.departDateInputBox.click();
        unitedAirlinesPage.passengerSelectorButton.click();
        unitedAirlinesPage.addOneMoreAdultButton.click();
        unitedAirlinesPage.cabinTypeDropdown.click();
        unitedAirlinesPage.clickOnCabinTypeOption("Business or First");
        unitedAirlinesPage.findFlightsButton.click();

        Assert.assertEquals(flightsPage.flightHeading.getText(), "Depart: Chicago, IL, US to Miami, FL, US");
    }






}










