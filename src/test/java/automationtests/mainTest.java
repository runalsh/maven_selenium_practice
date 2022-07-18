package automationtests;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class mainTest {

    WebDriver driver;

    @BeforeTest
    public void setup() {
        System.setProperty("WebDriver.gecko.driver", "F:\\VB\\SeleniumDriver\\geckodriver.exe");
        driver = new FirefoxDriver();
    }
    @Test
    public void loginTest() {
        driver.get("https://opensource-demo.orangehrmlive.com/"); 
        String pageTitle = driver.getTitle(); 
        System.out.println("The title of this page is ===> " + pageTitle);
        Assert.assertEquals("OrangeHRM", pageTitle);

        driver.findElement(By.id("txtUsername")).clear();
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).clear();
        driver.findElement(By.id("txtPassword")).sendKeys("admin123"); 
        driver.findElement(By.id("btnLogin")).click();
        System.out.println("Successfully logged in");
    }
    @AfterTest
    public void teardown() {
        driver.quit();
    }

}