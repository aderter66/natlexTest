package netlex.app;


import junit.framework.Assert;
import junit.framework.AssertionFailedError;
import netlex.app.navbarMenu.NavbarMenu;
import netlex.app.settingsPage.SettingsPage;
import netlex.app.sideMenu.SideMenu;
import netlex.app.signinForm.SignInForm;
import netlex.app.signupForm.SignUpForm;
import netlex.app.userPage.UserPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import tempMail.app.Mail;

import java.util.concurrent.TimeUnit;

public class Test {
    //ожидание завершения всех скриптов
    private static void waitJS(WebDriver driver){
        while ((Boolean) ((JavascriptExecutor) driver).executeScript("return jQuery.active!=0")) {}
    }

    //открытие новой вкладки
    private static void newWindow(WebDriver driver){
        ((JavascriptExecutor) driver).executeScript("window.open(arguments[0])", "http://temp-mail.ru");
    }
    //переключение м/у вкладками (нумеркция с нуля)
    private static void switchWindows(WebDriver driver, int numberOfWindows){
        String handle = driver.getWindowHandles().toArray()[numberOfWindows].toString();
        driver.switchTo().window(handle);
    }


    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(100,TimeUnit.SECONDS);

        NavbarMenu navbarMenu = new NavbarMenu(driver);
        SideMenu sideMenu = new SideMenu(driver);
        SignInForm signInForm = new SignInForm(driver);
        SignUpForm signUpForm = new SignUpForm(driver);
        Mail Mail = new Mail(driver);
        SettingsPage settingsPage = new SettingsPage(driver);
        UserPage userPage = new UserPage(driver);


        driver.get("http://iknow.travel/");
        //ожидение завершения всех скриптов
        waitJS(driver);
        //клик на меню
        navbarMenu.clickHamburgerBtn();
        sideMenu.clickLoginBtn();
        signInForm.clickSignUpBtn();

        //открытие новой вкладки
        newWindow(driver);
        //переключение м/у вкладками (на вкладку почты)
        switchWindows(driver,1);
        waitJS(driver);
        //Thread.sleep(1000);
        String address = Mail.getAddress();
        switchWindows(driver,0);

        signUpForm.fillEmailField(address);
        signUpForm.fillPasswordField("111111");
        signUpForm.fillConfirmField("111111");
        signUpForm.clickSignUpBtn();

        navbarMenu.clickHamburgerBtn();
        sideMenu.clickSettingsBtn();
        settingsPage.clickSettingsBtn();
        settingsPage.sendPicture();

        String userName = userPage.getUserName();
        String[] addressName = address.split("@");
        try {
            Assert.assertTrue("Неверное имя", userName.toLowerCase().equals(addressName[0].toLowerCase()));
        }catch (AssertionFailedError error){
            System.out.println(error);
            driver.quit();
        }
        driver.quit();
    }
}