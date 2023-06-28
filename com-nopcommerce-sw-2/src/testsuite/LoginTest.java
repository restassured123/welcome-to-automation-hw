package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest extends BaseTest {

    //Declaring BaseURL
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        //find login link and click on it
        driver.findElement(By.linkText("Log in")).click();
        String expectedMessage = "Welcome, Please Sign In!";
        //Find the message element and store it in variable
        String actualMessage = driver.findElement(By.xpath("//div[@class = 'page-title']")).getText();
        //Compare expected and actual
        Assert.assertEquals("Navigation to login page unsuccessful.", expectedMessage, actualMessage);

    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //find login link and click on it
        driver.findElement(By.linkText("Log in")).click();
        //find email field and type email
        driver.findElement(By.id("Email")).sendKeys("prime123@gmail.com");
        //find password field and type password
        driver.findElement(By.id("Password")).sendKeys("Prime@123");
        //find login button and click on it
        driver.findElement(By.xpath("//button[@class = 'button-1 login-button']")).click();
        //Verifying logout text
        String expectedText = "Log out";
        String actualText = driver.findElement(By.xpath("//a[@class = 'ico-logout']")).getText();
        Assert.assertEquals(expectedText,actualText);
    }

    @Test
    public void verifyTheErrorMessage(){
        //find login link and click on it
        driver.findElement(By.linkText("Log in")).click();

        //find email field and type email
        driver.findElement(By.id("Email")).sendKeys("prime456@gmail.com");

        //find password field and type password
        driver.findElement(By.id("Password")).sendKeys("Prime@456");

        //find login button and click on it
        driver.findElement(By.xpath("//button[@class = 'button-1 login-button']")).click();

        String expected = "Login was unsuccessful. Please correct the errors and try again.\n"+
                "No customer account found";
        String actual = driver.findElement(By.xpath("//div[@class = 'message-error validation-summary-errors']")).getText();
        Assert.assertEquals(expected,actual);

    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}
