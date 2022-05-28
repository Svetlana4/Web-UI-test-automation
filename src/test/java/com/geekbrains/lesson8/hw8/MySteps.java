package com.geekbrains.lesson8.hw8;

import com.codeborne.selenide.Selenide;
import com.geekbrains.lesson8.hw8.LibraryProject2.*;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Selenide.open;

public class MySteps {
    @Given("Click on the Catalog button")
    public void clickOnTheCatalogButton() {
        open("https://www.studentlibrary.ru/");
        new MainPage().addCatalog();
    }

    @When("Kit selection")
    public void kitSelection() {
        new SectionSelection().kitSelection("Медицина (ВО) ГЭОТАР-Медиа. Базовый комплект");
    }

    @And("Printing the title of a book in the search field")
    public void printingTheTitleOfABookInTheSearchField() {
        new BookSearchPage().bookSearch("фармакология");
    }

    @And("Book selection by year, title and author")
    public void bookSelectionByYearTitleAndAuthor() {
        new SearchResultPage().selectFromList("2018", "Фармакология", "Харкевич Д.А.");
    }

    @And("Click on the button Read online")
    public void clickOnTheButtonReadOnline() {
        new BookPage().clickButtonReadOnline();
    }

    @And("Click on the button to switch to paging mode")
    public void clickOnTheButtonToSwitchToPagingMode() {
        new PageAttention().successFulBookReading();
    }

    @Then("Check for successful opening of a book for paging")
    public void checkForSuccessfulOpeningOfABookForPaging() {
        new FinalPage().successBookOpening();
    }

    @When("Kit selection {string}")
    public void kitSelectionNameKit(String nameKit) {
        new SectionSelection().kitSelection(nameKit);
    }

    @And("Printing the title of a book in the search field {string}")
    public void printingTheTitleOfABookInTheSearchFieldNameBook(String nameBook) {
        new BookSearchPage().bookSearch(nameBook);
    }

    @And("Book selection by year {string}, title {string} and author {string}")
    public void bookSelectionByYearYearTitleName_bookAndAuthorAuthor(String year, String name_book, String author) {
        new SearchResultPage().selectFromList(year, name_book, author);
    }

    @After(value = "@close")
    public void quitBrowser() {
        Selenide.closeWebDriver();
    }
}
