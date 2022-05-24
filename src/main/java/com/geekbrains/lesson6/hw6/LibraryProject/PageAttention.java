package com.geekbrains.lesson6.hw6.LibraryProject;

import io.qameta.allure.Step;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageAttention extends BaseView {
    public PageAttention(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//span[@class='substr-img']")
    public WebElement pagingModeButton;

    @Step("Клик на кнопку для перехода в режим постраничного просмотра")
    public FinalPage successFulBookReading() {
        pagingModeButton.click();
        Cookie cookie = new Cookie("rdsulg", "kmm_2002");
        driver.manage().addCookie(cookie);
        driver.navigate().refresh();
        return new FinalPage(driver);
    }
}
