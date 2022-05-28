package com.geekbrains.lesson8.hw8;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.geekbrains.lesson8.hw8.OrderProject2.BlockCheckout;
import com.geekbrains.lesson8.hw8.OrderProject2.CatalogPage;
import com.geekbrains.lesson8.hw8.OrderProject2.SelectionDiscountProductsPage;
import com.geekbrains.lesson8.hw8.OrderProject2.YourOrderBlock;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.open;

public class MyStepdefs {
    @Given("Go to the discount page")
    public void clickOnTheCatalogButton() {
        open("https://daitesobakammaso.ru/");
        new CatalogPage().catalog();
    }

    @When("Select product")
    public void selectProduct() {
        new SelectionDiscountProductsPage().selectProduct("Филе индейки");
    }

    @And("Click on the shopping cart icon")
    public void clickOnTheShoppingCartIcon() {
        new SelectionDiscountProductsPage().addDiscountProductsToCart();
    }

    @And("Fill in the data")
    public void fillInTheData() {
        new BlockCheckout().fillData("Иван", "sdf@mail.ru", "+79897658765", "Москва, Советская, 32,2");
    }

    @Then("Successful ordering")
    public void successfulOrdering() {
        new YourOrderBlock().successfulOrdering();
    }

    @When("Select product {string}")
    public void selectProductProduct(String product) {
        new SelectionDiscountProductsPage().selectProduct(product);
    }

    @And("Fill in the data {string}, {string}, {string}, {string}")
    public void fillInTheDataNameEmailPhoneAddr(String name, String email, String phone, String addr) {
        new BlockCheckout().fillData(name,  email, phone, addr);
    }

    @After(value = "@close")
    public void quitBrowser() {
        Selenide.closeWebDriver();
    }
}
