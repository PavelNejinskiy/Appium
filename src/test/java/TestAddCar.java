import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class TestAddCar {

    public static ButtonsForTesting bft = new ButtonsForTesting();

    static AppiumLoader loader = new AppiumLoader();
    TestChooseCountry tcc;

    @BeforeTest
    public void start() throws MalformedURLException, InterruptedException {
        loader.setUp();

    }

    @Test
    public void testStart() throws InterruptedException, MalformedURLException {
        tcc.CountrySelection();
        Thread.sleep(8000);
    }

    @Test
    public void testAddCar() throws InterruptedException, MalformedURLException {

        tcc.CountrySelection();
       // Thread.sleep(2000);


//        MobileElement meMenu = loader.getDriver().findElement(By.id("Open navigation drawer"));
//        meMenu.click();
        MobileElement mePlus =loader.getDriver().findElement(By.id("de.autodoc.gmbh:id/fabAddCar"));
        mePlus.click();
        MobileElement meCarMarker = loader.getDriver().findElement(By.xpath(bft.meCarMarker));
        meCarMarker.click();
        MobileElement meChooseAUDI = loader.getDriver().findElement(By.xpath(bft.meChooseAUDI));
        meChooseAUDI.click();
        MobileElement meChooseModel =loader.getDriver().findElement(By.xpath(bft.meChooseModel));
        meChooseModel.click();
        MobileElement meChooseSpecification =loader.getDriver().findElement(By.xpath(bft.meChooseSpecification));
        meChooseSpecification.click();
        MobileElement meAddVehicles =loader.getDriver().findElement(By.xpath(bft.meAddVehicles));
        meAddVehicles.click();

        Thread.sleep(3000);
        MobileElement meResult = (MobileElement) loader.getDriver().findElement(By.xpath(bft.meResult));
        assert (meResult.getText().contains(meChooseAUDI.getText()));
        assert (meResult.getText().contains(meChooseModel.getText()));
        assert (meResult.getText().contains(meChooseSpecification.getText()));
    }



    @AfterTest
    public void close()
    {
        loader.tearDown();
    }
}
