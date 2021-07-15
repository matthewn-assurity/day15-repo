package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentSteps {
    private Response response;

    @When("I check the details of student {int}")
    public void i_check_the_details_of_student(Integer studentId) {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        RestAssured.baseURI = "https://it-foundations.app.ap.assurity.cloud/";
        RestAssured.defaultParser = Parser.JSON;
        response = RestAssured.get("people/" + studentId);
        System.out.println(response.asPrettyString());
    }
    @Then("I can see that their name is {string}")
    public void i_can_see_that_their_name_is(String fullName) {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(fullName, response.path("firstName") + " " + response.path("lastName"));
//        response.asPrettyString()

    }
    @Then("they have a {string} from {string}")
    public void they_have_a_from(String degree, String university) {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        assertEquals(degree, response.path("degree"));
        assertEquals(university, response.path("university"));
    }

}
