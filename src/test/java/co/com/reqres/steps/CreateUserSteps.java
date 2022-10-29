package co.com.reqres.steps;

import co.com.reqres.consequences.SeeThatCreateUser;
import co.com.reqres.models.createuser.UserModel;
import co.com.reqres.tasks.CreateUser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import static co.com.reqres.data.DataUser.correct;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CreateUserSteps {
    private UserModel data;

    @Given("que usuario {word} ingresa datos correctos de usuario")
    public void userSetData(String nameActor) {
        data = correct();
        theActorCalled(nameActor).wasAbleTo(
                CreateUser.with(data)
        );
    }

    @When("el puede registrar usuario en la pagina")
    public void heCanRegisterUserIntoPage() {
        theActorInTheSpotlight().should(
                SeeThatCreateUser.correctWith(data)
        );

    }
}
