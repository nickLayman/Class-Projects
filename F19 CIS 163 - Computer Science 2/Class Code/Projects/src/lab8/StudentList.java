package lab8;

import java.util.*;

//********************************************************************
//  PhoneList.java       Author: Lewis/Loftus
//
//  Driver for testing a sorting algorithm.
//********************************************************************
import java.util.stream.Collectors;

public class StudentList
{
	//-----------------------------------------------------------------
	//  Creates an array of Contact objects, sorts them, then prints
	//  them.
	//-----------------------------------------------------------------
	public static void main (String[] args)
	{

		// TODO 1: Answer the following question:
		// Can Collections.sort be used with a regular array like the
		// one below? Why or why not?
	// No, Collections.sort requires a list and an array is not a list
//		Student[] friends = new Student[8];

		ArrayList<Student> friends = new ArrayList<Student>();

		friends.add(new Student ("John", "Smith", "610-555-7384"));
		friends.add(new Student ("Sarah", "Barnes", "610-555-7384"));
		friends.add(new Student ("Mark", "Riley", "733-555-2969"));
		friends.add(new Student ("Laura", "Getz", "663-555-3984"));
		friends.add(new Student ("Laura", "Apple", "663-555-3984"));
		friends.add(new Student ("Laura", "Zimmer", "663-555-3984"));
		friends.add(new Student ("Larry", "Barnes", "464-555-3489"));
		friends.add(new Student ("Mike", "Barnes", "610-555-7384"));
		friends.add(new Student ("Frank", "Phelps", "322-555-2284"));
		friends.add(new Student ("Mario", "Guzman", "804-555-9066"));
		friends.add(new Student ("Marsha", "Grant", "243-555-2837"));

		// Sort using the compareTo function in the Student class
		// TODO 1a: open the Student class and complete compareTo so it sorts by lastname:

		Collections.sort(friends);
		System.out.println("Friends, sorted by last name\n" +
				friends);

		/*
		 * TODO 2: Below this line, the Collections.sort() has an
		 * error. This method should sort by phone number, but it does
		 * not! To correct the problem, complete the compare method in
		 * the SortByPhoneNumber class. 
		 */
		Collections.sort(friends, new SortByPhoneNumber());
		System.out.println("Friends, sorted by phone number\n" +
				friends);

		Collections.sort(friends, new Comparator<Student>() {

			/*
			 * TODO 3a: Complete this an inner class to sort by
			 * phone number.
			 */
			public int compare (Student o1, Student o2) {

				return o1.getPhone().compareTo(o2.getPhone());
			}
		});
		System.out.println("Friends, sorted by phone number\n" +
				friends);

		/*
		 * TODO 3b: Write another sorting algorithm below to sort by
		 * last name (and first name if last names are the same). Use
		 * another inner class just like in 2b.
		 * 
		 *  Code goes just below here
		 */

		Collections.sort(friends, new Comparator<Student>() {
			@Override
			public int compare(Student student, Student t1) {
				if (student.getLastName().compareTo(t1.getLastName()) != 0)
					return student.getLastName().compareTo(t1.getLastName());
				else
					return student.getFirstName().compareTo(t1.getFirstName());
			}
		});

		System.out.println("Friends, sorted by last name\n" +
				friends);

		/*
		 * TODO 4a: Write a lambda function to sort by last name
		 * 
		 *  Code goes just below here
		 */

		Collections.sort(friends, (Student s1, Student s2) -> s1.getLastName().compareTo(s2.getLastName()));

		System.out.println("Friends, sorted by last name\n" +
				friends);

		/*
		 * TODO 4b: Write a lambda function to sort by phone number
		 * 
		 *  Code goes just below here
		 */

		Collections.sort(friends, (Student s1, Student s2) -> s1.getPhone().compareTo(s2.getPhone()));

		System.out.println("Friends, sorted by phone number\n" +
				friends);

		/*
		 * TODO 5a: Write a Stream function to filter by Barnes as the
		 * last name. The code for the stream has been started for you,
		 * but it doesn't filter properly! Your task is to fix the
		 * code.
		 */
		ArrayList<Student> lista = (ArrayList<Student>)friends.stream()
				.filter(arg -> arg.getLastName().equals("Barnes"))
				.collect(Collectors.toList());

		System.out.println("Friends, last name is Barnes " + lista);

		/*
		 * TODO 5b: Write a Stream function to filter by 610 as part of
		 * a phone number. The code for the stream has been started for
		 * you. Your task is to complete the code.
		 */
		ArrayList<Student> listb = (ArrayList<Student>)friends.stream()
				.filter(arg -> arg.getPhone().contains("610"))
				.collect(Collectors.toList());
		System.out.println("Friends, phone contains 610 " + listb);

		/*
		 * TODO 5c: Write a Stream function to capitalize all names.
		 * This one is difficult!
		 */
		ArrayList<Student> listc = (ArrayList<Student>)friends.stream()
				//.map(arg -> new Student(arg.getFirstName().toUpperCase(), arg.getLastName().toUpperCase(), arg.getPhone()))
				.map(arg -> {
					arg.setFirstName(arg.getFirstName().toUpperCase());
					arg.setLastName(arg.getLastName().toUpperCase());
					return arg; })
				.collect(Collectors.toList());

		System.out.println("Friends, names in caps " + listc);
		
		/*
		 * TODO 6a: Walk through the code below, and make sure you
		 * understand what is happening at least conceptually
		 */
		Collections.sort(friends,
				Comparator.comparing(Student::getPhone));
		System.out.println("Friends, sorted by phone number\n" +
				friends);
		
		/*
		 * TODO 6b: Using the similar code as in 6a, write some new
		 * code that will sort by first name
		 * 
		 * Code goes just below here
		 */
		Collections.sort(friends,
				Comparator.comparing(Student::getFirstName));
		System.out.println("Friends, sorted by first name\n" +
				friends);
	}
}

