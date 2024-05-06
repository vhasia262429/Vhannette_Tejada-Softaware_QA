package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import static org.junit.Assert.*;
import static utility.BrowserDriver.driver;

public class CartPage {

    //texts
    public static String cart_header = "//h2[contains(.,'Products')]";
    public static String items_model = "//td[2]";
    public static String items_price = "//td[3]";
    public static String items = "//tr[@class='success']";
    public static String total_price = "//h3[@class='panel-title']";

    //images
    public static String items_image = "//tr//td//img";

    //buttons
    public static String delete = "//td/a";
    public static String place_order = "//button[contains(.,'Place Order')]";
    public static String purchase = "//button[text()='Purchase']";

    //fields
    public static String name = "//*[@id='name']";
    public static String country = "//*[@id='country']";
    public static String city = "//*[@id='city']";
    public static String credit_card = "//*[@id='card']";
    public static String month = "//*[@id='month']";
    public static String year = "//*[@id='year']";

    //pop-up
    public static String purchase_success_message = "//h2[text()='Thank you for your purchase!']";

    public static void validatesItemsOnTheCart()
    {
        List<WebElement> cartItems = driver.findElements(By.xpath(items));
        assertTrue(cartItems.size() >= 2);

        for (WebElement item : cartItems) {
            WebElement image = item.findElement(By.xpath(items_image));
            WebElement model = item.findElement(By.xpath(items_model));
            WebElement price = item.findElement(By.xpath(items_price));
            WebElement deleteButton = item.findElement(By.xpath(delete));

            assertTrue(image.isDisplayed());
            assertTrue(model.isDisplayed());
            assertTrue(price.isDisplayed());
            assertTrue(deleteButton.isDisplayed()); }

        WebElement totalPrice = driver.findElement(By.xpath(total_price));
        assertTrue(totalPrice.isDisplayed());
    }

    public static void clickDeleteButton() throws InterruptedException
    {
        driver.findElement(By.xpath(delete)).click();
        Thread.sleep(5000);
    }

    public static void validateTotalPriceUpdated()
    {
        WebElement totalPrice = driver.findElement(By.xpath(total_price));
        assertNotNull(totalPrice);
        assertTrue(Double.parseDouble(totalPrice.getText()) < 1180);
    }

    public static void clickPlaceOrder() throws InterruptedException
    {
        driver.findElement(By.xpath(place_order)).click();
        Thread.sleep(3000);
    }

    public static void enterRequiredFields() throws InterruptedException
    {
        driver.findElement(By.xpath(name)).sendKeys("Tester");
        driver.findElement(By.xpath(country)).sendKeys("Philippines");
        driver.findElement(By.xpath(city)).sendKeys("Pililla");
        driver.findElement(By.xpath(credit_card)).sendKeys("01234567");
        driver.findElement(By.xpath(month)).sendKeys("May");
        driver.findElement(By.xpath(year)).sendKeys("2024");
    }

    public static void clickPurchase() throws InterruptedException
    {
        driver.findElement(By.xpath(purchase)).click();
        Thread.sleep(3000);
    }

    public static void validateSuccessPurchaseMessage()
    {
        WebElement thankYouPopup = driver.findElement(By.xpath(purchase_success_message));
        assertTrue("Thank You popup should be shown upon successful purchase", thankYouPopup.isDisplayed());
    }
}
