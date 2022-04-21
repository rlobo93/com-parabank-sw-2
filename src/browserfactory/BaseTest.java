package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;
    String BaseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    public void openBrowser(String BaseUrl){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(BaseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }


    public void closeBrowser(){
        driver.quit();
    }


}
