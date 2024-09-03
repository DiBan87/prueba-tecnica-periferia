Feature: Interactuar con la pagina web Demo QA

  @FrameAndForm
  Scenario: Validar los modulos Alerts, Frame & Windows, Practice Form  y Book Store Application
    Given el usuario ingresa a la pagina Demo QA e ingresa las credenciales
      | User   | Password  |
      | test02 | Test2023* |
    And extrae el texto de los cuadros del frame en Nested Frames
    And ingresa la informacion del modulo practice form
    Then ingresa al modulo Book Store Application
    And elimina el usuario creado