package ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LogInUi {

    public static Target USER = Target.the("Usuario").located(By.id("userName"));
    public static Target PASSWORD = Target.the("Password").located(By.id("password"));
    public static Target BUTTON_LOGIN = Target.the("Boton LogIn").located(By.id("login"));
    public static Target BUTTON_NEW_USER = Target.the("Boton Nuevo Usuario").located(By.id("newUser"));
    public static Target BUTTON_LOGOUT = Target.the("Boton LogOut").located(By.xpath("//button[@type='button'][contains(.,'Log out')]"));
    public static Target MESSAGE_INVALID_USER = Target.the("Mensaje de Usuario Invalido").located(By.xpath("//p[@id='name']"));
}
