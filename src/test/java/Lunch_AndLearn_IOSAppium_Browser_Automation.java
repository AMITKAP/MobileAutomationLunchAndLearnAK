import dev.failsafe.internal.util.Assert;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static io.appium.java_client.AppiumBy.*;

public class Lunch_AndLearn_IOSAppium_Browser_Automation
{

    private static IOSDriver driver;
    private static XCUITestOptions caps;

    @BeforeTest
    public static void launchApp() throws MalformedURLException {

        caps= new XCUITestOptions();
        caps.setCapability("appium:automationName","XCUITest");
        caps.setCapability("appium:platformVersion","16.4");
        caps.setCapability("appium:deviceName","iPhone 14");
        caps.setCapability("platformName","ios");
        caps.setCapability("appium:udid","23A404BA-DC23-4D34-80E1-46F3E922A2A2");
        caps.setCapability("browserName","safari");
        driver=new IOSDriver(new URL("http://192.168.1.216:4724/wd/hub"),caps);

    }

    @Test
    public static void launchSafariBrowser()
    {

        driver.get("https://launch.nttdata.com");
        Assert.isTrue(driver.findElement(iOSClassChain("**/XCUIElementTypeImage[`label =='home`]")).isDisplayed(),"Not Displayed");
    }

    @AfterTest
    public static void tearDown()
    {
        driver.quit();

    }

}
