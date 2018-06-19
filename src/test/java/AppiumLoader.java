
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumLoader {

    public static AndroidDriver<MobileElement> driver;

    public static AndroidDriver<MobileElement> getDriver() {
        return driver;
    }

    public static void setUp() throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Google");
       // File app = new File("bin/ted.apk");
       // caps.setCapability(MobileCapabilityType.APP, app.getAbsoluteFile());
        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "de.autodoc.gmbh");
        caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "de.autodoc.gmbh.ui.activity.SplashActivity");
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    public void tearDown()
    {
        driver.quit();
    }
}
