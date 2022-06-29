import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTest {

    @Test
    public void fiveDigitZipCodeTest() {
        //Open browser Chrome
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Open url of ZipCode page
        driver.get("https://sharelane.com/cgi-bin/register.py");
        // Input 5 digits into input field
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        // Click 'Continue'
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        //Add check
        WebElement registerButton = driver.findElement(By.cssSelector("[value=Register]"));
        boolean isRegisterDisplayed = registerButton.isDisplayed();
        driver.quit();
        Assert.assertTrue(isRegisterDisplayed, "'Register' button isn't displayed");

    }

    @Test
    public void fourDigitZipCodeTest() {
        //Open browser Chrome
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Open url of ZipCode page
        driver.get("https://sharelane.com/cgi-bin/register.py");
        // Input 4 digits into input field
        driver.findElement(By.name("zip_code")).sendKeys("1234");
        // Click 'Continue'
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        //Add check
        WebElement errorMessage = driver.findElement(By.className("error_message"));
        boolean isErrorDisplayed = errorMessage.isDisplayed();
        driver.quit();
        Assert.assertTrue(isErrorDisplayed, "'Register' button isn't displayed");

    }

    @Test
    public void sixDigitZipCodeTest() {
        //Open browser Chrome
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Open url of ZipCode page
        driver.get("https://sharelane.com/cgi-bin/register.py");
        // Input 6 digits into input field
        driver.findElement(By.name("zip_code")).sendKeys("123456");
        // Click 'Continue'
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        //Add check
        WebElement errorMessage = driver.findElement(By.className("error_message"));
        boolean isErrorDisplayed = errorMessage.isDisplayed();
        driver.quit();
        Assert.assertTrue(isErrorDisplayed, "'Register' button isn't displayed");

    }

}

