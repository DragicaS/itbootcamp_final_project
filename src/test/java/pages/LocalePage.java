package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LocalePage extends BasePage {

    private By languageBtn = By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/button/span");
    private By languageEn = By.id("list-item-73");
    private By languageEs = By.id("list-item-75");
    private By languageFr = By.xpath("//*[@id=\"list-item-77\"]/div");

    public LocalePage(WebDriver driver, WebDriverWait wait, Faker faker) {
        super(driver, wait, faker);
    }

    public WebElement getLanguageBtn() {
        return getDriver().findElement(languageBtn);
    }

    public WebElement getLanguageEn() {
        return getDriver().findElement(languageEn);
    }

    public WebElement getLanguageEs() {
        return getDriver().findElement(languageEs);
    }

    public WebElement getLanguageFr() {
        return getDriver().findElement(languageFr);
    }

    public void clickLanguageBtn() {
        getLanguageBtn().click();
    }

    public void clickLanguageEn() {
        getLanguageEn().click();
    }

    public void clickLanguageEs() {
        getLanguageEs().click();
    }

    public void clickLanguageFr() {
        getLanguageFr().click();
    }
}
