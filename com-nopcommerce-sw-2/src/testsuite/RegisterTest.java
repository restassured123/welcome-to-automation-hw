package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class RegisterTest extends BaseTest {
    //Declaring BaseURL
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);

    }

    @Test
    public void userShouldNavigateToRegisterPageSuccessfully() {

        //find register link and click on it
        driver.findElement(By.linkText("Register")).click();
        String expected = "Register";
        //Find the message element and store it in variable
        String actual = driver.findElement(By.xpath("//h1[text()='Register']")).getText();
        //Compare expected and actual
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void userShouldRegisterAccountSuccessfully() {
        //find register link and click on it
        driver.findElement(By.linkText("Register")).click();
        //find form elements and fill values in it
        driver.findElement(By.xpath("//input[@id = 'gender-male']")).click();
        driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("DJ");
        driver.findElement(By.xpath("//input[@id = 'LastName']")).sendKeys("Dhiren");
        driver.findElement(By.xpath("//select[@name='DateOfBirthDay']//option[@value='24']")).click();
        driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']//option[@value='9']")).click();
        driver.findElement(By.xpath("//select[@name='DateOfBirthYear']//option[value='1995']")).click();
        driver.findElement(By.xpath("//input[@id = 'Email']")).sendKeys("prime123@gmail.com");
        driver.findElement(By.xpath("//input[@id = 'Password']")).sendKeys("Prime@123");
        driver.findElement(By.xpath("//input[@id = 'ConfirmPassword']")).sendKeys("Prime@123");
        driver.findElement(By.xpath("button[@name='register-button']")).click();
        String expected = "Your registration completed";
        String actual = driver.findElement(By.xpath("//div[text()= 'Your registration completed']")).getText();
        Assert.assertEquals(expected,actual);

    }
    @After
    public void tearDown() {
        closeBrowser();
    }

}
