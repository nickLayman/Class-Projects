
/**
 * Class Num - used to explain objects as
 * input parameters
 * 
 * @author Ana Posada
 * @version November 2013
 */
public class Num {
    /** number */
    private int n;

    /*****************************************
     * Constructor for objects of class Num
     * @param int n
     ****************************************/
    public Num(int n) {
        this.n = n;
    }

    /*****************************************
     * getNum
     * @return returns the value of n
     ****************************************/
    public int getNum() {
        return n;
    }

    /*****************************************
     * setNum
     * @param n
     ****************************************/
    public void setNum(int n) {
        this.n = n;
    }
    
    public String toString () {
        return "" + n;
    }
}
