package org.example;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.time.Duration;

public class Main {

    @Test
    public void SecondTest() throws InterruptedException {
        // Устанавливаем путь к драйверу Chrome
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\olenk\\IdeaProjects\\Maven\\drivers\\chromedriver.exe");

        // Инициализируем Chrome драйвер
        WebDriver driver = new ChromeDriver();

        // Навигируемся на веб-страницу
        driver.get("https://mail.ru/");

        driver.findElement(By.xpath("//*[@class='resplash-btn resplash-btn_primary resplash-btn_mailbox-big ejf-iekc__1jdtl7f']")).click();

        // Переключение на iframe
        WebElement iframeElement = driver.findElement(By.cssSelector("iframe.ag-popup__frame__layout__iframe"));
        driver.switchTo().frame(iframeElement);

        // Ввод логина
        driver.findElement(By.xpath("//*[@class='input-0-2-71']")).sendKeys("tester9lab");
        // Клик по кнопке входа
        driver.findElement(By.xpath("//*[contains(@class, 'inner-0-2-81 innerTextWrapper-0-2-82')]")).click();
        // Клик по кнопке "Войти с паролем"
        Thread.sleep(Duration.ofSeconds(5).toMillis());
        driver.findElement(By.xpath("//*[contains(@class, 'inner-0-2-81 innerTextWrapper-0-2-82')]")).click();
        // Ввод пароля
        Thread.sleep(Duration.ofSeconds(5).toMillis());
        driver.findElement(By.xpath("//*[@class='input-0-2-71 withIcon-0-2-72']")).sendKeys("labForTest");
        // Клик по кнопке входа
        Thread.sleep(Duration.ofSeconds(5).toMillis());
        driver.findElement(By.xpath("//*[contains(@class, 'inner-0-2-81 innerTextWrapper-0-2-82')]")).click();

        // Возвращаемся к основной странице
        driver.switchTo().defaultContent();
        Thread.sleep(Duration.ofSeconds(5).toMillis());

        // Клик по аватарке пользователя
        driver.findElement(By.xpath("//*[@class='ph-avatar-img svelte-dfhuqc']")).click();
        Thread.sleep(Duration.ofSeconds(5).toMillis());

        // Проверка имени пользователя
        Assert.assertEquals("Prof Tester",driver.findElement(By.xpath("//*[@class='ph-name svelte-1popff4']")).getText());

        // Выход из аккаунта
        driver.findElement(By.xpath("//*[@data-testid='whiteline-account-exit']")).click();
        Thread.sleep(Duration.ofSeconds(5).toMillis());

        // Проверка наличия кнопки "Создать почту"
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='resplash-btn resplash-btn_outlined-themed resplash-btn_mailbox-big ejf-iekc__1jdtl7f']")).isDisplayed());

        // Закрыть браузер
        driver.quit();
    }

    @Test
    public void FirstTest() throws InterruptedException {
        // Устанавливаем путь к драйверу Chrome
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\olenk\\IdeaProjects\\Maven\\drivers\\chromedriver.exe");

        // Инициализируем Chrome драйвер
        WebDriver driver = new ChromeDriver();

        // Навигируемся на веб-страницу
        driver.get("https://habr.com/ru/all/");
        Thread.sleep(Duration.ofSeconds(5).toMillis());

        // Находим и кликаем на иконку поиска
        driver.findElement(By.xpath("//*[@class='tm-svg-img tm-header-user-menu__icon tm-header-user-menu__icon_search tm-header-user-menu__icon_dark']")).click();
        Thread.sleep(Duration.ofSeconds(5).toMillis());

        // Находим поле ввода и вводим текст "Selenium WebDriver"
        WebElement input = driver.findElement(By.xpath("//input[@name='q']"));
        Assert.assertEquals(input, driver.switchTo().activeElement());
        input.sendKeys("Selenium WebDriver");

        // Кликаем на кнопку поиска
        driver.findElement(By.xpath("//*[@class='tm-svg-img tm-svg-icon']")).click();
        Thread.sleep(Duration.ofSeconds(5).toMillis());

        driver.findElement(By.linkText("Что такое Selenium?")).click();
        Thread.sleep(Duration.ofSeconds(5).toMillis());

        // Проверяем, что текст "28 сен 2012 в 17:14" присутствует на странице
        Assert.assertEquals("28 сен 2012 в 17:14", driver.findElement(By.cssSelector("[title='2012-09-28, 17:14']")).getText());
        Thread.sleep(Duration.ofSeconds(5).toMillis());

        // Прокручиваем страницу до конца
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(Duration.ofSeconds(5).toMillis());

        // Прокручиваем страницу до конца
        driver.findElement(By.xpath("//a[@href='/ru/articles/' and @class='footer-menu__item-link router-link-active']")).click();
        Thread.sleep(Duration.ofSeconds(5).toMillis());

        // Закрыть браузер
        driver.quit();

    }
}