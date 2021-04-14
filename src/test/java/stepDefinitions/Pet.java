package stepDefinitions;

import DataObjects.PetData;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Pet {

    private final PetData petData;
    private Response response;

    public Pet(PetData petData) {
        this.petData = petData;
    }

    @Given("user has an invalid pet id")
    public void user_has_an_invalid_pet_id() {
        petData.setId(-1);
    }

    @When("user makes a request to GET by id")
    public void user_makes_a_request_to_get_by_id() {
        response = given().port(80).when().get("localhost/api/v3/pet/" + petData.getId());
    }

    @Then("response is not found")
    public void response_is() {
        response.then().statusCode(404);
    }
}
