package natlex.app.sideMenu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SideMenu {
    private static WebDriver driver;
    private final By loginBtn = By.xpath("//*[@class='b-side-menu__side-menu-link']");
    private final By sideMenuElements = By.xpath("//ul[@class='b-side-menu__nav-links']//li//a");

    public SideMenu(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLoginBtn(){
        WebElement dynamicElement = (new WebDriverWait(driver,10))
                .until(ExpectedConditions.presenceOfElementLocated(loginBtn));
        WebElement btn = driver.findElement(loginBtn);
        btn.click();
    }

    public void clickSettingsBtn(){
        List<WebElement> h1 = driver.findElements(sideMenuElements);
        h1.get(6).click();
    }
}
