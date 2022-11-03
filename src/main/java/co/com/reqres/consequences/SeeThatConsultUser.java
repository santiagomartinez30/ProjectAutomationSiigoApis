package co.com.reqres.consequences;

import co.com.reqres.models.consultuser.UsersModel;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.screenplay.Consequence;
import net.serenitybdd.screenplay.rest.questions.LastResponse;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.apache.http.HttpStatus.SC_NOT_FOUND;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.CoreMatchers.*;

public class SeeThatConsultUser {
    private SeeThatConsultUser() {

    }

    public static Consequence[] correct(String idUser) {
        return new Consequence[]{
                seeThat("status code",
                        response -> LastResponse.received().answeredBy(theActorInTheSpotlight()).getStatusCode(),
                        equalTo(SC_OK)
                ),
                seeThat("schema user validation",
                        response -> LastResponse.received().answeredBy(theActorInTheSpotlight()).asString(),
                        JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/consult_users.json")),
                seeThat("id value",
                        response -> LastResponse.received().answeredBy(theActorInTheSpotlight()).as(UsersModel.class).getData().getId(),
                        equalTo(Integer.parseInt(idUser))
                )
        };
    }

    public static Consequence[] incorrect() {
        return new Consequence[]{
                seeThat("status code",
                        response -> LastResponse.received().answeredBy(theActorInTheSpotlight()).getStatusCode(),
                        equalTo(SC_NOT_FOUND)
                )
        };
    }
}
