package com.geekbrains.lesson6.hw6.LibraryProject;

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

    public FinalPage successFulBookReading() {
        pagingModeButton.click();
        Cookie cookie = new Cookie("rdsulg", "kmm_2002");
        driver.manage().addCookie(cookie);
        driver.navigate().refresh();
        return new FinalPage(driver);
    }
}
