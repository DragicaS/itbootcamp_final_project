package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage extends BasePage{
    private By signupButton= By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/a[4]/span");
    private By name=By.id("name");
    private By email=By.id("email");
    private By password=By.id("password");
    private By confirmPassword=By.id("confirmPassword");

    public SignupPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getSignupButton() {
        return getDriver().findElement(signupButton);
    }

    public WebElement getName() {
        return getDriver().findElement(name);
    }

    public WebElement getEmail() {
        return getDriver().findElement(email);
    }

    public WebElement getPassword() {
        return getDriver().findElement(password);
    }

    public WebElement getConfirmPassword() {
        return getDriver().findElement(confirmPassword);
    }

    public void clickButton()
    {
        getSignupButton().click();
    }
    /*Podaci:
•	name: Test Test
•	email: admin@admin.com
•	password: 123654
•	confirm password: 123654
assert:
•	Verifikovati da greska sadrzi poruku E-mail already exists
•	Verifikovati da se u url-u stranice javlja /signup ruta
*/
    public void errorMessage()
    {
        getName().clear();
        getEmail().clear();
        getPassword().clear();
        getConfirmPassword().clear();
        getName().sendKeys("Test Test");
        getEmail().sendKeys("admin@admin.com");
        getPassword().sendKeys("123654");
        getConfirmPassword().sendKeys("123654");
        WebElement result= getDriver().findElement(By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[2]/span/form/div/div[5]/button/span"));
        result.click();
    }

    /*Podaci:
•	name: Ime i prezime polaznika
•	email template: ime.prezime@itbootcamp.rs
•	password: 12346
•	confirm password: 123456
assert:
•	Verifikovati da dijalog za obavestenje sadrzi tekst IMPORTANT: Verify your account
*/

    public void signup()
    {
        getName().clear();
        getEmail().clear();
        getPassword().clear();
        getConfirmPassword().clear();
        getName().sendKeys("Dragica Smilj");
        getEmail().sendKeys("dragica.smilj@itbootcamp.com");
        getPassword().sendKeys("123456");
        getConfirmPassword().sendKeys("123456");

    }
    public void clickSignUp()
    {
        WebElement result= getDriver().findElement(By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[2]/span/form/div/div[5]/button/span"));
        result.click();
    }
    //"//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[2]/span/form/div/div[5]/button/span"
}
