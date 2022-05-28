Feature: Открытие книги в интернет библиотеке

  Background:
    Given Click on the Catalog button

  @hooks
    @close
  Scenario Outline:
    When Kit selection '<nameKit>'
    And Printing the title of a book in the search field '<nameBook>'
    And Book selection by year '<year>', title '<name_book>' and author '<author>'
    And Click on the button Read online
    And Click on the button to switch to paging mode
    Then Check for successful opening of a book for paging
    Examples:
      | nameKit                                      | nameBook     | year | name_book    | author             |
      | Медицина (ВО) ГЭОТАР-Медиа. Базовый комплект | фармакология | 2018 | Фармакология | Харкевич Д.А.      |
      | Медицина (ВО) ГЭОТАР-Медиа. Базовый комплект | фармакология | 2020 | Фармакология | А. И. Венгеровский |








