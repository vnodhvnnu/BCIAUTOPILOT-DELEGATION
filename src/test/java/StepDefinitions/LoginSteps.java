package StepDefinitions;

import Pages.LoginPage;
import com.qa.factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginSteps {

    private LoginPage loginPage;

    public LoginSteps() {
        this.loginPage = new LoginPage(DriverFactory.getDriver());
    }

    @Given("The user is on login page")
    public void the_user_is_on_login_page() {
        DriverFactory.getDriver().get("https://dev-fix.d27l7sadubzmz4.amplifyapp.com");
        System.out.println("Navigated to the login page.");
    }

    @When("The user enters a valid email {string} and valid password {string}")
    public void the_user_enters_a_valid_email_and_valid_password(String email, String password) {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
    }

    @When("The user enters a valid email {string} and invalid password {string}")
    public void the_user_enters_a_valid_email_and_invalid_password(String email, String password) {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
    }

    @When("The user enters an invalid email {string} and valid password {string}")
    public void the_user_enters_an_invalid_email_and_valid_password(String email, String password) {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
    }

    @When("The user leaves the email and password fields empty")
    public void the_user_leaves_the_email_and_password_fields_empty() {
        loginPage.enterEmail("");
        loginPage.enterPassword("");
    }

    @When("The user leaves the email field empty and enters a valid password {string}")
    public void the_user_leaves_the_email_field_empty_and_enters_a_valid_password(String password) {
        loginPage.enterEmail("");
        loginPage.enterPassword(password);
    }

    @When("The user enters a valid email {string} and leaves the password field empty")
    public void the_user_enters_a_valid_email_and_leaves_the_password_field_empty(String email) {
        loginPage.enterEmail(email);
        loginPage.enterPassword("");
    }

    @When("The user clicks on the login button")
    public void the_user_clicks_on_the_login_button() {
        loginPage.clickLogin();
    }

    @Then("The text {string} should be displayed on the dashboard indicating successful login")
    public void the_text_should_be_displayed_on_the_dashboard_indicating_successful_login(String expectedText) {
        Assert.assertTrue("Expected text not displayed on the dashboard!",
                loginPage.isTextVisible(expectedText));
    }

    @Then("The text {string} should not be displayed indicating unsuccessful login")
    public void the_text_should_not_be_displayed_indicating_unsuccessful_login(String unexpectedText) {
        Assert.assertFalse("Unexpected text was displayed!",
                loginPage.isTextVisible(unexpectedText));
    }
}
