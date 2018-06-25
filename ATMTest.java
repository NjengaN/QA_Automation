package atm_Test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ATMTest {
	int balance=150000;
	ATM atm = new ATM(balance);

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetBalance() {
		Assert.assertEquals(150000, balance);
	}

	@Test
	public void testSetDeposit() {
		int amount = 5000;
		balance = amount + balance;
		Assert.assertEquals(155000, balance);
	}

	@Test
	public void testGetDepositCount() {
		int count = 0;
		if(count>=1&& count<=3) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue("Max number of withdrawal in a day is 3", true);
			fail();
		}
	}

	@Test
	public void testSetDepositCount() {
		double depositCount = 0;
		if(depositCount>=1&& depositCount<=50000) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue("Maximum deposit allowed in a day is 50000", true);
			fail();
		}
	}
		
	@Test
	public void testSetWithdrawalCount() {
		double amount=1;
		if(amount<0) {
			fail();
		}else {
			Assert.assertTrue("1", true);
			fail();
		}
	}
	
	package moja;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Moja {

    public static WebDriver driver;

    @Test
    public void launchBrowser() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "My Phone");
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "6.0");
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("noReset", true);
        driver = new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"), caps);
        //Open URL in Chrome Browser
        driver.get("http://mojawifi.com");
    }
    @Test
    public void captive(){
        try {
            WebElement BtnWelcome = driver.findElement(By.xpath("//*[contains(text(), 'Welcome to Moja')])"));
            BtnWelcome.click();
        }
        catch (Exception e)
        {
            System.out.println("User Already Exists")
        }
        if ()
    }
}
}
