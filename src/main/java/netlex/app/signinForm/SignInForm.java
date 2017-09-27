package netlex.app.signinForm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInForm {
    private static WebDriver driver;

    private final By signUpBtn = By.xpath("//a[@class='b-login__registration']");

    public SignInForm(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSignUpBtn(){
        WebElement dynamicElement = (new WebDriverWait(driver,10))
                .until(ExpectedConditions.presenceOfElementLocated(signUpBtn));
        WebElement btn = driver.findElement(signUpBtn);
        btn.click();
    }

}
