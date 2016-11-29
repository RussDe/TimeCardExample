package main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;
import tools.DateCompare;
import tools.DateConvert;

import java.text.ParseException;

import static javax.swing.JOptionPane.showMessageDialog;

/**
 * main class
 */
public class TimeCardExample {
    public static boolean loginIsCorrect = false;

    public enum MENU {
        H, //Home
        T, //TimeCards
        L //Logout
        ;
    }

    public static void main(String[] args) throws InterruptedException, ParseException {
        WebDriver driver = new ChromeDriver();

        //set up variables
        String URL = "https://timeandexpense.teksystems.com/webtime/";
        String userName = "rustem75@mail.com";
        String password = "";
        //title for login page
        String LOGIN_TITLE = "Login";
        String TIMECARDS_TITLE = "Timecards";
        String HOME_TITLE = "Home";
        int GAP_DAYS = 2;


        //1. Navigate to the Login page and check if the title and the login correct
        driver.get(URL);
        if (new Title(driver).isCorrect(LOGIN_TITLE)) {
            //Login
            Login login = new Login(driver);
            login.setUserName(userName);
            login.setPassword(password);
            login.click();
            //Verify the title
            if (!new Title(driver).isCorrect(TIMECARDS_TITLE))
                new Alert(driver).showMessage("Incorrect page!", 5000);
        } else {
            new Alert(driver).showMessage("Incorrect page!", 5000);
        }

        //2. Navigate to the Home page and check if needed to submit a new card
        new Menu(driver).goTo('H');
        if (new Title(driver).isCorrect(HOME_TITLE)) {
            //get last time card date and status
            Home home = new Home(driver);
            if (!(DateCompare.needToSubmit((DateConvert.convertToDate(home.getLastTimeCardDate())), GAP_DAYS))) {
                //the alert for "if" doesn't work, throws an exception
                //new Alert(driver).showMessage("You don't need to submit a new time card!", 5000);
                showMessageDialog(null, "You don't need to submit a new time card!");
                //driver.quit();
            } else {
                //3. Navigate to the TimeCards page
                new Menu(driver).goTo('T');
                TimeCards timeCard = new TimeCards(driver);
                timeCard.printList();

            }

        }


        //driver.quit();
    }
}
