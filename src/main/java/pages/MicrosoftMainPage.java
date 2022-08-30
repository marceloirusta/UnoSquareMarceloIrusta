package pages;


import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class MicrosoftMainPage extends BasePage{

    @FindBy(id = "shellmenu_2")
    WebElement windows;


    public MicrosoftMainPage(){

        PageFactory.initElements(driver, BasePage.class);
    }

    public WindowsMainPage clickWindowsTab() throws IOException, ParseException {

        windows.click();
        return new WindowsMainPage();

    }

}
