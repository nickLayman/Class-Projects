package lab11;

public class LinkListLab {
    private Node top;

    public LinkListLab() {
        top = null;
    }

    /****************************************************************
     *
     * Determines the size, that is, the number of elements in the list
     *
     * @return  the size of the list
     *
     ****************************************************************/
    public int getLen() {
        // place your code here
        int size = 0;
        if (top != null)
            size++;
        else
            return 0;

        for (Node temp = top; temp.getNext() != null; temp = temp.getNext())
            size++;

        return size;
    }

    /****************************************************************
     *
     * Inserts a node before a specific index.  When the list is empty
     * that is, top = null, then the index must be 0. After the first
     * element is added, index must be:  0 <= index < size of list
     *
     * @param index a specific index into the list.
     *
     * @throws IllegalArgumentException if index < 0 or
     * 			index >= size of the list

     ****************************************************************/

    public void insertBefore (int index, String data) {
        // place your code here
        int size = getLen();

        if (index < 0 || index > size)
            throw new IllegalArgumentException();

        if (index == size && size != 0)
            throw new IllegalArgumentException();

        if (index == 0) {
            top = new Node(data, top);
            return;
        }

        Node prev = top;
        int i = 0;
        while (i < index - 1) {
            prev = prev.getNext();
            i++;
        }

        Node temp = new Node(data, prev.getNext());
        prev.setNext(temp);
    }

    /****************************************************************
     *
     * Inserts a node after a specific index.  When the list is empty
     * that is, top = null, then the index must be 0. After the first
     * element is added, index must be:  0 <= index < size of list
     *
     * @param index a specific index into the list.
     *
     * @throws IllegalArgumentException if index < 0 or
     * 			index >= size of the list

     ****************************************************************/

    public void insertAfter (int index, String data) {
        // place your code here
        insertBefore(index+1, data);
    }

    /****************************************************************
     *
     * Removes the top element of the list
     *
     * @return returns the element that was removed.
     *
     * @throws RuntimeException if top == null, that is,
     * 			 there is no list.
     *
     ****************************************************************/

    public String removeTop () {
        String data = top.getData();
        top = top.getNext();
        return data;
    }


    /****************************************************************
     *
     * This Method removes a node at the specific index position.  The
     * first node is index 0.
     *
     * @param index the position in the linked list that is to be
     * 			removed.  The first position is zero.
     *
     * @throws IllegalArgumentException if index < 0 or
     * 			index >= size of the list
     *
     ****************************************************************/
    public boolean delAt(int index) {
        int size = getLen();

        if (index < 0 || index >= size)
            return false;

        if (index == 0) {
            top = top.getNext();
            return true;
        }

        Node prev = top;
        int i = 0;
        while (i < index - 1) {
            prev = prev.getNext();
            i++;
        }

        prev.setNext(prev.getNext().getNext());
        return true;
    }

// A simple testing program.  Not complete but a good start.

    public static void main (String[] args){
        LinkListLab list = new LinkListLab();

        list.display();
        System.out.println ("Current length = " + list.getLen());

        list.insertBefore(0, "apple");
        list.insertBefore(0, "pear");
        list.insertBefore(1, "peach");
        list.insertBefore(1, "cherry");
        list.insertBefore(3, "donut");
        list.display();
        list.insertAfter(0, "apple");
        list.insertAfter(0, "pear");
        list.insertAfter(1, "peach");
        list.insertAfter(1, "cherry");
        list.insertAfter(3, "donut");
        list.display();

        list.removeTop();
        list.delAt(4);
        list.delAt(2);
        list.delAt(0);
        list.removeTop();
        list.removeTop();

        list.display();
    }

    public void display() {
        Node temp = top;

        System.out.println ("___________ List ________________________");
        while (temp != null) {
            System.out.println (temp.getData());
            temp = temp.getNext();
        }
    }
}