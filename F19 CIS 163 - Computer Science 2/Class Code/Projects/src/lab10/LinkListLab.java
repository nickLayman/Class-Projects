package lab10;

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
        int len = 0;

        if (top == null)
            return len;

        len++;
        Node temp = top;
        while(temp.getNext() != null){
            len++;
            temp = temp.getNext();
        }
        return len;
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
        int length = getLen();

        if (index > length || index < 0)
            throw new IllegalArgumentException();

        // you definitely have a valid index

        if (length == 0)
            top = new Node(data, null);
        else if (index == 0)
            top = new Node(data, top);

        if (index > 0){
            int i = 0;
            Node temp = top;
            while (i < index - 1){
                temp = temp.getNext();
                i++;
            }
            temp.setNext(new Node(data, temp.getNext()));
        }
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
        int length = getLen();

        if (index < 0)
            throw new IllegalArgumentException();

        if (length == 0) {
            if (index > 0)
                throw new IllegalArgumentException();
        } else if (index >= length)
            throw new IllegalArgumentException();

        // you definitely have a valid index

        if (length == 0)
            top = new Node(data, null);
        else if (index == 0)
            top.setNext(new Node(data, top.getNext()));

        if (index > 0){
            int i = 0;
            Node temp = top;
            while (i < index){
                temp = temp.getNext();
                i++;
            }
            temp.setNext(new Node(data, temp.getNext()));
        }
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
        if (top == null)
            throw new RuntimeException();

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
        return false;
    }

// A simple testing program.  Not complete but a good start.

    public static void main (String[] args){
        LinkListLab list = new LinkListLab();

        list.display();
        System.out.println ("Current length = " + list.getLen());

//        list.insertBefore(0, "apple");
//        list.insertBefore(0, "pear");
//        list.insertBefore(1, "peach");
//        list.insertBefore(1, "cherry");
//        list.insertBefore(3, "donut");
        list.insertAfter(0, "apple");
        list.insertAfter(0, "pear");
        list.insertAfter(1, "peach");
        list.insertAfter(1, "cherry");
        list.insertAfter(3, "donut");
        list.display();
//
//        list.removeTop();
//        list.delAt(4);
//        list.delAt(2);
//        list.delAt(0);
//        list.removeTop();
//        list.removeTop();
//
//        list.display();
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
