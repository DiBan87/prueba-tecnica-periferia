package tasks.herokuapp;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CreateToken implements Task{
    private final String username;
    private final String password;

    public CreateToken(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Response response = SerenityRest.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .contentType(ContentType.JSON)
                .body("{\"username\" : \"" + username + "\", \"password\" : \"" + password + "\"}")
                .post("/auth");

        String token = response.jsonPath().getString("token");
        actor.remember("token", token);
    }

    public static Performable withCredentials(String username, String password) {
        return instrumented(CreateToken.class, username, password);
    }

}
