package Utils;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

public class Browser {

    protected WebDriver webDriver;
    DesiredCapabilities desiredCapabilities;
    Capabilities capabilities;


    //public WebDriver setUpChrome() {
    // webDriver = new ChromeDriver();
    // webDriver.manage()
    // .timeouts()
    // .implicitlyWait(10L, TimeUnit.SECONDS);
    // webDriver.manage()
    //   .timeouts()
    //  .pageLoadTimeout(20L, TimeUnit.SECONDS);
    // return webDriver;
    // }

   /* public WebDriver setDesiredCapabilities(){
        if (desiredCapabilities.getPlatform().is(Platform.WINDOWS)){
            System.setProperty("webdriver.chrome.driver", "/Automation/VkTask/chromedriver.exe");
            webDriver = new ChromeDriver();

        }
        else if (desiredCapabilities.getPlatform().is(Platform.MAC))
        {
           // setUpChrome();
            webDriver = new ChromeDriver();
            webDriver.manage()
                    .timeouts()
                    .implicitlyWait(10L, TimeUnit.SECONDS);
            webDriver.manage()
                    .timeouts()
                    .pageLoadTimeout(20L, TimeUnit.SECONDS);
        }
        return webDriver;
    }*/

    public WebDriver setCapabilities() {
        System.out.println(System.getProperty("os.name").toLowerCase());
        String os = System.getProperty("os.name").toLowerCase();

        if (os.contains("windows")) {
          System.setProperty("webdriver.chrome.driver", "/Automation/VkTask/chromedriver.exe");
           webDriver = new ChromeDriver();
        } else if (os.contains("mac")) {
            // setUpChrome();
            webDriver = new ChromeDriver();
            webDriver.manage()
                    .timeouts()
                    .implicitlyWait(10L, TimeUnit.SECONDS);
            webDriver.manage()
                    .timeouts()
                    .pageLoadTimeout(20L, TimeUnit.SECONDS);

        }
        return webDriver;
    }


  /*  public static String OSDetector() {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")) {
            return "Windows";
        } else if (os.contains("nux") || os.contains("nix")) {
            return "Linux";
        } else if (os.contains("mac")) {
            return "Mac";
        } else if (os.contains("sunos")) {
            return "Solaris";
        } else {
            return "Other";
        }
    }*/
}

