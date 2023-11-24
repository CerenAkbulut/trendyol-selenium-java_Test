package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class HomePage extends BaseMethods {
    private final String homePageUrl = "https://www.trendyol.com/";
    private final By homePagePopUp = By.className("modal-close");
    private final By accountButton = By.className("account-user");
    private final By searchBox = By.className("V8wbcUhU");
    private final By searchButton = By.className("cyrzo7gC");

    public HomePage(WebDriver driver){
        super(driver);
    }
    public void goToHomePage(){
        driver.get(homePageUrl);
        if(isElementExist(homePagePopUp)) {
            click(homePagePopUp);
        }
    }
    public void goToLogin(){

        click(accountButton);
    }
    public void typeProduct()
    {
         click(searchBox);
         sendKeys(searchBox,"laptop");
         click(searchButton);
    }
}
