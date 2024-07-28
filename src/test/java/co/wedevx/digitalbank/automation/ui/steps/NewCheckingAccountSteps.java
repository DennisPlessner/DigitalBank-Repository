package co.wedevx.digitalbank.automation.ui.steps;

import co.wedevx.digitalbank.automation.ui.models.NewCheckingAccountInfo;
import co.wedevx.digitalbank.automation.ui.pages.LoginPage;
import co.wedevx.digitalbank.automation.ui.pages.NewCheckingPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;
import static co.wedevx.digitalbank.automation.ui.utils.Driver.getDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NewCheckingAccountSteps {

    LoginPage loginPage = new LoginPage(getDriver());
    NewCheckingPage newCheckingPage = new NewCheckingPage(getDriver());

    @Given("The user is logged in as {string}, {string}")
    public void theUserIsLoggedInAs(String username, String password) {

        loginPage.login(username, password);

    }


    @When("the user creates a new checking account with the following data")
    public void the_user_creates_a_new_checking_account_with_the_following_data(List<NewCheckingAccountInfo> newCheckingTestDataList) throws InterruptedException {

     newCheckingPage.createNewCheckingAccount(newCheckingTestDataList);

    }


    @Then("the user should see the green {string} message")
    public void theUserShouldSeeTheGreenMessage(String expectedConfirmationMessage) {

        assertEquals(expectedConfirmationMessage, newCheckingPage.getActualNewCheckingConfirmationMessage(), "Confirmation message mismatch");
        
    }

}
