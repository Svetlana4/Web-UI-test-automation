package com.geekbrains.lesson3.hw3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StudentLibraryTesting {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.studentlibrary.ru/");

        driver.findElement(By.xpath("//div[@class='main-block wrap-catalogue-block']/descendant::span[text()='Каталог']")).click();

        driver.findElement(By.xpath("//span[@class='item-head']")).click();
//        driver.findElement(By.xpath("//span[text()='Медицинские науки']")).click();
        driver.findElement(By.xpath("//a[@name='btn-med-on']")).click();

        driver.findElement(By.xpath("//a[text()='Медицина (ВО) ГЭОТАР-Медиа. Базовый комплект']")).click();

        driver.findElement(By.xpath("//input[@autocomplete='off']")).sendKeys("фармакология");

        driver.findElement(By.xpath("//span[@class='input-group-btn']")).click();

        driver.findElement(By.xpath("//a[@href='https://www.studentlibrary.ru/ru/book/06-COS-2401.html']")).click();

        driver.findElement(By.xpath("//a[@id='a-to_first_chapter']")).click();

        driver.findElement(By.xpath("//span[@class='substr-img']")).click();

        Cookie cookie = new Cookie("rdsulg", "kmm_2002");
        driver.manage().addCookie(cookie);
        driver.navigate().refresh();

        Thread.sleep(5000);

        driver.quit();
    }
}
