package lesson5Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;

public class BackCallTest {
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
        WebElement webElement5 = driver.findElement(By.cssSelector("#mainBlock > header > div.header__contact > div.contact-head > div.contact-head__btn > button > span"));
        webElement5.click();
        WebElement webElement6= driver.findElement(By.cssSelector("#modal-callback > div > div > div > div.form-call.form > div > form > div:nth-child(2)"));
        webElement6.click();
        WebElement webElement7= driver.findElement(By.xpath("//*[@id=\"modal-callback\"]/div/div/div/div[3]/div/form/div[1]/input"));
        webElement7.sendKeys("Юлия");
        WebElement webElement8 = driver.findElement(By.xpath("//*[@id=\"modal-callback\"]/div/div/div/div[3]/div/form/div[5]/div"));
        webElement8.click();

       WebElement webElement9 = driver.findElement(By.xpath("//WebElement webElement8 = driver.findElement(By.xpath(\"//*[@id=\\\"modal-cart\\\"]/div/div/div/div[2]/div[2]/div[4]/div[1]/a\"));"));
        Assertions.assertEquals("Необходимо Ваше согласие на обработку персональных данных!",driver.getTitle(),"Необходимо Ваше согласие на обработку персональных данных!");

    }
    // @AfterAll
    //static void close(){
    //   driver.quit();
    //}
}
