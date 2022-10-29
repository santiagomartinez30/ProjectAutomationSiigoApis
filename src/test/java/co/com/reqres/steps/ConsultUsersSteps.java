package co.com.reqres.steps;

import co.com.reqres.consequences.SeeThatConsultUser;
import co.com.reqres.tasks.GetUser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ConsultUsersSteps {

    private String idUser;

    @Given("que usuario {word} consulta un usuario por id {word}")
    public void consultUserForId(String nameActor, String id) {
        idUser = id;
        theActorCalled(nameActor).wasAbleTo(
                GetUser.withData(idUser)
        );
    }

    @Then("el puede obtener información de usuario")
    public void obtainUserInformation() {
        theActorInTheSpotlight().should(
                SeeThatConsultUser.correct(idUser)
        );
    }

    @Then("el no puede obtener información de usuario")
    public void canNotobtainUserInformation() {
        theActorInTheSpotlight().should(
                SeeThatConsultUser.incorrect()
        );
    }
}
