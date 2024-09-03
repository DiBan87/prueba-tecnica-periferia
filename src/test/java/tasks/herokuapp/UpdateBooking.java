package tasks.herokuapp;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.hamcrest.CoreMatchers.equalTo;

public class UpdateBooking implements Task {

    private final String token;
    private final int bookingId;
    private final String firstname;
    private final String lastname;
    private final int totalprice;
    private final boolean depositpaid;
    private final String checkin;
    private final String checkout;
    private final String additionalneeds;

    public UpdateBooking(String token, int bookingId, String firstname, String lastname, int totalprice,
                         boolean depositpaid, String checkin, String checkout, String additionalneeds) {
        this.token = token;
        this.bookingId = bookingId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totalprice;
        this.depositpaid = depositpaid;
        this.checkin = checkin;
        this.checkout = checkout;
        this.additionalneeds = additionalneeds;
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
                .body(createRequestBody())
                .put("/booking/" + bookingId);
    }

    private String createRequestBody() {
        return "{\n" +
                "    \"firstname\" : \"" + firstname + "\",\n" +
                "    \"lastname\" : \"" + lastname + "\",\n" +
                "    \"totalprice\" : " + totalprice + ",\n" +
                "    \"depositpaid\" : " + depositpaid + ",\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"" + checkin + "\",\n" +
                "        \"checkout\" : \"" + checkout + "\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"" + additionalneeds + "\"\n" +
                "}";
    }

    public static UpdateBooking withDetails(String token, int bookingId, String firstname, String lastname, int totalprice,
                                            boolean depositpaid, String checkin, String checkout, String additionalneeds) {
        return instrumented(UpdateBooking.class, token, bookingId, firstname, lastname, totalprice, depositpaid, checkin, checkout, additionalneeds);
    }
}
