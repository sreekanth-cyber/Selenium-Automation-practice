package StepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class StepDefinition {

    @Given("^user is on a landing page$")
    public void user_is_on_a_landing_page() throws Throwable {
        System.out.println("Navigated to landing page");
    }

    @When("^user login to the application by entering \"([^\"]*)\" and \"([^\"]*)\"$")
    public void user_login_to_the_application_by_entering_something_and_something(String strArg1, String strArg2) throws Throwable {
    	System.out.println("Navigated to Home page");
    	System.out.println(strArg1);
    	System.out.println(strArg2);
    }

    @Then("^Home page is displayed$")
    public void home_page_is_displayed() throws Throwable {
    	System.out.println("Validated the Home page");
    }

    @And("^usename displayed \"([^\"]*)\"$")
    public void usename_displayed_something(String strArg1) throws Throwable {
    	System.out.println(strArg1);
    }

}