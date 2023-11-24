package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.LogUtils;

public class BasketPage extends BaseMethods{
    private final By myBasket = By.xpath("//a[@class='link account-basket']/p[@class='link-text']");
    private final By productPriceLocator = By.className("pb-basket-item-price");
    private final By gotItButton = By.xpath("//button[text()='Anladım']");
    private final By increaseItem = By.xpath("//button[@class='ty-numeric-counter-button']");
    private final By getCountItem = By.className("counter-content");
    private final By deleteButton = By.className("i-trash");
    private final By basketHeader = By.className("pb-header");
    public String countOfItem;
    public String basketHeaderText;
    public BasketPage(WebDriver driver) {

        super(driver);
    }
    public void goToBasketPage(){
        waitToElement(myBasket);
        click(myBasket);
    }
    public String getPriceAfterAddBasketPage() {
        WebElement productPriceElement = driver.findElement(productPriceLocator);
        String afterProductPrice = productPriceElement.getText();
        return afterProductPrice;
    }
    public void gotIt() {
        click(gotItButton);
    }
    public void increaseItem()
    {
        WebElement increaseItemElement = driver.findElement(increaseItem);
        if (increaseItemElement.isEnabled()) {
            click(increaseItem);
            waitSecond();
        }
        else{
            LogUtils.logInfo("Increase buttonu pasif oldugundan arttırma işlemi yapılamadı!");
        }
    }
    public String getIncreaseItem(){

        WebElement productPriceElement = driver.findElement(getCountItem);
        countOfItem = productPriceElement.getAttribute("value");
        return countOfItem;
    }
    public void deleteItemClick(){
        click(deleteButton);
        waitSecond();
    }
    public String getBasketHeaderText(){
        WebElement basketHeaderElement = driver.findElement(basketHeader);
        basketHeaderText = basketHeaderElement.getText();
        return  basketHeaderText;
    }
}
