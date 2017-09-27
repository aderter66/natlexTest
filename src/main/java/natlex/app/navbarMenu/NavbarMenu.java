package natlex.app.navbarMenu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavbarMenu {
    private static NavbarMenu instance;
    private static WebDriver driver;

    private final By hamburgerBtn = By.xpath("//div[@class='i-layout-v2']//a[@class='b-navbar__hamburger']");


    public NavbarMenu(WebDriver driver) {
        this.driver = driver;
    }

    public void clickHamburgerBtn(){

        WebElement dynamicElement = (new WebDriverWait(driver,10))
                .until(ExpectedConditions.presenceOfElementLocated(hamburgerBtn));

        WebElement btn = driver.findElement(hamburgerBtn);
        btn.click();
    }
}
