package questions.calculator;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import ui.CalculatorUi;

public class Result implements Question {
    @Override
    public Object answeredBy(Actor actor) {
        String[] text = CalculatorUi.RESULT.resolveFor(actor).getText().split(" ");
        return Integer.parseInt(text[0].replace(".", ""));
    }

    public static Question<Integer> withValue(){return new Result();}
}
