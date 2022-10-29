package co.com.reqres.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;

import static co.com.reqres.enums.EndPoints.USER;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DeleteUser implements Task {

    private final String id;

    public DeleteUser(String id) {
        this.id = id;
    }

    public static DeleteUser withId(String id) {
        return instrumented(DeleteUser.class, id);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Delete.from(USER.resource().concat(id))
        );
    }
}
