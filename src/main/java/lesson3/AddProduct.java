package lesson3;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
public class AddProduct {

    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");


        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://google.com");

        WebElement webElement1 = driver.findElement(By.name("q"));
        WebElement webElement2 = driver.findElement(By.cssSelector("input.gLFyf"));
        WebElement webElement3 = driver.findElement(By.name("btnK"));

        webElement1.click();
        webElement2.sendKeys("https://www.dogeat.ru/");
        webElement3.click();

        WebElement webElement4 = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/table/tbody/tr[3]/td/div/h3/a"));
        webElement4.click();

        //карточка товара
        WebElement webElement5 = driver.findElement(By.xpath("//*[@id=\"content\"]/div[9]/div[2]/div[2]/div/div/div[1]/div[3]/a[1]"));
        webElement5.click();
        Thread.sleep(5000);

        if(!driver.findElements(By.cssSelector(".flocktory-widget-overlay")).isEmpty()){
          WebElement Modal = driver.findElement(By.cssSelector(".flocktoru-widget-overlay"));
          if(driver instanceof JavascriptExecutor){
            JavascriptExecutor js = (JavascriptExecutor) driver;
              js.executeScript("arguments[0].remove()",Modal);
            }
      }
        // увеличние количества
        WebElement webElement6 = driver.findElement(By.xpath("//*[@id=\"good30616\"]/div[3]/div/div/button[2]"));
        webElement6.click();

        Thread.sleep(5000);

        // добавить в корзину
        WebElement webElement7 = driver.findElement(By.cssSelector("#getOrderButton > div:nth-child(2) > button"));
        webElement7.click();

        //driver.quit();
    }
}
