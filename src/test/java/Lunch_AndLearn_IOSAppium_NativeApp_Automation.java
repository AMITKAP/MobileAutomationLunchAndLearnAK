import dev.failsafe.internal.util.Assert;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;

public class Lunch_AndLearn_IOSAppium_NativeApp_Automation
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
        caps.setCapability("appium:bundleId","com.apple.mobilecal");
        driver=new IOSDriver(new URL("http://192.168.1.216:4724/wd/hub"),caps);

    }

    @Test
    public static void validateCalcApp()
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
