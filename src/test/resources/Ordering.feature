Feature: Оформление заказа

  Background:
    Given Go to the discount page

  @hooks
    @close
  Scenario Outline:
    When Select product '<product>'
    And Click on the shopping cart icon
    And Fill in the data '<name>', '<email>', '<phone>', '<addr>'
    Then Successful ordering
    Examples:
      | product      | name | email       | phone        | addr |
      | Филе индейки | Иван | sdf@mail.ru | +79897658765 | addr |










