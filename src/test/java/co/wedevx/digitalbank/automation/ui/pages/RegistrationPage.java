package co.wedevx.digitalbank.automation.ui.pages;


import co.wedevx.digitalbank.automation.ui.utils.MockData;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.Select;


import java.util.List;
import java.util.Map;


public class RegistrationPage extends BasePage {



    public RegistrationPage(WebDriver driver) {
        super(driver);

    }

    MockData mockData = new MockData();

    @FindBy(id = "title")
    private WebElement titleDropdown;

    @FindBy(id = "firstName")
    private WebElement firstNameField;

    @FindBy(id = "lastName")
    private WebElement lastNameField;

    @FindBy(xpath = "//input[@name='gender' and @value='M']")
    private WebElement maleGenderRadio;

    @FindBy(xpath = "//input[@name='gender' and @value='F']")
    private WebElement femaleGenderRadio;

    @FindBy(id = "dob")
    private WebElement dateOfBirthField;

    @FindBy(id = "ssn")
    private WebElement ssnField;

    @FindBy(id = "emailAddress")
    private WebElement emailField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "confirmPassword")
    private WebElement confirmPasswordField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement nextButton;

    @FindBy(id = "address")
    private WebElement addressField;

    @FindBy(id = "locality")
    private WebElement localityField;

    @FindBy(id = "region")
    private WebElement regionField;

    @FindBy(id = "postalCode")
    private WebElement postalCodeField;

    @FindBy(id = "country")
    private WebElement countryField;

    @FindBy(id = "homePhone")
    private WebElement homePhoneField;

    @FindBy(id = "mobilePhone")
    private WebElement mobilePhoneField;

    @FindBy(id = "workPhone")
    private WebElement workPhoneField;

    @FindBy(id = "agree-terms")
    private WebElement agreeTermsCheckbox;

    @FindBy(xpath = "//span[@class = 'badge badge-pill badge-success']")
    private WebElement messageLabelFirstPart;
    @FindBy(xpath = "//span[starts-with(text(), 'Registration')]")
    private WebElement messageLabelSecondPart;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement registrationButton;

    public void fillOutRegistrationForm(List<Map<String, String>> registrationTestDataListOfMap) throws InterruptedException {

        //JavascriptExecutor js = (JavascriptExecutor) driver;

        Map<String, String> firstRow = registrationTestDataListOfMap.get(0);
        Select titleDropdownSelect = new Select(titleDropdown);

        if (firstRow.get("title") != null) {
            titleDropdownSelect.selectByVisibleText(firstRow.get("title"));
        }
        if (firstRow.get("firstName") != null) {
            firstNameField.sendKeys(firstRow.get("firstName"));

        }
        if (firstRow.get("lastName") != null) {
            lastNameField.sendKeys(firstRow.get("lastName"));

        }
        if (firstRow.get("gender") != null) {
            if (firstRow.get("gender").equalsIgnoreCase("M")) {
                maleGenderRadio.click();
            } else if (firstRow.get("gender").equalsIgnoreCase("F")) {
                femaleGenderRadio.click();
            } else {
                System.out.println("Wrong gender");
            }
        }

            if (firstRow.get("dateOfBirth") != null) {

                dateOfBirthField.sendKeys(firstRow.get("dateOfBirth"));
            }


        if (firstRow.get("ssn") != null) {
            if (firstRow.get("ssn").equalsIgnoreCase("random")) {
                String mockSnn = mockData.generateSnn();
                ssnField.sendKeys(mockSnn);
            }
        }

        if (firstRow.get("email") != null) {
            if (firstRow.get("email").equalsIgnoreCase("random")) {

                Map<String, String> mockNameAndEmail = mockData.generateRandomNameAndEmail();
                emailField.sendKeys(mockNameAndEmail.get("email"));
            }
        }
//        //scrolling down
//        js.executeScript("arguments[0].scrollIntoView(true);", nextButton);

        if (firstRow.get("password") != null) {

            passwordField.sendKeys(firstRow.get("password"));
        }

        if (firstRow.get("confirmPassword") != null) {

            confirmPasswordField.sendKeys(firstRow.get("password"));
        }

        nextButton.click();

        if (addressField.isDisplayed()) {

            if (firstRow.get("address") != null) {

                addressField.sendKeys(firstRow.get("address"));
            }

            if (firstRow.get("locality") != null) {

                localityField.sendKeys(firstRow.get("locality"));
            }
            if (firstRow.get("region") != null) {

                regionField.sendKeys(firstRow.get("region"));
            }
            if (firstRow.get("postalCode") != null) {

                postalCodeField.sendKeys(firstRow.get("postalCode"));
            }
            if (firstRow.get("country") != null) {

                countryField.sendKeys(firstRow.get("country"));
            }
            if (firstRow.get("homePhone") != null) {

                homePhoneField.sendKeys(firstRow.get("homePhone"));
            }
            if (firstRow.get("mobilePhone") != null) {

                mobilePhoneField.sendKeys(firstRow.get("mobilePhone"));
            }

            if (firstRow.get("workPhone") != null) {

                workPhoneField.sendKeys(firstRow.get("workPhone"));
            }


//        //scrolling down
//        js.executeScript("arguments[0].scrollIntoView(true);", registrationButton);

            if (firstRow.get("termsCheckMark") != null) {
                if (firstRow.get("termsCheckMark").equalsIgnoreCase("true")) {
                    agreeTermsCheckbox.click();
                }
            }

            registrationButton.click();

        }
    }
        public String getMessage () {

            return messageLabelFirstPart.getText() + " " + messageLabelSecondPart.getText();

        }

        public String getRequiredFieldErrorMessage (String fieldWithError){

            switch (fieldWithError.toLowerCase()) {
                case "title":
                    return titleDropdown.getAttribute("validationMessage");
                case "firstname":
                    return firstNameField.getAttribute("validationMessage");
            }
            return "Validating the error message is failed";

        }

    }
