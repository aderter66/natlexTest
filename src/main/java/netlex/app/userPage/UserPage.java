package netlex.app.userPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class UserPage {
    private static WebDriver driver;
    private final By userName = By.xpath("//div[@class='i-layout-v2']//div[@class='b-full-user']//p");

    public UserPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getUserName(){
        WebElement dynamicElement = (new WebDriverWait(driver,10))
                .until(ExpectedConditions.presenceOfElementLocated(userName));
        WebElement user = driver.findElement(userName);
        return user.getText();
    }

}
