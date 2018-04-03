package Pages;

import model.vUser;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.io.FileNotFoundException;

public class HomePage extends General {
    vUser vUser = new vUser();

   @FindBy(xpath = "//span[contains(text(),'Фотографии')]")
    WebElement PhotosButton;

    public HomePage() throws FileNotFoundException {
    }

    public void clickOnPhotos(){
        PhotosButton.click();
    }

    public boolean isRightPageisOpen(WebDriver webdriver){
        String id = webdriver.findElement(By.xpath("//*[@id='l_pr']/a")).getAttribute("href").toString().substring(17);
        System.out.println("page id " + id);
        System.out.println("page id boolean " + vUser.getId().equals(id));
        return vUser.getId()== id;
    }
}


