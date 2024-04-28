# Title: End-to-End Testing with Selenium in Java Gradle


Introduction:
This documentation provides a guide for setting up and running end-to-end tests using Selenium WebDriver with Java and Gradle. The tests cover various scenarios of a registration form, including successful registration and validation failures for empty and invalid inputs.


## Setting up the Project in IntelliJ IDEA:
1. Install IntelliJ IDEA: Download and install IntelliJ IDEA from the official website if you haven't already.

2. Clone the Project from GitHub: Open IntelliJ IDEA and select "Check out from Version Control" -> "Git". Enter the repository URL and choose a directory to clone the project.

3. Import Gradle Project: Once the project is cloned, select "Import Project" and choose the directory where the project was cloned. Select "Gradle" as the project type and click "Next" until the project is imported.

4. Configure JDK: Ensure that a JDK is configured in IntelliJ IDEA. Go to "File" -> "Project Structure" -> "Project" and select the appropriate JDK version.

5. Install Dependencies: IntelliJ IDEA should automatically download and install the required dependencies specified in the build.gradle file.

6. Set up WebDriver Path: Open the build.gradle file and locate the configuration for the Chrome WebDriver. Ensure that the webdriver.chrome.driver property points to the correct path where the Chrome WebDriver executable is located on your system. If necessary, update the path to match your local environment.

7. Set up Test Configuration: Create a run configuration for Gradle tests by selecting "Edit Configurations" from the dropdown menu next to the Run/Debug buttons. Add a new Gradle configuration and specify the Gradle project path and tasks to run.


## Running the Tests:
Once the project is set up, you can run the tests using the following steps:

1. Run Individual Tests: Navigate to the test class containing the tests you want to run. Right-click on the test method and select "Run" to execute that specific test.
   
2. Run All Tests: To run all tests, navigate to the test class containing the test suite. Right-click on the class name and select "Run" to execute all tests within that class.

View Test Results: The test results will be displayed in the "Run" tool window at the bottom of the IntelliJ IDEA interface. You can view the status of each test (passed/failed) along with any error messages or stack traces.


## Test Scenarios:
The end-to-end tests cover the following scenarios:

1. Successful Registration: Verifies that the registration process completes successfully with valid input data.

2. Empty Email Validation Failure: Checks that an error is displayed when the email field is left empty.

3. Invalid Email Validation Failure: Ensures that entering an invalid email address triggers an error message.

4. Empty First Name Validation Failure: Validates that an error is shown when the first name field is empty.

5. Empty Last Name Validation Failure: Confirms that leaving the last name field blank results in a validation error.


## Conclusion:
By following this documentation, users can set up and run end-to-end tests for a registration form using Selenium WebDriver, Java, and Gradle in IntelliJ IDEA. The provided test scenarios cover various validation cases, ensuring the robustness and reliability of the application under test.


