package TestRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features/CreateDelegation.feature", // Path to your CreateDelegation feature files
    glue = {"StepDefinitions", "AppHooks"}, // Package name where your step definitions are located
    plugin = {
        "pretty", // Prints Gherkin steps in the console
        "html:target/cucumber-reports/CreateDelegationindex.html", // Generate HTML report in a separate folder for Create Delegation
        "json:target/cucumber-reports/CreateDelegationreport.json"  // Generate JSON report in the separate folder
    },
    monochrome = true // Better console output readability
)
public class MyTestRunner {
    // This class will run the Cucumber tests as per the provided options
}
