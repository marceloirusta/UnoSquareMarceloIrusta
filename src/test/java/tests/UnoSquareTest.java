package tests;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.MicrosoftMainPage;
import pages.SearchPage;
import pages.WindowsMainPage;
import java.io.IOException;

public class UnoSquareTest extends BasePage {

    MicrosoftMainPage microsoftMainPage;
    WindowsMainPage windowsMainPage;
    SearchPage searchPage;

    @Test
    public void unoSquareTestCaseMicrosoft() throws IOException, ParseException, InterruptedException {
        System.out.println("-- Uno Square Test Case --");
        System.out.println("-- Step 1: Click on windows button --");
        windowsMainPage = microsoftMainPage.clickWindowsTab();
        Assert.assertTrue(windowsMainPage.isPageLoaded(), "Windows page not loaded");

        System.out.println("-- Step 2: Typing on search bar and click on search --");
        searchPage = windowsMainPage.search();
        searchPage.clickOnComprar();
        searchPage.checkIfLocalePopupIsPresent();
        Assert.assertTrue(searchPage.isComprarPageLoaded(), "Comprar page not loaded");

        System.out.println("-- Step 3: Counting and displaying applications --");
        searchPage.countAndDisplayAplicaciones();
        searchPage.changePage();
        searchPage.countAndDisplayAplicaciones();
        searchPage.changePage();
        searchPage.countAndDisplayAplicaciones();
        searchPage.printNumberOfElements();

        System.out.println("-- Step 4: Going back to page 1 and selecting the first non free option --");
        searchPage.goBackToPageOne();
        searchPage.selectFirstNonFree();
        Assert.assertTrue(searchPage.arePricesMatching(), "Prices are not matching");


    }

}
