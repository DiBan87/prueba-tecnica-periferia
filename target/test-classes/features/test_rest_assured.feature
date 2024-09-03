Feature: Consumir los servicios de herokuapp utilizando rest assured

  @restfulBooker @CreateToken
  Scenario: Consumir el servicio CreateToken
    Given se consume el servicio CreateToken

  @restfulBooker @CreateBooking
  Scenario: Consumir el servicio CreateBooking
    Given se consume el servicio CreateBooking
      | firstname | lastname  | totalprice | depositpaid | checkin    | checkout   | additionalneeds |
      | Pedro     | Gutierrez | 100        | true        | 2024-03-01 | 2024-04-01 | Comics          |
      | Javier    | Jaramillo | 356        | true        | 2024-03-15 | 2024-04-15 | Terror          |

  @restfulBooker @GetBooking
  Scenario: Consumir el servicio GetBooking
    Given se consume el servicio CreateBooking
      | firstname | lastname  | totalprice | depositpaid | checkin    | checkout   | additionalneeds |
      | Pedro     | Gutierrez | 100        | true        | 2024-03-01 | 2024-04-01 | Comics          |
      | Javier    | Jaramillo | 356        | true        | 2024-03-15 | 2024-04-15 | Terror          |
    Then se consume el servicio GetBooking

  @restfulBooker @UpdateBooking
  Scenario: Consumir el servicio UpdateCooking
    Given se consume el servicio CreateToken
    And se consume el servicio CreateBooking
      | firstname | lastname  | totalprice | depositpaid | checkin    | checkout   | additionalneeds |
      | Pedro     | Gutierrez | 100        | true        | 2024-03-01 | 2024-04-01 | Comics          |
      | Javier    | Jaramillo | 356        | true        | 2024-03-15 | 2024-04-15 | Terror          |
    Then se consume el servicio UpdateBooking
      | firstname | lastname  | totalprice | depositpaid | checkin    | checkout   | additionalneeds |
      | Jose      | Gutierrez | 100        | true        | 2023-05-12 | 2023-06-28 | Comics          |
      | Javier    | Mora      | 356        | true        | 2023-06-20 | 2023-07-20 | Terror          |

  @restfulBooker @DeleteBooking
  Scenario: Consumir el servicio DeleteCooking
    Given se consume el servicio CreateToken
    And se consume el servicio CreateBooking
      | firstname | lastname  | totalprice | depositpaid | checkin    | checkout   | additionalneeds |
      | Pedro     | Gutierrez | 100        | true        | 2024-03-01 | 2024-04-01 | Comics          |
      | Javier    | Jaramillo | 356        | true        | 2024-03-15 | 2024-04-15 | Terror          |
    Then se consume el servicio DeleteBooking