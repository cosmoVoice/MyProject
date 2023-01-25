package lesson6Test;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    protected WebDriver driver;

//    private By incBtn = By.xpath("/html/body/div[5]/div[1]/div[3]/div/div[3]/div[2]/div[1]/div/div[2]/div[4]/div[1]/div/div[3]/div/div/button[2]");
    private By incBtn = By.cssSelector("div#content div#good30614 .product-info_full > div:nth-child(1) button.num-control__btn_plus");
//    private By addToCartBtn = By.xpath("/html/body/div[5]/div[1]/div[3]/div/div[3]/div[2]/div[1]/div/div[2]/div[6]/div[2]/button");
    private By addToCartBtn = By.cssSelector("#content #getOrderButton button.product-order__cart");
    private By headCartBtn = By.cssSelector("#cart a.cart__link");

    private By modalCloseBtn = By.cssSelector("#modal-cart button.close-modal");
    private By headCartCount = By.cssSelector("#cartInfo > div.cart-info__unit > b.cart-info__value");
    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void incrementCounter() {
        // Увеличиваем счётчик товара
        this.driver.findElement(this.incBtn).click();
    }

    public void addToCartClick() {
        // Нажимаем В корзину
        this.driver.findElement(this.addToCartBtn).click();
    }

    public void closeModal() {
        // Закрываем модалку, которая появляется после добавления в корзину
        this.driver.findElement(this.modalCloseBtn).click();
    }

    public void checkHeadCart() {
        // Проверяем что один товар в корзине (в шапке сайта)
        Assert.assertEquals(this.driver.findElement(this.headCartCount).getText(), "1 шт.");
    }

    public CartPage goToCart() {
        // Идём на страницу корзины
        this.driver.findElement(this.headCartBtn).click();
        return new CartPage(this.driver);
    }

}
