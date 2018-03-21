package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends General {

   @FindBy(xpath = "//span[contains(text(),'Фотографии')]")
    WebElement PhotosButton;

    public void clickOnPhotos(){
        PhotosButton.click();
    }
}


