package LabExam;

/**
 * A custom class to define a single position in a custom double linked
 * list 
 * 
 * @author Roger Ferguson
 *
 */
public class MyNode {

    /** The element that this Node holds */
	private String element;

	/** A next pointer in the double linked list */
	private MyNode next;

	/******************************************************************
	 * A constructor that sets the element, next, and previous of this
	 * Node to null 
	 */
	public MyNode(String data) {
		this.element = data;
		this.next = null;
	}

	/******************************************************************
	 * A constructor that sets the element, next, and previous to the
	 * specified values
	 * @param element that represents the element to set for this Node
	 * @param next that represents the next Node in the double linked
	 * 		list
	 */
	public MyNode(String element, MyNode next) {
		this.element = element;
		this.next = next;
    }

	/******************************************************************
	 * A setter for the element of this Node
	 * @param element that represents the element to set for this Node
	 */
	public void setElement(String element) {
		this.element = element;
	}

	/******************************************************************
	 * A getter for the element of this Node
	 * @return String that represents the element of this Node
	 */
	public String getElement() {
		return this.element;
	}

	/******************************************************************
	 * A setter for the next Node in the double linked list
	 * @param next that represents the next Node in the double linked
	 * 		list
	 */
	public void setNext(MyNode next) {
		this.next = next;
	}

	/******************************************************************
	 * A getter for the next Node in the double linked list
	 * @return MyNode<T> that represents the next Node in the double
	 * 		linked list
	 */
	public MyNode getNext() {
		return this.next;
	}
}

