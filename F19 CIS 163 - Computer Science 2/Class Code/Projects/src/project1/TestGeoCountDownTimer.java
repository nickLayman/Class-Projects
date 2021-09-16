package project1;

import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import static org.junit.Assert.*;

public class TestGeoCountDownTimer {

	@Test
	public void testConstructor1() {
		GeoCountDownTimer s = new GeoCountDownTimer();
		assertEquals(s.toString(),"January 1, 2019");
	}

	@Test
	public void testConstructor2() {
		GeoCountDownTimer s = new GeoCountDownTimer("5/10/2019");
		assertTrue(s.toDateString().equals("5/10/2019"));
	}

	@Test  (expected = IllegalArgumentException.class)
	public void testConstructor3() {
		GeoCountDownTimer s = new GeoCountDownTimer("2/29/2019");
		//	Create more, many more tests
	}


	@Test
	public void testToString1(){
		GeoCountDownTimer s = new GeoCountDownTimer("2/28/2019");
		assertEquals("February 28, 2019", s.toString());
	}

	@Test
	public void testToString2(){
		GeoCountDownTimer s = new GeoCountDownTimer("3/15/2020");
		assertEquals("March 15, 2020", s.toString());
	}

	@Test
	public void testToString3(){
		GeoCountDownTimer s = new GeoCountDownTimer("3/15/2020");
		assertNotEquals("March 16, 2020", s.toString());
	}

	@Test
	public void testToDateString1(){
		GeoCountDownTimer s = new GeoCountDownTimer("2/28/2019");
		assertEquals("2/28/2019", s.toDateString());
	}

	@Test
	public void testToDateString2(){
		GeoCountDownTimer s = new GeoCountDownTimer("3/15/2020");
		assertEquals("3/15/2020", s.toDateString());
	}

	@Test
	public void testToDateString3(){
		GeoCountDownTimer s = new GeoCountDownTimer("3/15/2020");
		assertNotEquals("3/16/2020", s.toDateString());
	}

	@Test
	public void testInc1() {
		GeoCountDownTimer s1 = new GeoCountDownTimer(5, 10, 2019);
		s1.inc(1);
		assertEquals("5/11/2019", s1.toDateString());
	}

	@Test
	public void testDec1(){
		GeoCountDownTimer s1 = new GeoCountDownTimer(5, 10, 2019);
		s1.dec(1);
		assertEquals("5/9/2019", s1.toDateString());
	}

	@Test
	public void testInc2() {
		GeoCountDownTimer s1 = new GeoCountDownTimer(5, 10, 2019);
		s1.inc();
		assertEquals("5/11/2019", s1.toDateString());
	}

	@Test
	public void testDec2() {
		GeoCountDownTimer s1 = new GeoCountDownTimer(5, 10, 2019);
		s1.dec();
		assertEquals("5/9/2019", s1.toDateString());
	}

	@Test
	public void testInc3() {
		GeoCountDownTimer s1 = new GeoCountDownTimer(5, 10, 2019);
		s1.inc(1);
		s1.inc();
		assertEquals("5/12/2019", s1.toDateString());
	}

	@Test
	public void testDec3() {
		GeoCountDownTimer s1 = new GeoCountDownTimer(5, 10, 2019);
		s1.dec(1);
		s1.dec();
		assertEquals("5/8/2019", s1.toDateString());
	}

	@Test
	public void testInc4() {
		GeoCountDownTimer s1 = new GeoCountDownTimer(5, 10, 2019);
		s1.inc(31);
		assertEquals("6/10/2019", s1.toDateString());
	}

	@Test
	public void testDec4() {
		GeoCountDownTimer s1 = new GeoCountDownTimer(5, 10, 2019);
		s1.dec(30);
		assertEquals("4/10/2019", s1.toDateString());
	}

	@Test
	public void testInc5(){
		GeoCountDownTimer s1 = new GeoCountDownTimer(2, 10, 2020);
		s1.inc(29);
		assertEquals("3/10/2020", s1.toDateString());
	}

	@Test
	public void testDec5(){
		GeoCountDownTimer s1 = new GeoCountDownTimer(3, 10, 2020);
		s1.dec(29);
		assertEquals("2/10/2020", s1.toDateString());
	}

