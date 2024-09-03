package tasks.demoqa;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.waits.WaitUntil;

import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.ProfileUi;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class DeleteAccount implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(ProfileUi.BUTTON_DELETE_ACCOUNT, isVisible()).forNoMoreThan(10).seconds(),
                Scroll.to(ProfileUi.BUTTON_DELETE_ACCOUNT),
                Click.on(ProfileUi.BUTTON_DELETE_ACCOUNT),
                Click.on(ProfileUi.BUTTON_CONFIRM_DELETE_ACCOUNT),
                WaitUntil.the(ExpectedConditions.alertIsPresent()),
                Switch.toAlert().andAccept(),
                Switch.toDefaultContext()
        );
    }
    public static Performable confirm(){return new DeleteAccount();}
}
