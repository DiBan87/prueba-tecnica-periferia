package stepdefinations;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.Actor;

import questions.herokuapp.ValidateResponseValueQuestion;
import questions.herokuapp.ValidateStatusQuestion;
import tasks.herokuapp.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

public class SerenityTestRestStep {

    private final List<Integer> bookingIds = new ArrayList<>();
    private final List<String> recallFirstName = new ArrayList<>();
    private String token;

    @Given("^se consume el servicio CreateToken$")
    public void createTokenServiceIsConsumed() {
        Actor admin = Actor.named("admin");

        admin.attemptsTo(
                CreateToken.withCredentials("admin", "password123")
        );
        admin.should(
                seeThat("Validar el Status 200 ", ValidateStatusQuestion.is(200)),
                seeThat("Validar el token ", ValidateResponseValueQuestion.answer("token"), notNullValue())
        );

        token = admin.recall("token");
    }

    @Given("^se consume el servicio CreateBooking$")
    public void createBookingServiceIsConsumed(DataTable dataTable) {
        Actor admin = Actor.named("admin");
        List<Map<String, String>> accountDataList = dataTable.asMaps();

        for (Map<String, String> accountData : accountDataList) {
            System.out.println("Detalles del token EN CREATEBOOKING: " + admin.recall("token"));
            String firstName = accountData.get("firstname");
            String lastName = accountData.get("lastname");
            int totalPrice = Integer.parseInt(accountData.get("totalprice"));
            boolean depositPaid = Boolean.parseBoolean(accountData.get("depositpaid"));
            String checkIn = accountData.get("checkin");
            String checkOut = accountData.get("checkout");
            String additionalNeeds = accountData.get("additionalneeds");

            admin.attemptsTo(
                    CreateBooking.withDetails(firstName, lastName, totalPrice, depositPaid, checkIn, checkOut, additionalNeeds)
            );

            admin.should(
                    seeThat("Validar el Status 200 ", ValidateStatusQuestion.is(200)),
                    seeThat("Validar el primer nombre ", ValidateResponseValueQuestion.answer("booking.firstname"), equalTo(firstName)),
                    seeThat("Validar el bookingId ", ValidateResponseValueQuestion.answer("bookingid"), notNullValue())
            );

            bookingIds.add(admin.recall("bookingId"));
            recallFirstName.add(admin.recall("firstName"));
        }
    }

    @Given("^se consume el servicio GetBooking$")
    public void getBookingServiceIsConsumed() {
        Actor admin = Actor.named("admin");
        for (int i = 0; i < bookingIds.size(); i++) {
            admin.attemptsTo(
                    GetBooking.withId(bookingIds.get(i))
            );

            admin.should(
                    seeThat("Validar el Status 200 ", ValidateStatusQuestion.is(200)),
                    seeThat("Validar el primer nombre ", ValidateResponseValueQuestion.answer("firstname"), equalTo(recallFirstName.get(i)))
            );
        }
    }

    @Then("^se consume el servicio UpdateBooking$")
    public void updateBookingServiceIsConsumed(DataTable dataTable) {
        Actor admin = Actor.named("admin");
        int count = 0;
        List<Map<String, String>> accountDataList = dataTable.asMaps();

        for (Map<String, String> accountData : accountDataList) {
            System.out.println("Detalles del bookingId EN UPDATE: " + bookingIds.get(count));
            int bookingId = bookingIds.get(count);
            String firstName = accountData.get("firstname");
            String lastName = accountData.get("lastname");
            int totalPrice = Integer.parseInt(accountData.get("totalprice"));
            boolean depositPaid = Boolean.parseBoolean(accountData.get("depositpaid"));
            String checkIn = accountData.get("checkin");
            String checkOut = accountData.get("checkout");
            String additionalNeeds = accountData.get("additionalneeds");

            admin.attemptsTo(
                    UpdateBooking.withDetails(token, bookingId, firstName, lastName, totalPrice, depositPaid, checkIn, checkOut, additionalNeeds)
            );

            admin.should(
                    seeThat("Validar el Status 200 ", ValidateStatusQuestion.is(200)),
                    seeThat("Validar el primer nombre ", ValidateResponseValueQuestion.answer("firstname"), equalTo(firstName))
            );

            count++;
        }
    }

    @Then("^se consume el servicio DeleteBooking$")
    public void deleteBookingServiceIsConsumed() {
        Actor admin = Actor.named("admin");
        for (int bookingId : bookingIds) {
            admin.attemptsTo(
                    DeleteBooking.withIdAndToken(bookingId, token)
            );

            admin.should(
                    seeThat("Validar el Status 200 ", ValidateStatusQuestion.is(201))
            );
        }
    }
}
