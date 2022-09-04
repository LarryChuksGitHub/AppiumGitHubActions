package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class TaskPage extends PageBase{

    private By taskTitleiOS = By.xpath("//XCUIElementTypeTextField[@value='Title']");
    private  By taskTitleAndroid = By.id("com.jeffprod.todo:id/editTextTitre");
    private  By taskNoteiOS = By.xpath("//XCUIElementTypeTextField[@value='Description']");
    private By  taskNoteAndriod = By.id("com.jeffprod.todo:id/editTextNote");
    private By saveTaskiOS = By.name("Save");
    private By saveTaskiAndroid = By.id("com.jeffprod.todo:id/action_save");



    public TaskPage(AppiumDriver driver) {
        super(driver);
    }
    public void addTaskTitleiOS(String taskName){
        //Xpath =//tagname[@Attribute=’value’]
        //Xpath =//XCUIElementTypeTextField[@value=’Title’]
        waitForVisibilty(taskTitleiOS);
        click(taskTitleiOS);
        clear(taskTitleiOS);
        sendText(taskTitleiOS, taskName);
    }

    public void addTaskTitleAndroid(String taskName){
        waitForVisibilty(taskTitleAndroid);
        click(taskTitleAndroid);
        clear(taskTitleAndroid);
        sendText(taskTitleAndroid, taskName);
    }
    public void addTaskNoteiOS(String taskNoteName){
        waitForVisibilty(taskNoteiOS);
        click(taskNoteiOS);
        clear(taskNoteiOS);
        sendText(taskNoteiOS, taskNoteName);
    }

    public void addTaskNoteAndroid(String taskNoteName){
        waitForVisibilty(taskNoteAndriod);
        click(taskNoteAndriod);
        clear(taskNoteAndriod);
        sendText(taskNoteAndriod, taskNoteName);
    }

    public void saveTaskiOS(){
        click(saveTaskiOS);
    }

    public void saveTaskAndroid(){
        click(saveTaskiAndroid);
    }

}
