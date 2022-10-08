package test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTests extends BaseTest {


    @Test
    public void localeES() {

        localePage.clickLanguageBtn();
        localePage.clickLanguageEs();
        String actualResult=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/h1")).getText();
        Assert.assertTrue(actualResult.contains("Página de aterrizaje"));
    }
    @Test
    public void localeEn()  {

        localePage.clickLanguageBtn();
        localePage.clickLanguageEn();
        String actualResult=getDriver().findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/h1")).getText();
        Assert.assertTrue(actualResult.contains("Landing"));
    }
    @Test
    public void localeFr()  {
        localePage.clickLanguageBtn();
        localePage.clickLanguageFr();
        String actualResult=getDriver().findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/h1")).getText();
        Assert.assertTrue(actualResult.contains("Page d'atterrissage"));
    }

}
