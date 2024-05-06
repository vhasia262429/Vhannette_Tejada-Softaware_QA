package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

import static pages.ProductPage.*;

public class ProductPage {

    @And("^user validates that the categories and available items is displayed$")
    public void user_validates_that_the_categories_and_available_items_is_displayed() throws InterruptedException {
        visibilityOfCategories();
        visibilityOfAvailableItems();
    }

    @When("^user add items to the cart$")
    public void user_adds_items_to_the_cart() throws InterruptedException {
        addItemsToCart();
    }
}
