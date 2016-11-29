package pages;

import org.openqa.selenium.WebDriver;

/**
 * Check the title
 */
public class Title {

    WebDriver driver;

    public  Title(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isCorrect(String title) {
        return driver.getTitle().equals(title);
    }
}
