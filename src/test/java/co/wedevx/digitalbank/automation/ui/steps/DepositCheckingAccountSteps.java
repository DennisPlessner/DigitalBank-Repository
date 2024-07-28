package co.wedevx.digitalbank.automation.ui.steps;

import co.wedevx.digitalbank.automation.ui.models.NewCheckingAccountInfo;
import co.wedevx.digitalbank.automation.ui.pages.DepositPage;
import co.wedevx.digitalbank.automation.ui.pages.LoginPage;
import co.wedevx.digitalbank.automation.ui.pages.NewCheckingPage;
import co.wedevx.digitalbank.automation.ui.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static co.wedevx.digitalbank.automation.ui.utils.Driver.getDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class DepositCheckingAccountSteps {

    LoginPage loginPage = new LoginPage(getDriver());
    NewCheckingPage newCheckingPage = new NewCheckingPage(getDriver());
    DepositPage depositPage = new DepositPage(getDriver());


    @Given("the user loges in as {string} {string}")
    public void theUserLogesInAs(String username, String password) {
        loginPage.login(username, password);
    }

    @And("the user opens a new checking account with the following data")
    public void theUserOpensANewCheckingAccountWithTheFollowingData(List<NewCheckingAccountInfo> newCheckingTestDataList) throws InterruptedException {

        newCheckingPage.createNewCheckingAccount(newCheckingTestDataList);
    }

    @Given("User is on View Checking Accounts web page")
    public void user_is_on_ViewCheckingAccounts_web_page() {

    assertEquals("View Checking Accounts", getDriver().getTitle(), "Web page mismatch");

    }

    @When("the user deposit newly created Standard Checking account with amount of {string}")
    public void theUserDepositNewlyCreatedStandardCheckingAccountWithAmountOf(String amount) throws InterruptedException {

        depositPage.deposit(amount);



    }


    @Then("User should see the {string}")
    public void userShouldSeeThe(String expectedPageTitle) {
        assertEquals(expectedPageTitle, depositPage.getViewCheckingAccountsTile(), "Web page mismatch");
    }
}


