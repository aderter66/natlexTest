package natlex.app.signupForm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SignUpForm {
    private static WebDriver driver;
    private final By signUpBtn = By.xpath("//section[@class='b-registration__login-forms']/button");
    private final By form = By.xpath("//section[@class='b-registration__login-forms']");
    private final By holders = By.xpath("//section[@class='b-registration__login-forms']//input");

    public SignUpForm(WebDriver driver) {
        this.driver = driver;
    }


    public void fillEmailField(String email){
        List<WebElement> h1 = driver.findElements(holders);
        h1.get(0).sendKeys(email);
    }

    public void fillPasswordField(String password){
        List<WebElement> h1 = driver.findElements(holders);
        h1.get(1).sendKeys(password);
    }

    public void fillConfirmField(String confirm){
        List<WebElement> h1 = driver.findElements(holders);
        h1.get(2).sendKeys(confirm);
    }

    public void clickSignUpBtn(){
        WebElement btn = driver.findElement(signUpBtn);
        btn.click();
    }
}
