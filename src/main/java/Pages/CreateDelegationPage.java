package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CreateDelegationPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private LoginPage loginPage;

    // Constructor to initialize WebDriver and WebDriverWait
    public CreateDelegationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Set a reasonable timeout
    }

    // Locators for elements on the Create Delegation page
    private By createTasksDropdown = By.xpath("//*[@id=\"root\"]/div/div/div/div[1]/div[2]/div/div/div[4]/div[1]/div/p");
    private By createDelegationOption = By.xpath("//*[@id=\"root\"]/div/div/div/div[1]/div[2]/div/div/div[4]/div[2]/div[2]/p");
    private By createDelegationPageHeader = By.xpath("//*[contains(text(), 'Create Task')]");
    private By titleTextbox = By.xpath("//*[@id='title']");
    private By assignTextbox = By.xpath("//*[@id=\"viewName\"]");
    private By suggestionList = By.xpath("//div[contains(@class, 'searchDropdown')]");
    private By completionDateField = By.xpath("//*[@id='completionDate']");
    private By saveButton = By.xpath("//*[@id='root']/div/div/div/div[2]/div/div/div/div/div[2]/div[2]/button");
    
    public void loginToApplication(String username, String password) {
        loginPage.enterEmail(username);    // Enter email/username
        loginPage.enterPassword(password); // Enter password
        loginPage.clickLogin();            // Click login button
    }

    // Methods for interactions on the page
    public void clickCreateTasksDropdown() {
        wait.until(ExpectedConditions.elementToBeClickable(createTasksDropdown));
        driver.findElement(createTasksDropdown).click();
    }

    public void clickCreateDelegation() {
        wait.until(ExpectedConditions.elementToBeClickable(createDelegationOption));
        driver.findElement(createDelegationOption).click();
    }

    public boolean isOnCreateDelegationPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(createDelegationPageHeader));
        return driver.findElement(createDelegationPageHeader).isDisplayed();
    }

    public void enterTitle(String title) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(titleTextbox));
        driver.findElement(titleTextbox).clear();
        driver.findElement(titleTextbox).sendKeys(title);
    }

    public void enterAssignName(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(assignTextbox));
        WebElement element = driver.findElement(assignTextbox);
        element.clear();
        element.sendKeys(name);
        wait.until(ExpectedConditions.visibilityOfElementLocated(suggestionList));
    }

   
    public boolean hasSuggestions() {
        try {
            // Use a short timeout to check for the suggestion list
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(3));
            shortWait.until(ExpectedConditions.visibilityOfElementLocated(suggestionList));
            System.out.println("Suggestions are visible.");
            return driver.findElement(suggestionList).isDisplayed();
        } catch (Exception e) {
            System.out.println("No suggestions found: " + e.getMessage());
            return false;
        }
    }



    public void selectSuggestion(String name) {
        By suggestion = By.xpath("//div[contains(@class, 'searchDropdown')]//div[1]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(suggestion));
        driver.findElement(suggestion).click();
    }

    public void selectCompletionDate(String date) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(completionDateField));
        driver.findElement(completionDateField).clear();
        driver.findElement(completionDateField).sendKeys(date);
    }

    public void clickSaveButton() {
        wait.until(ExpectedConditions.elementToBeClickable(saveButton));
        driver.findElement(saveButton).click();
    }

}