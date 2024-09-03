package tasks.demoqa;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.model.util.FileSystemUtils;
import org.openqa.selenium.Keys;
import ui.PracticeFormUi;
import utils.ExcelReader;

import java.io.IOException;
import java.util.Map;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class PracticeForm implements Task {

    private final Map<String, String> datos;

    public PracticeForm(String filePath, String sheetName) throws IOException {
        this.datos = ExcelReader.leerDatosFormulario(filePath, sheetName);
    }

    public static PracticeForm withExcel(String filePath, String sheetName) throws IOException {
        return new PracticeForm(filePath, sheetName);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(PracticeFormUi.TITLE_PRACTICE_FORM, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(datos.get("First Name")).into(PracticeFormUi.FIRST_NAME),
                Enter.theValue(datos.get("Last Name")).into(PracticeFormUi.LASTNAME),
                Enter.theValue(datos.get("Email")).into(PracticeFormUi.EMAIL),
                Scroll.to(PracticeFormUi.GENDER.of(datos.get("Gender"))).andAlignToTop(),
                Click.on(PracticeFormUi.GENDER.of(datos.get("Gender"))),
                Enter.theValue(datos.get("Mobile")).into(PracticeFormUi.MOBILE)
        );
        String[] partesFecha = datos.get("Date of Birth").split(" ");
        String dia = partesFecha[0];
        String mes = partesFecha[1];
        String anio = partesFecha[2];

        actor.attemptsTo(
                Click.on(PracticeFormUi.DATE_OF_BIRTH),
                Click.on(PracticeFormUi.DATE_OF_BIRTH),
                SelectFromOptions.byValue(anio).from(PracticeFormUi.SELECT_YEAR),
                SelectFromOptions.byVisibleText(mes).from(PracticeFormUi.SELECT_MOUNTH),
                Click.on(PracticeFormUi.SELECT_DAY.of(dia))
        );

        String imagePath = FileSystemUtils.getResourceAsFile("gatico.jpg").getAbsolutePath();
        actor.attemptsTo(
                Enter.theValue(datos.get("Subjects")).into(PracticeFormUi.SUBJECTS).thenHit(Keys.ENTER),
                Click.on(PracticeFormUi.HOBBIES.of(datos.get("Hobbies"))),
                Enter.theValue(imagePath).into(PracticeFormUi.PICTURE),
                Enter.theValue(datos.get("Current Address")).into(PracticeFormUi.CURRENT_ADDRESS),
                Enter.theValue(datos.get("State")).into(PracticeFormUi.STATE).thenHit(Keys.ENTER),
                Enter.theValue(datos.get("City")).into(PracticeFormUi.CITY).thenHit(Keys.ENTER),
                Scroll.to(PracticeFormUi.BUTTON_SAVE),
                Click.on(PracticeFormUi.BUTTON_SAVE),
                Scroll.to(PracticeFormUi.BUTTON_CLOSE),
                Click.on(PracticeFormUi.BUTTON_CLOSE)
        );
    }
}
