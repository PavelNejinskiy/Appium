import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;


public class TestChooseCountry {

    public static ButtonsForTesting bft = new ButtonsForTesting();

    static AppiumLoader loader = new AppiumLoader();

    static String xpathCountry = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.CheckedTextView[";

    @BeforeTest
    public void start() throws MalformedURLException, InterruptedException {
        loader.setUp();
    }

    @Test
    public void testCountrySelection() throws InterruptedException, MalformedURLException {
        CountrySelection();
    }

    public static void CountrySelection() throws MalformedURLException, InterruptedException {

        int i = 12;
        String country = "";
        Thread.sleep(2000);

        Tools.swipeByCoords(100, 800, 100, 100);
        Tools.swipeByCoords(100, 800, 100, 100);
        Tools.swipeByCoords(100, 900, 100, 100);

        MobileElement element = loader.getDriver().findElement(By.xpath(xpathCountry + String.valueOf(i) + "]"));
        country = element.getText();
        element.getCenter();
        if (country.equals("United Kingdom")) {
            element.click();
        }
        Thread.sleep(8000);
    }


    @Test
    public void editingCar(String newCar, String newModel, String newSpecification) throws InterruptedException {

        MobileElement meCarProperties = (MobileElement) loader.getDriver().findElements(By.xpath(bft.meCarProperties));
        meCarProperties.click();
        MobileElement meEditingProperties = (MobileElement) loader.getDriver().findElements(By.xpath(bft.meEditingProperties));
        meEditingProperties.click();
        MobileElement meBtnEdit = (MobileElement) loader.getDriver().findElements(By.xpath(bft.meBtnEdit));
        meBtnEdit.click();
        MobileElement meSelectorCar = (MobileElement) loader.getDriver().findElements(By.xpath(bft.meSelectorCar));
        meSelectorCar.click();
        MobileElement meChangeCar = (MobileElement) loader.getDriver().findElements(By.xpath(bft.meChangeCar));
        meChangeCar.click();
        MobileElement meNewCar = (MobileElement) loader.getDriver().findElements(By.xpath(newCar));
        meNewCar.click();
        MobileElement meNewModel = (MobileElement) loader.getDriver().findElements(By.xpath(newModel));
        meNewModel.click();
        MobileElement meNewSpecification = (MobileElement) loader.getDriver().findElements(By.xpath(newSpecification));
        meNewSpecification.click();
        MobileElement meSave = (MobileElement) loader.getDriver().findElements(By.xpath(bft.meSave));
        meSave.click();

        Thread.sleep(3000);
        MobileElement meResultEdit = (MobileElement) loader.getDriver().findElements(By.xpath(bft.meResultEdit));
        assert meResultEdit.getText().contains(meNewCar.getText());
        assert meResultEdit.getText().contains(meNewModel.getText());
        assert meResultEdit.getText().contains(meNewSpecification.getText());

    }

    @Test
    public void deleteCar() {
        MobileElement meCarProperties = (MobileElement) loader.getDriver().findElements(By.xpath(bft.meCarProperties));
        meCarProperties.click();
        MobileElement meEditingProperties = (MobileElement) loader.getDriver().findElements(By.xpath(bft.meEditingProperties));
        meEditingProperties.click();
        MobileElement meBtnEdit = (MobileElement) loader.getDriver().findElements(By.xpath(bft.meBtnEdit));
        meBtnEdit.click();
        MobileElement meDeleteCar = (MobileElement) loader.getDriver().findElements(By.xpath(bft.meDeleteCar));
        meDeleteCar.click();
        MobileElement meResultDelete = (MobileElement) loader.getDriver().findElements(By.xpath(bft.meResultDelete));
        assert (meResultDelete.getText().equals("There is no vehicle in your garage"));
    }


    public MobileElement myElement(By by) {
        MobileElement element = loader.getDriver().findElement(by);
        return element;
    }

    @AfterTest
    public void endTest() {
        loader.getDriver().quit();
    }

}
