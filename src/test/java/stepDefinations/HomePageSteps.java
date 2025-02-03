package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import util.DriverFactory;

public class HomePageSteps {
    WebDriver driver = DriverFactory.getDriver();
    HomePage homePage = new HomePage(driver);
    @Given("Migros Sayfasına Git")
    public void migrosSayfasınaGit() {
        homePage.MigrosHomePage();
    }

    @When("Kategoriler linkine tıkla")
    public void kategorilerLinkineTıkla() {
        homePage.clickKategoriler();
    }

    @When("Petshop linkine tıkla")
    public void petshopLinkineTıkla() {
        homePage.clickPetshop();
    }

    @When("Size En Yakın Migros Pop-up'ı kapat")
    public void sizeEnYakınMigrosPopUpIKapat() {
        homePage.clikEnYakinMigrosPopup();
    }

    @When("Kategoriler sekmesini aç")
    public void kategorilerSekmesiniAc() {
        homePage.moveKategorilerLink();
    }

    @When("Pethop Sayfasının açıldığını kontrol et")
    public void pethopSayfasınınAcıldıgınıKontrolEt() {
        homePage.checkPetShopPage();
    }

    @When("Sıralama Sayfasına tıkla ve Fiyatına göre En düşük seçeneğini seç")
    public void sıralamaSayfasınaTıklaVeFiyatınaGoreEnDusukSeceneginiSec() throws InterruptedException {
        homePage.clickFilterEnDusukFiyat();
    }

    @When("Fiyatların düşükten yükseğe doğru listelendiğini gör")
    public void fiyatlarınDusuktenYuksegeDogruListelendiginiGor() {
        homePage.checkPricetolowerthanhigher();
    }
}
