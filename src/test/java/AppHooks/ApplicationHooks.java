package AppHooks;

import com.qa.factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ApplicationHooks {

    private DriverFactory driverFactory;

    @Before(order = 0)
    public void setUp() {
        driverFactory = new DriverFactory();
        driverFactory.initDriver("chrome"); // Initialize the WebDriver instance
        DriverFactory.getDriver().get("https://dev-fix.d27l7sadubzmz4.amplifyapp.com"); // Navigate to the login page
    }

    @After(order = 1)
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            // Attach screenshot on failure
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            byte[] sourcePath = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath, "image/png", screenshotName);
        }

        // Quit the driver and remove the ThreadLocal WebDriver instance
        DriverFactory.closeDriver();
    }
}
