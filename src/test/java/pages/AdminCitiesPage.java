package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminCitiesPage extends BasePage {
    //
    private By admin = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[1]/span");
    private By cities = By.xpath("//*[@id=\"list-item-117\"]/div[2]");
    private By cites2 = By.xpath("//*[@id=\"list-item-80\"]/div[2]");
    private By users = By.xpath("//*[@id=\"app\"]/div[1]/div/aside/div[1]/div/div[2]/div[2]/a[2]");
    private By newItem = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/div[3]/form/div[1]/button/span");
    private By searchF = By.xpath("//*[@id=\"name\"]");

    protected String city;

    public AdminCitiesPage(WebDriver driver, WebDriverWait wait, Faker faker) {
        super(driver, wait, faker);
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public WebElement getSerachField() {
        return getDriver().findElement(searchF);
    }

    public WebElement getAdmin() {
        return getDriver().findElement(admin);
    }

    public WebElement getCities() {
        return getDriver().findElement(cities);
    }

    public WebElement getCities2() {
        return getDriver().findElement(cites2);
    }

    public WebElement getUsers() {
        return getDriver().findElement(users);
    }

    public WebElement getNewItem() {
        return getDriver().findElement(newItem);
    }

    public void clickAdmin() {
        getAdmin().click();
    }

    public void clickCities() {
        getCities().click();
    }

    public void clickCities2() {
        getCities2().click();
    }

    public void addCity() {
        getNewItem().click();
        WebElement serachField = getDriver().findElement(By.xpath("//*[@id=\"name\"]"));
        city = faker.address().city();
        serachField.sendKeys(city);
        WebElement searchField2 = getDriver().findElement(By.xpath("//*[@id=\"app\"]/div[5]/div/div/div[3]/button[2]/span"));
        searchField2.click();
    }

    public void editCity() throws InterruptedException {

        WebElement searchField = getDriver().findElement(By.xpath("//*[@id=\"name\"]"));
        searchField.sendKeys(" edited");
        WebElement searchField2 = getDriver().findElement(By.xpath("//*[@id=\"app\"]/div[5]/div/div/div[3]/button[2]/span"));
        searchField2.click();

    }

    public void checkCity() throws InterruptedException {
        WebElement search = getDriver().findElement(By.id("search"));
        search.click();
        search.sendKeys(getCity());
        WebElement nameColon = getDriver().findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr[1]/td[2]"));
        nameColon.getText();

    }

}
