package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
    ////
    private By menu = By.xpath("//*[@id=\"app\"]/div/div/header/div/span/button");
    private By loginButton = By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/a[3]");
    private By email = By.id("email");
    private By password = By.id("password");
    Faker faker = new Faker();

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getMenu() {
        return getDriver().findElement(menu);
    }

    public WebElement getLoginButton() {
        return getDriver().findElement(loginButton);
    }

    public WebElement getEmail() {
        return getDriver().findElement(email);
    }

    public WebElement getPassword() {
        return getDriver().findElement(password);
    }

    public void loginClick() {
        getLoginButton().click();
    }

    public void invalidInput() {
        getEmail().clear();
        getPassword().clear();
        WebElement searchField = getDriver().findElement(email);
        searchField.sendKeys(faker.internet().emailAddress());
        WebElement searchFieldPassword = getDriver().findElement(password);
        searchFieldPassword.sendKeys(faker.internet().password());
        WebElement searchFieldLogin = getDriver().findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/span/form/div/div[3]/button/span"));
        searchFieldLogin.click();
    }
    public void invalidInputWithWrongPassword()
    {
        getEmail().clear();
        getPassword().clear();

    }
}
