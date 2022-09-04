package testbase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class TestBase {
    public static AppiumDriver driver;

    public static void androidSetUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("appium:platformName", "platform");
        desiredCapabilities.setCapability("appium:automationName","UiAutomator2");
        desiredCapabilities.setCapability("appium:platformVersion","11");
        desiredCapabilities.setCapability("appium:deviceName","Android Emulator");
        //desiredCapabilities.setCapability("appium:browserName","Chrome");
        //desiredCapabilities.setCapability("autoGrantPermission", true);

        //desiredCapabilities.setCapability("appium:app",System.getProperty("user.dir")+ "/apps/selendroid-test-app.apk");

        desiredCapabilities.setCapability("appium:app",System.getProperty("user.dir")+ "/apps/ToDo.apk");
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"),desiredCapabilities);
    }

    public static void iOSSetUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("appium:platformName", "platform");
        desiredCapabilities.setCapability("appium:automationName", "XCUITest");
        desiredCapabilities.setCapability("appium:platformVersion", "15.5");
        desiredCapabilities.setCapability("appium:deviceName", "iPhone 11");
        desiredCapabilities.setCapability("appium:safari:userSimulator", true);
        desiredCapabilities.setCapability("appium:app",System.getProperty("user.dir")+ "/apps/DailyCheck.app");
        //desiredCapabilities.setCapability("appium:app",System.getProperty("user.dir")+ "/apps/DHLPaket.app");
        //desiredCapabilities.setCapability("appium:app", System.getProperty("user.dir") + "/apps/UIKitCatalog.app");
        driver = new IOSDriver(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
    }

    public static void iOSSetUp2(String udid, String port, String webdriverAgentLocalPart, String deviceName, String platformVersion) throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("appium:platformName", "iOS");
        desiredCapabilities.setCapability("appium:automationName", "XCUITest");
        desiredCapabilities.setCapability("appium:platformVersion", platformVersion);
        desiredCapabilities.setCapability("appium:deviceName", deviceName);
        desiredCapabilities.setCapability("appium:safari:userSimulator", true);
        desiredCapabilities.setCapability("appium:app",System.getProperty("user.dir")+ "/apps/DailyCheck.app");
        desiredCapabilities.setCapability("appium:udid",udid);
        desiredCapabilities.setCapability("appium:wdaLocalPort",webdriverAgentLocalPart);

        //desiredCapabilities.setCapability("appium:app", System.getProperty("user.dir") + "/apps/UIKitCatalog.app");
        driver = new IOSDriver(new URL("http://localhost:"+port+"/wd/hub"), desiredCapabilities);
    }


    public  static void tearDown(){
        if (null != driver){
            driver.quit();
        }

    }


}
