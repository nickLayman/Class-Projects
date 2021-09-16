package lab8;

import java.util.Comparator;

public class SortByPhoneNumber implements Comparator<Student> {

	@Override
	public int compare (Student o1, Student o2) {

		// TODO: Complete this function so that it allows
		// Collections.sort to sort Students by their phone number
		
		return o1.getPhone().compareTo(o2.getPhone());
	}
}
