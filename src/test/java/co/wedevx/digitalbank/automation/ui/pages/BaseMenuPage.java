package co.wedevx.digitalbank.automation.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BaseMenuPage extends BasePage {
    public BaseMenuPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "checking-menu")
    protected WebElement checkingMenu;
    @FindBy(id = "view-checking-menu-item")
    protected WebElement viewCheckingMenuItem;

    @FindBy(id = "new-checking-menu-item")
    protected WebElement newCheckingMenuItem;

    @FindBy(id = "home-menu-item")
    protected WebElement homeButton;




    public void goToHomePage(){
        homeButton.click();

    }
}



