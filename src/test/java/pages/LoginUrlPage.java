package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginUrlPage extends BasePage {
   ////
    private By menu=By.xpath("//*[@id=\"app\"]/div/div/header/div/span/button");
    private By loginButton=By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/a[3]");

    public LoginUrlPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getMenu() {
        return getDriver().findElement(menu);
    }

    public WebElement getLoginButton() {
        return getDriver().findElement(loginButton);
    }
    public void loginClick()
    {
        getLoginButton().click();
    }
}