	@Test
	public void testInc6(){
		GeoCountDownTimer s1 = new GeoCountDownTimer(12, 30, 2020);
		for (int i = 0; i < 366; i++)
			s1.inc();
		assertEquals("12/31/2021", s1.toDateString());
	}

	@Test
	public void testDec6(){
		GeoCountDownTimer s1 = new GeoCountDownTimer(12, 30, 2020);
		for (int i = 0; i < 366; i++)
			s1.dec();
		assertEquals("12/30/2019", s1.toDateString());
	}

	@Test
	public void testInc7(){
		GeoCountDownTimer s1 = new GeoCountDownTimer(12, 30, 2019);
		for (int i = 0; i < 366; i++)
			s1.inc();
		assertEquals("12/30/2020", s1.toDateString());
	}

	@Test
	public void testDec7(){
		GeoCountDownTimer s1 = new GeoCountDownTimer(12, 30, 2020);
		for (int i = 0; i < 366; i++)
			s1.dec();
		assertEquals("12/30/2019", s1.toDateString());
	}

	@Test
	public void testInc8() {
		GeoCountDownTimer s1 = new GeoCountDownTimer(5, 10, 2019);
		s1.inc(365);
		assertEquals("5/9/2020", s1.toDateString());
	}

	@Test
	public void testDec8() {
		GeoCountDownTimer s1 = new GeoCountDownTimer(5, 10, 2020);
		s1.dec(365);
		assertEquals("5/11/2019", s1.toDateString());
	}

	@Test
	public void testInc9() {
		GeoCountDownTimer s1 = new GeoCountDownTimer(5, 10, 2020);

		for (int i = 0; i < 365; i++)
			s1.inc();
		assertEquals("5/10/2021", s1.toDateString());
	}

	@Test
	public void testDec9() {
		GeoCountDownTimer s1 = new GeoCountDownTimer(5, 10, 2021);

		for (int i = 0; i < 365; i++)
			s1.dec();
		assertEquals("5/10/2020", s1.toDateString());
	}

	@Test
	public void testInc10() {
		GeoCountDownTimer s1 = new GeoCountDownTimer(5,10,2020);

		for (int i = 0; i < 31665; i++)
			s1.inc();

		for (int i = 0; i < 31665; i++)
			s1.dec();

		assertEquals("5/10/2020", s1.toDateString());
	}

	@Test (expected = IllegalArgumentException.class)
	public void testDec10() {
		GeoCountDownTimer s1 = new GeoCountDownTimer(5,10,2020);

		for (int i = 0; i < 31665; i++)
			s1.dec();
	}

