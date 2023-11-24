package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.Set;

import static java.time.Duration.ofSeconds;
import static utils.LogUtils.logInfo;

public class BaseMethods {
    protected WebDriver driver;
    protected Actions actions;
    protected WebDriverWait wait;
    protected String firstTab;

    public BaseMethods(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(this.driver);
        this.wait = new WebDriverWait(driver, ofSeconds(5));
        firstTab = driver.getWindowHandle();
    }
    public void click(By element) {

        waitToElement(element).click();
    }
    public void sendKeys(By element, String text) {

        waitToElement(element).sendKeys(text);
    }
    public boolean isElementExist(By element) {

        return driver.findElements(element).size() > 0;
    }
    public WebElement waitToElement(By element) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }
    public void waitSecond(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void switchToSecondTab(){
        Set<String> handles = driver.getWindowHandles();
        String firstTab = driver.getWindowHandle();
        String secondTab = null;
        for (String handle : handles) {
            if (!handle.equals(firstTab)) {
                secondTab = handle;
                break;
            }
        }
        driver.switchTo().window(secondTab);
    }
}
