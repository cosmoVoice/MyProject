package lesson5Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;


public class RepeatOrderTest {
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
        WebElement webElement5 = driver.findElement(By.xpath("//*[@id=\"cart\"]/div[2]/div[1]/a"));
        webElement5.click();


        //WebElement webElement6 = driver.findElement(By.name("phone"));
        //webElement6.click();


        WebElement webElement7 = driver.findElement(By.xpath("//*[@id=\"modal-repeat\"]/div/div/div/div[2]/div/form/div[1]/input"));
        webElement7.sendKeys("89219545805");

        WebElement webElement8 = driver.findElement(By.xpath("//*[@id=\"modal-repeat\"]/div/div/div/div[2]/div/form/div[2]/div[1]/button"));
        webElement8.click();
         WebElement webElement9 = driver.findElement(By.xpath("//*[@id=\"cartInfo\"]/div"));
        // в корзине есть товар
        Assertions.assertEquals("Товаров в корзине 1 шт.", webElement9.getText());
    }
    // @AfterAll
    //static void close(){
    //   driver.quit();
    //}
}
