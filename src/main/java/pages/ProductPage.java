package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Random;

public class ProductPage extends BaseMethods {
    //private final By products = By.xpath("//div[@class='p-card-chldrn-cntnr card-border']");
    private final By productsClass = By.className("p-card-chldrn-cntnr");
    private final By productDetailPopup = By.className("popup");
    private final By empty = By.xpath("//html");
    public ProductPage(WebDriver driver){

        super(driver);
    }
    public void selectRandomElement() {
        wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete'"));
        List<WebElement> elements = driver.findElements(productsClass);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Random random = new Random();
        int randomIndex = random.nextInt(20);
        WebElement randomElement = elements.get(0);
        //Normalde randomIndex değişkeni elements.get() e parametre olarak verilmelidir.
        //0. indeksin verilme nedeni her ürün adedi arttıralamadığından.
        //0. indeks normalde arttırılabilirken, laptop listesi değişkenlik gösterebildiğinden  indeks numarası  değiştirilebilir.
        js.executeScript("arguments[0].scrollIntoView({block: 'center' , inline: 'center'})", randomElement);
        if (isElementExist(productDetailPopup)) {
            click(empty);
        }
        waitSecond();
        randomElement.click();
    }
}
