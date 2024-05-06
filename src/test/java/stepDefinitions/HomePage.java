package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static pages.HomePage.*;

public class HomePage {

    @Given("^user navigates to demo blaze home page$")
    public void user_navigates_to_demo_blaze_home_page() {
        visibilityHomePageElement();
    }

    @When("^user enters valid username and password$")
    public void user_enters_valid_username_and_password() throws InterruptedException {
        clickSignupLink();
        enterRandomUserName();
        enterValidPassword();
        clickSignup();
        clickOkPopup();
    }

    @Then("^user is signed in successfully$")
    public void user_is_signed_in_successfully() {
        visibilityHomePageElement();
    }

    @When("^user enters the sign in credentials$")
    public void user_enters_the_sign_in_credentials() {
        clickLogInLink();
        enterSignInUserName();
        enterSignInPassword();
        clickLogInUser();
    }

    @Then("^user is logged in successfully to the demo blaze web application$")
    public void user_is_logged_in_successfully_to_the_demo_blaze_web_application() {
        visibilityHomePageElement();
    }
}
