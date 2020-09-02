package TestSteps;

import TestPages.SearchPage;
import io.cucumber.java.en.Then;

public class SearchSteps {

    SearchPage searchPage = new SearchPage();

    @Then("I should see an error message")
    public void iShouldSeeAErrorMessage() throws Throwable {
        searchPage.validateSearchPage();
        searchPage.errorMessageResult();
    }

    @Then("I should see the expected result")
    public void iShouldSeeTheExpectedResult() throws Throwable {
        searchPage.validateSearchPage();
        searchPage.expectedResult();
    }

    @Then("I should see search suggestions")
    public void iShouldSeeSearchSuggestions() throws Throwable {
        searchPage.searchSugestions();
    }
}
