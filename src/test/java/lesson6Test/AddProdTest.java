package lesson6Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AddProdTest {
    static WebDriver driver;

    private void deleteElements(List<By> selectors) {
        // Удаляет элементы по селекторам
        for (By selector : selectors) {
            if (!driver.findElements(selector).isEmpty()) {
                WebElement element = driver.findElement(selector);
                if (driver instanceof JavascriptExecutor) {
                    JavascriptExecutor js = (JavascriptExecutor) driver;
                    js.executeScript("arguments[0].remove()", element);
                }
            }
        }
    }
    @Test
    public void testAddProductToCart() throws InterruptedException {
        // Настраиваем Selenium
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        //options.addArguments("--headless");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.dogeat.ru/");
        
        List<By> removeEls = Arrays.asList(By.cssSelector(".flocktory-widget-overlay"), By.id("popmechanic-snippet"));

        MainPage mainPage = new MainPage(driver);
        this.deleteElements(removeEls);
        ProductPage productPage = mainPage.clickOnProductCard();
        Thread.sleep(1000);
        this.deleteElements(removeEls);
        productPage.incrementCounter();
        Thread.sleep(1000);
        productPage.addToCartClick();
        Thread.sleep(2000);
        productPage.closeModal();
        Thread.sleep(1000);
        productPage.checkHeadCart();
        Thread.sleep(1000);
        CartPage cartPage = productPage.goToCart();
        this.deleteElements(removeEls);
        Thread.sleep(1000);
        cartPage.checkRowsInCart();
    }
}
