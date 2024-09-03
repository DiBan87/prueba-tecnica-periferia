package questions.demoqa;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;
import ui.LogInUi;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class MessageInvalidUser implements Question {
    @Override
    public Object answeredBy(Actor actor) {
        actor.attemptsTo(WaitUntil.the(LogInUi.MESSAGE_INVALID_USER, isVisible()).forNoMoreThan(10).seconds());
        return LogInUi.MESSAGE_INVALID_USER.resolveFor(actor).getText();
    }

    public static Question<String> text(){return new MessageInvalidUser();}
}
