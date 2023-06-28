import dev.failsafe.internal.util.Assert;
import io.appium.java_client.AppiumBy;
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
        caps.setCapability("bitbar_apiKey", "AI0fPQfmoYLwM4MDiSpRKp6a0kjEkTQY");
        caps.setCapability("appium:bitbar_device", "Apple iPhone SE 2020 A2296 13.4.1");
        caps.setCapability("platformName", "ios");
        caps.setCapability("appium:deviceName", "Apple iPhone SE 2020 A2296 13.4.1");
        caps.setCapability("automationName", "XCUITest");
        caps.setCapability("appium:bitbar_findDevice", "false");
        caps.setCapability("appium:bundleId","com.apple.mobilecal");
        driver=new IOSDriver(new URL("https://eu-mobile-hub.bitbar.com/wd/hub"),caps);

    }

    @Test
    public static void launchCalcApp()
    {

        driver.findElement(AppiumBy.iOSNsPredicateString("name =='Inbox' AND value =='Inbox'")).click();
        Assert.isTrue(driver.findElement(AppiumBy.iOSNsPredicateString("label =='Done'")).isDisplayed(),"Not Displayed");

    }


    @AfterTest
    public static void tearDown()
    {
        driver.quit();

    }

}
