package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Faker faker;


    public BasePage(WebDriver driver, WebDriverWait wait,Faker faker) {
        this.driver = driver;
        this.wait = wait;
        this.faker=new Faker();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public void baseUrl() {
        getDriver().get("https://vue-demo.daniel-avellaneda.com");
    }

    public Faker getFaker() {
        return faker;
    }
}
