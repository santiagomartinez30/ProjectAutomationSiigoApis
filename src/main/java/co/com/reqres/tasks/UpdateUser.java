package co.com.reqres.tasks;

import co.com.reqres.models.createuser.UserModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import lombok.SneakyThrows;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Put;

import static co.com.reqres.enums.EndPoints.USER;
import static com.google.common.net.HttpHeaders.CONTENT_TYPE;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class UpdateUser implements Task {

    private final ObjectMapper objectMapper;
    private final UserModel userModel;
    private final String id;

    public UpdateUser(UserModel userModel, String id) {
        this.objectMapper = new ObjectMapper();
        this.userModel = userModel;
        this.id = id;
    }

    public static UpdateUser with(UserModel userModel, String id) {
        return instrumented(UpdateUser.class, userModel, id);
    }

    @Override
    @SneakyThrows
    public <T extends Actor> void performAs(T actor) {
        String json = objectMapper.writeValueAsString(userModel);
        actor.attemptsTo(
                Put.to(USER.resource().concat(id))
                        .with(request -> request
                                .header(CONTENT_TYPE, ContentType.JSON)
                                .body(json)
                        )
        );
    }

}
