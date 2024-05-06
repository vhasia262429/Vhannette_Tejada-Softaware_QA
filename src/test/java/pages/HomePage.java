package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.TestUtils;
import java.time.Duration;
import static utility.BrowserDriver.driver;

public class HomePage {

    static String registeredUsername;

    //text
    public static String categories = "//*[@id='cat']";

    //fields
    public static String username_signup = "//*[@id='sign-username']";
    public static String password_signup = "//*[@id='sign-password']";
    public static String username_login = "//*[@id='loginusername']";
    public static String password_login = "//*[@id='loginpassword']";

    //buttons
    public static String sign_up_user = "//button[contains(.,'Sign up')]";
    public static String login_user = "//button[@onclick='logIn()']";

    //nav link
    public static String sign_up1 = "//*[@id='signin2']";
    public static String login1 = "//*[@id='login2']";

    public static void visibilityHomePageElement()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(categories)));
    }

    public static void clickSignupLink()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement sign_up_nav_link = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sign_up1)));
        sign_up_nav_link.click();
    }

    public static void enterRandomUserName()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        registeredUsername = TestUtils.generateRandomUsername(10);
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(username_signup)));
        usernameField.sendKeys(registeredUsername);
    }

    public static void enterValidPassword()
    {
        driver.findElement(By.xpath(password_signup)).sendKeys("secret_password");
    }

    public static void clickSignup()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement signUp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sign_up_user)));
        signUp.click();
    }

    public static void clickOkPopup() throws InterruptedException {
        Thread.sleep(5000);
        driver.switchTo().alert().accept();
    }

    public static void clickLogInLink()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement login_nav_link = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login1)));
        login_nav_link.click();
    }

    public static void enterSignInUserName()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        if (registeredUsername != null && !registeredUsername.isEmpty()) {
            WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(username_login)));
            usernameField.sendKeys(registeredUsername);
        } else {
            System.out.println("Registered username is null or empty. Cannot proceed with login.");
        }
    }

    public static void enterSignInPassword()
    {
        driver.findElement(By.xpath(password_login)).sendKeys("secret_password");
    }

    public static void clickLogInUser()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement login = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login_user)));
        login.click();
    }
}
