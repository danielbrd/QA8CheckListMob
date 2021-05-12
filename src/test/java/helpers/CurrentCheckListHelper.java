package helpers;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class CurrentCheckListHelper extends PageBase {
    public CurrentCheckListHelper(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//*[@content-desc='Navigate up']")
    WebElement currentListBackButton;
    @FindBy (id = "com.flt.checklist:id/add_item_edit")
    WebElement addTask;
    @FindBy (id = "com.flt.checklist:id/add_item")
    WebElement taskOkButton;
    @FindBy (id = "com.flt.checklist:id/list_title")
    List<WebElement> listsCount;


    public void addTaskInList(String name) {
        waitUntilElementIsClickable(addTask, 10);
        this.fillField(addTask, name);
//        driver.navigate().back();
        taskOkButton.click();
    }

    public void currentListBackButton(){
        waitUntilElementIsClickable(currentListBackButton, 10);
        currentListBackButton.click();
    }
    public int getQuantityList() {
        return listsCount.size();
    }

    public boolean isLastCheckListTitle(String title) {
        int size = this.getQuantityList();
        boolean res = false;
        if(size != 0 && listsCount.get(size-1).getText().equals(title)) {res = true;}
        return res;
    }
}
