package lesson5Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;

public class SearchInCatalogTest {
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
        WebElement webElement5 = driver.findElement(By.xpath("//*[@id=\"mainBlock\"]/div[2]/div/nav/ul/li[1]/a"));
        webElement5.click();
        Thread.sleep(5000);
        WebElement webElement6 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div[3]/a/span[2]"));
        webElement6.click();
        Thread.sleep(5000);
        WebElement webElement7 = driver.findElement(By.xpath("//*[@id=\"vkus\"]/div[1]/span[1]"));
        webElement7.click();
        Thread.sleep(5000);
        WebElement webElement8 = driver.findElement(By.xpath("//*[@id=\"vkus___s-yagodami\"]/a"));
        webElement8.click();
        Thread.sleep(5000);
        WebElement webElement9 = driver.findElement(By.xpath("//*[@id=\"vkus\"]/div[2]/div[2]/button"));
        webElement9.click();
        Thread.sleep(5000);
        Assertions.assertEquals("Москва",driver.getTitle(),"Не та страница");
    }
    // @AfterAll
    //static void close(){
    //   driver.quit();
    //}
}
