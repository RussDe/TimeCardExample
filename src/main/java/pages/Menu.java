package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Navigate through menu
 */
public class Menu {
    WebDriver driver;

    public Menu(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Home page
    @FindBy(id = "Left1_SecuredHyperLink01")
    WebElement consultantHome;

    //Time Cards page
    @FindBy(id = "Left1_SecuredHyperLink02")
    WebElement timecardHome;

    //Logout page
    @FindBy(id = "Left1_SecuredHyperLink35")
    WebElement logout;

    public void goTo(Character page) {
        switch (page) {
            case 'H':
                consultantHome.click();
                break;
            case 'T':
                timecardHome.click();
                break;
            case 'L':
                logout.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid page name - " + page);
        }

    }


}
