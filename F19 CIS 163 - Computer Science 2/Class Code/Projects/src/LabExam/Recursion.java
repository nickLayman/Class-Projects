package LabExam;

public class Recursion {
    /**
     * Given a string, compute recursively (no loops) a new string
     * where all the lowercase 'x' chars have been changed to 'xyx' chars.
     *
     * changeXY("xyz123")  returns "xyxyz123"
     * changeXY("xxx")  returns  "xyxxyxxyx"
     * changeXY("()")  returns  "()"
     */
    public String changeXxyx(String str) {

        // TODO: Write a recursive function to complete this method
        //
        // Note: The code below is simply a placeholder to allow the
        // code to compile and run.

        if (str.length() == 0)
            return str;
        else if (str.charAt(0) == 'x')
            return "xyx" + changeXxyx(str.substring(1));
        else
            return str.substring(0, 1) + changeXxyx(str.substring(1));
    }
}