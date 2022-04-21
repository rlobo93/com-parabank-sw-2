package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class RegisterTest extends BaseTest {
    String BaseUrl = "https://parabank.parasoft.com/parabank/index.htm";


    @Before
    public void setUp(){
        openBrowser(BaseUrl);

    }

    @Test
    public void verifyThatSigningUpPageDisplay(){

        //locate ‘Register’ link and click on it
        WebElement register =driver.findElement(By.xpath("//a[contains(text(),'Register')]"));
        register.click();

        //Verify the text ‘Signing up is easy!’
        String expectedMessage = "Signing up is easy!";
        WebElement actualMessageElement = driver.findElement(By.xpath("//h1[@class='title']"));
        String actualMessage = actualMessageElement.getText();
        Assert.assertEquals( expectedMessage, actualMessage);
    }


    public void userSholdRegisterAccountSuccessfully(){
        WebElement register = driver.findElement(By.linkText("Register"));
        register.click();

        //Enter First name
        WebElement firstName = driver.findElement(By.id("customer.firstName"));
        firstName.sendKeys("Ron");

        //Enter Last name
        WebElement lastName = driver.findElement(By.id("customer.lastName"));
        lastName.sendKeys("Jira");

        //Enter Address
        WebElement address = driver.findElement(By.id("customer.address.street"));
        address.sendKeys("150 london street");

        //Enter City
        WebElement city = driver.findElement(By.id("customer.address.city"));
        city.sendKeys("london");

        //Enter State
        WebElement state = driver.findElement(By.id("customer.address.state"));
        state.sendKeys("london");

        //Enter Zip Code
        WebElement zipCode = driver.findElement(By.id("customer.address.zipCode"));
        zipCode.sendKeys("ub10 10ub");

        //Enter Phone
        WebElement phone = driver.findElement(By.id("customer.phoneNumber"));
        phone.sendKeys("07123456789");

        //Enter SSN
        WebElement SSN = driver.findElement(By.id("customer.ssn"));
        SSN.sendKeys("1234");

        //Enter Username
        WebElement userName = driver.findElement(By.id("customer.username"));
        userName.sendKeys("ronjira");

        //Enter Password
        WebElement password = driver.findElement(By.id("customer.password"));
        password.sendKeys("ron12345");
        //Enter Confirm
        WebElement confirm = driver.findElement(By.id("repeatedPassword"));
        confirm.sendKeys("ron12345");


        //Click on REGISTER button
        WebElement registerButton = driver.findElement(By.xpath("//tbody/tr[13]/td[2]/input[1]"));
        registerButton.click();

        //Verify the text 'Your account was created successfully. You are now logged in.’
        String expectedMessage = "Your account was created successfully. You are now logged in.";
        WebElement actualMessageElement = driver.findElement(By.xpath("//p[contains(text(),'Your account was created successfully. You are now')]"));
        String actualMessage = actualMessageElement.getText();
        Assert.assertEquals(expectedMessage, actualMessage);


    }




    @After
    public void tearDown(){
        closeBrowser();
    }




}
