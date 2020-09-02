package TestSteps;

import TestPages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class HomeSteps {

    HomePage homePage = new HomePage();

    @Given("I am at the GetNet Page")
    public void iAmAtTheGetNetPage() throws Throwable {
        homePage.validateHomePage();
    }

    @When("I click on the Search Field")
    public void iClickOnTheSearchField() throws Throwable {
        homePage.clickSearchButton();
    }

    @And("I fill the textbox with {string}")
    public void iFillTheTextboxWith(String string) throws Throwable {
        homePage.inputSearch(string);
    }

    @And("I click on the Search Button")
    public void iClickOnTheSearchButton() throws Throwable {
        homePage.clickSubmit();
    }
}
