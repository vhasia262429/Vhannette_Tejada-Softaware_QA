package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static pages.CartPage.*;
import static pages.ProductPage.*;

public class CartPage {

    @And("^user clicks the cart link$")
    public void user_clicks_the_cart_link() throws InterruptedException {
        clickCartLink();
    }

    @Then("^user validates that the cart contains two items$")
    public void user_validates_that_the_cart_contains_two_items() {
        validatesItemsOnTheCart();
    }

    @When("^user remove one item in the cart$")
    public void user_remove_one_item_in_the_cart() throws InterruptedException {
        clickDeleteButton();
    }

    @Then("^user validates that a confirmation pop up is displayed and the total price is updated$")
    public void user_validates_that_a_confirmation_pop_up_is_displayed_and_the_total_price_is_updated() {
        validateTotalPriceUpdated();
    }

    @When("^user clicks the place order button$")
    public void user_clicks_the_place_order_button() throws InterruptedException {
        clickPlaceOrder();
    }

    @And("^user enters the required fields and optional fields$")
    public void user_enters_the_required_fields_and_optional_fields() throws InterruptedException {
        enterRequiredFields();
    }

    @And("^user clicks purchase button$")
    public void user_clicks_purchase_button() throws InterruptedException {
        clickPurchase();
    }

    @Then("user validates that a pop up is displayed for a successful purchase$")
    public void user_validates_that_a_pop_up_is_displayed_for_a_successful_purchase() {
        validateSuccessPurchaseMessage();
    }
}
