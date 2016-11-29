package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Home page (a list of submitted time cards)
 */
public class Home {
    WebDriver driver;

    public Home(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "Time")
    WebElement timeCardTable;

    By tr = By.tagName("tr");
    By td = By.tagName("td");

    //find last time card date submission
    public String getLastTimeCardDate() {
        List dates = new ArrayList();
        List<WebElement> trs = timeCardTable.findElements(tr);
        for (WebElement tr : trs) {
            List<WebElement> tds = tr.findElements(td);
            for (WebElement td : tds) {
                if (td.getText().contains("/")) {
                    dates.add(td.getText());
                }
            }
        }
        return String.valueOf(dates.get(0));
    }

    //find the status of the last time card submission
    public boolean lastTimeCardStatusApproved(String lastTimeCardDate, String status) {
        List<WebElement> trs = timeCardTable.findElements(tr);
        List<WebElement> tds = trs.get(1).findElements(td);
        for (WebElement td : tds) {
            return (td.getText().contains(lastTimeCardDate) && td.getText().contains("Final Manager Approved"));
        }
        return false;
    }
}

