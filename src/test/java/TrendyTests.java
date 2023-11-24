import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.LogUtils;


public class TrendyTests extends BaseTest{
    @Test
    public void assertHomePage() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ProductPage productList = new ProductPage(driver);
        ProductDetailPage productDetailPage = new ProductDetailPage(driver);
        BasketPage basketPage = new BasketPage(driver);
        homePage.goToHomePage();
        Assert.assertEquals("https://www.trendyol.com/", driver.getCurrentUrl());
        homePage.goToLogin();
        LogUtils.logInfo("Anasayfaya gitme işlemi tamam");
        loginPage.typeEmailPassword();
        LogUtils.logInfo("Email Şifre işlemi tamam");
        loginPage.tryLogin();
        LogUtils.logInfo("Login olmaya çalışma işlemi tamam");
        homePage.typeProduct();
        LogUtils.logInfo("Laptop Aratması işlemi tamam");
        productList.selectRandomElement();
        LogUtils.logInfo("Rastgele Ürün seçme işlemi tamam");
        productDetailPage.clickAddBasket();
        LogUtils.logInfo("Sepete Ekle işlemi tamam");
        basketPage.goToBasketPage();
        LogUtils.logInfo("Sepete Gitme işlemi tamam");
        Assert.assertTrue( productDetailPage.getPriceBeforeAddBasketPage().compareTo(basketPage.getPriceAfterAddBasketPage()) >= 0 , "Sepete eklenen ürünün fiyatı artmıştır. Hata vardır.");
        LogUtils.logInfo("Sepetöncesi fiyat ile sonrası fiyat karşılaştırma işlemi tamam");
        basketPage.gotIt();
        basketPage.increaseItem();
        Assert.assertEquals(basketPage.getIncreaseItem(), "2");
        basketPage.deleteItemClick();
        Assert.assertEquals(basketPage.getBasketHeaderText(), "Sepetim (0 Ürün)");
        LogUtils.logInfo("Test Bitti!");



    }
}
