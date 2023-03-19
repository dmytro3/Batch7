@regression @ui @RTB-13
Feature: Validating Etsy titles

  Scenario Outline: Validating Etsy categories titles
    Given user navigates to "EtsyApp" application
    When user clicks on specific "<category>" category
    Then user validates the title is "<title>"

    Examples:
      | category              | title                            |
      | Home Favorites        | Home decor and furniture \| Etsy |
      | Jewelry & Accessories | Jewelry & Accessories - Etsy     |
      | Clothing & Shoes      | Clothing & Shoes - Etsy          |
      | Home & Living         | Home & Living - Etsy             |





