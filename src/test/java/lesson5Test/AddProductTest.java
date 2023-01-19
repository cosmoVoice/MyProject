package lesson5Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;

public class AddProductTest {
    static WebDriver driver;

    @BeforeAll
    static void init() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        //options.addArguments("--headless");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @BeforeEach
    void getPage() {
        driver.get("https://www.dogeat.ru/");
    }

    @Test
    void test() throws InterruptedException {


        if (!driver.findElements(By.id("popmechanic-snippet")).isEmpty()) {
            WebElement ModalCircle = driver.findElement(By.id("popmechanic-snippet"));
            if (driver instanceof JavascriptExecutor) {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].remove()", ModalCircle);
            }
        }

        //карточка товара
        WebElement webElement5 = driver.findElement(By.xpath("//*[@id=\"content\"]/div[9]/div[2]/div[2]/div/div/div[1]/div[1]/a/img"));
        webElement5.click();
        Thread.sleep(5000);

        // увеличние количества
        WebElement webElement6 = driver.findElement(By.xpath("/html/body/div[5]/div[1]/div[3]/div/div[3]/div[2]/div[1]/div/div[2]/div[4]/div[1]/div/div[3]/div/div/button[2]"));
        webElement6.click();
        Thread.sleep(5000);


        // добавить в корзину
        WebElement webElement7 = driver.findElement(By.xpath("/html/body/div[5]/div[1]/div[3]/div/div[3]/div[2]/div[1]/div/div[2]/div[6]/div[2]/button"));
        webElement7.click();
        Thread.sleep(10000);

        // появилась кнопка Оформить товар?

        WebElement webElement8 = driver.findElement(By.cssSelector("#modal-cart > div > div > div > div.add-cart > div.add-cart__inner > div.add-cart__foot.clearfix > div:nth-child(1) > a"));
        Assertions.assertEquals("Оформить заказ", webElement8.getText());
    }
            // @AfterAll
            //static void close(){
            //   driver.quit();
            //}
}

