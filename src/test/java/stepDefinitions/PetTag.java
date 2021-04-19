package stepDefinitions;

import DataObjects.World;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PetTag extends BaseDefinition {

    private final World world;

    public PetTag(World world) {
        this.world = world;
    }

    @Given("pet with tag name {string}")
    public void pet_with_tag_name(String tagName) {
        world.setTagName(tagName);
    }

    @When("GET request to {string}")
    public void get_request_to(String url) {
        this.setUrl(this.getUrl() + url + world.getTagName());
        Response response = given()
                .port(getPort())
                .when().get(this.getUrl());
        world.setResponse(response);
    }
}
