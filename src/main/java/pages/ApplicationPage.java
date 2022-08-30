package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApplicationPage extends BasePage{

    @FindBy(id = "ButtonPanel_buttonPanel_OverflowMenuTrigger")
    WebElement threeDots;


    public ApplicationPage(){

        PageFactory.initElements(driver, BasePage.class);
    }


}
