package lesson6Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    protected WebDriver driver;

    private By productCard = By.xpath("//*[@id=\"content\"]/div[9]/div[2]/div[2]/div/div/div[1]/div[1]/a/img");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public ProductPage clickOnProductCard() {
        // Кликаем на продукт
        driver.findElement(this.productCard).click();
        return new ProductPage(this.driver);
    }
}
