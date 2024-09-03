package tasks.calculator;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import ui.CalculatorUi;
import utils.ExcelReader;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Calculator implements Task {

    private final Map<String, String> datos;
    private final String operation;

    public Calculator(String filePath, String sheetName, String operation) throws IOException {
        this.operation = operation;
        this.datos = ExcelReader.leerDatosFormulario(filePath, sheetName);
    }

    public static Calculator withExcel(String filePath, String sheetName, String operation) throws IOException {
        return new Calculator(filePath, sheetName, operation);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        int result = 0;
        actor.attemptsTo(WaitUntil.the(CalculatorUi.BUTTON_ADD, isVisible()).forNoMoreThan(10).seconds());

        String[] digits = datos.get("First number").split("");
        for (String digit : digits) {
            actor.attemptsTo(Click.on(CalculatorUi.BUTTON_NUMBER.of(digit)));
        }

        if(Objects.equals(operation, "suma")) {
            actor.attemptsTo(Click.on(CalculatorUi.BUTTON_ADD));
            result = Integer.parseInt(datos.get("First number")) + Integer.parseInt(datos.get("Second number"));
        }
        else if(Objects.equals(operation, "resta")) {
            actor.attemptsTo(Click.on(CalculatorUi.BUTTON_SUBTRACT));
            result = Integer.parseInt(datos.get("First number")) - Integer.parseInt(datos.get("Second number"));
        }
        else if(Objects.equals(operation, "multiplica")) {
            actor.attemptsTo(Click.on(CalculatorUi.BUTTON_MULTIPLY));
            result = Integer.parseInt(datos.get("First number")) * Integer.parseInt(datos.get("Second number"));
        }

        digits = datos.get("Second number").split("");
        for (String digit : digits) {
            actor.attemptsTo(Click.on(CalculatorUi.BUTTON_NUMBER.of(digit)));
        }
        actor.attemptsTo(Click.on(CalculatorUi.BUTTON_RESULT));

        actor.remember("result", result);
    }
}
