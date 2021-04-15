package stepDefinitions;

import DataObjects.PetData;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;

public class Pet extends BaseDefinition {

    private final PetData petData;
    private Response response;

    public Pet(PetData petData) {
        this.petData = petData;
        setUrl(getUrl() + "pet/");
    }

    @Given("user has an invalid pet id")
    public void user_has_an_invalid_pet_id() {
        petData.setId(-1);
    }

    @When("user makes a request to GET by id")
    public void user_makes_a_request_to_get_by_id() {
        String url = getUrl() + petData.getId();
        response = given()
                .port(getPort())
                .when().get(url);
    }

    @Then("response is not found")
    public void response_is() {
        response.then().statusCode(HttpStatus.SC_NOT_FOUND);
    }

    @Given("user has a valid pet id")
    public void user_has_a_valid_pet_id() {
        petData.setId(1);
    }

    @Then("response is success")
    public void response_is_success() {
        response.then().statusCode(HttpStatus.SC_OK);
    }
}
