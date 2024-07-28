package co.wedevx.digitalbank.automation.ui.pages;

import co.wedevx.digitalbank.automation.ui.models.NewCheckingAccountInfo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import java.util.NoSuchElementException;

public class NewCheckingPage extends BaseMenuPage {

    public NewCheckingPage(WebDriver driver) {

       super(driver);
    }


    @FindBy(id = "Standard Checking")
    private WebElement standardAccountTypeRadioButton;
    @FindBy(id = "Interest Checking")
    private WebElement interestAccountTypeRadioButton;
    @FindBy(id = "Individual")
    private WebElement individualOwnershipTypeRadioButton;
    @FindBy(id = "Joint")
    private WebElement jointOwnershipTypeRadioButton;
    @FindBy(id = "name")
    private WebElement accountNameTxt;
    @FindBy(id = "openingBalance")
    private WebElement openingBalanceTxtBox;
    @FindBy(id = "newCheckingSubmit")
    private WebElement submitButton;

    //should be on the separate page class

    @FindBy(xpath = "//span[contains(text(), 'Confirmation')]")
    private WebElement newCheckingConfirmationMessage;

    public void createNewCheckingAccount(List<NewCheckingAccountInfo> newCheckingTestDataList) throws InterruptedException {

        NewCheckingAccountInfo testDataForOneChecking = newCheckingTestDataList.get(0);

        checkingMenu.click();
        newCheckingMenuItem.click();

        if (testDataForOneChecking.getCheckingAccountType().equalsIgnoreCase("Standard Checking")) {
            standardAccountTypeRadioButton.click();

        } else if (testDataForOneChecking.getCheckingAccountType().equalsIgnoreCase("Interest Checking")) {
            interestAccountTypeRadioButton.click();

        } else {
            throw new NoSuchElementException("Unsupported checking account option provided. Available only Standard checking  and Individual checking");
        }


        if (testDataForOneChecking.getAccountOwnership().equalsIgnoreCase("Individual")) {
            individualOwnershipTypeRadioButton.click();
        } else if (testDataForOneChecking.getAccountOwnership().equalsIgnoreCase("Joint")) {
            jointOwnershipTypeRadioButton.click();

        } else {
            throw new NoSuchElementException("Unsupported  account type option provided. Available only Individual  and Joint types");

        }

        accountNameTxt.sendKeys(testDataForOneChecking.getAccountName());
        openingBalanceTxtBox.sendKeys(String.valueOf(testDataForOneChecking.getInitialDepositAmount()));
        submitButton.click();
        Thread.sleep(1000);

    }

        //should be in the separate page class
        public String getActualNewCheckingConfirmationMessage() {

            return newCheckingConfirmationMessage.getText();
        }
    }

