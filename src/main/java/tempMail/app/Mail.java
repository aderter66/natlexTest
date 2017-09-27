package tempMail.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Mail {
    private static WebDriver driver;

    private final By emailAddressField = By.xpath("//input[@id='mail']");


    public Mail(WebDriver driver) {
        this.driver = driver;
    }

    public String getAddress () throws InterruptedException {
        WebElement dynamicElement = (new WebDriverWait(driver,10))
                .until(ExpectedConditions.presenceOfElementLocated(emailAddressField));
        WebElement address = driver.findElement(emailAddressField);
        return address.getAttribute("value");
    }
}
