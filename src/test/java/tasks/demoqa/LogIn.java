package tasks.demoqa;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import ui.LogInUi;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class LogIn implements Task {

    private final String user;
    private final String password;

    public LogIn(String user, String password){
        this.user = user;
        this.password = password;
    }

    public static Performable value(String user, String password){
        return instrumented(LogIn.class, user, password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(LogInUi.USER, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(user).into(LogInUi.USER),
                Enter.theValue(password).into(LogInUi.PASSWORD),
                Click.on(LogInUi.BUTTON_LOGIN)
        );
    }
}
