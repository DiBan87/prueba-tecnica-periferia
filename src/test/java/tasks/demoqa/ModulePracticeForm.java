package tasks.demoqa;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import ui.ModulesUi;

public class ModulePracticeForm implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(ModulesUi.MODULE_FORMS),
                Click.on(ModulesUi.SUBMODULE_PRACTICE_FORM)
        );
    }

    public static Performable enter(){return new ModulePracticeForm();}
}
