package com.geekbrains.lesson3.hw3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DaitesobakammasoTesting {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromiumdriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://daitesobakammaso.ru/");

//        WebElement directoryEntry = driver.findElement(By.xpath("//td[text()='В каталог']"));
//        directoryEntry.click();
        driver.findElement(By.xpath("//td[text()='В каталог']")).click();

        driver.findElement(By.xpath("//div[text()='Акции и скидки']")).click();

        driver.findElement(By.xpath("//div[text()='Бараний корень сушёный']")).click();

        driver.findElement(By.xpath("//div[text()='Потрошки северного оленя']")).click();

        driver.findElement(By.xpath("//div[@class='t706__carticon-wrapper']")).click();

        driver.findElement(By.xpath("//input[@data-tilda-rule='name']")).sendKeys("Иван");

        driver.findElement(By.xpath("//input[@data-tilda-rule='email']")).sendKeys("sdf@mail.ru");

        driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("+79897658765");

        driver.findElement(By.xpath("//input[@name='Адрес']")).sendKeys("Москва, Советская, 32,2");

        driver.findElement(By.xpath("//button[text()='Оформить заказ']")).click();


        Thread.sleep(5000);
        driver.quit();
    }
}