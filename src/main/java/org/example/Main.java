package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Main {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://automationpratice.com.br");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,600);");
        driver.findElement(By.xpath("//div[@id='video']/child::div/div[1]")).click();
    }
}