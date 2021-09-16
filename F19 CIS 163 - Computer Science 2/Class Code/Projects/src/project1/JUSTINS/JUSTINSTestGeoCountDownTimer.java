//package project1.JUSTINS;
//
//import org.junit.Test;
//import project1.GeoCountDownTimer;
//
//import static org.junit.Assert.*;
//
//public class JUSTINSTestGeoCountDownTimer {
//
//	@Test
//	public void testBasicConstructor() {
//		GeoCountDownTimer s = new GeoCountDownTimer();//we had to adjust this?
//		assertEquals(s.toString(),"January 1, 2015");
//	}
//
//    @Test (expected = IllegalArgumentException.class)
//    public void testConstructor1() {
//        GeoCountDownTimer s = new GeoCountDownTimer("12/12/12");
//        assertTrue(s.toDateString().equals("12/12/12"));
//    }
//
//	@Test
//		public void testConstructor2() {
//			GeoCountDownTimer s = new GeoCountDownTimer("5/10/2015");
//			assertTrue(s.toDateString().equals("5/10/2015"));
//		}
//
//		@Test  (expected = IllegalArgumentException.class)
//			public void testConstructor3() {
//				GeoCountDownTimer s = new GeoCountDownTimer("2/29/2015");
//				assertTrue(s.toDateString().equals("2/29/2016"));
//				}
//
//    @Test  (expected = IllegalArgumentException.class)
//    public void testConstructor4() {
//        GeoCountDownTimer s = new GeoCountDownTimer("1/1/2014");
//        assertTrue(s.toDateString().equals("2/29/2016"));
//    }
//
//
//    @Test (expected = IllegalArgumentException.class)
//    public void testConstructor5(){
//        new GeoCountDownTimer("0/3/2016");
//        assertTrue(toString().equals("1/3/2016"));
//    }
//
//    @Test
//    public void testConstructor6() {
//        GeoCountDownTimer s = new GeoCountDownTimer("2/29/2016");
//        assertTrue(s.toDateString().equals("2/29/2016"));
//    }
//
//    @Test (expected = IllegalArgumentException.class)
//    public void testConstructor7() {
//        GeoCountDownTimer s = new GeoCountDownTimer("1/1/2014");
//        assertTrue(s.toDateString().equals("1/1/2014"));
//    }
//
//    @Test (expected = IllegalArgumentException.class)
//    public void testConstructor8() {
//        GeoCountDownTimer s = new GeoCountDownTimer("2/29/2017");
//        assertTrue(s.toDateString().equals("2/29/2017"));
//    }
//
//    @Test (expected = IllegalArgumentException.class)
//    public void testConstructor9() {
//        GeoCountDownTimer s = new GeoCountDownTimer("2/0/2017");
//        assertTrue(s.toDateString().equals("2/0/2017"));
//    }
//
//    @Test (expected = IllegalArgumentException.class)
//    public void testConstructor10() {
//        GeoCountDownTimer s = new GeoCountDownTimer("2/30/2016");
//        assertTrue(s.toDateString().equals("2/30/2016"));
//    }
//
//    @Test (expected = IllegalArgumentException.class)
//    public void testConstructor11() {
//        GeoCountDownTimer s = new GeoCountDownTimer("2/2016");
//        assertTrue(s.toDateString().equals("2/30/2016"));
//    }
//
//    @Test
//    public void test2ndConstructor1() {
//        GeoCountDownTimer s = new GeoCountDownTimer(5, 10, 2016);
//        assertTrue(s.toDateString().equals("5/10/2016"));
//    }
//
//    @Test (expected = IllegalArgumentException.class)
//    public void test2ndConstructor2() {
//        GeoCountDownTimer s = new GeoCountDownTimer(0, 10, 2016);
//        assertTrue(s.toDateString().equals("0/10/2016"));
//    }
//
//    @Test (expected = IllegalArgumentException.class)
//    public void test2ndConstructor3() {
//        GeoCountDownTimer s = new GeoCountDownTimer(13, 10, 2016);
//        assertTrue(s.toDateString().equals("13/10/2016"));
//    }
//
//    @Test (expected = IllegalArgumentException.class)
//    public void test2ndConstructor4() {
//        GeoCountDownTimer s = new GeoCountDownTimer(1, 0, 2016);
//        assertTrue(s.toDateString().equals("1/0/2016"));
//    }
//
//    @Test (expected = IllegalArgumentException.class)
//    public void test2ndConstructor5() {
//        GeoCountDownTimer s = new GeoCountDownTimer(2, 32, 2016);
//        assertTrue(s.toDateString().equals("2/32/2016"));
//    }
//
//    @Test (expected = IllegalArgumentException.class)
//    public void test2ndConstructor6() {
//        GeoCountDownTimer s = new GeoCountDownTimer(10, 10, 2014);
//        assertTrue(s.toDateString().equals("10/10/2014"));
//    }
//
//    @Test
//    public void test2ndConstructor7() {
//        GeoCountDownTimer s = new GeoCountDownTimer(2, 29, 2016);
//        assertTrue(s.toDateString().equals("2/29/2016"));
//    }
//
//    @Test (expected = IllegalArgumentException.class)
//    public void test2ndConstructor8() {
//        GeoCountDownTimer s = new GeoCountDownTimer(2, 29, 2017);
//        assertTrue(s.toDateString().equals("2/29/2017"));
//    }
//
//    @Test (expected = IllegalArgumentException.class)
//    public void test2ndConstructor9() {
//        GeoCountDownTimer s = new GeoCountDownTimer(3, 32, 2017);
//        assertTrue(s.toDateString().equals("3/31/2017"));
//    }
//
//    @Test
//    public void test3rdConstructor(){
//	    GeoCountDownTimer s1 = new GeoCountDownTimer("3/3/2019");
//	    GeoCountDownTimer s2 = new GeoCountDownTimer(s1);
//	    assertTrue(s2.toDateString().equals("3/3/2019"));
//    }
//
//    @Test
//    public void testChangingTimer(){
//        GeoCountDownTimer s1 = new GeoCountDownTimer("3/3/2019");
//        GeoCountDownTimer s2 = new GeoCountDownTimer("12/12/2019");
//        s1.GeoCountDownTimer(s2);
//        assertTrue(s1.toDateString().equals("12/12/2019"));
//    }
//
//    @Test
//    public void testCompareTo1(){
//        GeoCountDownTimer s1 = new GeoCountDownTimer("5/15/2016");
//        GeoCountDownTimer s2 = new GeoCountDownTimer("5/14/2016");
//        assertTrue(s1.compareTo(s2) == 1);
//    }
//
//    @Test
//    public void testCompareTo2(){
//        GeoCountDownTimer s1 = new GeoCountDownTimer("5/15/2016");
//        GeoCountDownTimer s2 = new GeoCountDownTimer("4/15/2016");
//        assertTrue(s1.compareTo(s2) == 1);
//    }
//
//    @Test
//    public void testCompareTo3(){
//        GeoCountDownTimer s1 = new GeoCountDownTimer("5/15/2016");
//        GeoCountDownTimer s2 = new GeoCountDownTimer("5/15/2015");
//        assertTrue(s1.compareTo(s2) == 1);
//    }
//
//    @Test
//    public void testCompareTo4(){
//        GeoCountDownTimer s1 = new GeoCountDownTimer("5/14/2016");
//        GeoCountDownTimer s2 = new GeoCountDownTimer("5/15/2016");
//        assertTrue(s1.compareTo(s2) == -1);
//    }
//
//    @Test
//    public void testCompareTo5(){
//        GeoCountDownTimer s1 = new GeoCountDownTimer("4/15/2016");
//        GeoCountDownTimer s2 = new GeoCountDownTimer("5/15/2016");
//        assertTrue(s1.compareTo(s2) == -1);
//    }
//
//    @Test
//    public void testCompareTo6(){
//        GeoCountDownTimer s1 = new GeoCountDownTimer("5/15/2015");
//        GeoCountDownTimer s2 = new GeoCountDownTimer("5/15/2016");
//        assertTrue(s1.compareTo(s2) == -1);
//    }
//
//    @Test
//    public void testCompareTo7(){
//        GeoCountDownTimer s1 = new GeoCountDownTimer("5/15/2016");
//        GeoCountDownTimer s2 = new GeoCountDownTimer("5/15/2016");
//        assertTrue(s1.compareTo(s2) == 0);
//    }
//
//    @Test
//    public void testCompareTo8(){
//        GeoCountDownTimer s1 = new GeoCountDownTimer("5/15/2016");
//        GeoCountDownTimer s2 = new GeoCountDownTimer("5/14/2017");
//        assertTrue(s1.compareTo(s2) == -1);
//    }
//
//    @Test
//    public void testCompareTo9(){
//        GeoCountDownTimer s1 = new GeoCountDownTimer("1/1/2016");
//        GeoCountDownTimer s2 = new GeoCountDownTimer("12/31/2015");
//        assertTrue(s1.compareTo(s2) == 1);
//    }
//
//    @Test
//    public void testCompareTo10(){
//        GeoCountDownTimer s1 = new GeoCountDownTimer("1/1/2015");
//        GeoCountDownTimer s2 = new GeoCountDownTimer("12/31/2015");
//        assertTrue(s1.compareTo(s2) == -1);
//    }
//
//    @Test
//    public void testCompareTo11(){
//        GeoCountDownTimer s1 = new GeoCountDownTimer("1/1/2015");
//        GeoCountDownTimer s2 = new GeoCountDownTimer("12/31/2016");
//        assertTrue(s1.compareTo(s2) == -1);
//    }
//
//    @Test
//    public void testCompareTo12(){
//        GeoCountDownTimer s1 = new GeoCountDownTimer("12/12/2020");
//        GeoCountDownTimer s2 = new GeoCountDownTimer("12/11/2021");
//        assertTrue(s1.compareTo(s2) == -1);
//    }
//
//    @Test
//    public void testDaysToGo1(){
//	    GeoCountDownTimer s1 = new GeoCountDownTimer("1/9/2017");
//	    assertTrue(s1.daysToGo("1/1/2017") == 8);
//    }
//
//    @Test
//    public void testDaysToGo2(){
//        GeoCountDownTimer s1 = new GeoCountDownTimer("1/9/2017");
//        assertTrue(s1.daysToGo("1/9/2017") == 0);
//    }
//
//    @Test
//    public void testDaysToGo3(){
//        GeoCountDownTimer s1 = new GeoCountDownTimer("2/1/2017");
//        assertTrue(s1.daysToGo("1/1/2017") == 31);
//    }
//
//    @Test
//    public void testDaysToGo4(){
//        GeoCountDownTimer s1 = new GeoCountDownTimer("1/1/2017");
//        assertTrue(s1.daysToGo("1/1/2016") == 366);
//    }
//
//    @Test
//    public void testDaysToGo5(){
//        GeoCountDownTimer s1 = new GeoCountDownTimer("1/9/2017");
//        assertTrue(s1.daysToGo("1/1/2017") == 8);
//    }
//
//    @Test (expected = IllegalArgumentException.class)
//    public void testDaysToGo6(){
//        GeoCountDownTimer s1 = new GeoCountDownTimer("1/9/2017");
//        assertTrue(s1.daysToGo("1/19/2017") == 10);
//    }
//
//    @Test (expected = IllegalArgumentException.class)
//    public void testDaysToGo7(){
//        GeoCountDownTimer s1 = new GeoCountDownTimer("1/9/2017");
//        assertTrue(s1.daysToGo("2/9/2017") == 10);
//    }
//
//    @Test (expected = IllegalArgumentException.class)
//    public void testDaysToGo8(){
//        GeoCountDownTimer s1 = new GeoCountDownTimer("1/9/2017");
//        assertTrue(s1.daysToGo("1/9/2018") == 10);
//    }
//
//    @Test
//    public void testDaysInFuture7(){
//        GeoCountDownTimer s1 = new GeoCountDownTimer("10/12/2017");
//        GeoCountDownTimer s2 = new GeoCountDownTimer(s1.daysInFuture(10));
//        assertTrue(s2.toDateString().equals("10/22/2017"));
//    }
//
//    @Test
//    public void daysInFuture8(){
//        GeoCountDownTimer s1 = new GeoCountDownTimer("10/12/2017");
//        GeoCountDownTimer s2 = new GeoCountDownTimer(s1.daysInFuture(-10));
//        assertTrue(s2.toDateString().equals("10/2/2017"));
//    }
//}
