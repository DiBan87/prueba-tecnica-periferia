package questions.herokuapp;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidateStatusQuestion implements Question {

    final private int status;

    public ValidateStatusQuestion(int status) {
        this.status = status;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return SerenityRest.lastResponse().statusCode() == status;
    }

    public static Question<Boolean> is(int status) {
        return new ValidateStatusQuestion(status);
    }
}
