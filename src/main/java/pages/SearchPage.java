package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchPage extends BasePage{
    @FindBy(xpath = "//a[text() = 'Comprar']")
    WebElement comprar;

    @FindBy(xpath = "//button[text() = 'Categorías']")
    WebElement categorias;

    @FindBy(id = "R1MarketRedirect-close")
    WebElement cerrarPopup;

    @FindBy(xpath = "//a/span[text() = 'Aplicaciones']")
    WebElement aplicaciones;

    @FindBy(xpath = "//div[@class='c-group f-wrap-items context-list-page']")
    WebElement listOfAplicaciones;

    @FindBy(xpath = "//ul[@class='m-pagination']")
    WebElement pagination;

    @FindBy(xpath = "//a[text()='1']")
    WebElement firstPage;

    @FindBy(xpath = "//div[@id = 'ProductPrice_productPrice_PriceContainer-3' ]/span")
    WebElement priceInPage;

    int contador = 0;
    int numeroDePagina = 1;
    String firstPrice;

    public SearchPage(){

        PageFactory.initElements(driver, this);
    }

    public void checkIfLocalePopupIsPresent() throws InterruptedException {
        WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(10));
        cerrarPopup.click();
        System.out.println("-- Locale Pop Up was present and we stood on the site --");


    }
    
    public void clickOnComprar(){
        comprar.click();
    }

    public void clickOnAplicaciones(){
        aplicaciones.click();
    }

    public void countAndDisplayAplicaciones(){

        for (WebElement element : listOfAplicaciones.findElements(By.xpath("/div[@class='m-channel-placement-item']"))) {
            contador++;
            System.out.println(contador + ". " + element.findElement(By.xpath("//a/div[2]/h3")).getText());
        }
        scrollToBottom();

    }

    private void scrollToBottom() {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Launch the application
        driver.get("http://demo.guru99.com/test/guru99home/");

        //This will scroll the web page till end.
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public boolean isComprarPageLoaded() {
        try {
            categorias.isDisplayed();
            return true;
        }
        catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }

    }

    public void changePage() {
        System.out.println("Cambiando a pagina: " + numeroDePagina+1);
        pagination.findElement(By.xpath("//li[@class='f-active']/following-sibling::li["+numeroDePagina+"]")).click();
        numeroDePagina++;
    }

    public void printNumberOfElements() {
        System.out.println("El numero total de elementos en las paginas observadas es igual a: " + contador);
    }

    public void goBackToPageOne() {
        firstPage.click();

    }

    public ApplicationPage selectFirstNonFree() {
        for (WebElement e :listOfAplicaciones.findElements(By.xpath("//div[@class='m-channel-placement-item']/a/div[contains(@id, 'coreui-productplacementlist')]/div/div/span[1]"))) {
            if(e.getText() != "Gratis"){
                e.click();
                firstPrice = e.getText();
                return new ApplicationPage();
            }
        }
        return null;
    }

    public boolean arePricesMatching() {

        return priceInPage.getText() == firstPrice;
    }
}
