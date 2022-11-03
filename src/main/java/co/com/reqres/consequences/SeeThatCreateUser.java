package co.com.reqres.consequences;

import co.com.reqres.models.createuser.UserModel;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.screenplay.Consequence;
import net.serenitybdd.screenplay.rest.questions.LastResponse;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.hamcrest.CoreMatchers.equalTo;

public class SeeThatCreateUser {
    private SeeThatCreateUser() {

    }

    public static Consequence[] correctWith(UserModel userModel) {
        return new Consequence[]{
                seeThat("status code",
                        response -> LastResponse.received().answeredBy(theActorInTheSpotlight()).getStatusCode(),
                        equalTo(SC_CREATED)),
                seeThat("schema user validation",
                        response -> LastResponse.received().answeredBy(theActorInTheSpotlight()).asString(),
                        JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/create_user.json")),
                seeThat("name value",
                        response -> LastResponse.received().answeredBy(theActorInTheSpotlight()).as(UserModel.class).getName(),
                        equalTo(userModel.getName())),
                seeThat("job value",
                        response -> LastResponse.received().answeredBy(theActorInTheSpotlight()).as(UserModel.class).getJob(),
                        equalTo(userModel.getJob()))
        };
    }

}
