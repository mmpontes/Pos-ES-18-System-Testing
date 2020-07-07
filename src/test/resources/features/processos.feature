@System
Feature: CRUD Page Process

  Background: Creating a new process
    Given the process is on Agapito Server page
    And the user clicks on Process menu
    And the user clicks on new process button
    And the user fill "vara" with value equal "171"
    And the user fill "numero_processo" with value equal "121"
    And the user fill "natureza" with value equal "Veracity of Life"
    And the user fill "partes" with value equal "Death x Life"
    And the user selects "urgency" with value equal "Sim"
    And the user clicks on "arbitramento" with value equal "Não"
    And the user fill "arbitramento" with value equal "Não"
    And the user fill "assistente_social" with value equal "Catia"
    And the user fill "data_entrada" with value equal "2018-06-21"
    And the user fill "data_saida" with value equal "2018-10-21"
    And the user fill "data_agendamento" with value equal "2018-09-21"
    And the user fill "status" with value equal "Finished"
    And the user fill "observacao" with value equal "Life confirmed"
    When the user clicks on save button

  Scenario: Validating a new process
    Given the user should see "Processo foi criado com sucesso." into view process page

  Scenario Outline: Reading a process
    Given the user backs to the process grid
    When the user clicks on show button
    Then the user should see "vara" with value equal "<vVara>"
    And the user should see "numero" with value equal "<vNroProc>"
    And the user should see "partes" with value equal "<vPartes>"
    And the user should see "status" with value equal "<vStatus>"

    Examples:
      | vVara | vNroProc | vPartes      | vStatus  |
      | 171   | 121      | Death x Life | Finished |

  Scenario Outline: Updating a process
    Given the user backs to the process grid
    And the user clicks on edit button
    And the user edits and clicks "arbitramento" with value equal "<vArbitramento>"
    And the user must change "status" with value equal "<vStatus>"
    And the user must change "observacao" with value equal "<vObs>"
    And the user clicks on edit save button
    And the user backs to the process grid
    When the user clicks on show button
    Then the user should see "arbitramento" with value equal "S"
    And the user should see "status" with value equal "<vStatus>"
    And the user should see "observacao" with value equal "<vObs>"

    Examples:
      | vArbitramento | vStatus  | vObs                    |
      | Sim           | Waiting  | Checking life situation |
      | Sim           | Starting | Life situation          |
      | Sim           | Awake    | He died but he is well  |

  Scenario: Deleting a process
    Given the user backs to the process grid
    When the user clicks on delete button
    And the user confirms delete
    Then the user should not see last process code