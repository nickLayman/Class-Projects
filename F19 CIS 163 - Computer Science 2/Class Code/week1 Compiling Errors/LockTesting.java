package week1;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class LockTesting {	
	@Test
	public void testCorrectCode() {
		Lock d = new Lock("246");
		d.enterCode("246");
		Assert.assertTrue(d.isUnlock());
	}

	 @Test
	public void TestMasterPassword() {
		Lock d = new Lock("246");
		d.enterCode("999");
		Assert.assertTrue(d.isUnlock());
		d.enterCode("234");
		Assert.assertFalse(d.isUnlock());
	}
	 
	@Test
    (expected = IllegalArgumentException.class)
	public void ErrorTest (){
		new Lock ("");	
		//  no more code allowed, will not reach.
	}
	 
	 @Test
	public void TestEquals () {
			Lock d1 = new Lock("246");
			Lock d2 = new Lock("246");
			Assert.assertEquals(d1, d2);
	 }
}
