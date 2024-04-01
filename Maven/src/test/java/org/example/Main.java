package org.example;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Main {
    @Test
    public void FirstTest() throws InterruptedException {
        // Устанавливаем путь к драйверу Chrome
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\olenk\\IdeaProjects\\Maven\\drivers\\chromedriver.exe");

        // Инициализируем Chrome драйвер
        WebDriver driver = new ChromeDriver();

        // Навигируемся на веб-страницу
        driver.get("https://mail.ru/");

        driver.findElement(By.xpath("//*[@class='resplash-btn resplash-btn_primary resplash-btn_mailbox-big mfflmpk__b85yax']")).click();

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
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='resplash-btn resplash-btn_outlined-themed resplash-btn_mailbox-big mfflmpk__b85yax']")).isDisplayed());

        // Закрыть браузер
        driver.quit();
    }
}