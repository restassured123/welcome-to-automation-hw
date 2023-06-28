package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {

    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userSholdLoginSuccessfullyWithValid() {

        driver.findElement(By.xpath("//input[@id= 'user-name']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id= 'login-button']")).click();
        String expected = "Products";
        String actual = driver.findElement(By.xpath("//span[text()='Products']")).getText();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        driver.findElement(By.xpath("//input[@id= 'user-name']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id= 'login-button']")).click();
        int numberOfProducts = driver.findElements(By.className("inventory_item")).size();
        System.out.println("Number of Products displayed on page : " + numberOfProducts);


    }
    @After
    public void tearDown(){
        closeBrowser();
    }

}
