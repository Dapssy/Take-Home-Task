package Assignment.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    /*
    *@constructor
    */
    public RegistrationPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    /*
    * navigate to the website being tested
    * @return void
    */
    public void navigateToRegistrationPage() {
        driver.get("https://test.cv.ee/et");

        WebElement loginRegisterButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Logi sisse / registreeri']")));
        loginRegisterButton.click();
        WebElement registrationTab = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Registreerimine']")));
        registrationTab.click();
    }

    /*
    * handle both successful and failed registration
    * @param String email
    * @param String password
    * @param String firstName
    * @Param String lastName
    * @return void
    */
    public void register(String email, String password, String firstName, String lastName){
        WebElement jobSeekerButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='jsx-579114886 registration-flow']//button[1]")));
        jobSeekerButton.click();
        WebElement registerWithEmailButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Loo konto e-mailiga']")));
        registerWithEmailButton.click();

        // Add code to fill registration form with valid data
        WebElement emailInput = driver.findElement(By.xpath("//input[@name='email']"));
        emailInput.sendKeys(email);

        WebElement passwordInput = driver.findElement(By.xpath("//input[@name='password']"));
        passwordInput.sendKeys(password);

        WebElement firstNameInput = driver.findElement(By.xpath("//input[@name='firstName']"));
        firstNameInput.sendKeys(firstName);

        WebElement surnameInput = driver.findElement(By.xpath("//input[@name='lastName']"));
        surnameInput.sendKeys(lastName);

        WebElement newsLetter = driver.findElement(By.xpath("//body/div[@class='modal-root modal-root--visible']/div[@class='modal-wrapper']/div[@class='jsx-1457385152 modal']/div[@class='jsx-1096026829 authentication']/form[@class='jsx-1485111105 email-registration-form']/div[@class='jsx-1485111105 email-registration-form__content']/div[1]/label[1]/span[1]"));
        newsLetter.click();

        WebElement terms = driver.findElement(By.xpath("//body/div[@class='modal-root modal-root--visible']/div[@class='modal-wrapper']/div[@class='jsx-1457385152 modal']/div[@class='jsx-1096026829 authentication']/form[@class='jsx-1485111105 email-registration-form']/div[@class='jsx-1485111105 email-registration-form__content']/div[2]/label[1]/span[1]"));
        terms.click();

        WebElement shareInfo = driver.findElement(By.cssSelector("body > div:nth-child(24) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > form:nth-child(1) > div:nth-child(1) > div:nth-child(9) > label:nth-child(1) > span:nth-child(2)"));
        shareInfo.click();

        // Submit the registration form
        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
        submitButton.click();
    }

}
