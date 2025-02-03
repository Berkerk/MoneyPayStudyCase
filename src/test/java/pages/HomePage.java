package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.Assertion;
import stepDefinations.HomePageSteps;
import util.ElementHelper;

import java.time.Duration;
import java.util.List;

public class HomePage {

    static WebDriver driver;
    static ElementHelper elementHelper;
    WebDriverWait wait;

    public HomePage(WebDriver driver){
        this.driver = driver;
        this.elementHelper = new ElementHelper(driver);
        this.wait = new WebDriverWait(driver, 10);
    }
    // Page Elements
    static By HomePageBanner = By.xpath("//*[@id='sm-home-main-swiper-banner']");
    static By KategorilerLink = By.xpath("//*[text()='KATEGORİLER']");
    static By XIconEnYakinMigros = By.xpath("//*[@class='svg-inline--fa fa-xmark']");
    static By PetshopLink = By.xpath("//*[@id ='home-page-category-card-pet-shop-c-a0']");
    static By Petshopfiltertitle = By.xpath("//*[@id='product-filter-desktop-title' and text()='Pet Shop']");
    static By FilterinPetshop = By.xpath("//*[text()='Önerilenler']");
    static By FilterinPetshopfields = By.xpath("//*[@class='mdc-list-item__primary-text' and text()=' Önce En Düşük Fiyat ']");
    static By PriceElements = By.xpath("//*[@class='price subtitle-1 ng-star-inserted']");



    public void MigrosHomePage() {
        elementHelper.presenceElement(HomePageBanner);
    }

    public void clickKategoriler() {
        elementHelper.click(KategorilerLink);
    }

    public void clickPetshop() {
        elementHelper.click(PetshopLink);
    }

    public void clikEnYakinMigrosPopup() {
        List<WebElement> element = driver.findElements(XIconEnYakinMigros);
        if(!element.isEmpty()){
        elementHelper.click(XIconEnYakinMigros);}
        else{
        }
    }

    public void moveKategorilerLink() {
        elementHelper.moveElement(KategorilerLink);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void checkPetShopPage() {
        elementHelper.presenceElement(Petshopfiltertitle);
    }

    public void clickFilterEnDusukFiyat() throws InterruptedException {
        elementHelper.click(FilterinPetshop);
        Thread.sleep(2000);
        elementHelper.presenceElement(FilterinPetshopfields);
        Thread.sleep(2000);
        elementHelper.click(FilterinPetshopfields);
        Thread.sleep(2000);

    }

    public void checkPricetolowerthanhigher() {
        List<WebElement> priceelement = driver.findElements(PriceElements);

        for(int i = 0;i<priceelement.size()-1;i++){
                int currentprice = Integer.parseInt(priceelement.get(i).getText().replace(",","").replace("TL","").trim());
                int nextprice = Integer.parseInt(priceelement.get(i+1).getText().replace(",","").replace("TL","").trim());
         if(currentprice>nextprice){
             Assert.fail("Sıralama Küçükten büyüğe doğru değildir. Lütfen kontrol ediniz.");
         }


        }
    }
}
