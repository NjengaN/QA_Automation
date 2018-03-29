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
}
