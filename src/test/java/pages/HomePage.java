package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    protected By home= By.xpath("//*[@id=\"app\"]/div[1]/div/aside/div[1]/div/a[1]/div[2]");
    protected By about=By.xpath("//*[@id=\"app\"]/div[1]/div/aside/div[1]/div/a[2]/div[2]");
    protected By login=By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/a[3]/span");
    protected By signup=By.xpath("//*[@id=\"app\"]/div[1]/div/aside/div[1]/div/a[4]/div[2]");


    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    public WebElement getHome() {
        return getDriver().findElement(home);
    }

    public WebElement getAbout() {
        return getDriver().findElement(about);
    }

    public WebElement getLogin() {
        return getDriver().findElement(login);
    }

    public WebElement getSignup() {
        return getDriver().findElement(signup);
    }
    public void clickLogin()
    {
        getLogin().click();
    }
}
