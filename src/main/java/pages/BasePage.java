package pages;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.time.Duration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BasePage {
    public static WebDriver driver;
    public MicrosoftMainPage microsoftMainPage;
    //public WindowsMainPage windowsMainPage;

    @BeforeMethod
    public void setup() throws IOException, ParseException {
        System.out.println("-- Setting up browser and redirecting to Microsoft Main page --");
        System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chrome/widows/chromedriver.exe");

        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.microsoft.com/");

        microsoftMainPage = new MicrosoftMainPage();
       // windowsMainPage = new WindowsMainPage();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
