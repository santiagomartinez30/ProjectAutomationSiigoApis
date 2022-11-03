package co.com.reqres.consequences;

import net.serenitybdd.screenplay.Consequence;
import net.serenitybdd.screenplay.rest.questions.LastResponse;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;


import static org.apache.http.HttpStatus.SC_NO_CONTENT;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.*;

public class SeeThatDeleteUser {
    private SeeThatDeleteUser() {

    }

    public static Consequence[] correct() {
        return new Consequence[]{
                seeThat("status code",
                        response -> LastResponse.received().answeredBy(theActorInTheSpotlight()).getStatusCode(),
                        equalTo(SC_NO_CONTENT)),
                seeThat("Body",
                        response -> LastResponse.received().answeredBy(theActorInTheSpotlight()).getBody().asString(), emptyString())
        };
    }
}
