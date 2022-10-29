package co.com.reqres.steps;

import co.com.reqres.consequences.SeeThatUpdatedUser;
import co.com.reqres.data.DataUser;
import co.com.reqres.models.createuser.UserModel;
import co.com.reqres.tasks.UpdateUser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static co.com.reqres.data.DataUser.correct;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class UpdateUserSteps {

    private UserModel data;

    @Given("que usuario {word} modifica correctamente datos del usuario con id {word}")
    public void userRegisterClientWithCorrectData(String nameActor, String id) {
        data = correct();
        theActorCalled(nameActor).wasAbleTo(
                UpdateUser.with(data, id)
        );
    }

    @Then("el puede actualizar la información del usuario")
    public void heCanUpdateUserInformation() {
        theActorInTheSpotlight().should(
                SeeThatUpdatedUser.correctWith(data)
        );
    }
}
