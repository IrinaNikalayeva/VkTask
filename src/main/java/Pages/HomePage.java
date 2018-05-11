package Pages;

import model.vUser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileNotFoundException;

public class HomePage extends General {
    vUser vUser = new vUser();

   @FindBy(xpath = "//span[contains(text(),'Фотографии')]")
    WebElement PhotosButton;

    public HomePage() throws FileNotFoundException {
    }

    public void clickOnPhotos(WebDriver webDriver) throws InterruptedException {
        initElements(webDriver);
        PhotosButton.click();
    }

    public boolean isRightPageisOpen(WebDriver webDriver){
        String id = webDriver.findElement(By.xpath("//*[@id='l_pr']/a")).getAttribute("href").toString().substring(17);
        System.out.println("page id " + id);
        System.out.println("page id boolean " + vUser.getId().equals(id));
        return vUser.getId()== id;
    }
}


