package stepdefinations;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actions.Open;
import questions.demoqa.LogInQuestion;
import questions.demoqa.MessageInvalidUser;
import tasks.demoqa.*;

import java.io.IOException;
import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class TestDemoQaStep {

    private String user;
    private String password;

    @Given("^el (.*) ingresa a la pagina Demo QA e ingresa las credenciales$")
    public void userEntersWebPage(String actor, DataTable dataTable) {
        theActorCalled(actor).attemptsTo(Open.browserOn().thePageNamed("pages.DemoQA"));

        Map<String, String> data = dataTable.asMaps().getFirst();
        user = data.get("User");
        password = data.get("Password");

        theActorInTheSpotlight().attemptsTo(
                LogIn.value(user, password)
        );
        theActorInTheSpotlight().should(
                seeThat("Inicio de Sesion", LogInQuestion.isTrue())
        );

    }

    @And("^extrae el texto de los cuadros del frame en Nested Frames$")
    public void extractsTextFromFramesOfNestedFrames() {
        theActorInTheSpotlight().attemptsTo(
                ModuleNastedFrame.enter(),
                TextNestedFrames.get()
        );
    }

    @And("^ingresa la informacion del modulo practice form$")
    public void enterInformationFromThePracticeFormModule() throws IOException {
        theActorInTheSpotlight().attemptsTo(
                ModulePracticeForm.enter(),
                PracticeForm.withExcel("src/test/resources/formulario.xlsx", "Hoja1")
        );
    }

    @Then("^ingresa al modulo Book Store Application$")
    public void enterTheBookStoreApplicationModule() {
        theActorInTheSpotlight().attemptsTo(
                ModuleProfile.enter()
        );
    }

    @And("elimina el usuario creado")
    public void deleteUser() {
        theActorInTheSpotlight().attemptsTo(DeleteAccount.confirm());
        theActorInTheSpotlight().attemptsTo(
                LogIn.value(user, password)
        );
        String menssage = "Invalid username or password!";
        theActorInTheSpotlight().should(
                seeThat("Mensaje de Usuario Invalido", MessageInvalidUser.text(), equalTo(menssage))
        );
    }
}
