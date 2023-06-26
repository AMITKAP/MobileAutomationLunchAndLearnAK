import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Lunch_AndLearn_IOSAppium_CloudDevice_Automation
{

    private static IOSDriver driver;
    private static XCUITestOptions caps;

    @BeforeTest
    public static void launchApp() throws MalformedURLException {

        caps= new XCUITestOptions();
        caps.setCapability("bitbar_apiKey", "T0AiUh5MxFUhAucGFvlHXwW9jrH5hfYx");
        caps.setCapability("appium:bitbar_device", "Apple iPhone SE 2020 A2296 13.4.1");
        caps.setCapability("platformName", "ios");
        caps.setCapability("appium:deviceName", "Apple iPhone SE 2020 A2296 13.4.1");
        caps.setCapability("automationName", "XCUITest");
        caps.setCapability("appium:bitbar_findDevice", "false");

        driver=new IOSDriver(new URL("https://eu-mobile-hub.bitbar.com/wd/hub"),caps);

    }

    @Test
    public static void launchCalcApp()
    {
        caps.setCapability("appium:bitbar_app", "189160073");

    }


    @AfterTest
    public static void tearDown()
    {
        driver.quit();

    }

}
