package com.mavenit.selenium.training.step_defination;


import com.mavenit.selenium.training.driver.DriverManager;
import com.mavenit.selenium.training.page_objects.HomePage;
import com.mavenit.selenium.training.page_objects.ResultsPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringEndsWith.endsWith;

public class SearchSteps {
    private DriverManager driverManager=new DriverManager();

    private HomePage homePage = new HomePage();

    private ResultsPage resultsPage=new ResultsPage();


    @Given("^I am on homepage$")
    public void onHomepage()  {
        // Write code here that turns the phrase above into concrete actions
       String actual= homePage.getCurrentUrl();
       assertThat(actual, is(endsWith("/gbuk/index.html") ));

    }

    @When("^I search for \"([^\"]*)\"$")
    public void searchItem(String arg1)  {
        homePage.search("laptop");
    }

    @Then("^I should be able to see the respective products$")
    public void relatedProducts() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I should be able to see the respective product$")
    public void iShouldBeAbleToSeeTheRespectiveProduct() {
    }
}
