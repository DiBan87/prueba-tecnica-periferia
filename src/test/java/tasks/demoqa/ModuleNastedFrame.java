package tasks.demoqa;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import ui.ModulesUi;
import ui.NastedFrameUi;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ModuleNastedFrame implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(ModulesUi.MODULE_ALERTS_FRAME_WINDOWS),
                Scroll.to(ModulesUi.SUBMODULE_ALERTS_FRAME_WINDOWS),
                Click.on(ModulesUi.SUBMODULE_ALERTS_FRAME_WINDOWS),
                WaitUntil.the(NastedFrameUi.TITLE_NASTED_FRAME, isVisible()).forNoMoreThan(10).seconds()
        );
    }

    public static Performable enter() {
        return new ModuleNastedFrame();
    }
}
