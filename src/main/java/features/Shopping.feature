Feature: Shopping on Zara

  Scenario: User searches for products and adds to cart
    Given user is on the Zara homepage
    When user navigates to Erkek > Tümünü Gör
    And user searches for product from excel row 0 column 0
    And user clears the search box
    And user searches for other product from excel row 0 column 1
    And user presses enter key
    And user selects a random product from results
    Then product info and price are saved to txt file
    And product is added to the cart
    And product size select
    And price in product page and cart match
    And user navigates to the cart page
    When user increases product quantity to 2
    Then product quantity is verified as 2
    When user removes product from cart
    Then cart is verified as empty
