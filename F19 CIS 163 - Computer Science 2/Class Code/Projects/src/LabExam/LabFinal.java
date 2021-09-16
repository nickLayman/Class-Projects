package LabExam;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * The class that tests your code in the CountXs, Recursion, and
 * MyLinkedList classes
 *
 * To complete this Lab Final, go to each of these three classes and
 * complete the TODO's within
 *
 * DO NOT alter this file in any way nor any of the other methods
 * provided in the three classes (aside from those with TODO's)
 * DO NOT leave in any extra print statements in your code
 *
 * You may add helper functions in any of the three classes if you
 * wish.
 *
 * When you are ready, raise your hand. One of us will come to you to
 * grade your exam. You only get one chance to have your exam graded.
 * Grading will be done silently, after which you will be dismissed
 * from class so that others can concentrate on completing this exam.
 * If time is called and you are still working on your exam, you will
 * be asked to stop typing and stand next to your machine. Continuing
 * to type will be considered cheating at that point, which will result
 * in you getting a 0 on this exam.
 *
 * Grading:
 *  * 		All 3 correct: 	100%
 *  * 		2 correct:		83%
 *  * 		1 correct:		70%
 *  *
 *  * 		Only one problem may be submitted for partial credit. For
 *  * 		example, if you have 1 complete but 2 partially complete, let
 *  * 		us know which one you want to submit for partial credit.
 *  *
 *  *
 *
 */
public class LabFinal {

    /**
     * The main method to run and test the methods you write.
     *
     */
    @Test
    public void question1() {
        // Question 1
        String[] data1 = new String[3];
        data1[0] = "xhix";
        data1[1] = "";
        data1[2] = "xxxxxx";

        CountXs count = new CountXs();
        Assert.assertTrue(count.lines(data1) == 2);

        String[] data1a = new String[5];
        data1a[0] = "xhix";
        data1a[1] = "x";
        data1a[3] = "xxxxxxx";
        data1a[4] = "jsdlb x  j sdfdsx";
        data1a[2] = "x         s   s sss aaaa    x";

        Assert.assertTrue(count.lines(data1a) == 4);

        try {
            String[] data2 = new String[3];
            data2[0] = "";
            data2[1] = "abc";
            data2[2] = null;
            count.lines(data2);
        } catch (IllegalArgumentException e) {
            Assert.assertTrue(true);
        }

        String[] data3 = new String[3];
        data3[0] = "x";
        data3[1] = "";
        data3[2] = "";
        Assert.assertTrue(count.lines(data3) == 0);
    }


        @Test
        public void question2() {
            // Question 2
            Recursion recurse = new Recursion();
            Assert.assertEquals("axyx", recurse.changeXxyx("ax"));
            Assert.assertEquals("xyxhello", recurse.changeXxyx("xhello"));
            Assert.assertEquals("xyxxyx", recurse.changeXxyx("xx"));
            Assert.assertEquals("", recurse.changeXxyx(""));
        }

        @Test
        public void question3() {
            // Question 3
            MyLinkedList linkedL = new MyLinkedList();

            linkedL.insert("C");
            linkedL.insert("H");
            linkedL.insert("A");
            linkedL.insert("B");
            linkedL.insert("Z");
            linkedL.insert("Q");
            linkedL.insert("K");
            Assert.assertEquals("ABCHKQZ", linkedL.toString());

        }
    }