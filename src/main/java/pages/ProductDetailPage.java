package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.tracing.opentelemetry.SeleniumSpanExporter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.Set;

import java.util.ArrayList;

public class ProductDetailPage extends BaseMethods {
    private final By productPriceLocator = By.className("prc-dsc");
    public final By addBasketButton = By.className("add-to-basket");

    public  String productPrice;
    public ProductDetailPage(WebDriver driver){
        super(driver);
    }
    public void clickAddBasket(){
        switchToSecondTab();
        if (isElementExist(addBasketButton)){
            System.out.println(addBasketButton);
            System.out.println("Buldu");
        }
        else {

            System.out.println(addBasketButton);
            System.out.println("Bulamadı");
        }
        WebElement productPriceElement = driver.findElement(productPriceLocator);
        productPrice = productPriceElement.getText();
        click(addBasketButton);
        waitSecond();
    }
public String getPriceBeforeAddBasketPage(){
        return productPrice;
    }
}
