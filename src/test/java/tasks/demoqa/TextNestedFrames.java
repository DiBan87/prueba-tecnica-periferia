package tasks.demoqa;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.ensure.Ensure;
import ui.NastedFrameUi;

public class TextNestedFrames implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Switch.toFrame("frame1"));
        String parentFrameText = NastedFrameUi.PARENT_FRAME_TEXT.resolveFor(actor).getText();
        actor.attemptsTo(Switch.toFrame(0));
        String childFrameText = NastedFrameUi.CHILD_IFRAME_TEXT.resolveFor(actor).getText();

        actor.attemptsTo(
                Ensure.that(parentFrameText).isEqualTo("Parent frame"),
                Ensure.that(childFrameText).isEqualTo("Child Iframe")
        );
        actor.attemptsTo(Switch.toDefaultContext());
    }

    public static Performable get() {
        return new TextNestedFrames();
    }
}
