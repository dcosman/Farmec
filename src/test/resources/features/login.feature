Feature: Login

  Scenario: Successfully login
    Given I open url"https://dev2.farmec.ro/autentificare.html"
    And I login with "testare1984@gmail.com"/"parola"
    And I should see an element with text "Contul meu"


  Scenario: Login with wrong password
    Given I open url"https://dev2.farmec.ro/autentificare.html"
    And I login with "testare1984@gmail.com"/"wrong password"
    And I should see an element with text "Adresă de email sau parolă incorectă"

  Scenario: Login with wrong email address
     Given I open url"https://dev2.farmec.ro/autentificare.html"
     And I login with "testare1984@gmail.com"/"wrong password"
     And I should see an element with text "Adresă de email sau parolă incorectă"

  Scenario: Login with empty email field
    Given I open url"https://dev2.farmec.ro/autentificare.html"
    And I login with ""/"parola"
    And I should see an element with text "Acest câmp este obligatoriu."

  Scenario: Login with empty password field
    Given I open url"https://dev2.farmec.ro/autentificare.html"
    And I login with "testare1985@gmail.com"/""
    And I should see an element with text "Acest câmp este obligatoriu."


