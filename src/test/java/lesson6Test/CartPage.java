package lesson6Test;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage {
    protected WebDriver driver;

    private By tableRows = By.className("cart-table__tr");
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void checkRowsInCart() {
        // Проверяем что один товар в корзине
        List<WebElement> rows = this.driver.findElements(this.tableRows);
        Assert.assertEquals(rows.size(), 1);
    }

}
