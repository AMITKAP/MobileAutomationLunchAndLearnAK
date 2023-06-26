import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Lunch_AndLearn_Cloud_Automation
{

    private static AndroidDriver driver;

    @BeforeTest
    public static void launchApp() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("bitbar_apiKey", "T0AiUh5MxFUhAucGFvlHXwW9jrH5hfYx");
        capabilities.setCapability("bitbar_device", "Google Pixel 3a Android 12");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Android Phone");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("browserName", "Chrome");

        driver=new AndroidDriver(new URL("https://eu-mobile-hub.bitbar.com/wd/hub"),capabilities);

    }

    public static void validateProductPage()
    {
        driver.get("https://launch.nttdata.com");
    }

    @AfterTest
    public static void tearDown()
    {
        driver.quit();

    }

}
