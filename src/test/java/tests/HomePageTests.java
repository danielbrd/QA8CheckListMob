package tests;

import helpers.CurrentCheckListHelper;
import helpers.HomePageHelper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class HomePageTests extends TestBase {

    //initiation of the class helper
    HomePageHelper homePage;
    CurrentCheckListHelper currentCheckList;

    //metod init test dlya testov etogo klassa
    @BeforeMethod
    public void initTests(){
        homePage = PageFactory.initElements(driver, HomePageHelper.class);
        currentCheckList = PageFactory.initElements(driver, CurrentCheckListHelper.class);
        homePage.waitUntilPageIsLoaded();
        homePage.waitUntilAppNameIsVisible();
    }

    @Test
    public void applStartTest() throws InterruptedException {
        Thread.sleep(1500);
        homePage.gettAppName();
    }

    @Test
    public void addNewList() throws InterruptedException {
        int firstQuan = currentCheckList.getQuantityList();

        homePage.createNewCheckList("NewList");
        homePage.waitUntilPageIsLoaded();
        currentCheckList.currentListBackButton();
        homePage.waitUntilPageIsLoaded();
        homePage.createNewCheckList("NewList2");
        currentCheckList.addTaskInList("First Task");
        currentCheckList.currentListBackButton();

        int lastQuan = currentCheckList.getQuantityList();

        Assert.assertTrue(currentCheckList.isLastCheckListTitle("NewList"));
        Assert.assertEquals(firstQuan+1, lastQuan,
                "The quantity of lists after adding is not the quantity before adding plus one");
    }

    @Test
    public void addNewCheckListAndRotate() throws InterruptedException {
        int firstQuan = currentCheckList.getQuantityList();

        homePage.createNewCheckList("NewListForRotationTest");
        homePage.waitUntilPageIsLoaded();
        currentCheckList.rotateScreenLandscape();
        currentCheckList.currentListBackButton();
        homePage.waitUntilPageIsLoaded();
        int lastQuan = currentCheckList.getQuantityList();

        Assert.assertTrue(currentCheckList.isLastCheckListTitle("NewListForRotationTest"));
        Assert.assertEquals(firstQuan+1, lastQuan,
                "The quantity of lists after adding is not the quantity before adding plus one");
    }
}
