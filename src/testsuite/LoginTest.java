package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String BaseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setup(){
        openBrowser(BaseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){

        //Enter valid username
        WebElement userName = driver.findElement(By.name("username"));
        userName.sendKeys("ronjira");

        //Enter valid password
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("ron12345");

        //Click on ‘LOGIN’ button
        WebElement logIn = driver.findElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[3]/input[1]"));
        logIn.click();

        //Verify the ‘Accounts Overview’ text is display
        String expectedMessage = "Accounts Overview";

        WebElement actualMessageElement = driver.findElement(By.xpath("///h1[contains(text(),'Accounts Overview')]"));
        String actualMessage = actualMessageElement.getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }


    @Test
    public void verifyTheErrorMessage(){

        //Enter invalid username
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("rlobo123");

        //Enter invalid password
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("rlobo123");

        //Click on ‘LOGIN’ button
        WebElement logIn = driver.findElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[3]/input[1]"));
        logIn.click();

        //Verify the error message ‘The username and password could not be verified.’
        String expectedMessage = "The username and password could not be verified.";
        WebElement actualMessageElement = driver.findElement(By.xpath("//p[contains(text(),'The username and password could not be verified.')]"));
        String actualMessage = actualMessageElement.getText();
        Assert.assertEquals( expectedMessage, actualMessage);


    }
    @Test
    public void userShouldLogOutSuccessfully(){

        //Enter valid username
        WebElement userName = driver.findElement(By.name("username"));
        userName.sendKeys("ronjira");

        //Enter valid password
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("ron12345");

        //Click on ‘LOGIN’ button
        WebElement logIn = driver.findElement(By.xpath(""));
        logIn.click();


        //Click on ‘Log Out’ link
        WebElement logOut = driver.findElement(By.xpath("//a[contains(text(),'Log Out')]"));
        logOut.click();

        //Verify the text ‘Customer Login’
        String expectedMessage = "Customer Login";
        WebElement actualMessageElement = driver.findElement(By.xpath("h2[contains(text(),'Customer Login')]"));
        String actualMessage = actualMessageElement.getText();
        Assert.assertEquals(expectedMessage, actualMessage);

    }


    @After
    public void tearDown(){
        closeBrowser();
    }


}
