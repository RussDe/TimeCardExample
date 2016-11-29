package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Home/Login page
 */
public class Login {
    WebDriver driver; /**/

    public Login(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(id = "txtUserName")
    WebElement userName;

    @FindBy(id = "txtPassword")
    WebElement password;

    @FindBy(id = "lBtnLogin")
    WebElement loginButton;

/*    public void openPage(String URL) {
        driver.get(URL);
    }*/

    public void setUserName(String userName) {
        this.userName.sendKeys(userName);
    }

    public void setPassword(String password) {
        this.password.sendKeys(password);
    }

    public void click() {
        loginButton.click();
    }
}
