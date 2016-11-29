package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

/**
 * Pop up the alert
 */
public class Alert {

    WebDriver driver;

    public Alert(WebDriver driver) {
        this.driver = driver;
    }

    public void showMessage(String text, long timeout) throws InterruptedException {
        //Generating Alert Using Javascript Executor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("function showAlert() { alert('" + text + "'); }; showAlert()");
        Thread.sleep(timeout);
        //driver.switchTo().alert().accept();
    }
}
