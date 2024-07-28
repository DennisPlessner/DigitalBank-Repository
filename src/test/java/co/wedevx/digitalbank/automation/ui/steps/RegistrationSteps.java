package co.wedevx.digitalbank.automation.ui.steps;

import co.wedevx.MockData;
import co.wedevx.digitalbank.automation.ui.pages.RegistrationPage;
import co.wedevx.digitalbank.automation.ui.utils.ConfigReader;
import co.wedevx.digitalbank.automation.ui.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import java.util.List;
import java.util.Map;

import static co.wedevx.digitalbank.automation.ui.utils.Driver.getDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationSteps {

    RegistrationPage registrationPage = new RegistrationPage(getDriver());

    MockData mockData = new MockData();

    @Given("the user is on the sign up page")
    public void the_user_is_on_the_sign_up_page() {

        getDriver().get(ConfigReader.getPropertiesValue("digitalBank.registrationPageUrl"));

        assertEquals("Digital Bank", getDriver().getTitle(), "Registration page Title mismatch");

    }

    @When("the user creates account with following fields with mocked email and ssn")
    public void the_user_creates_account_with_following_fields_with_mocked_email_and_ssn(List<Map<String, String>> registrationTestDataListOfMap) throws InterruptedException {

        registrationPage.fillOutRegistrationForm(registrationTestDataListOfMap);


    }

    @Then("the user should see the success message {string}")
    public void the_user_should_see_the_success_message(String expectedSuccessMessage) {

        assertEquals(expectedSuccessMessage, registrationPage.getMessage(), "Success message mismatch");
        System.out.println("Actual success message: " + registrationPage.getMessage());

    }

    @Then("the user should see the {string} required field error message {string}")
    public void the_user_should_see_the_required_field_error_message(String fieldWithError, String expectedErrorMessage) {

        assertEquals(expectedErrorMessage, registrationPage.getRequiredFieldErrorMessage(fieldWithError), "Error message mismatch");
        System.out.println("Actual error message: " + registrationPage.getRequiredFieldErrorMessage(fieldWithError));
    }
}

