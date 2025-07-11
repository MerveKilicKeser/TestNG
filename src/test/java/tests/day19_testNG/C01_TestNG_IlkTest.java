package tests.day19_testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class C01_TestNG_IlkTest {

    @Test
    public void aramaTesti(){

        // gerekli ayarları yapın
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // phon için arama yapın
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        // arama sonucunda urun bulunabildiğini test edin
        WebElement sonucYaziElementi = driver.findElement(By.className("product-count-text"));

        String unexpectedSonucYazisi = "0 Products found";
        String actualSonucYazisi = sonucYaziElementi.getText();

        Assert.assertNotEquals(actualSonucYazisi,unexpectedSonucYazisi);

        // sayfayi kapatın
        driver.quit();

    }
}
