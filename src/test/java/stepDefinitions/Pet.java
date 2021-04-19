package stepDefinitions;

import DataObjects.World;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;

public class Pet extends BaseDefinition {

    private final World world;

    public Pet(World world) {
        this.world = world;
        setUrl(getUrl() + "pet/");
    }

    @Given("user has an invalid pet id")
    public void user_has_an_invalid_pet_id() {
        world.setId(-1);
    }

    @When("user makes a request to GET by id")
    public void user_makes_a_request_to_get_by_id() {
        String url = getUrl() + world.getId();
        Response response = given()
                .port(getPort())
                .when().get(url);

        world.setResponse(response);
    }

    @Then("response is not found")
    public void response_is() {
        world.getResponse().then().statusCode(HttpStatus.SC_NOT_FOUND);
    }

    @Given("user has a valid pet id")
    public void user_has_a_valid_pet_id() {
        world.setId(1);
    }

    @Then("response is success")
    public void response_is_success() {
        world.getResponse().then().statusCode(HttpStatus.SC_OK);
    }
}
