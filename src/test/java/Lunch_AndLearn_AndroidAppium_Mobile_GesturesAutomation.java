import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
public class Lunch_AndLearn_AndroidAppium_Mobile_GesturesAutomation
{
    private static AndroidDriver driver;
    @BeforeTest
    public static void launchApp() throws MalformedURLException {
      UiAutomator2Options caps= new UiAutomator2Options();
      caps.setApp("C:\\Users\\akapoor\\Downloads\\ApiDemos-debug.apk");
      caps.setDeviceName("LunchAndLearnAndroidEmulator");
      caps.setPlatformName("Android");
      caps.setAutomationName("UiAutomator2");
      caps.setPlatformVersion("9");

      driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),caps);
      WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
      wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("android:id/action_bar_container")));

    }

    public static void longPressGesture()
    {

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();

        WebElement element=driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='People Names']"));
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),"duration",1000
        ));

    }

    @AfterTest
    public static void tearDown()
    {
        driver.quit();

    }

}
