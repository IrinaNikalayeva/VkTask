package Pages;


import Utils.Util;
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
    @FindBys({@FindBy(className = "ge_photos_album")})
    List<WebElement> albumList;


    String text = Util.getRandomString(6);

    public String createAlbum() throws InterruptedException {
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

    public void uploadPhotos() {
        uploadPhotosBttn.sendKeys(System.getProperty("user.dir")+"/test_image.jpeg");
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
            }
            else {
                System.out.println(albumNameString);
                isAlbumPresent = false;
            }
            //System.out.println(albumNameString + " " + text);
            //if (albumNameString == text){
            //   System.out.println(albumName + " " + text + "= success!!");
            // }
        }
        System.out.println(isAlbumPresent);
        return isAlbumPresent;

        //System.out.println(albumName);
        //boolean isAlbumPresent = albumList.contains(text);
        //System.out.println(albumList);
        // System.out.println(isAlbumPresent);
        // return  isAlbumPresent;

    }
}
