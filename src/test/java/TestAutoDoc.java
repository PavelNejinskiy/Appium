import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;

public class TestAutoDoc {

    public static ButtonsForTesting bft = new ButtonsForTesting();

    AppiumDriver driver;
    URL serverURL;
    WebDriverWait wait;

    @BeforeClass
    public void setup() throws MalformedURLException {
       serverURL = new URL("http://127.0.0.1:4723/wd/hub");
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsung Galaxy S8");
        cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Browser");
        cap.setCapability(MobileCapabilityType.FULL_RESET, "true");
        cap.setCapability("appPackage", "de.autodoc.gmbh");
        cap.setCapability("appActivity", ".ui.activity.SearchActivity");

        driver = new AndroidDriver(serverURL, cap);
        wait = new WebDriverWait(driver, 20);

    }

    @Test
    public void countrySelection() {

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(bft.meCountrySelection)));
    }

    @Test
    public void creatingCar() throws MalformedURLException, InterruptedException {

        MobileElement meMenu = (MobileElement) driver.findElements(By.xpath(bft.meMenu));
        meMenu.click();
        MobileElement mePlus = (MobileElement) driver.findElements(By.xpath(bft.mePlus));
        mePlus.click();
        MobileElement meCarMarker = (MobileElement) driver.findElements(By.xpath(bft.meCarMarker));
        meCarMarker.click();
        MobileElement meChooseAUDI = (MobileElement) driver.findElements(By.xpath(bft.meChooseAUDI));
        meChooseAUDI.click();
        MobileElement meChooseModel = (MobileElement) driver.findElements(By.xpath(bft.meChooseModel));
        meChooseModel.click();
        MobileElement meChooseSpecification = (MobileElement) driver.findElements(By.xpath(bft.meChooseSpecification));
        meChooseSpecification.click();
        MobileElement meAddVehicles = (MobileElement) driver.findElements(By.xpath(bft.meAddVehicles));
        meAddVehicles.click();

        Thread.sleep(3000);
        MobileElement meResult = (MobileElement) driver.findElements(By.xpath(bft.meResult));
        assert (meResult.getText().contains(meChooseAUDI.getText()));
        assert (meResult.getText().contains(meChooseModel.getText()));
        assert (meResult.getText().contains(meChooseSpecification.getText()));

    }


    @Test
    public void editingCar(String newCar, String newModel, String newSpecification) throws InterruptedException {

        MobileElement meCarProperties = (MobileElement) driver.findElements(By.xpath(bft.meCarProperties));
        meCarProperties.click();
        MobileElement meEditingProperties = (MobileElement) driver.findElements(By.xpath(bft.meEditingProperties));
        meEditingProperties.click();
        MobileElement meBtnEdit = (MobileElement) driver.findElements(By.xpath(bft.meBtnEdit));
        meBtnEdit.click();
        MobileElement meSelectorCar = (MobileElement) driver.findElements(By.xpath(bft.meSelectorCar));
        meSelectorCar.click();
        MobileElement meChangeCar = (MobileElement) driver.findElements(By.xpath(bft.meChangeCar));
        meChangeCar.click();
        MobileElement meNewCar = (MobileElement) driver.findElements(By.xpath(newCar));
        meNewCar.click();
        MobileElement meNewModel = (MobileElement) driver.findElements(By.xpath(newModel));
        meNewModel.click();
        MobileElement meNewSpecification = (MobileElement) driver.findElements(By.xpath(newSpecification));
        meNewSpecification.click();
        MobileElement meSave = (MobileElement) driver.findElements(By.xpath(bft.meSave));
        meSave.click();

        Thread.sleep(3000);
        MobileElement meResultEdit = (MobileElement) driver.findElements(By.xpath(bft.meResultEdit));
        assert meResultEdit.getText().contains(meNewCar.getText());
        assert meResultEdit.getText().contains(meNewModel.getText());
        assert meResultEdit.getText().contains(meNewSpecification.getText());

    }

    @Test
    public void deleteCar() {
        MobileElement meCarProperties = (MobileElement) driver.findElements(By.xpath(bft.meCarProperties));
        meCarProperties.click();
        MobileElement meEditingProperties = (MobileElement) driver.findElements(By.xpath(bft.meEditingProperties));
        meEditingProperties.click();
        MobileElement meBtnEdit = (MobileElement) driver.findElements(By.xpath(bft.meBtnEdit));
        meBtnEdit.click();
        MobileElement meDeleteCar = (MobileElement) driver.findElements(By.xpath(bft.meDeleteCar));
        meDeleteCar.click();
        MobileElement meResultDelete = (MobileElement) driver.findElements(By.xpath(bft.meResultDelete));
        assert (meResultDelete.getText().equals("There is no vehicle in your garage"));
    }

    @AfterClass
    public void endTest() {
        driver.quit();
    }

}
