package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id="name")
    WebElement txt_username;
    @FindBy(id="password")
    WebElement txt_password;
    @FindBy(id="login")
    WebElement btn_login;

    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,LoginPage.class);
    }

    public void enterUserName(String username){
        txt_username.sendKeys(username);
    }

    public void enterPassword(String password){
        txt_password.sendKeys(password);
    }

    public void clickOnLogin(){
        btn_login.click();
    }

}
