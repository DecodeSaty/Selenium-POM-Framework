package torus.labs.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import torus.labs.base.BasePage;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class HomePage extends BasePage {
    private final By abtTorusTab = By.xpath("//div[contains(text(),'About Torus')]");
    private final By contactUs = By.xpath("//div[normalize-space()='Contact us']");
    private final By visitOffice = By.xpath("//strong[normalize-space()='Visit Our Office']");
    private final By chaticon = By.xpath("//span[@class='cc-7doi cc-1ada']");
    private final By chatText = By.xpath("//span[@class='cc-2dnw cc-6zjc cc-151q']");
    private final By developerTab = By.xpath("//div[contains(text(),'Developers')]");
    private final By wallet = By.xpath("//a[@href='https://toruswallet.io']//div[@class='text-2'][normalize-space()='Wallet']");
    private final By accessWallet = By.xpath("//a[normalize-space()='Access Wallet']");
    private final By emailFld = By.xpath("//input[@id='input-26']");
    private final By invalidEmailTxt = By.xpath("//div[@class='v-messages__message message-transition-enter-to']");
    private final By loginBtn = By.xpath("//span[contains(text(),'Continue with Email')]");
    private final By verificationText = By.xpath("//h1[normalize-space()='Verification']");




    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage load() {
        load("");
        return this;
    }

    public HomePage hoverOverAboutTorus() {

        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(abtTorusTab)).perform();
        return this;
    }


    public HomePage SwitchWindows() {

        String parent = driver.getWindowHandle();
        Set<String> childWindows = driver.getWindowHandles();
        Iterator<String> eachChild = childWindows.iterator();
        while (eachChild.hasNext()) {
            String child_window = eachChild.next();
            if (!parent.equals(child_window)) {
                driver.switchTo().window(child_window);
            }
        }
    return this ;
    }

    public HomePage clickcontactUs() {
        wait.until(ExpectedConditions.elementToBeClickable(contactUs)).click();
        return this;
    }

    public String getOfficeAddress() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(visitOffice)).getText();
    }

    public HomePage clickChatIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(chaticon)).click();
        return this;
    }

    public String getChatWindowText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(chatText)).getText();
    }

    public HomePage hoverOverDeveloperTab() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(developerTab)).perform();
        return this;
    }

    public HomePage clickWalletSubMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(wallet)).click();
        return this;
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    public HomePage accessWallet() {
        wait.until(ExpectedConditions.elementToBeClickable(accessWallet)).click();
        return this;
    }



    public HomePage enterEmail(String emailAddress) {
        WebElement emailEle = driver.findElement(emailFld);
        emailEle.sendKeys(emailAddress);
        emailEle.sendKeys(Keys.TAB);
        return this;
    }

    public String getInvalidEmailText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(invalidEmailTxt)).getText();
    }

    public HomePage clickContinue() {
        driver.findElement(loginBtn).click();
        return this;
    }

    public String getVerficationEmailText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(verificationText)).getText();
    }

    public HomePage waitForWhile()
    {
        driver.manage().timeouts().implicitlyWait(400, TimeUnit.MILLISECONDS);
        return this ;
    }



}




