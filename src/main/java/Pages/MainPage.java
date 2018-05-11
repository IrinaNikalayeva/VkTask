package Pages;


import model.vUser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class MainPage extends General {

    @FindBy(id = "index_email")
    WebElement EmailField;

    @FindBy(id = "index_pass")
    WebElement PasswordField;

    @FindBy(id = "index_login_button")
    WebElement LoginButton;


    // public void provideEmail(){
     //   EmailField.click();
        //EmailField.sendKeys("tvetemporary@gmail.com");
        //PasswordField.click();
        //PasswordField.sendKeys("Qwerty12345");
        //LoginButton.click();

//    }

    public void doLogin(WebDriver webDriver) throws IOException {
        vUser vUser = new vUser();
        EmailField.click();
        String username = vUser.getUsername();
        EmailField.sendKeys(username);
        PasswordField.sendKeys(vUser.getPassword().toString());
        LoginButton.click();
    }

}
