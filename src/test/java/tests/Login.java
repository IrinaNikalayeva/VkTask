package tests;

import Pages.HomePage;
import Pages.MainPage;
import Pages.PhotosPage;
import Utils.Browser;
import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.httpclient.HttpTransportClient;
//import model.vUser;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class Login extends Browser {
    //vUser user = new vUser();
    MainPage mainPage = new MainPage();
    HomePage homePage = new HomePage();
    PhotosPage photosPage = new PhotosPage();
    WebDriver webDriver = setCapabilities();

    TransportClient transportClient = HttpTransportClient.getInstance();
    VkApiClient vk = new VkApiClient(transportClient);
    SoftAssert softAssert = new SoftAssert();

    public Login() throws FileNotFoundException {
    }

    @Test()

    public void login() throws InterruptedException, IOException, FileNotFoundException {
        mainPage.initElements(webDriver);
        //PageFactory.initElements(webDriver, homePage);
        webDriver.get("https://vk.com");
        //mainPage.provideEmail();
        mainPage.doLogin(webDriver);
        //homePage.initElements(webDriver);
        Thread.sleep(20000);
        softAssert.assertTrue(homePage.isRightPageisOpen(webDriver), "wrong page is open!");
       // homePage.isRightPageisOpen(webDriver);
        homePage.clickOnPhotos(webDriver);
        //photosPage.initElements(webDriver);
        String text = photosPage.createAlbum(webDriver);
        webDriver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        //homePage.clickOnPhotos();
        //Thread.sleep(4000);
       //photosPage.clickOnBttn();
       photosPage.uploadPhotos();
      Thread.sleep(5000);
      homePage.clickOnPhotos(webDriver);
        Thread.sleep(5000);
      photosPage.isAlbumPresented(text);



       //webDriver.quit();

    }

   // @Test
   // public void openPhotosPage(){


    }
