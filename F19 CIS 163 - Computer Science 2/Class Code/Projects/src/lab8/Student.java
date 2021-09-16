package lab8;
//********************************************************************
//  Contact.java       Author: Lewis/Loftus
//
//  Represents a phone contact.
//********************************************************************

public class Student  implements Comparable<Student>
{
	private String firstName, lastName, phone;


	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Student (String first, String last, String telephone)
	{
		firstName = first;
		lastName = last;
		phone = telephone;
	}
	public String toString ()
	{
		return "\n" + lastName + ", " + firstName + "\t" + phone;
	}
	public boolean equals (Object other)
	{
		return (lastName.equals(((Student)other).getLastName()) &&
				firstName.equals(((Student)other).getFirstName()));
	}
	public int compareTo (Student other)
	{
	// TODO 1a: Complete this function 
		return lastName.compareTo(other.getLastName());
	}

	//-----------------------------------------------------------------
	//  First name accessor.
	//-----------------------------------------------------------------
	public String getFirstName ()
	{
		return firstName;
	}

	//-----------------------------------------------------------------
	//  Last name accessor.
	//-----------------------------------------------------------------
	public String getLastName ()
	{
		return lastName;
	}
}
