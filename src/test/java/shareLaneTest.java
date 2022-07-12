import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class shareLaneTest {

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


    //-------------------------------------HW--------------------------------------------------

    //Task 1
//#1
    @Test
    public void registrationFieldsAreFilledByMinValuesTest() {
        //Open browser Chrome
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Open url of ZipCode page
        driver.get("https://sharelane.com/cgi-bin/register.py");
        // Input 5 digits into input field
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        //Input min values into all fields
        driver.findElement(By.name("first_name")).sendKeys("A");
        driver.findElement(By.name("last_name")).sendKeys("V");
        driver.findElement(By.name("email")).sendKeys("av@v.ru");
        driver.findElement(By.name("password1")).sendKeys("1111");
        driver.findElement(By.name("password2")).sendKeys("1111");
        // Click 'Continue'
        driver.findElement(By.cssSelector("[value=Register]")).click();
        //Add check
        WebElement registerMessage = driver.findElement(By.className("confirmation_message"));
        boolean isMessageDisplayed = registerMessage.isDisplayed();
        driver.quit();
        Assert.assertTrue(isMessageDisplayed, "Message 'Account is created!' isn't displayed");

    }

    //#2
    @Test
    public void registrationFieldsAreEmptyTest() {
        //Open browser Chrome
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Open url of ZipCode page
        driver.get("https://sharelane.com/cgi-bin/register.py");
        // Input 5 digits into input field
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        //Input min values into all fields

        // Click 'Register'
        driver.findElement(By.cssSelector("[value=Register]")).click();
        //Add check
        WebElement errorMessage = driver.findElement(By.className("error_message"));
        boolean isMessageDisplayed = errorMessage.isDisplayed();
        driver.quit();
        Assert.assertTrue(isMessageDisplayed, "Message 'Oops, error on page. Some of your fields have invalid data or email was previously used' isn't displayed");
    }

    //#3
    @Test
    public void passwordThrieCharactersTest() {
        //Open browser Chrome
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Open url of ZipCode page
        driver.get("https://sharelane.com/cgi-bin/register.py");
        // Input 5 digits into input field
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        //Input min values into all fields
        driver.findElement(By.name("first_name")).sendKeys("A");
        driver.findElement(By.name("last_name")).sendKeys("V");
        driver.findElement(By.name("email")).sendKeys("alex_rao@752.25.sharelane.com");
        driver.findElement(By.name("password1")).sendKeys("111");
        driver.findElement(By.name("password2")).sendKeys("111");
        // Click 'Register'
        driver.findElement(By.cssSelector("[value=Register]")).click();
        //Add check
        WebElement errorMessage = driver.findElement(By.className("error_message"));
        boolean isMessageDisplayed = errorMessage.isDisplayed();
        driver.quit();
        Assert.assertTrue(isMessageDisplayed, "Message 'Oops, error on page. Some of your fields have invalid data or email was previously used' isn't displayed");
    }

    //#4
    @Test
    public void onlySpaceIntoFirstNameFieldTest() {
        //Open browser Chrome
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Open url of ZipCode page
        driver.get("https://sharelane.com/cgi-bin/register.py");
        // Input 5 digits into input field
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        //Input min values into all fields
        driver.findElement(By.name("first_name")).sendKeys(" ");
        driver.findElement(By.name("last_name")).sendKeys("V");
        driver.findElement(By.name("email")).sendKeys("alex_rao@752.25.sharelane.com");
        driver.findElement(By.name("password1")).sendKeys("1111");
        driver.findElement(By.name("password2")).sendKeys("1111");
        // Click 'Register'
        driver.findElement(By.cssSelector("[value=Register]")).click();
        //Add check
        WebElement errorMessage = driver.findElement(By.className("error_message"));
        boolean isMessageDisplayed = errorMessage.isDisplayed();
        driver.quit();
        Assert.assertTrue(isMessageDisplayed, "Message 'Oops, error on page. Some of your fields have invalid data or email was previously used' isn't displayed");
    }

    //#5
    @Test
    public void onlySpaceIntoLastNameFieldTest() {
        //Open browser Chrome
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Open url of ZipCode page
        driver.get("https://sharelane.com/cgi-bin/register.py");
        // Input 5 digits into input field
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        //Input min values into all fields
        driver.findElement(By.name("first_name")).sendKeys("A");
        driver.findElement(By.name("last_name")).sendKeys("");
        driver.findElement(By.name("email")).sendKeys("alex_rao@752.25.sharelane.com");
        driver.findElement(By.name("password1")).sendKeys("1111");
        driver.findElement(By.name("password2")).sendKeys("1111");
        // Click 'Register'
        driver.findElement(By.cssSelector("[value=Register]")).click();
        //Add check
        WebElement errorMessage = driver.findElement(By.className("error_message"));
        boolean isMessageDisplayed = errorMessage.isDisplayed();
        driver.quit();
        Assert.assertTrue(isMessageDisplayed, "Message 'Oops, error on page. Some of your fields have invalid data or email was previously used' isn't displayed");
    }

    //#6
    @Test
    public void mailFieldWithoutLettersTest() {
        //Open browser Chrome
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Open url of ZipCode page
        driver.get("https://sharelane.com/cgi-bin/register.py");
        // Input 5 digits into input field
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        //Input min values into all fields
        driver.findElement(By.name("first_name")).sendKeys("A");
        driver.findElement(By.name("last_name")).sendKeys("V");
        driver.findElement(By.name("email")).sendKeys("@.");
        driver.findElement(By.name("password1")).sendKeys("1111");
        driver.findElement(By.name("password2")).sendKeys("1111");
        // Click 'Register'
        driver.findElement(By.cssSelector("[value=Register]")).click();
        //Add check
        WebElement errorMessage = driver.findElement(By.className("error_message"));
        boolean isMessageDisplayed = errorMessage.isDisplayed();
        driver.quit();
        Assert.assertTrue(isMessageDisplayed, "Message 'Oops, error on page. Some of your fields have invalid data or email was previously used' isn't displayed");
    }

    //#7
    @Test
    public void injectionSQLIntoPasswordTest() {
        //Open browser Chrome
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Open url of ZipCode page
        driver.get("https://sharelane.com/cgi-bin/register.py");
        // Input 5 digits into input field
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        //Input min values into all fields
        driver.findElement(By.name("first_name")).sendKeys("A");
        driver.findElement(By.name("last_name")).sendKeys("V");
        driver.findElement(By.name("email")).sendKeys("alex_rao@752.25.sharelane.com");
        driver.findElement(By.name("password1")).sendKeys("'); SELECT * FROM users; ");
        driver.findElement(By.name("password2")).sendKeys("'); SELECT * FROM users; ");
        // Click 'Register'
        driver.findElement(By.cssSelector("[value=Register]")).click();
        //Add check
        WebElement errorMessage = driver.findElement(By.className("error_message"));
        boolean isMessageDisplayed = errorMessage.isDisplayed();
        driver.quit();
        Assert.assertTrue(isMessageDisplayed, "Message 'Oops, error on page. Some of your fields have invalid data or email was previously used' isn't displayed");
    }


    //#8
    @Test
    public void passwordAndConfirmPasswordTest() {
        //Open browser Chrome
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Open url of ZipCode page
        driver.get("https://sharelane.com/cgi-bin/register.py");
        // Input 5 digits into input field
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        //Input min values into all fields
        driver.findElement(By.name("first_name")).sendKeys("A");
        driver.findElement(By.name("last_name")).sendKeys("V");
        driver.findElement(By.name("email")).sendKeys("alex_rao@752.25.sharelane.com");
        driver.findElement(By.name("password1")).sendKeys("11111");
        driver.findElement(By.name("password2")).sendKeys("1111");
        // Click 'Register'
        driver.findElement(By.cssSelector("[value=Register]")).click();
        //Add check
        WebElement errorMessage = driver.findElement(By.className("error_message"));
        boolean isMessageDisplayed = errorMessage.isDisplayed();
        driver.quit();
        Assert.assertTrue(isMessageDisplayed, "Message 'Oops, error on page. Some of your fields have invalid data or email was previously used' isn't displayed");
    }

    //#9
    @Test
    public void typePasswordBeUsedForPasswordTest() {
        //Open browser Chrome
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Open url of ZipCode page
        driver.get("https://sharelane.com/cgi-bin/register.py");
        // Input 5 digits into input field
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        //Add check
        WebElement filePassword1 = driver.findElement(By.name("password1"));
        WebElement filePassword2 = driver.findElement(By.name("password2"));
        boolean closePassword = true;
        assertEquals(filePassword2.getAttribute("type"), filePassword1.getAttribute("type"));
        driver.quit();
        Assert.assertTrue(closePassword, "Message 'Oops, error on page. Some of your fields have invalid data or email was previously used' isn't displayed");

    }

    //Task 2
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
        Assert.assertThrows(NoSuchElementException.class, () -> {
            WebElement errorMessage = driver.findElement(By.className("error_message"));
        });
        driver.quit();
    }

    // Task 3_Adding One book to the Card
    @Test
    public void addingBookToTheCartTest() {
        //Open browser Chrome
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Open url of main page
        driver.get("https://sharelane.com/cgi-bin/main.py");
        // LogIn and adding 1 book to the Card
        driver.findElement(By.name("email")).sendKeys("rajiv_baker@470.06.sharelane.com");
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value=Login]")).click();
        driver.get("https://sharelane.com/cgi-bin/show_book.py?book_id=8");
        WebElement addBook = driver.findElement(By.xpath("//a[@href='./add_to_cart.py?book_id=8']"));
        addBook.click();
        //Add check
        WebElement confirmationMessage = driver.findElement(By.xpath("//span[@class='confirmation_message']"));
        boolean isMessageDisplayed = confirmationMessage.isDisplayed();
        Assert.assertTrue(isMessageDisplayed, "Message 'Book was added to the Shopping Cart' isn't displayed");
        WebElement checkCard = driver.findElement(By.xpath("//a[@href='./shopping_cart.py']"));
        checkCard.click();
        WebElement checkBook = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[5]/td/table/tbody/tr[2]/td[3]/input"));
        boolean isBookAddToCard = checkBook.isDisplayed();
        driver.quit();
        Assert.assertTrue(isBookAddToCard, "Book not added to Card");
    }


}