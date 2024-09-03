package questions.herokuapp;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidateResponseValueQuestion implements Question {
    private String field;

    public ValidateResponseValueQuestion(String field) {
        this.field = field;
    }

    public static Question<String> answer(String field) {
        return new ValidateResponseValueQuestion(field);
    }

    @Override
    public Object answeredBy(Actor actor) {
        return SerenityRest.lastResponse().jsonPath().getString(field);
    }
}
