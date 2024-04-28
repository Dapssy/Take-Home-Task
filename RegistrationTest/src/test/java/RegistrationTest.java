import Assignment.Test.RegistrationPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class RegistrationTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private RegistrationPage registrationPage;

    /*
    *setup and assign values before each test
    */
    @BeforeEach
    void setup(){
        //You will need to configure a path to your Chrome driver to be able to execute the tests successfully
        //The path here is a path on my own PC, change it to the Chrome driver path on your PC
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kasutaja\\Documents\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--remote-allow-origins=*");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        registrationPage = new RegistrationPage(driver, wait);
    }

    /*
    *
    * Test a successful registration
    * @return void
    * assert that there is a successful registration message displayed
    */
    @Test
    void testSuccessfulRegistration() {
        registrationPage.navigateToRegistrationPage();
        String username = generateRandomString();
        String email = username+"@"+"gmail.com";
        String password = "testtest001";
        String firstName = "Angelina";
        String lastName = "Jolie";
        registrationPage.register(email, password, firstName, lastName);
        WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("email-registration-success")));
        Assertions.assertTrue(confirmationMessage.isDisplayed());
    }

    /*
    *
    * Test a registration with empty email address
    * @return void
    * assert that there is an error thrown
    */
    @Test
    void testEmptyEmailValidationFailure() {
        String email = "";
        String password = "testtest001";
        String firstName = "Angelina";
        String lastName = "Jolie";
        registrationPage.navigateToRegistrationPage();
        registrationPage.register(email, password, firstName, lastName);
        WebElement emailInput = driver.findElement(By.xpath("//input[@name='email']"));
        String error  = emailInput.getCssValue("border-color");
        Assertions.assertEquals(error, "rgb(236, 35, 89)");
    }

    /*
    *
    * Test a registration with an invalid email address
    * @return void
    * assert that there is an error thrown
    */
    @Test
    void testInvalidEmailValidationFailure(){
        String email = "juju";
        registrationPage.navigateToRegistrationPage();
        WebElement jobSeekerButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='jsx-579114886 registration-flow']//button[1]")));
        jobSeekerButton.click();
        WebElement registerWithEmailButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Loo konto e-mailiga']")));
        registerWithEmailButton.click();
        WebElement emailInput = driver.findElement(By.xpath("//input[@name='email']"));
        emailInput.sendKeys(email);
        String error  = emailInput.getCssValue("border-color");
        Assertions.assertTrue(error.contains("252"), "String contains '252'");
    }

    /*
    *
    * Test a registration with empty first name
    * @return void
    * assert that there is an error thrown
    */
    @Test
    void testEmptyFirstNameValidationFailure(){
        String email = "juju@gmail.com";
        String password = "testtest001";
        String firstName = "";
        String lastName = "Jolie";
        registrationPage.navigateToRegistrationPage();
        registrationPage.register(email, password, firstName, lastName);
        WebElement firstNameError = driver.findElement(By.xpath("//input[@name='firstName']"));
        String error  = firstNameError.getCssValue("border-color");
        Assertions.assertEquals(error, "rgb(236, 35, 89)");
    }

    /*
    *
    * Test a registration with empty last name
    * @return void
    * assert that there is an error thrown
    */
    @Test
    void testEmptyLastNameValidationFailure(){
        String email = "juju@gmail.com";
        String password = "testtest001";
        String firstName = "Angelina";
        String lastName = "";
        registrationPage.navigateToRegistrationPage();
        registrationPage.register(email, password, firstName, lastName);
        WebElement lastNameError = driver.findElement(By.xpath("//input[@name='lastName']"));
        String error  = lastNameError.getCssValue("border-color");
        Assertions.assertEquals(error, "rgb(236, 35, 89)");
    }

   /*
   * quit the driver after every test
   * @return void
   */
   @AfterEach
   void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }


    /*
    *
    * A helper method to generate random alphanumeric strings
    * to create random email addresses each time testing is done
    * @return String random string
    */
    String generateRandomString() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 8; i++) {
            int index = random.nextInt(chars.length());
            sb.append(chars.charAt(index));
        }
        return sb.toString();
    }

}
