import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static io.appium.java_client.touch.offset.PointOption.point;


public class Tools {

    private static AndroidDriver<MobileElement> driver;
    static AppiumLoader loader = new AppiumLoader();

    public static void setDriver(AndroidDriver <MobileElement> driver) {
        Tools.driver = driver;
    }

    public static void swipeElements (MobileElement elementA, MobileElement elementB) {
        Point locStart = elementA.getLocation();
        Point locEnd = elementB.getLocation();
        new TouchAction(loader.getDriver()).longPress(point(locStart.x, locStart.y)).moveTo(point(locEnd.x,locEnd.y)).release().perform();
    }

    public static void swipeByCoords (int startX, int startY, int endX, int endY) {
       // new TouchAction(loader.getDriver()).longPress(point(startX, startY)).moveTo(point(endX, endY)).release().perform();
        new TouchAction(loader.getDriver()).longPress(startX, startY).moveTo(endX, endY).release().perform();
    }

    public static void waitForDispalayed (MobileElement element){
       new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));
    }

    public static void finedAndClick(String keyWord, String xpath, int x, int y1, int step, AndroidDriver<MobileElement> myDriver)
    {
        boolean isFoundTheElement = myDriver.findElementsByXPath(xpath).size() < 0;
        while (isFoundTheElement == false){

            if(isFoundTheElement  = myDriver.findElementsByXPath(xpath).size() > 0)
            {
                MobileElement element =  myDriver.findElement(By.xpath(xpath));
                element.click();
                break;
            }
            Tools.swipeByCoords(x, y1, x, y1 + step);

        }

    }

}
