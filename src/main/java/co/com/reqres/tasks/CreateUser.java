package co.com.reqres.tasks;

import co.com.reqres.models.createuser.UserModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import lombok.SneakyThrows;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;
import org.apache.http.HttpHeaders;

import static co.com.reqres.enums.EndPoints.USER;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CreateUser implements Task {

    private final UserModel userModel;
    private final ObjectMapper objectMapper;

    public CreateUser(UserModel userModel) {
        this.userModel = userModel;
        this.objectMapper = new ObjectMapper();
    }

    public static CreateUser with(UserModel userModel) {
        return instrumented(CreateUser.class, userModel);
    }

    @Override
    @SneakyThrows
    public <T extends Actor> void performAs(T actor) {
        String json = objectMapper.writeValueAsString(userModel);
        actor.attemptsTo(
                Post.to(USER.resource())
                        .with(request -> request
                                .header(HttpHeaders.CONTENT_TYPE, ContentType.JSON)
                                .body(json)
                        )
        );
    }
}
