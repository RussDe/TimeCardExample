package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * TimeCards page
 */
public class TimeCards {
    WebDriver driver;

    public TimeCards(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "WeekEnding1")
    WebElement weekEndingDate;

    @FindBy(id = "a_g_ctl00_c_lblStatus")
    WebElement reportStatus;

    //create a list of elements to fill out hours
    @FindBy(id = "tblTimeCard")
    WebElement table;

    By input = By.tagName("input");

    public void printList() {
        List<WebElement> inputs = table.findElements(input);
        for (WebElement input : inputs) {
            if (input.getAttribute("id").startsWith("a_g_ctl00_c_w_ctl0\\d_s_ctl0\\d_txt(Start|Stop)Time")) {
                System.out.println(input.getAttribute("id").toString());
                //input.getAttribute("id").startsWith("a_g_ctl00_c_w_ctl0\\d_s_ctl0\\d_txt(Start|Stop)Time")
            }
        }
    }

    //Sunday
    //a_g_ctl00_c_w_ctl01_s_ctl01_txtStartTime
    //a_g_ctl00_c_w_ctl01_s_ctl01_txtStopTime

    //a_g_ctl00_c_w_ctl01_s_ctl02_txtStartTime
    //a_g_ctl00_c_w_ctl01_s_ctl02_txtStopTime

    //a_g_ctl00_c_w_ctl01_s_ctl03_txtStartTime
    //a_g_ctl00_c_w_ctl01_s_ctl03_txtStopTime


    //a_g_ctl00_c_w_ctl02_s_ctl01_txtStartTime
    //a_g_ctl00_c_w_ctl02_s_ctl01_txtStopTime

    //Saturday
    //a_g_ctl00_c_w_ctl07_s_ctl01_txtStartTime

}
