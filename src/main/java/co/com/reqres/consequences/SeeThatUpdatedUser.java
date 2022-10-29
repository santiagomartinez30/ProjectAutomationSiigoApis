package co.com.reqres.consequences;

import co.com.reqres.models.createuser.UserModel;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.screenplay.Consequence;
import net.serenitybdd.screenplay.rest.questions.LastResponse;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class SeeThatUpdatedUser {
    private SeeThatUpdatedUser() {

    }

    public static Consequence[] correctWith(UserModel usersModel) {
        return new Consequence[]{
                seeThat("status code",
                        response -> LastResponse.received().answeredBy(theActorInTheSpotlight()).getStatusCode(),
                        equalTo(200)),
                seeThat("schema user validation",
                        response -> LastResponse.received().answeredBy(theActorInTheSpotlight()).asString(),
                        JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/update_user.json")),
                seeThat("name value",
                        response -> LastResponse.received().answeredBy(theActorInTheSpotlight()).as(UserModel.class).getName(),
                        equalTo(usersModel.getName()))
        };
    }
}
