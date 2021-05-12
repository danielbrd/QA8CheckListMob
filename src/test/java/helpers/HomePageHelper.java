package helpers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageHelper extends PageBase{

    public HomePageHelper(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }

    @FindBy (className = "android.widget.TextView")
    WebElement appName;
    @FindBy (id = "com.flt.checklist:id/add_shopping_list")
    WebElement addList;
    @FindBy(xpath = "//*[@resource-id='android:id/custom']/*")
    WebElement nameCheckListField;
    @FindBy(id = "android:id/button1")
    WebElement okButton;
    @FindBy(id = "com.flt.checklist:id/add_item_edit")
    WebElement addTaskFieldName;

    public void waitUntilPageIsLoaded() {
        waitUntilElementIsClickable(addList, 10);
    }

    public void waitUntilAppNameIsVisible() {
        waitUntilElementIsVisible(appName, 10);
    }


    public String gettAppName(){
        return appName.getText();
    }

    public void createNewCheckList(String name){
        addList.click();
        waitUntilElementIsClickable(nameCheckListField, 10);
        this.fillField(nameCheckListField, name);
        waitUntilElementIsClickable(okButton, 10);
        okButton.click();
    }


}
