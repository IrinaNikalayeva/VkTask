package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Browser {

    protected WebDriver webDriver;


    public WebDriver setUpChrome() {
        webDriver = new ChromeDriver();
        webDriver.manage()
                .timeouts()
                .implicitlyWait(10L, TimeUnit.SECONDS);
        webDriver.manage()
                .timeouts()
                .pageLoadTimeout(20L, TimeUnit.SECONDS);
        return webDriver;
    }

}