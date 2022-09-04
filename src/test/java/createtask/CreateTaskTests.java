package createtask;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.PageBase;
import pages.StartPage;
import pages.TaskPage;
import testbase.TestBase;
import utils.JsonReader;

import java.io.IOException;
import java.net.MalformedURLException;

public class CreateTaskTests extends TestBase {

    StartPage startPage;
    TaskPage taskPage;
    PageBase pageBase;
    private  By paket = By.name("Paket");


    @DataProvider(name = "tasks data")
    public Object [][] parser() throws IOException, ParseException {
        return JsonReader.getJsonData(System.getProperty("user.dir") +"/data/TasksData.json",
                "Tasks Data",
                2);
    }

    @Test
    public void testSwipeDHLAppiOS() throws MalformedURLException, InterruptedException {
        iOSSetUp();
        startPage = new StartPage(driver);
        pageBase = new PageBase(driver);
        startPage.swipeToLeftDHLAppiOS();
        startPage.swipeToRightDHLAppiOS();
        Assert.assertTrue(startPage.getAnmeldenButtonName().equalsIgnoreCase("Anmelden"),"Could not swipe Onboatding screen away");
        //driver.findElement(By.id("tabBarSend")).click();
       // pageBaseNew.waitForVisibilty(paket);
       // pageBaseNew.click(paket);
        //startPage.swipeToDownDHLAppiOS();
        //startPage.swipeToUpDHLAppiOS();
    }

    @Test(dataProvider = "tasks data")
    public void createTaskiOS(String taskName, String taskNote) throws MalformedURLException {
        //  iPhone 11 (9BBB2EF0-9155-446F-805B-D046678F8EA5) (Booted)
        //  iPhone 12 (8211FE5A-A721-441A-AC1D-18EA1D91E8C2) (Booted)
        iOSSetUp();
        startPage = new StartPage(driver);
        taskPage = new TaskPage(driver);
        //var page =startPage.clickAddTaskButton();
        //taskPage = new TaskPage(driver);
        startPage.clickAddTaskButtoniOS();
        taskPage.addTaskTitleiOS(taskName);
        taskPage.addTaskNoteiOS(taskNote);
        taskPage.saveTaskiOS();
        startPage.getTaskTileiOS(taskName);
        Assert.assertTrue(startPage.getTaskTileiOS(taskName).contains(taskName));
        //startPage.scrollDowniOS(taskName);
        //startPage.swipeToDeleteTaskiOS(taskName);
        tearDown();

    }

    @Test(dataProvider = "tasks data")
    public void createTaskiOS2(String taskName, String taskNote) throws MalformedURLException {
        //  iPhone 11 (9BBB2EF0-9155-446F-805B-D046678F8EA5) (Booted)
        //  iPhone 12 (8211FE5A-A721-441A-AC1D-18EA1D91E8C2) (Booted)
        iOSSetUp2("8211FE5A-A721-441A-AC1D-18EA1D91E8C2","1000","8200","iPhone 12","15.5");
        startPage = new StartPage(driver);
        taskPage = new TaskPage(driver);
        //var page =startPage.clickAddTaskButton();
        //taskPage = new TaskPage(driver);
        startPage.clickAddTaskButtoniOS();
        taskPage.addTaskTitleiOS(taskName);
        taskPage.addTaskNoteiOS(taskNote);
        taskPage.saveTaskiOS();
        startPage.getTaskTileiOS(taskName);
        Assert.assertTrue(startPage.getTaskTileiOS(taskName).contains(taskName));
        tearDown();

    }

    @Test(dataProvider = "tasks data")
    public void createTaskAndroid(String taskName, String taskNote) throws MalformedURLException, InterruptedException {
        androidSetUp();
        startPage = new StartPage(driver);
        taskPage = new TaskPage(driver);
        startPage.clickAddTaskButtonAndroid();
        Thread.sleep(10);
        taskPage.addTaskTitleAndroid(taskName);
        taskPage.addTaskNoteAndroid(taskNote);
        taskPage.saveTaskAndroid();
        String text = startPage.getTaskTileAndroid(taskName);
        Assert.assertTrue(text.contains(taskName));
        //driver.hideKeyboard();
        tearDown();
    }
}
