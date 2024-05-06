package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import static utility.BrowserDriver.driver;

public class ProductPage {

    //text
    public static String phones = "//a[contains(.,'Phones')]";
    public static String laptops = "//a[contains(.,'Laptops')]";
    public static String monitors = "//a[contains(.,'Monitors')]";
    public static String product_model = "card-title";
    public static String product_price = "//div[@class='card-block']//h5";
    public static String product_description = "p";
    public static String first_item = "//div[@class='col-lg-4 col-md-6 mb-4'][1]//a";
    public static String second_item = "//*[@id='tbodyid']//div[2]//div//div//h4//a";

    //image
    public static String carousel_slider = "carousel-inner";
    public static String product_image = "card-img-top";

    //buttons
    public static String cart = "//*[@id='cartur']";
    public static String add_to_cart_second_item = "//*[@id='tbodyid']//div[2]//div//a";
    public static String add_to_cart = "//a[text()='Add to cart']";

    //nav link
    public static String home = "//a[contains(.,'Home')]";

    public static void visibilityOfCategories() throws InterruptedException {
        Thread.sleep(3000);
        WebElement carousel = driver.findElement(By.className(carousel_slider));
        WebElement phonesCategory = carousel.findElement(By.xpath(phones));
        WebElement laptopsCategory = carousel.findElement(By.xpath(laptops));
        WebElement monitorsCategory = carousel.findElement(By.xpath(monitors));

        assert phonesCategory.isDisplayed();
        assert laptopsCategory.isDisplayed();
        assert monitorsCategory.isDisplayed();
    }

    public static void visibilityOfAvailableItems()
    {
        WebElement carouselSlider = driver.findElement(By.className(carousel_slider));

        // Get all categories in the carousel slider
        List<WebElement> categories = carouselSlider.findElements(By.className("carousel-item"));

        // Print the names of all categories
        for (WebElement category : categories) {
            System.out.println(category.getText());
        }
        // Locate the details of each item
        List<WebElement> items = driver.findElements(By.className("card"));

        // Print the details of each item
        for (WebElement item : items) {
            System.out.println("Image: " + item.findElement(By.className(product_image)).getAttribute("src"));
            System.out.println("Model: " + item.findElement(By.className(product_model)).getText());
            System.out.println("Price: " + item.findElement(By.xpath(product_price)).getText());
            System.out.println("Description: " + item.findElement(By.tagName(product_description)).getText());
            System.out.println("Available Items");
        }
    }

    public static void addItemsToCart() throws InterruptedException {
        Thread.sleep(3000);
        WebElement firstItem = driver.findElement(By.xpath(first_item));
        firstItem.click();
        Thread.sleep(3000);
        WebElement addToCartButton = driver.findElement(By.xpath(add_to_cart));
        addToCartButton.click();
        Thread.sleep(3000);

        // Accept the confirmation popup
        driver.switchTo().alert().accept();

        // Go back to the previous page
        driver.findElement(By.xpath(home)).click();
        Thread.sleep(3000);

        WebElement secondItem = driver.findElement(By.xpath(second_item));
        secondItem.click();
        Thread.sleep(3000);
        WebElement addToCartButtonItem2 = driver.findElement(By.xpath(add_to_cart_second_item));
        Thread.sleep(3000);
        addToCartButtonItem2.click();
        Thread.sleep(3000);

        // Accept the confirmation popup
        driver.switchTo().alert().accept();

    }

    public static void clickCartLink() throws InterruptedException
    {
        driver.findElement(By.xpath(cart)).click();
        Thread.sleep(2000);
    }
}

