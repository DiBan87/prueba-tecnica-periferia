package ui;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class ProfileUi {
    public static Target BUTTON_DELETE_ACCOUNT = Target.the("Boton Eliminar Cuenta").located(By.xpath("//button[@type='button'][contains(.,'Delete Account')]"));
    public static Target BUTTON_CONFIRM_DELETE_ACCOUNT = Target.the("Boton Confirmar Eliminar Cuenta").located(By.xpath("//button[@id='closeSmallModal-ok']"));

}
