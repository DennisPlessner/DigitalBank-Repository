package co.wedevx.digitalbank.automation.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DepositPage extends BaseMenuPage {

    public DepositPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@id = 'deposit-menu-item']")
    protected WebElement depositButton;


    @FindBy(id = "selectedAccount")
    protected WebElement accountDropDownMenu;

    @FindBy(id = "amount")
    protected WebElement amountTxtBox;

    @FindBy(xpath = "//button[@class = 'btn btn-primary btn-sm']")
    protected WebElement depositSubmitButton;

    @FindBy(id = "page-title")
    private WebElement viewCheckingAccountsTitle;


    public void deposit(String amount) throws InterruptedException {



        Thread.sleep(2000);
        depositButton.click();
        Thread.sleep(2000);


        Select accountDropDownSelect = new Select(accountDropDownMenu);
        accountDropDownSelect.selectByIndex(1);
        Thread.sleep(2000);

        amountTxtBox.sendKeys(amount);
        Thread.sleep(2000);

        depositSubmitButton.click();
        Thread.sleep(2000);
    }

    public String getViewCheckingAccountsTile() {
        return viewCheckingAccountsTitle.getText();

    }

}


