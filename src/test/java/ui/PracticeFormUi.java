package ui;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class PracticeFormUi {
    public static Target TITLE_PRACTICE_FORM = Target.the("Titulo Practice Form").located(By.xpath("//h1[@class='text-center'][contains(.,'Practice Form')]"));
    public static Target FIRST_NAME = Target.the("Primer Nombre").located(By.id("firstName"));
    public static Target LASTNAME = Target.the("Apellido").located(By.id("lastName"));
    public static Target EMAIL = Target.the("Email").located(By.id("userEmail"));
    public static Target GENDER = Target.the("Genero").locatedBy("//label[contains(.,'{0}')]");
    public static Target MOBILE = Target.the("Telefono").located(By.id("userNumber"));
    public static Target DATE_OF_BIRTH = Target.the("Fecha de Nacimiento").located(By.id("dateOfBirth"));
    public static Target SELECT_YEAR = Target.the("Seleccionar el año").located(By.xpath("//select[@class='react-datepicker__year-select']"));
    public static Target SELECT_MOUNTH = Target.the("Seleccionar el mes").located(By.xpath("//select[@class='react-datepicker__month-select']"));
    public static Target SELECT_DAY = Target.the("Seleccionar el dia").locatedBy("//div[@class='react-datepicker__week']/div[text()={0}]");
    public static Target SUBJECTS = Target.the("Materias").located(By.id("subjectsInput"));
    public static Target HOBBIES = Target.the("Hobbies").locatedBy("//label[contains(.,'{0}')]");
    public static Target PICTURE = Target.the("Pintura").located(By.id("uploadPicture"));
    public static Target CURRENT_ADDRESS = Target.the("Direccion Actual").located(By.xpath("//textarea[@placeholder='Current Address']"));
    public static Target STATE = Target.the("Estado").located(By.id("react-select-3-input"));
    public static Target CITY = Target.the("Ciudad").located(By.id("react-select-4-input"));
    public static Target BUTTON_SAVE = Target.the("Boton de Guardar").located(By.id("submit"));
    public static Target BUTTON_CLOSE = Target.the("Boton de Cerrar").located(By.id("closeLargeModal"));

}
