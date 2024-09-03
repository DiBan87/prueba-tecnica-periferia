Feature: Realizar cálculos en la calculadora de android

  @Calculadora @Add
  Scenario: Sumar dos números en la calculadora
    Given el usuario suma dos numeros
    Then valida el resultado

  @Calculadora @Subtract
  Scenario: restar dos números en la calculadora
    When el usuario resta dos numeros
    Then valida el resultado

  @Calculadora @Multiply
  Scenario: multiplicar dos números en la calculadora
    When el usuario multiplica dos numeros
    Then valida el resultado