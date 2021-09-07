package torus.labs.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import torus.labs.base.BaseTest;
import torus.labs.pages.HomePage;
import torus.labs.utils.ConfigLoader;

import java.io.IOException;

public class HomePageTest extends BaseTest {

   @Test
    public void UserAccessingContactUsPage() {
        HomePage homePage = new HomePage(getDriver()).load();
        homePage.hoverOverAboutTorus()
                .clickcontactUs();
        Assert.assertEquals(homePage.getOfficeAddress(), "Visit Our Office");
    }

   @Test
    public void UserAccessingChatMenu() {
        HomePage homePage = new HomePage(getDriver()).load();
        homePage.hoverOverAboutTorus()
                .waitForWhile()
                .clickcontactUs()
                .clickChatIcon();
        Assert.assertEquals(homePage.getChatWindowText(), "Questions? Chat with us!");
    }

   @Test
    public void UserAccessingWalletPage() {
        HomePage homePage = new HomePage(getDriver()).load();
        homePage.hoverOverAboutTorus()
                .hoverOverDeveloperTab()
                .clickWalletSubMenu();
        Assert.assertEquals(homePage.getCurrentURL(), "https://toruswallet.io/");
    }

    @Test
    public void UserEnteringValidEmailWalletPage() throws IOException {

        HomePage homePage = new HomePage(getDriver()).load();
        homePage = homePage.hoverOverDeveloperTab()
                .clickWalletSubMenu()
                .accessWallet();
        homePage.SwitchWindows().enterEmail(ConfigLoader.getInstance().getValidEmail()).waitForWhile().clickContinue();
        homePage.SwitchWindows();
        Assert.assertEquals(homePage.getVerficationEmailText(), "Verification");

    }

   @Test
    public void UserEnteringIncorectEmailonWalletPage() throws IOException {

        HomePage homePage = new HomePage(getDriver()).load();
        homePage.hoverOverDeveloperTab()
                .clickWalletSubMenu()
                .accessWallet();
       homePage.SwitchWindows();
       homePage.enterEmail(ConfigLoader.getInstance().getInvalidEmail()).waitForWhile();
       Assert.assertEquals(homePage.getInvalidEmailText(), "Invalid email");

    }
}
