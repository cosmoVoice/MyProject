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
import org.openqa.selenium.Alert;
import io.qameta.allure.*;
public class BackCallTest {
    static WebDriver driver;
    @Test
    @DisplayName("Обратный звонок")
    @Description("Заказ звонка для обратной связи")
    @Severity(SeverityLevel.NORMAL)
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
        WebElement webElement5 = driver.findElement(By.cssSelector("#mainBlock > header > div.header__contact > div.contact-head > div.contact-head__btn > button > span"));
        webElement5.click();
        WebElement webElement6= driver.findElement(By.cssSelector("#modal-callback > div > div > div > div.form-call.form > div > form > div:nth-child(2)"));
        webElement6.click();
        WebElement webElement7= driver.findElement(By.xpath("//*[@id=\"modal-callback\"]/div/div/div/div[3]/div/form/div[1]/input"));
        webElement7.sendKeys("Юлия");
        WebElement webElement8 = driver.findElement(By.xpath("//*[@id=\"modal-callback\"]/div/div/div/div[3]/div/form/div[5]/div"));
        webElement8.click();


       Alert alert = driver.switchTo().alert();
       String alertMessage= driver.switchTo().alert().getText();

       Assertions.assertEquals("Необходимо Ваше согласие на обработку персональных данных!",alertMessage);

    }
    // @AfterAll
    //static void close(){
    //   driver.quit();
    //}
}
