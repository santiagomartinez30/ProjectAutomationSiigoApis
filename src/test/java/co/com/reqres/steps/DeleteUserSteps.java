package co.com.reqres.steps;

import co.com.reqres.consequences.SeeThatDeleteUser;
import co.com.reqres.tasks.DeleteUser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class DeleteUserSteps {
    @Given("que usuario {word} elimina correctamente datos del usuario con id {word}")
    public void eliminateUser(String nameActor, String id) {
        theActorCalled(nameActor).wasAbleTo(
                DeleteUser.withId(id)
        );
    }

    @Then("el puede confirmar la eliminación del usuario")
    public void heCanConfirmUserEliminated() {
        theActorInTheSpotlight().should(
                SeeThatDeleteUser.correct()
        );
    }
}
