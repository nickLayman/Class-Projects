package LabExam;

import java.util.ArrayList;

public class CountXs {

    /**
     * Given a String array, count the number of lines that contain
     *  at least 2 (or more) x's in that line. Assume there is at least
     *  one String in the parameter data array.
     *
     *  Throw a IllegalArgumentException for
     *    (1) if a null String is encounterd.
     *
     * For example:
     *  countX ("xx","xSxxx", "xjjsdf") returns 2
     *  countX ("x")  returns 0
     *  countX ("xx","", "xjjsdf") returns 1
     *  countX ("abcx", null, "") throws IllegalArgumentException
     *
     *   Hint:  Use an ArrayList, makes things just a bit nicer
     *
     */
    public int lines(String[] data) {

        // TODO write the code to complete this method!
        //
        // Note: The code below is simply a placeholder to allow the
        // code to compile and run.

        int countLines = 0;

        for(int lineNum = 0; lineNum < data.length; lineNum++){
            if(data[lineNum] == null)
                throw new IllegalArgumentException();

            if (data[lineNum].indexOf('x') != data[lineNum].lastIndexOf('x'))
                countLines++;
        }

       return countLines;
    }
}
