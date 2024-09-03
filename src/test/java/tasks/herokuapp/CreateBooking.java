package tasks.herokuapp;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CreateBooking implements Task {
    private final String firstname;
    private final String lastname;
    private final int totalprice;
    private final boolean depositpaid;
    private final String checkin;
    private final String checkout;
    private final String additionalneeds;

    public CreateBooking(String firstname, String lastname, int totalprice, boolean depositpaid,
                         String checkin, String checkout, String additionalneeds) {
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
        Response response = SerenityRest.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .contentType(ContentType.JSON)
                .body(createRequestBody())
                .post("/booking");

        int bookingId = response.jsonPath().getInt("bookingid");
        actor.remember("bookingId", bookingId);

        String firstName = response.jsonPath().getString("booking.firstname");
        actor.remember("firstName", firstName);
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

    public static CreateBooking withDetails(String firstname, String lastname, int totalprice,
                                            boolean depositpaid, String checkin, String checkout, String additionalneeds) {
        return instrumented(CreateBooking.class, firstname, lastname, totalprice, depositpaid, checkin, checkout, additionalneeds);
    }
}
