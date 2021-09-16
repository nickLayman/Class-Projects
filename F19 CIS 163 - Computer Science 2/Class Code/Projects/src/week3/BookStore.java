package week4;

import javax.swing.JFrame;

public class BookStore {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
			Book b1, b2, b3;
			Dictionary d1, d2, d3;
			Object o;
			FrenchDictionary f1 = null;
			
			b1 = new Book(12);
			b2 = new Book();

			d1 = new Dictionary();
			d1.setPages(12);
		
			System.out.println(b1);
			b1 = b2;
			b1 = d1;	
			b1 = d1;
	//		d1 = b1;
			o = b1;
			o = d1;
	//		d1 = o;
	//		f1 = o;
			o = f1;
			d1 = f1;
	}

}
