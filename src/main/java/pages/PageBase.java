package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.ios.IOSTouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;

public class PageBase {
    public static AppiumDriver driver;
    //private TouchAction touchAction;
    AndroidTouchAction androidTouchAction;
    TouchAction touchAction;
    public static final Duration WAIT = Duration.ofSeconds(2500);

    public PageBase(AppiumDriver appiumDriver){
            this.driver = appiumDriver;
    }

    public void waitForVisibilty(By element){
        WebDriverWait wait = new WebDriverWait(driver,WAIT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }
    public void click(By element ){
        waitForVisibilty(element);
        WebElement element1 = driver.findElement(element);
        element1.click();
    }

    protected void clear(By element ){
        waitForVisibilty(element);
        WebElement element1 = driver.findElement(element);
        element1.clear();
    }
    protected void sendText(By element, String text ){
        waitForVisibilty(element);
        WebElement element1 = driver.findElement(element);
        element1.sendKeys(text);
    }

    protected void scrollDown(String toElementName) {
        HashMap<String, Object> hashMapScrollDown = new HashMap<>();
        hashMapScrollDown.put("direction", "down");
        hashMapScrollDown.put("value", toElementName);
        driver.executeScript("mobile:scroll", hashMapScrollDown);
    }

    protected void scrollUp(String toElementName) {
        HashMap<String, Object> hashMapScrollDown = new HashMap<>();
        hashMapScrollDown.put("direction", "up");
        hashMapScrollDown.put("value", toElementName);
        driver.executeScript("mobile:scroll", hashMapScrollDown);
    }
    /*
    protected void swipeLeft(String toElementName) {
        HashMap<String, Object> hashMapSwipeLeft = new HashMap<>();
        hashMapSwipeLeft.put("direction", "left");
        hashMapSwipeLeft.put("value", toElementName);
        driver.executeScript("mobile:scroll", hashMapSwipeLeft);
    }

     */
    protected void swipeRight(String toElementName) {
        HashMap<String, Object> hashMapSwipeLeft = new HashMap<>();
        hashMapSwipeLeft.put("direction", "right");
        hashMapSwipeLeft.put("value", toElementName);
        driver.executeScript("mobile:swipe", hashMapSwipeLeft);
    }

    protected String getAttribute(By element, String attribute ){
        waitForVisibilty(element);
        WebElement element1 = driver.findElement(element);
        return element1.getAttribute(attribute);
    }


    protected void swipeLeft(String a){
        Dimension dimension = driver.manage().window().getSize();
        WebElement elementa = driver.findElement(By.name(a));
        int endX = (int) (dimension.width * 0.10);
        int startY = (int) (dimension.height * 0.90);
        touchAction = new IOSTouchAction((PerformsTouchActions) driver);
        var perform = touchAction.longPress(ElementOption.element(elementa))
                .waitAction()
                .moveTo(PointOption.point(endX,startY))
                .release()
                .perform();

    }

    protected void swipeLeft(){
        Dimension dimension = driver.manage().window().getSize();
        int startPoint = (int) (dimension.getWidth() * 0.8);
        int endPoint = (int) (dimension.getWidth() * 0.2);

        touchAction = new IOSTouchAction((PerformsTouchActions) driver);
        touchAction.press(PointOption.point(startPoint,0))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(endPoint,0))
                .release().perform();
    }

    protected enum DIRECTION {
        DOWN, UP, LEFT, RIGHT;
    }
    protected void swipe( DIRECTION direction, Duration duration) {
        Dimension size = driver.manage().window().getSize();
        System.out.println("Device screen size: "+ size);

        int startX = 0;
        int endX = 0;
        int startY = 0;
        int endY = 0;

        switch (direction) {
            case RIGHT:
                startY = (int) (size.height / 2);
                startX = (int) (size.width * 0.10);
                endX = (int) (size.width * 0.90);
                touchAction = new IOSTouchAction((PerformsTouchActions) driver);
                var perform = touchAction.press(PointOption.point(startX, startY))
                        .waitAction(WaitOptions.waitOptions(duration))
                        .moveTo(PointOption.point(endX, startY))
                        .release()
                        .perform();
                break;

            case LEFT:
                startY = (int) (size.height / 2);
                startX = (int) (size.width * 0.90);
                endX = (int) (size.width * 0.10);
                touchAction = new IOSTouchAction((PerformsTouchActions) driver);
                touchAction.press(PointOption.point(startX, startY))
                        .waitAction(WaitOptions.waitOptions(duration))
                        .moveTo(PointOption.point(endX, startY))
                        .release()
                        .perform();

                break;

            case UP:
                endY = (int) (size.height * 0.70);
                startY = (int) (size.height * 0.30);
                startX = (size.width / 2);
                touchAction = new IOSTouchAction((PerformsTouchActions) driver);
                touchAction.press(PointOption.point(startX, startY))
                        .waitAction(WaitOptions.waitOptions(duration))
                        .moveTo(PointOption.point(startX, endY))
                        .release()
                        .perform();
                break;


            case DOWN:
                startY = (int) (size.height * 0.80);
                endY = (int) (size.height * 0.10);
                startX = (size.width / 2);
                touchAction = new IOSTouchAction((PerformsTouchActions) driver);
                touchAction.press(PointOption.point(startX, startY))
                        .waitAction(WaitOptions.waitOptions(duration))
                        .moveTo(PointOption.point(startX, endY))
                        .release()
                        .perform();

                break;

        }
    }


}
