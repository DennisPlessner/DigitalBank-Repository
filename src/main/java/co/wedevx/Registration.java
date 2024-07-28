package co.wedevx;


import org.openqa.selenium.*;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Map;

public class Registration {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new SafariDriver();

        MockData mockData = new MockData();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.get("https://dbank-qa.wedevx.co/bank/signup");
        Thread.sleep(500);

        driver.manage().window().fullscreen();

        WebElement titleDropdown =   driver.findElement(By.id("title"));
        Select titleDropdownSelect = new Select(titleDropdown);
        titleDropdownSelect.selectByVisibleText("Mr.");
        Thread.sleep(500);


        WebElement firstNameField =   driver.findElement(By.id("firstName"));
        firstNameField.sendKeys("Jim");
        Thread.sleep(500);


        WebElement lastNameField = driver.findElement(By.id("lastName"));
        lastNameField.sendKeys("Halpert");
        Thread.sleep(500);


        WebElement maleGenderRadio =driver.findElement(By.xpath("//input[@name='gender' and @value='M']"));
        maleGenderRadio.click();
        Thread.sleep(500);


        WebElement femaleGenderRadio = driver.findElement(By.xpath("//input[@name='gender' and @value='F']"));

        WebElement dateOfBirthField = driver.findElement(By.id("dob"));
        dateOfBirthField.sendKeys("01/01/1990");
        Thread.sleep(500);


        WebElement ssnField = driver.findElement(By.id("ssn"));
        String mockSnn = mockData.generateSnn();
        ssnField.sendKeys(mockSnn);
        Thread.sleep(500);


        WebElement emailField = driver.findElement(By.id("emailAddress"));
        Map<String, String> mockNameAndEmail = mockData.generateRandomNameAndEmail();
        emailField.sendKeys(mockNameAndEmail.get("email"));
        Thread.sleep(500);


        WebElement nextButton = driver.findElement(By.xpath("//button[@type='submit']"));
        //scrolling down to the 'Next' button
        js.executeScript("arguments[0].scrollIntoView(true);", nextButton);
        Thread.sleep(500);


        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("Jim1990!");
        Thread.sleep(500);

        WebElement confirmPasswordField = driver.findElement(By.id("confirmPassword"));
        confirmPasswordField.sendKeys("Jim1990!");
        Thread.sleep(500);

        WebDriverWait wait = new WebDriverWait(driver, 3);

        wait.until(ExpectedConditions.elementToBeClickable(nextButton));

        nextButton.click();
        Thread.sleep(1000);

        driver.manage().window().fullscreen();
        Thread.sleep(500);

        WebElement addressField = driver.findElement(By.id("address"));
        addressField.sendKeys("234 W Ohio St");
        Thread.sleep(500);


        WebElement localityField = driver.findElement(By.id("locality"));
        localityField.sendKeys("Scranton");
        Thread.sleep(500);


        WebElement regionField = driver.findElement(By.id("region"));
        regionField.sendKeys("PA");
        Thread.sleep(500);


        WebElement postalCodeField = driver.findElement(By.id("postalCode"));
        postalCodeField.sendKeys("18509");
        Thread.sleep(500);


        WebElement countryField = driver.findElement(By.id("country"));
        countryField.sendKeys("USA");
        Thread.sleep(500);


        WebElement homePhoneField = driver.findElement(By.id("homePhone"));
        homePhoneField.sendKeys("(645)747-4576");
        Thread.sleep(500);


        WebElement mobilePhoneField = driver.findElement(By.id("mobilePhone"));
        mobilePhoneField.sendKeys("(736)746-9124");
        Thread.sleep(500);


        WebElement workPhoneField = driver.findElement(By.id("workPhone"));
        workPhoneField.sendKeys("(943)645-9283");
        Thread.sleep(500);

        //scrolling down to the 'Registration' button
        WebElement registrationButton = driver.findElement(By.xpath("//button[@type='submit']"));
        js.executeScript("arguments[0].scrollIntoView(true);", registrationButton);
        Thread.sleep(500);


        WebElement agreeTermsCheckbox = driver.findElement(By.id("agree-terms"));
        agreeTermsCheckbox.click();
        Thread.sleep(500);


        registrationButton.click();
        Thread.sleep(500);

        WebElement messageLabelFirstPart = driver.findElement(By.xpath("//span[@class = 'badge badge-pill badge-success']"));
        WebElement messageLabelSecondPart = driver.findElement(By.xpath("//span[starts-with(text(), 'Registration')]"));
        System.out.println("Message: " + messageLabelFirstPart.getText() + " " + messageLabelSecondPart.getText());
        Thread.sleep(2000);

        driver.quit();

    }
}
