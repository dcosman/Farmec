@screen
Feature: Checkout


  Scenario: Checkout
      Given I open url"https://dev2.farmec.ro/autentificare.html"
      And I login with "testare1984@gmail.com"/"parola"
      And I click on element with text "Produse noi"
      And I click on link with text "Balsam hidratant"
      And I click on link with text "Adaugă în coş"
      And I click on button with text "Finalizează comanda acum "
      And I click on  button2 with text "Finalizează comanda "
      And I click on link with text "Continuare"
      And I wait 1 seconds
      And I click on link with text "Continuare"
      And I click on label "Online cu card bancar"
      And I click on link with text "Continuare"
      And I click on label "Sunt de acord şi am luat la cunoştinţă "
      And I click on link with text "Finalizează comanda"
      And I fill in credit card information

  Scenario: Checkout with cash courier
     Given I open url"https://dev2.farmec.ro/autentificare.html"
     And I login with "testare1984@gmail.com"/"parola"
     And I click on element with text "Produse noi"
     And I click on link with text "Mască regenerantă"
     And I click on link with text "Adaugă în coş"
     And I click on button with text "Finalizează comanda acum "
     And I click on  button2 with text "Finalizează comanda "
     And I click on link with text "Continuare"
     And I wait 1 seconds
     And I click on link with text "Continuare"
     And I click on label "Ramburs prin curier"
     And I click on link with text "Continuare"
     And I click on label "Sunt de acord şi am luat la cunoştinţă "
     And I click on link with text "Finalizează comanda"
     And I should see an element with text "Finalizare comandă"


  Scenario: Checkout with paymet order
    Given I open url"https://dev2.farmec.ro/autentificare.html"
    And I login with "testare1984@gmail.com"/"parola"
    And I click on element with text "Produse noi"
    And I click on link with text "Mască regenerantă"
    And I click on link with text "Adaugă în coş"
    And I click on button with text "Finalizează comanda acum "
    And I click on  button2 with text "Finalizează comanda "
    And I click on link with text "Continuare"
    And I wait 1 seconds
    And I click on link with text "Continuare"
    And I click on label "Ordin de plată"
    And I click on link with text "Continuare"
    And I click on label "Sunt de acord şi am luat la cunoştinţă "
    And I click on link with text "Finalizează comanda"
    And I should see an element with text "Finalizare comandă"


  Scenario: Checkout without login when the user enter on the web site
    Given I open url"https://dev2.farmec.ro/"
    And I click on element with text "Produse noi"
    And I click on link with text "Cremă corp pentru piele uscată"
    And I click on link with text "Adaugă în coş"
    And I click on button with text "Finalizează comanda acum "
    And I click on  button2 with text "Finalizează comanda "
    And I login with "testare1984@gmail.com"/"parola"
    And I click on link with text "Continuare"
    And I wait 1 seconds
    And I click on link with text "Continuare"
    And I click on label "Ramburs prin curier"
    And I click on link with text "Continuare"
    And I click on label "Sunt de acord şi am luat la cunoştinţă "
    And I click on link with text "Finalizează comanda"
    And I should see an element with text "Finalizare comandă"
    And I wait 40 seconds

  Scenario: Checkout with card number wrong
    Given I open url"https://dev2.farmec.ro/autentificare.html"
    And I login with "testare1984@gmail.com"/"parola"
    And I click on element with text "Produse noi"
    And I click on link with text "Balsam hidratant"
    And I click on link with text "Adaugă în coş"
    And I click on button with text "Finalizează comanda acum "
    And I click on  button2 with text "Finalizează comanda "
    And I click on link with text "Continuare"
    And I wait 1 seconds
    And I click on link with text "Continuare"
    And I click on label "Online cu card bancar"
    And I click on link with text "Continuare"
    And I click on label "Sunt de acord şi am luat la cunoştinţă "
    And I click on link with text "Finalizează comanda"
    And I fill in card number "6778", cvc "555", month "05 Mai", year "2020" and card type "Maestro"
    And I wait 40 seconds

  Scenario: Checkout with empty cvc
    Given I open url"https://dev2.farmec.ro/autentificare.html"
    And I login with "testare1984@gmail.com"/"parola"
    And I click on element with text "Produse noi"
    And I click on link with text "Balsam hidratant"
    And I click on link with text "Adaugă în coş"
    And I click on button with text "Finalizează comanda acum "
    And I click on  button2 with text "Finalizează comanda "
    And I click on link with text "Continuare"
    And I wait 1 seconds
    And I click on link with text "Continuare"
    And I click on label "Online cu card bancar"
    And I click on link with text "Continuare"
    And I click on label "Sunt de acord şi am luat la cunoştinţă "
    And I click on link with text "Finalizează comanda"
    And I fill in card number "677899999", cvc "", month "05 Mai", year "2020" and card type "Maestro"
    And I should not see an element with text ""
    And I wait 40 seconds


  Scenario: Checkout with empty month field
    Given I open url"https://dev2.farmec.ro/autentificare.html"
    And I login with "testare1984@gmail.com"/"parola"
    And I click on element with text "Produse noi"
    And I click on link with text "Balsam hidratant"
    And I click on link with text "Adaugă în coş"
    And I click on button with text "Finalizează comanda acum "
    And I click on  button2 with text "Finalizează comanda "
    And I click on link with text "Continuare"
    And I wait 1 seconds
    And I click on link with text "Continuare"
    And I click on label "Online cu card bancar"
    And I click on link with text "Continuare"
    And I click on label "Sunt de acord şi am luat la cunoştinţă "
    And I click on link with text "Finalizează comanda"
    And I fill in card number "677899999", cvc "555", month "", year "2020" and card type "Maestro"
    And I wait 40 seconds

  Scenario: Checkout with
    Given I open url"https://dev2.farmec.ro/autentificare.html"
    And I login with "testare1984@gmail.com"/"parola"
    And I click on element with text "Produse noi"
    And I click on link with text "Balsam hidratant"
    And I click on link with text "Adaugă în coş"
    And I click on button with text "Finalizează comanda acum "
    And I click on  button2 with text "Finalizează comanda "
    And I click on link with text "Continuare"
    And I wait 1 seconds
    And I click on link with text "Continuare"
    And I click on label "Online cu card bancar"
    And I click on link with text "Continuare"
    And I click on label "Sunt de acord şi am luat la cunoştinţă "
    And I click on link with text "Finalizează comanda"
    And I fill in card number "677899999", cvc "555", month "05 Mai", year "2015" and card type "Maestro"
    And I wait 40 seconds
