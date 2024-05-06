package utility;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeOptions;



public class Hooks {

    public static BrowserDriver driver;

    @Before
    public void setUp() throws InterruptedException
    {
        Thread.sleep(2000);
        driver = new BrowserDriver();
    }

    @After
    public void tearDown()
    {
        driver.close();
    }
}

