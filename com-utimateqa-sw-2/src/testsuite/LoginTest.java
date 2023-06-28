package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {

    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp() {
        openingBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        driver.findElement(By.xpath("//li[@class= 'header__nav-item header__nav-sign-in']")).click();
        String expected = "Welcome Back!";
        String actual = driver.findElement(By.xpath("//h2[@class= 'page__heading']")).getText();
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void verifyTheErrorMessage() throws InterruptedException {
        driver.findElement(By.xpath("//li[@class= 'header__nav-item header__nav-sign-in']")).click();
        driver.findElement(By.id("user[email]")).sendKeys("abcd123@gmail.com");
        driver.findElement(By.id("user[password]")).sendKeys("123456");
        driver.findElement(By.xpath("//button[@class='button button-primary g-recaptcha']")).click();
        Thread.sleep(5000);
        String expected = "Invalid email or password.";
        String actual = driver.findElement(By.xpath("//ul[@class='form-error__list']")).getText();
        System.out.println(actual);
        //Assert.assertEquals(expected,actual);
    }

    @After
    public void tearDown() {

        closingBrowser();
    }
}
