
/**
 * Example of parameter passing 
 * 
 * @author CIS-162
 * @version November 2013
 */
public class References{

    public static void main(String[] args)     {
        References r = new References();
        int x = 4;
        int z = 11;
        Num y = new Num(11);

        // passing primitive data types as parameters
        System.out.println("Before invoking task1 NO objects ====> x: " 
            + x +" z: " + z);
            
        r.task1(x,z);
        
        System.out.println("After invoking task1 NO objects ====> x: "  
            + x +" z: " + z);

        // passing objects as parameters
        System.out.println("Before invoking task1 OBJECTS ====> x: " 
            + x +" y: " + y);
            
        r.task1(x,y);
        
        System.out.println("After invoking task1 OBJECTS ====> x: "  
            + x +" y: " + y);
    }

    /*****************************************
     * task1
     * @param int first (primitive data type)
     * @param Num second (ref to an object)
     ****************************************/
    public void task1(int first, Num second) {
        second.setNum(first);
        first = 88899;
    }

    /*****************************************
     * task1
     * @param int first (primitive data type)
     * @param int second (primitive data type)
     ****************************************/
    public void task1(int first, int second)  {
        second = first;
        first = second;
    }
}