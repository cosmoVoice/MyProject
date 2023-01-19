package lesson5Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;

public class SearchInputTest {
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
        WebElement webElement5 = driver.findElement(By.xpath("//*[@id=\"mainBlock\"]/div[2]/div/div/div/form/div[1]"));
        webElement5.click();
        Thread.sleep(5000);
        WebElement webElement6 = driver.findElement(By.cssSelector("#search-input"));
        webElement6.sendKeys("ошейник");
        WebElement webElement7 = driver.findElement(By.xpath("//*[@id=\"mainBlock\"]/div[2]/div/div/div/form/div[2]/input"));
        webElement7.click();
        Assertions.assertEquals("Москва",driver.getTitle(),"Не та страница");
    }
    // @AfterAll
    //static void close(){
    //   driver.quit();
    //}
}
