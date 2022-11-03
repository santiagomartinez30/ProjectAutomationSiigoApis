package co.com.reqres.tasks;

import co.com.reqres.models.createuser.UserModel;
import io.restassured.http.ContentType;
import lombok.SneakyThrows;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Put;

import static co.com.reqres.enums.EndPoints.USER;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class UpdateUser implements Task {
    private final UserModel userModel;
    private final String id;

    public UpdateUser(UserModel userModel, String id) {
        this.userModel = userModel;
        this.id = id;
    }

    public static UpdateUser with(UserModel userModel, String id) {
        return instrumented(UpdateUser.class, userModel, id);
    }

    @Override
    @SneakyThrows
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Put.to(USER.resource())
                        .with(request -> request
                                .param(id)
                                .contentType(ContentType.JSON)
                                .body(userModel)
                        )
        );
    }

}
