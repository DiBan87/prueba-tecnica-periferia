package tasks.herokuapp;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetBooking implements Task {

    private final int bookingId;

    public GetBooking(int bookingId) {
        this.bookingId = bookingId;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        SerenityRest.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .get("/booking/" + bookingId);
    }

    public static GetBooking withId(int bookingId) {
        return instrumented(GetBooking.class, bookingId);
    }
}
