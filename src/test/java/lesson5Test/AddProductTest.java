package lesson5Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
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
        //карточка товара
        WebElement webElement5 = driver.findElement(By.xpath("//*[@id=\"content\"]/div[9]/div[2]/div[2]/div/div/div[1]/div[1]/a/img"));
        webElement5.click();


        // увеличние количества
        WebElement webElement6 = driver.findElement(By.cssSelector("#good30616 > div:nth-child(3) > div > div > button.num-control__btn.num-control__btn_plus"));
        webElement6.click();

        Thread.sleep(5000);

        // добавить в корзину
        WebElement webElement7 = driver.findElement(By.cssSelector("#getOrderButton > div:nth-child(2) > button"));
        webElement7.click();

        Thread.sleep(5000);
 // появилась кнопка Оформить товар?

       WebElement webElement8 = driver.findElement(By.cssSelector("#modal-cart > div > div > div > div.add-cart > div.add-cart__inner > div.add-cart__foot.clearfix > div:nth-child(1) > a"));
       Assertions.assertEquals("Оформить заказ", webElement8.getText());
    }
    // @AfterAll
    //static void close(){
    //   driver.quit();
    //}
}
