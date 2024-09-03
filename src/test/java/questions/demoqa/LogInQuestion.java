package questions.demoqa;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import ui.LogInUi;

import java.time.Duration;


public class LogInQuestion implements Question {

    @Override
    public Object answeredBy(Actor actor) {
        return LogInUi.BUTTON_LOGOUT.waitingForNoMoreThan(Duration.ofSeconds(10)).resolveFor(actor).isVisible();
    }
    public static Question<Boolean> isTrue(){return new LogInQuestion();}
}
