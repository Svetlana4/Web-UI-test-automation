package com.geekbrains.lesson6.hw6.LibraryProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FinalPage extends BaseView {
    public FinalPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//div[@id='mm4-doc-content-pgs']")
    public WebElement canBeRead;

}
