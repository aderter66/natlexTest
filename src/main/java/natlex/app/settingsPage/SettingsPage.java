package natlex.app.settingsPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SettingsPage {
    private static WebDriver driver;

    private final By settingsBtn = By.xpath("//div[@class='b-subnavbar__navbar-link-holder']//*[@class='b-subnavbar__navbar-link']");
    private final By saveBtn = By.xpath("//div[@class='b-select__dropdown-menu']/button/span");
    private final By spinner = By.xpath("//div[@class= 'i-layout-v2']//div[@class='b-spinner__spinner']");
    private final By fakePicture = By.xpath("//input[1]");

    public SettingsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSettingsBtn() throws InterruptedException{
        WebElement dynamicElement = (new WebDriverWait(driver,10))
                .until(ExpectedConditions.presenceOfElementLocated(settingsBtn));
        Thread.sleep(2000);
        WebElement btn = driver.findElement(settingsBtn);
        btn.click();
    }

    public void sendPicture()throws InterruptedException{
        WebElement dynamicElement = (new WebDriverWait(driver,10))
                .until(ExpectedConditions.presenceOfElementLocated(fakePicture));
        WebElement fakePic = driver.findElement(fakePicture);
        fakePic.sendKeys("/home/aderter66/test.jpg");
        WebElement spinnerElement = driver.findElement(spinner);
        while (!spinnerElement.isDisplayed()){}
        while (spinnerElement.isDisplayed()){}
        WebElement btn = driver.findElement(saveBtn);
        btn.click();
    }

}
