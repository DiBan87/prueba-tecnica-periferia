package tasks.herokuapp;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DeleteBooking implements Task {

    private final int bookingId;
    private final String token;

    public DeleteBooking(int bookingId, String token) {
        this.bookingId = bookingId;
        this.token = token;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        if (token == null) {
            throw new IllegalStateException("El actor no tiene un token. Asegúrate de autenticarse primero.");
        }

        SerenityRest.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .contentType(ContentType.JSON)
                .cookie("token", token) // Incluir el token en la cabecera Cookie
                .delete("/booking/" + bookingId);
    }

    public static DeleteBooking withIdAndToken(int bookingId, String token) {
        return instrumented(DeleteBooking.class, bookingId, token);
    }
}
