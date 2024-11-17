package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverFactory {

    private WebDriver driver;

    // ThreadLocal driver for parallel execution
    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    // Method to initialize WebDriver based on the browser value passed
    public WebDriver initDriver(String browser) {
        System.out.println("Browser value is: " + browser);

        if (browser.equalsIgnoreCase("chrome")) {
            // Ensure the path to chromedriver is correct
            System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
            tlDriver.set(new ChromeDriver());
        } else if (browser.equalsIgnoreCase("firefox")) {
            // Ensure the path to geckodriver is correct
            System.setProperty("webdriver.gecko.driver", "C:\\Drivers\\geckodriver.exe");
            tlDriver.set(new FirefoxDriver());
        } else {
            throw new IllegalArgumentException("Invalid browser value: " + browser);
        }

        // Maximize browser window and set implicit wait
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        return getDriver();
    }

    // Get WebDriver from ThreadLocal
    public static synchronized WebDriver getDriver() {
        return tlDriver.get();
    }

    // Close the driver
    public static void closeDriver() {
        tlDriver.get().quit();
        tlDriver.remove();
    }
}
