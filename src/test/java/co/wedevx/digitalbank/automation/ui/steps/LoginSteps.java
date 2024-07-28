package co.wedevx.digitalbank.automation.ui.steps;

import co.wedevx.digitalbank.automation.ui.pages.LoginPage;
import co.wedevx.digitalbank.automation.ui.utils.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static co.wedevx.digitalbank.automation.ui.utils.Driver.getDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


public class LoginSteps {


//    WebDriver driver = new SafariDriver();

    LoginPage loginPage = new LoginPage(getDriver());

    @Given("The user on Digital Bank login page")
    public void theUserOnDigitalBankLoginPage() {
        getDriver().get(ConfigReader.getPropertiesValue("digitalBank.loginPageUrl"));
        assertEquals("Digital Bank", getDriver().getTitle(), "Login page title mismatch");
    }

    @When("the user is logged in as {string} {string}")
    public void the_user_is_logged_in_as(String username, String password)  {

       loginPage.login(username, password);

    }


    @Then("the user should see {string}")
    public void theUserShouldSee(String arg0) {
    }


}
