package ui;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class NastedFrameUi {

    public static Target TITLE_NASTED_FRAME = Target.the("Titulo Nasted Frame").located(By.xpath("//h1[@class='text-center'][contains(.,'Nested Frames')]"));
    public static Target PARENT_FRAME_TEXT = Target.the("Texto parent frame").located(By.xpath("//body"));
    public static Target CHILD_IFRAME_TEXT = Target.the("Texto child iframe").located(By.xpath("//p[contains(text(), 'Child Iframe')]"));
}
