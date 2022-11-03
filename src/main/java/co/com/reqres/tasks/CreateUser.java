package co.com.reqres.tasks;

import co.com.reqres.models.createuser.UserModel;
import io.restassured.http.ContentType;
import lombok.SneakyThrows;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static co.com.reqres.enums.EndPoints.USER;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CreateUser implements Task {

    private final UserModel userModel;

    public CreateUser(UserModel userModel) {
        this.userModel = userModel;
    }

    public static CreateUser with(UserModel userModel) {
        return instrumented(CreateUser.class, userModel);
    }

    @Override
    @SneakyThrows
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to(USER.resource())
                        .with(request -> request
                                .contentType(ContentType.JSON)
                                .body(userModel)
                        )
        );
    }
}
