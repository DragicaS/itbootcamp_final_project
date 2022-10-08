package test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ProfileTests extends BaseTest {

    @Test
    public void profileTest() throws InterruptedException {
        homePage.clickLogin();
        loginPage.login();
        profilePage.cliclMyProfile();
        profilePage.editProfile();

        String expectedResult = "Profile saved successfuly" + "\nCLOSE";
        String actualResult = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]")).getText();
        Assert.assertEquals(actualResult, expectedResult);

    }

    @Test(dependsOnMethods = {"profileTest"})
    public void verifyProfileTest() throws InterruptedException {

        profilePage.cliclMyProfile();


        String actualResult = profilePage.getName().getAttribute("value");
        Assert.assertTrue(actualResult.contains(profilePage.getName().getText()));

        String actualResult2 = profilePage.getPhone().getAttribute("value");
        Assert.assertTrue(actualResult.contains(profilePage.getPhone().getText()));

        String actualResult3 = profilePage.getCity().getAttribute("value");
        Assert.assertTrue(actualResult.contains(profilePage.getCity().getText()));

        String actualResult4 = profilePage.getCountry().getAttribute("value");
        Assert.assertTrue(actualResult.contains(profilePage.getCountry().getText()));

        String actualResult5 = profilePage.getTwitter().getAttribute("value");
        Assert.assertTrue(actualResult.contains(profilePage.getTwitter().getText()));

        String actualResult6 = profilePage.getGitHub().getAttribute("value");
        Assert.assertTrue(actualResult.contains(profilePage.getGitHub().getText()));
    }
}
