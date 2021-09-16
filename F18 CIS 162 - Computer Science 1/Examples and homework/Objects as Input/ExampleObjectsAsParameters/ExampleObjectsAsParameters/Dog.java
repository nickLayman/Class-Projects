/**************************************************
 * Dog Class
 * @author: Ana Posada
 * @version Summer 2013
 * Example of passing objects as parameters
 * ************************************************/

public class Dog  {
    /** dog's name */
    private String name;

    /** dog's age */
    private int age;

    /*************************************************
     * Constructor - 1 parameter per each instance 
     * variable
     * @param int age
     * @param String Name
     **************************************************/

    public Dog(int age, String name)     {        
        this.age = age;
        this.name = name;
    }

    /*************************************************
     * get age
     * @return age
     **************************************************/
    public int getAge()    {
        return age;
    }

    /*************************************************
     * get name
     * @return name
     **************************************************/
    public String getName ()    {
        return name;
    }

    /*************************************************
     * set age
     * @param int age 
     **************************************************/
    public void setAge(int age)    {
        this.age = age;
    }

    /*************************************************
     * set name
     * @param String name
     **************************************************/
    public void setName(String name)    {
        this.name = name;
    }

    /*************************************************
     * Mystery????
     * @param Dog 
     **************************************************/
    public void mystery (Dog dog)    {
        dog.setName(name);
        dog.setAge(age);
    }

    /*************************************************
     * equals
     * @param Dog - dog to be compared to
     **************************************************/

    public boolean equals (Dog dog)     {
        return name.equals (dog.name) && age == dog.age;
    }

    /*************************************************
     * toString
     * @return String - object converted to a String
     **************************************************/
    public String toString()     {
        return (name + " , age: " + age);
    }

}

