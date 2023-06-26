import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Lunch_AndLearn_AndroidAppium_RealDevice_Automation
{

    private static AndroidDriver driver;

    @BeforeTest
    public static void launchApp() throws MalformedURLException {
      UiAutomator2Options caps= new UiAutomator2Options();
      caps.setApp("C:\\Users\\akapoor\\Downloads\\General-Store.apk");
      caps.setDeviceName("RF8R81FSLAW");
      caps.setPlatformName("Android");
      caps.setAutomationName("UiAutomator2");
      caps.setPlatformVersion("11");

      driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),caps);
      WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
      wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.androidsample.generalstore:id/toolbar_title")));

    }

    public static void validateProductPage()
    {

        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Amit Kapoor");
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.androidsample.generalstore:id/toolbar_title")));

        Assert.assertEquals(driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/toolbar_title")).getText(),"Products","Expected Page Title Not Found");

    }

    @AfterTest
    public static void tearDown()
    {
        driver.quit();

    }

}
