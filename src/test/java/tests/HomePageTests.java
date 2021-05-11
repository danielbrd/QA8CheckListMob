package tests;

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

    HomePageHelper homePage;

    @Test
    public void applStartTest() throws InterruptedException {
        Thread.sleep(1500);
        homePage.gettAppName();
    }

    @Test
    public void addNewList() throws InterruptedException {
        Thread.sleep(5000);
        int listsCountBef = driver.findElements(By.id("com.flt.checklist:id/text_layout")).size();
        driver.findElement(By.id("com.flt.checklist:id/add_shopping_list")).click();
        Thread.sleep(1500);
        WebElement editText = driver.findElement(By.xpath("//*[@resource-id='android:id/custom']/*"));
        editText.click();
        Thread.sleep(1500);
        editText.sendKeys("NewList");
        Thread.sleep(1500);
        driver.findElement(By.id("android:id/button1")).click();
        Thread.sleep(1500);
        driver.findElement(By.id("com.flt.checklist:id/add_item_edit")).sendKeys("1.Finish My First MobTest task!");
        Thread.sleep(1500);
        driver.findElement(By.id("com.flt.checklist:id/add_item")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@content-desc='Navigate up']")).click();
        Thread.sleep(1500);
        int listsCountAft = driver.findElements(By.id("com.flt.checklist:id/text_layout")).size();

        Assert.assertTrue(driver.findElement(By.id("com.flt.checklist:id/list_title"))
                .getText().contains("NewList"));
        Assert.assertEquals(listsCountBef + 1, listsCountAft,
                "The quantity of lists after adding is not the quantity before adding plus one");
    }
}
