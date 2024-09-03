package stepdefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import questions.calculator.Result;
import tasks.calculator.Calculator;

import java.io.IOException;


import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class CalculatorAndriodStep {

    private int result;

    @Given("^el (.*) (.*) dos numeros$")
    public void el_usuario_suma(String actor, String operation) throws IOException {
        theActorCalled(actor).attemptsTo(
                Calculator.withExcel("src/test/resources/calculadora.xlsx", "Hoja1", operation)
        );
        result = theActorInTheSpotlight().recall("result");
    }

    @Then("^valida el resultado$")
    public void el_resultado_debe_ser() {
        theActorInTheSpotlight().should(
                seeThat("Resultado operacion", Result.withValue(), equalTo(result))
        );
    }
}
