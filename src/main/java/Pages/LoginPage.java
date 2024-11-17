package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Constructor to initialize WebDriver and WebDriverWait
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Set a reasonable timeout
    }

    // Locators for email, password fields, and login button
    private By emailField = By.id("userEmail");
    private By passwordField = By.id("userPass");
    private By loginButton = By.xpath("//*[@id=\"root\"]/div/div/div/div[3]/div[2]/button");

    // Method to enter email
    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
        driver.findElement(emailField).sendKeys(email);
    }

    // Method to enter password
    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        driver.findElement(passwordField).sendKeys(password);
    }

    // Method to click the login button
    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        driver.findElement(loginButton).click();
    }

    // Method to check if a specific text is visible on the page
    public boolean isTextVisible(String expectedText) {
        try {
            // Use XPath to search for the expected text dynamically
            By textLocator = By.xpath("//*[contains(text(),'" + expectedText + "')]");
            
            // Wait for the text to be visible on the page
            wait.until(ExpectedConditions.visibilityOfElementLocated(textLocator));
            return driver.findElement(textLocator).isDisplayed();
        } catch (Exception e) {
            System.out.println("Text not visible or error occurred: " + e.getMessage());
            return false;
        }
    }

    // Method to check if the user is logged in
    public boolean isLoggedIn() {
        try {
            // Use XPath to locate an element that is visible only after login
            By loggedInIndicator = By.xpath("//*[contains(text(), 'DashBoard')]"); // Replace with the actual text or element
            wait.until(ExpectedConditions.visibilityOfElementLocated(loggedInIndicator));
            return driver.findElement(loggedInIndicator).isDisplayed();
        } catch (Exception e) {
            System.out.println("User is not logged in: " + e.getMessage());
            return false;
        }
    }

    // Method to log in to the application using username and password
    public void loginToApplication(String username, String password) {
        enterEmail(username);        // Enter the username
        enterPassword(password);     // Enter the password
        clickLogin();                // Click the login button
    }
}
