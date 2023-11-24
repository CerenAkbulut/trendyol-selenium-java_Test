package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage extends BaseMethods{

    private final By emailField = By.id("login-email");
    private final By passwordField = By.id("login-password-input");
    private final By loginButton = By.xpath("//button[@type='submit']");
    private final By loginErrorMessage = By.xpath("//span[text()='E-posta adresiniz ve/veya şifreniz hatalı.']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void typeEmailPassword(){
       sendKeys(emailField,"ceren.akbulut@mail.com");
        sendKeys(passwordField,"123456");
    }
    public void tryLogin(){
        click(loginButton);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement elementMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(loginErrorMessage));
        Assert.assertTrue(elementMessage.isDisplayed(), "Element görünür değil.");
    }
}
