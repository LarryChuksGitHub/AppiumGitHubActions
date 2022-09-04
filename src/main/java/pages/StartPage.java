package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class StartPage extends PageBase {

    private By addTaskiOS = By.name("plus.circle");
    private By addTaskAndroid = By.id("com.jeffprod.todo:id/fab");
    private By taskTitleAndroid = By.xpath("//android.widget.TextView[@resource-id='com.jeffprod.todo:id/textViewListView']");
    private By alleAkzeptieren = By.name("Alle akzeptieren");
    private  By anmelden = By.name("Anmelden");
    private By goToAdressEntry = By.name("Go to address entry");
    private By productSelection = By.name("Product selection");
    private By headerElement = By.name("Send parcel");
    //private By secondHeaderElement = By.name("Add services");
    private By secondHeaderElement = By.xpath("//XCUIElementTypeStaticText[@name='Add services']");

    private WebElement taskTitleiOS;
    private int numberOfOnboardingScreens = 5;

    public StartPage(AppiumDriver driver) {
        super(driver);
    }

    public void clickAddTaskButtoniOS() {
        driver.findElement(addTaskiOS);
        waitForVisibilty(addTaskiOS);
        click(addTaskiOS);
    }

    public void clickAddTaskButtonAndroid() {
        driver.findElement(addTaskAndroid);
        waitForVisibilty(addTaskAndroid);
        click(addTaskAndroid);
    }

    public String getTaskTileiOS(String title) {
        taskTitleiOS = driver.findElement(By.name(title));
        return taskTitleiOS.getText();
    }

    public String getTaskTileAndroid(String title) {
        title = driver.findElement(taskTitleAndroid).getText();
        System.out.println("this the title " + title);
        return title;
    }

    public void swipeToDeleteTaskiOS(String elementToDelete) {
        taskTitleiOS = driver.findElement(By.name(elementToDelete));
        swipeLeft(elementToDelete);
        //taskTitleiOS.click();
        //swipe(DIRECTION.LEFT, Duration.ofSeconds(30));
    }

    public void swipeToLeftDHLAppiOS() {
        int n = 0;
        while (n < numberOfOnboardingScreens) {
            swipe(DIRECTION.LEFT, Duration.ofSeconds(1));
            n++;
            System.out.println("n is: " +n );
            //if (n == 5){
             //   swipeToRightDHLAppiOS();
            //}
        }
        //waitForVisibilty(alleAkzeptieren);
        //click(alleAkzeptieren);
    }
    public void swipeToRightDHLAppiOS() {
        int n = 0;
        while (n < numberOfOnboardingScreens) {
            swipe(DIRECTION.RIGHT, Duration.ofSeconds(1));
            n++;
            System.out.println("n is: " +n );
        }
    }

    public void swipeToDownDHLAppiOS() {
        waitForVisibilty(headerElement);
        while (driver.findElement(headerElement).isDisplayed()) {
            swipe(DIRECTION.DOWN, Duration.ofSeconds(1));
            System.out.println("The header: " + headerElement);
            if (driver.findElement(goToAdressEntry).isDisplayed()){
                break;
            }
        }
        //waitForVisibilty(goToAdressEntry);
        //click(goToAdressEntry);
    }

    public void swipeToUpDHLAppiOS() {
        waitForVisibilty(secondHeaderElement);
        while (driver.findElement(secondHeaderElement).isDisplayed() || driver.findElement(headerElement).isDisplayed()) {
            swipe(DIRECTION.UP, Duration.ofSeconds(1));
            System.out.println("The second header: " + secondHeaderElement);
            if (driver.findElement(productSelection).isDisplayed()){
                System.out.println("This is product selection: "+ productSelection);
                break;
            }
        }
    }

    public String getAnmeldenButtonName(){
        return driver.findElement(anmelden).getText();
    }

    public void scrollUpiOS(String elementToDelete) {
        taskTitleiOS = driver.findElement(By.name(elementToDelete));
        scrollUp(elementToDelete);
    }

    public void scrollDowniOS(String elementToDelete) {
        taskTitleiOS = driver.findElement(By.name(elementToDelete));
        scrollDown(elementToDelete);
    }

}