	@Test (expected = IllegalArgumentException.class)
	public void testInc11(){
		GeoCountDownTimer s1 = new GeoCountDownTimer(5,10,2020);

		s1.inc(-1);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testDec11(){
		GeoCountDownTimer s1 = new GeoCountDownTimer(5,10,2020);

		s1.dec(-1);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testInc12(){
		GeoCountDownTimer s1 = new GeoCountDownTimer(5,10,2020);

		s1.inc(-15);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testDec12(){
		GeoCountDownTimer s1 = new GeoCountDownTimer(5,10,2020);

		s1.dec(-15);
	}

	@Test
	public void testIsValidDate1(){
		assertTrue(GeoCountDownTimer.isValidDate(5, 10, 2020));
	}

	@Test
	public void testIsValidDate2(){
		assertFalse(GeoCountDownTimer.isValidDate(5, -10, 2020));
	}

	@Test
	public void testIsValidDate3(){
		assertFalse(GeoCountDownTimer.isValidDate(5, 32, 2020));
	}

	@Test
	public void testIsValidDate4(){
		assertFalse(GeoCountDownTimer.isValidDate(-1, 13, 2020));
	}

	@Test
	public void testIsValidDate5(){
		assertFalse(GeoCountDownTimer.isValidDate(13, 9, 2020));
	}

	@Test
	public void testIsValidDate6(){
		assertFalse(GeoCountDownTimer.isValidDate(10, 9, 2010));
	}

	@Test
	public void testDaysInMonth1(){
		assertEquals(31, GeoCountDownTimer.daysInMonth(1, 2020));
	}

	@Test
	public void testDaysInMonth2(){
		assertEquals(29, GeoCountDownTimer.daysInMonth(2, 2020));
	}

	@Test
	public void testDaysInMonth3(){
		assertEquals(28, GeoCountDownTimer.daysInMonth(2, 2019));
	}

	@Test
	public void testDaysInMonth4(){
		assertEquals(28, GeoCountDownTimer.daysInMonth(2, 2100));
	}

	@Test (expected = IllegalArgumentException.class)
	public void testDaysInMonth5(){
		assertEquals(31, GeoCountDownTimer.daysInMonth(-1, 2019));
	}

	@Test (expected = IllegalArgumentException.class)
	public void testDaysInMonth6(){
		assertEquals(31, GeoCountDownTimer.daysInMonth(13, 2019));
	}

	@Test
	public void testDaysInMonth7(){
		assertEquals(31, GeoCountDownTimer.daysInMonth(1, 2010));
	}

	 @Test (expected = IllegalArgumentException.class)
	    public void testContuctor1() {
		 new GeoCountDownTimer(2,-3,-3);
	    }

	 @Test (expected = IllegalArgumentException.class)
	    public void testContuctor2() {
		 new GeoCountDownTimer("2,-3/-3");
	    }

	@Test
	public void testEquals1 () {
		GeoCountDownTimer s1 = new GeoCountDownTimer(5,9,3000);
		GeoCountDownTimer s2 = new GeoCountDownTimer(5,9,3000);

		assertEquals(s1, s2);
	}

	@Test
	public void testEquals2 () {
		GeoCountDownTimer s1 = new GeoCountDownTimer(5,9,3000);
		GeoCountDownTimer s2 = new GeoCountDownTimer(5,9,2019);

		assertNotEquals(s1, s2);
	}

	@Test
	public void testEquals3 () {
		GeoCountDownTimer s1 = new GeoCountDownTimer(5, 9, 3000);
		GeoCountDownTimer s2 = new GeoCountDownTimer(5, 15, 3000);

		assertNotEquals(s1, s2);
	}

	@Test
	public void testEquals4 () {
		GeoCountDownTimer s1 = new GeoCountDownTimer(5, 9, 3000);
		GeoCountDownTimer s2 = new GeoCountDownTimer(5, 15, 2019);

		assertNotEquals(s1, s2);
	}

	@Test
	public void testEquals5 () {
		GeoCountDownTimer s1 = new GeoCountDownTimer(5, 9, 3000);
		GeoCountDownTimer s2 = new GeoCountDownTimer(10, 9, 3000);

		assertNotEquals(s1, s2);
	}

	@Test
	public void testEquals6 () {
		GeoCountDownTimer s1 = new GeoCountDownTimer(5, 9, 3000);
		GeoCountDownTimer s2 = new GeoCountDownTimer(10, 9, 2019);

		assertNotEquals(s1, s2);
	}

	@Test
	public void testEquals7 () {
		GeoCountDownTimer s1 = new GeoCountDownTimer(5, 9, 3000);
		GeoCountDownTimer s2 = new GeoCountDownTimer(10, 15, 3000);

		assertNotEquals(s1, s2);
	}

	@Test
	public void testEquals8 () {
		GeoCountDownTimer s1 = new GeoCountDownTimer(5, 9, 3000);
		GeoCountDownTimer s2 = new GeoCountDownTimer(10, 15, 2019);

		assertNotEquals(s1, s2);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testEquals9 () {
		GeoCountDownTimer s1 = new GeoCountDownTimer(5, 9, 3000);
		String s2 = "May 9, 3000";

		assertNotEquals(s1, s2);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testEquals10 () {
		GeoCountDownTimer s1 = new GeoCountDownTimer(5, 9, 3000);

		assertNotEquals(s1, null);
	}

	@Test
	public void testEquals11 () {
		GeoCountDownTimer s1 = new GeoCountDownTimer(5,9,3000);
		GeoCountDownTimer s2 = new GeoCountDownTimer(5,9,3000);

		assertTrue(GeoCountDownTimer.equals(s1, s2));
	}

	@Test
	public void testEquals12 () {
		GeoCountDownTimer s1 = new GeoCountDownTimer(5,9,3000);
		GeoCountDownTimer s2 = new GeoCountDownTimer(5,9,2019);

		assertFalse(GeoCountDownTimer.equals(s1, s2));

	}

	@Test
	public void testEquals13 () {
		GeoCountDownTimer s1 = new GeoCountDownTimer(5, 9, 3000);
		GeoCountDownTimer s2 = new GeoCountDownTimer(5, 15, 3000);

		assertFalse(GeoCountDownTimer.equals(s1, s2));
	}

	@Test
	public void testEquals14 () {
		GeoCountDownTimer s1 = new GeoCountDownTimer(5, 9, 3000);
		GeoCountDownTimer s2 = new GeoCountDownTimer(5, 15, 2019);

		assertFalse(GeoCountDownTimer.equals(s1, s2));
	}

	@Test
	public void testEquals15 () {
		GeoCountDownTimer s1 = new GeoCountDownTimer(5, 9, 3000);
		GeoCountDownTimer s2 = new GeoCountDownTimer(10, 9, 3000);

		assertFalse(GeoCountDownTimer.equals(s1, s2));
	}

	@Test
	public void testEquals16 () {
		GeoCountDownTimer s1 = new GeoCountDownTimer(5, 9, 3000);
		GeoCountDownTimer s2 = new GeoCountDownTimer(10, 9, 2019);

		assertFalse(GeoCountDownTimer.equals(s1, s2));
	}

	@Test
	public void testEquals17 () {
		GeoCountDownTimer s1 = new GeoCountDownTimer(5, 9, 3000);
		GeoCountDownTimer s2 = new GeoCountDownTimer(10, 15, 3000);

		assertFalse(GeoCountDownTimer.equals(s1, s2));
	}

	@Test
	public void testEquals18 () {
		GeoCountDownTimer s1 = new GeoCountDownTimer(5, 9, 3000);
		GeoCountDownTimer s2 = new GeoCountDownTimer(10, 15, 2019);

		assertFalse(GeoCountDownTimer.equals(s1, s2));
	}

	@Test (expected = IllegalArgumentException.class)
	public void testEquals19 () {
		GeoCountDownTimer s1 = new GeoCountDownTimer(5, 9, 3000);
		String s2 = "May 9, 3000";

		assertFalse(GeoCountDownTimer.equals(s1, s2));
	}

	@Test (expected = IllegalArgumentException.class)
	public void testEquals20 () {
		GeoCountDownTimer s1 = new GeoCountDownTimer(5, 9, 3000);

		assertFalse(GeoCountDownTimer.equals(s1, null));
	}

	@Test (expected = IllegalArgumentException.class)
	public void testEquals21 () {
		GeoCountDownTimer s2 = new GeoCountDownTimer(5, 9, 3000);

		assertFalse(GeoCountDownTimer.equals(null, s2));
	}

	@Test (expected = IllegalArgumentException.class)
	public void testEquals22 () {
		assertFalse(GeoCountDownTimer.equals(null, null));
	}

	@Test
	public void testCompareTo () {
		GeoCountDownTimer s1 = new GeoCountDownTimer(5,9,2019);
		GeoCountDownTimer s2 = new GeoCountDownTimer(6,1,2019);
		GeoCountDownTimer s3 = new GeoCountDownTimer(5,8,2019);
		GeoCountDownTimer s4 = new GeoCountDownTimer(5,9,2019);

		assertTrue (s2.compareTo(s1) > 0);
		assertTrue (s3.compareTo(s1) < 0);
		assertTrue (s1.compareTo(s4) == 0);
	}

	@Test
	public void testLoadSave1 () {
		GeoCountDownTimer s1 = new GeoCountDownTimer(5,9,2019);
		GeoCountDownTimer s2 = new GeoCountDownTimer(5,9,2019);

		s1.save("./src/project1/testfiles/file1");
		s1 = new GeoCountDownTimer(1,1,2019);  // resets to zero
		s1.load("./src/project1/testfiles/file1");
		assertEquals(s2, s1);
	}

	@Test
	public void testLoadSave2 () {
		GeoCountDownTimer s1 = new GeoCountDownTimer(5,9,2019);
		GeoCountDownTimer s2 = new GeoCountDownTimer(5,9,2019);

		s2.save("./src/project1/testfiles/file1");
		s1 = new GeoCountDownTimer(1,1,2019);  // resets to zero
		s1.load("./src/project1/testfiles/file1");
		assertEquals(s2, s1);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testLoadSave3 () {
		GeoCountDownTimer s1 = new GeoCountDownTimer(5,9,2019);
		GeoCountDownTimer s2 = new GeoCountDownTimer(5,9,2019);

		String filename = "./src/project1/testfiles/yyy//\\y";
		s1.save(filename);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testLoadSave4 () {
		GeoCountDownTimer s1 = new GeoCountDownTimer(5,9,2019);
		GeoCountDownTimer s2 = new GeoCountDownTimer(5,9,2019);

		String filename = "./src/project1/testfiles/kjfgpi90wy348mae;..//sdfkvb[]d";
		s1.save(filename);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testLoadSave5 () {
		GeoCountDownTimer s1 = new GeoCountDownTimer(5,9,2019);
		GeoCountDownTimer s2 = new GeoCountDownTimer(5,9,2019);

		String filename = "./src/project1/testfiles/file2.file2.file2--/7";
		s1.save(filename);
	}

	@Test
	public void testLoadSave6 () {
		GeoCountDownTimer s1 = new GeoCountDownTimer(5,9,2019);
		GeoCountDownTimer s2 = new GeoCountDownTimer(5,9,2019);

		String filename = "./src/project1/testfiles/file2.file2.file2--7";
		s1.save(filename);
		s1.load(filename);
		assertEquals(s1, s2);
	}

	@Test
	public void testLoadSave7 () {
		GeoCountDownTimer s1 = new GeoCountDownTimer(5,9,2019);
		GeoCountDownTimer s2 = new GeoCountDownTimer(5,9,2019);

		String filename = "./src/project1/testfiles/.9";
		s1.save(filename);
		s1.load(filename);
		assertEquals(s1, s2);
	}

	@Test
	public void testLoadSave8 () {
		GeoCountDownTimer s1 = new GeoCountDownTimer(5,9,2019);
		GeoCountDownTimer s2 = new GeoCountDownTimer(5,9,2019);

		String filename = "";
		String charList = "1234567890-=[]\\;',./~!@#$%^&*()_+{}|:\"<>?`";
		for (int size = 1; size <= charList.length(); size++) {
			for (int i = 0; i < charList.length() - size + 1; i++) {
				try {
					filename = charList.substring(i, i + size);
					s1.save("./src/project1/testfiles/" + filename);
					s1.load("./src/project1/testfiles/" + filename);
				} catch (IllegalArgumentException e) {
					System.out.println(filename);
				}
			}
		}
		assertEquals(s1, s2);
	}

	@Test
	public void testDaysToGo1 () {
		GeoCountDownTimer s1 = new GeoCountDownTimer(2,9,2019);
		assertEquals(8, s1.daysToGo("2/1/2019"));
	}

	@Test
	public void testDaysToGo2 () {
		GeoCountDownTimer s1 = new GeoCountDownTimer(2,9,2019);
		assertEquals(1, s1.daysToGo("2/8/2019"));
	}

	@Test
	public void testDaysToGo3 () {
		GeoCountDownTimer s1 = new GeoCountDownTimer(2,9,2019);
		assertEquals(0, s1.daysToGo("2/9/2019"));
	}

	@Test
	public void testDaysToGo4 () {
		GeoCountDownTimer s1 = new GeoCountDownTimer(2,9,5015);
		System.out.print(s1.daysToGo("2/9/2019"));
	}

	@Test
	public void testDaysToGo5 () {
		GeoCountDownTimer s1 = new GeoCountDownTimer(2,9,2019);
		assertEquals(1, s1.daysToGo("2/8/2019"));
	}

	@Test (expected = IllegalArgumentException.class)
	public void testDaysToGo6 () {
		GeoCountDownTimer s1 = new GeoCountDownTimer(2,9,2019);
		s1.daysToGo("2/10/2019");
	}

	@Test (expected = IllegalArgumentException.class)
	public void testDaysToGo7 () {
		GeoCountDownTimer s1 = new GeoCountDownTimer(2,9,2019);
		s1.daysToGo("2/10/15");
	}

	@Test
	public void testDaysInFuture1 () {
		GeoCountDownTimer s1 = new GeoCountDownTimer(2, 9, 2019);
		GeoCountDownTimer s2 = new GeoCountDownTimer(2, 9, 2019);

		assertEquals(s2, s1.daysInFuture(0));
	}

	@Test
	public void testDaysInFuture2 () {
		GeoCountDownTimer s1 = new GeoCountDownTimer(2, 9, 2019);
		GeoCountDownTimer s2 = new GeoCountDownTimer(2, 10, 2019);

		assertEquals(s2, s1.daysInFuture(1));
	}

	@Test
	public void testDaysInFuture3 () {
		GeoCountDownTimer s1 = new GeoCountDownTimer(2, 9, 2019);
		GeoCountDownTimer s2 = new GeoCountDownTimer(2, 8, 2019);

		assertEquals(s2, s1.daysInFuture(-1));
	}

	@Test
	public void testDaysInFuture4 () {
		GeoCountDownTimer s1 = new GeoCountDownTimer(2, 9, 2019);
		GeoCountDownTimer s2 = new GeoCountDownTimer(3, 9, 2019);

		assertEquals(s2, s1.daysInFuture(28));
	}

	@Test
	public void testDaysInFuture5 () {
		GeoCountDownTimer s1 = new GeoCountDownTimer(2, 9, 2019);
		GeoCountDownTimer s2 = new GeoCountDownTimer(2, 9, 2020);

		assertEquals(s2, s1.daysInFuture(365));
	}

	@Test
	public void testDaysInFuture6 () {
		GeoCountDownTimer s1 = new GeoCountDownTimer(2, 9, 2019);
		GeoCountDownTimer s2 = new GeoCountDownTimer(2, 9, 2021);

		assertEquals(s2, s1.daysInFuture(365 + 366));
	}

	@Test
	public void testBasicConstructor() {
		GeoCountDownTimer s = new GeoCountDownTimer();
		assertEquals(s.toString(),"January 1, 2019");
	}

	@Test (expected = IllegalArgumentException.class)
	public void testConstructorJ1() {
		GeoCountDownTimer s = new GeoCountDownTimer("12/12/12");
	}

	@Test
	public void testConstructorJ2() {
		GeoCountDownTimer s = new GeoCountDownTimer("5/10/2019");
		assertTrue(s.toDateString().equals("5/10/2019"));
	}

	@Test  (expected = IllegalArgumentException.class)
	public void testConstructorJ3() {
		GeoCountDownTimer s = new GeoCountDownTimer("2/29/2019");
	}

	@Test  (expected = IllegalArgumentException.class)
	public void testConstructor4() {
		GeoCountDownTimer s = new GeoCountDownTimer("1/1/2014");
	}


	@Test (expected = IllegalArgumentException.class)
	public void testConstructor5(){
		new GeoCountDownTimer("0/3/2020");
	}

	@Test
	public void testConstructor6() {
		GeoCountDownTimer s = new GeoCountDownTimer("2/29/2020");
		assertTrue(s.toDateString().equals("2/29/2020"));
	}

	@Test (expected = IllegalArgumentException.class)
	public void testConstructor7() {
		GeoCountDownTimer s = new GeoCountDownTimer("1/1/2014");
	}

	@Test (expected = IllegalArgumentException.class)
	public void testConstructor8() {
		GeoCountDownTimer s = new GeoCountDownTimer("2/29/2021");
	}

	@Test (expected = IllegalArgumentException.class)
	public void testConstructor9() {
		GeoCountDownTimer s = new GeoCountDownTimer("2/0/2021");
	}

	@Test (expected = IllegalArgumentException.class)
	public void testConstructor10() {
		GeoCountDownTimer s = new GeoCountDownTimer("2/30/2020");
	}

	@Test (expected = IllegalArgumentException.class)
	public void testConstructor11() {
		GeoCountDownTimer s = new GeoCountDownTimer("2/2020");
	}

	@Test
	public void test2ndConstructor1() {
		GeoCountDownTimer s = new GeoCountDownTimer(5, 10, 2020);
		assertTrue(s.toDateString().equals("5/10/2020"));
	}

	@Test (expected = IllegalArgumentException.class)
	public void test2ndConstructor2() {
		GeoCountDownTimer s = new GeoCountDownTimer(0, 10, 2020);
	}

	@Test (expected = IllegalArgumentException.class)
	public void test2ndConstructor3() {
		GeoCountDownTimer s = new GeoCountDownTimer(13, 10, 2020);
	}

	@Test (expected = IllegalArgumentException.class)
	public void test2ndConstructor4() {
		GeoCountDownTimer s = new GeoCountDownTimer(1, 0, 2020);
	}

	@Test (expected = IllegalArgumentException.class)
	public void test2ndConstructor5() {
		GeoCountDownTimer s = new GeoCountDownTimer(2, 32, 2020);
	}

	@Test (expected = IllegalArgumentException.class)
	public void test2ndConstructor6() {
		GeoCountDownTimer s = new GeoCountDownTimer(10, 10, 2014);
	}

	@Test
	public void test2ndConstructor7() {
		GeoCountDownTimer s = new GeoCountDownTimer(2, 29, 2020);
		assertTrue(s.toDateString().equals("2/29/2020"));
	}

	@Test (expected = IllegalArgumentException.class)
	public void test2ndConstructor8() {
		GeoCountDownTimer s = new GeoCountDownTimer(2, 29, 2021);
	}

	@Test (expected = IllegalArgumentException.class)
	public void test2ndConstructor9() {
		GeoCountDownTimer s = new GeoCountDownTimer(3, 32, 2021);
	}

	@Test
	public void test3rdConstructor(){
		GeoCountDownTimer s1 = new GeoCountDownTimer("3/3/2019");
		GeoCountDownTimer s2 = new GeoCountDownTimer();
		s2.GeoCountDownTimer(s1);
		assertTrue(s2.toDateString().equals("3/3/2019"));
	}

	@Test
	public void testChangingTimer(){
		GeoCountDownTimer s1 = new GeoCountDownTimer("3/3/2019");
		GeoCountDownTimer s2 = new GeoCountDownTimer("12/12/2019");
		s1.GeoCountDownTimer(s2);
		assertTrue(s1.toDateString().equals("12/12/2019"));
	}

	@Test
	public void testCompareTo1(){
		GeoCountDownTimer s1 = new GeoCountDownTimer("5/15/2020");
		GeoCountDownTimer s2 = new GeoCountDownTimer("5/14/2020");
		assertTrue(s1.compareTo(s2) == 1);
	}

	@Test
	public void testCompareTo2(){
		GeoCountDownTimer s1 = new GeoCountDownTimer("5/15/2020");
		GeoCountDownTimer s2 = new GeoCountDownTimer("4/15/2020");
		assertTrue(s1.compareTo(s2) == 1);
	}

	@Test
	public void testCompareTo3(){
		GeoCountDownTimer s1 = new GeoCountDownTimer("5/15/2020");
		GeoCountDownTimer s2 = new GeoCountDownTimer("5/15/2019");
		assertTrue(s1.compareTo(s2) == 1);
	}

	@Test
	public void testCompareTo4(){
		GeoCountDownTimer s1 = new GeoCountDownTimer("5/14/2020");
		GeoCountDownTimer s2 = new GeoCountDownTimer("5/15/2020");
		assertTrue(s1.compareTo(s2) == -1);
	}

	@Test
	public void testCompareTo5(){
		GeoCountDownTimer s1 = new GeoCountDownTimer("4/15/2020");
		GeoCountDownTimer s2 = new GeoCountDownTimer("5/15/2020");
		assertTrue(s1.compareTo(s2) == -1);
	}

	@Test
	public void testCompareTo6(){
		GeoCountDownTimer s1 = new GeoCountDownTimer("5/15/2019");
		GeoCountDownTimer s2 = new GeoCountDownTimer("5/15/2020");
		assertTrue(s1.compareTo(s2) == -1);
	}

	@Test
	public void testCompareTo7(){
		GeoCountDownTimer s1 = new GeoCountDownTimer("5/15/2020");
		GeoCountDownTimer s2 = new GeoCountDownTimer("5/15/2020");
		assertTrue(s1.compareTo(s2) == 0);
	}

	@Test
	public void testCompareTo8(){
		GeoCountDownTimer s1 = new GeoCountDownTimer("5/15/2020");
		GeoCountDownTimer s2 = new GeoCountDownTimer("5/14/2021");
		assertTrue(s1.compareTo(s2) == -1);
	}

	@Test
	public void testCompareTo9(){
		GeoCountDownTimer s1 = new GeoCountDownTimer("1/1/2020");
		GeoCountDownTimer s2 = new GeoCountDownTimer("12/31/2019");
		assertTrue(s1.compareTo(s2) == 1);
	}

	@Test
	public void testCompareTo10(){
		GeoCountDownTimer s1 = new GeoCountDownTimer("1/1/2019");
		GeoCountDownTimer s2 = new GeoCountDownTimer("12/31/2019");
		assertTrue(s1.compareTo(s2) == -1);
	}

	@Test
	public void testCompareTo11(){
		GeoCountDownTimer s1 = new GeoCountDownTimer("1/1/2019");
		GeoCountDownTimer s2 = new GeoCountDownTimer("12/31/2020");
		assertTrue(s1.compareTo(s2) == -1);
	}

	@Test
	public void testCompareTo12(){
		GeoCountDownTimer s1 = new GeoCountDownTimer("12/12/2020");
		GeoCountDownTimer s2 = new GeoCountDownTimer("12/11/2021");
		assertTrue(s1.compareTo(s2) == -1);
	}

	@Test
	public void testDaysToGoJ1(){
		GeoCountDownTimer s1 = new GeoCountDownTimer("1/9/2021");
		assertTrue(s1.daysToGo("1/1/2021") == 8);
	}

	@Test
	public void testDaysToGoJ2(){
		GeoCountDownTimer s1 = new GeoCountDownTimer("1/9/2021");
		assertTrue(s1.daysToGo("1/9/2021") == 0);
	}

	@Test
	public void testDaysToGoJ3(){
		GeoCountDownTimer s1 = new GeoCountDownTimer("2/1/2021");
		assertTrue(s1.daysToGo("1/1/2021") == 31);
	}

	@Test
	public void testDaysToGoJ4(){
		GeoCountDownTimer s1 = new GeoCountDownTimer("1/1/2021");
		assertTrue(s1.daysToGo("1/1/2020") == 366);
	}

	@Test
	public void testDaysToGoJ5(){
		GeoCountDownTimer s1 = new GeoCountDownTimer("1/9/2021");
		assertTrue(s1.daysToGo("1/1/2021") == 8);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testDaysToGoJ6(){
		GeoCountDownTimer s1 = new GeoCountDownTimer("1/9/2021");
		assertTrue(s1.daysToGo("1/19/2021") == 10);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testDaysToGoJ7(){
		GeoCountDownTimer s1 = new GeoCountDownTimer("1/9/2021");
		assertTrue(s1.daysToGo("2/9/2021") == 10);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testDaysToGo8(){
		GeoCountDownTimer s1 = new GeoCountDownTimer("1/9/2021");
		assertTrue(s1.daysToGo("1/9/2022") == 10);
	}

	@Test
	public void testDaysInFuture7(){
		GeoCountDownTimer s1 = new GeoCountDownTimer("10/12/2021");
		GeoCountDownTimer s2 = new GeoCountDownTimer();
		s2.GeoCountDownTimer(s1.daysInFuture(10));
		assertTrue(s2.toDateString().equals("10/22/2021"));
	}

	@Test
	public void daysInFuture8(){
		GeoCountDownTimer s1 = new GeoCountDownTimer("10/12/2021");
		GeoCountDownTimer s2 = new GeoCountDownTimer();
		s2.GeoCountDownTimer(s1.daysInFuture(-10));
		assertTrue(s2.toDateString().equals("10/2/2021"));
	}
}
