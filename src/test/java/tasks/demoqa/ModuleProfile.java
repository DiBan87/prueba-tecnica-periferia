package tasks.demoqa;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import ui.ModulesUi;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ModuleProfile implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(ModulesUi.MODULE_BOOK_STORE_APPLICATION, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(ModulesUi.MODULE_BOOK_STORE_APPLICATION),
                Click.on(ModulesUi.SUBMODULE_PROFILE)
        );
    }
    public static Performable enter(){return new ModuleProfile();}
}
