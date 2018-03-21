package Pages;


import Utils.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class General {

    Browser browser = new Browser();

    public void initElements(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);

    }
}
