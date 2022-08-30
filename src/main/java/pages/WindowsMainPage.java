package pages;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

public class WindowsMainPage extends BasePage{
    WebDriver driver;


    @FindBy(id = "search")
    WebElement searchButton;

    @FindBy(id = "cli_shellHeaderSearchInput")
    WebElement searchInput;

    @FindBy(xpath = "//*[@id=\"uhfCatLogo\"]/span")
    WebElement windowsHeader;

    JSONParser jParse = new JSONParser();
    JSONObject jsonObject = (JSONObject) jParse.parse(new FileReader("src/main/java/testData/testData.json"));
    String searchValue = (String) jsonObject.get("searchBoxValue");

    public WindowsMainPage() throws IOException, ParseException {
        PageFactory.initElements(driver, this);
    }

    public SearchPage search() throws InterruptedException {
            searchButton.click();
            searchInput.sendKeys(searchValue);
            searchButton.click();
            driver.wait(30000);

            return new SearchPage();

    }

    public boolean isPageLoaded() {
        try {
            windowsHeader.getText().equals("Windows");
            return true;
        }
        catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
}
