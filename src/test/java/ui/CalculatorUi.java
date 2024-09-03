package ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CalculatorUi {
    public static Target BUTTON_ADD = Target.the("Boton de Sumar")
            .located(By.xpath("//android.widget.Button[@content-desc=\"Más\"]"));
    public static Target BUTTON_SUBTRACT = Target.the("Boton de Restar")
            .located(By.xpath("//android.widget.Button[@content-desc=\"Menos\"]"));
    public static Target BUTTON_MULTIPLY = Target.the("Boton de Multiplicar")
            .located(By.xpath("//android.widget.Button[@content-desc=\"Multiplicación\"]"));
    public static Target BUTTON_RESULT = Target.the("Boton de Resultado")
            .located(By.xpath("//android.widget.Button[@content-desc=\"Cálculo\"]"));
    public static Target BUTTON_NUMBER = Target.the("Boton de Numero")
            .locatedBy("//android.widget.Button[@content-desc=\"{0}\"]");
    public static Target RESULT = Target.the("Resultado")
            .locatedBy("//android.widget.EditText[@resource-id=\"com.sec.android.app.popupcalculator:id/calc_edt_formula\"]");

}
