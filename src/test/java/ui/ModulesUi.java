package ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ModulesUi {
    public static Target MODULE_ALERTS_FRAME_WINDOWS = Target.the("Modulo de Alerts, Frame y Windows").located(By.xpath("//div[@class='header-text'][contains(.,'Alerts, Frame & Windows')]"));
    public static Target SUBMODULE_ALERTS_FRAME_WINDOWS = Target.the("Sub Modulo de Nested Frames").located(By.xpath("//span[@class='text'][contains(.,'Nested Frames')]"));
    public static Target MODULE_FORMS = Target.the("Modulo de Forms").located(By.xpath("//div[@class='header-text'][contains(.,'Forms')]"));
    public static Target SUBMODULE_PRACTICE_FORM = Target.the("Submodulo Practice Form").located(By.xpath("//span[@class='text'][contains(.,'Practice Form')]"));
    public static Target MODULE_BOOK_STORE_APPLICATION = Target.the("Modulo Book Store Application").located(By.xpath("//div[@class='header-text'][contains(.,'Book Store Application')]"));
    public static Target SUBMODULE_PROFILE = Target.the("Submodulo Profile").located(By.xpath("//li[@class='btn btn-light '][contains(.,'Profile')]"));
}
