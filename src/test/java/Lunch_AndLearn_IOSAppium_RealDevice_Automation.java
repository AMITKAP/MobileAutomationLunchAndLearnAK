import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;

public class Lunch_AndLearn_IOSAppium_RealDevice_Automation
{

    private static IOSDriver driver;
    private static XCUITestOptions caps;

    @BeforeTest
    public static void launchApp() throws MalformedURLException {

        caps= new XCUITestOptions();
        caps.setCapability("appium:automationName","XCUITest");
        caps.setCapability("appium:platformVersion","16.5.1");
        caps.setCapability("appium:deviceName","iPhone 12 Pro Max");
        caps.setCapability("platformName","ios");
        caps.setCapability("appium:udid","00008101-00111C860292001E");

        driver=new IOSDriver(new URL("http://192.168.1.216:4724/wd/hub"),caps);

    }

    public static void launchCalcApp()
    {

        caps.setCapability("appium:bundleId","com.apple.mobilecal");

    }


    @AfterTest
    public static void tearDown()
    {
        driver.quit();

    }

}
