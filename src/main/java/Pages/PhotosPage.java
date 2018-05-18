package Pages;


import Utils.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class PhotosPage extends General {

    @FindBy(id = "photos_add_album_btn")
    WebElement addAlbumBttn;
    @FindBy(id = "new_album_title")
    WebElement albumTitle;
    //@FindBy(className = "flat_button")
    @FindBy(xpath = "//td/button[contains(text(),'Создать альбом')]")
    WebElement createAlbumButtn;
    @FindBy(id = "photos_upload_input")
    WebElement uploadPhotosBttn;
    @FindBy(className = "flat_button secondary")
    WebElement addToAlbum;
    //@FindBys({@FindBy(className = "photos_album_title ge_photos_album")})
    @FindBy(id = "ui_albums_load_more")
    WebElement showAllAlbums;
    //@FindBy(xpath = "//div[@id='photos_add_list']/div")
    @FindBy(className = "photos_photo_edit_row")
    WebElement photoInProgress;
    @FindBys({@FindBy(className = "ge_photos_album")})
    List<WebElement> albumList;
    @FindBys({@FindBy(className = "photos_row")})
    List<WebElement> photosList;


    String text = Util.getRandomString(6);

    public String createAlbum(WebDriver webDriver) throws InterruptedException {
        initElements(webDriver);
        Thread.sleep(3000);
        addAlbumBttn.click();
        Thread.sleep(4000);
        albumTitle.click();
        albumTitle.sendKeys(text);
        createAlbumButtn.click();
        Thread.sleep(5000);
        System.out.println("Album Created " + text);
        return text;

    }

    //public void clickOnBttn(){
    //uploadPhotosBttn.click();
    //}

    public String uploadPhotos() throws InterruptedException {
        uploadPhotosBttn.sendKeys(System.getProperty("user.dir") + "/test_image.jpeg");
        Thread.sleep(3000);
        String photoID = photoInProgress.getAttribute("data-id");
        System.out.println("uploaded Photo ID: " + photoID);
        return photoID;
        //addToAlbum.click();
        //String id = addToAlbum.getAttribute("id").toString();
        //System.out.println(id);
    }

    public boolean isAlbumPresented(String text) {
        Boolean isAlbumPresent = null;
        showAllAlbums.click();
        for (WebElement albumName : albumList) {
            //System.out.println(albumName.getAttribute("title"));
            String albumNameString = albumName.getAttribute("title");
            if (albumNameString.contains(text)) {
                System.out.println(albumNameString + " " + text + "= success!!");
                isAlbumPresent = true;
                break;
            } else {
                System.out.println(albumNameString);
                isAlbumPresent = false;
            }

        }
        System.out.println(isAlbumPresent);
        return isAlbumPresent;

    }

    public Boolean isRightPhotoLoaded(WebDriver webDriver, String albumName, String photoID) throws InterruptedException {
        Boolean isRightPhotoLoaded = null;
        WebElement album = webDriver.findElement(By.xpath("//div[contains(@title, '"+albumName+"')]"));
        album.click();
        Thread.sleep(3000);
        for (WebElement photo : photosList){
            String ID = photo.getAttribute("id").substring(10);
            if (ID.equals(photoID)){
                System.out.println(ID + " " + photoID);
                isRightPhotoLoaded = true;
                break;
            }
        else {
                System.out.println(ID + " " + photoID);
                isRightPhotoLoaded = false;
            }
        }
        return isRightPhotoLoaded;
    }
}
