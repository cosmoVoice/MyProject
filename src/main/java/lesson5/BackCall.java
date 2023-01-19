package lesson5;
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

public class BackCall {
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

        WebElement webElement5 = driver.findElement(By.cssSelector("#mainBlock > header > div.header__contact > div.contact-head > div.contact-head__btn > button > span"));
        webElement5.click();
        WebElement webElement6= driver.findElement(By.cssSelector("#modal-callback > div > div > div > div.form-call.form > div > form > div:nth-child(2)"));
        webElement6.click();
        WebElement webElement7= driver.findElement(By.xpath("//*[@id=\"modal-callback\"]/div/div/div/div[3]/div/form/div[1]/input"));
        webElement7.sendKeys("Юлия");
        WebElement webElement8 = driver.findElement(By.xpath("//*[@id=\"modal-callback\"]/div/div/div/div[3]/div/form/div[5]/div"));
        webElement8.click();
        //driver.quit();


    }

}
