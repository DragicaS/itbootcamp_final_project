package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthRoutesPage extends BasePage {
    private By home = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[1]/span");

    public AuthRoutesPage(WebDriver driver, WebDriverWait wait, Faker faker) {
        super(driver, wait, faker);
    }

    public WebElement getHome() {
        return getDriver().findElement(home);
    }

    public void clickHomePage() {
        getHome().click();
    }
}
