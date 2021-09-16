package LabExam;

public class MyLinkedList {
    /** Pointers to the first MyNodes in this linked list */
    private MyNode top;

    public MyLinkedList() {
        top = null;
          }

    /**
     * A function to insert in alphabetical order, that is,
     *  sort order by data. For example:
     *      Example1 : A before B, B before C.
     *      Example2 : Rod before Roger
     *
     * NOTE: the code must work for all list inputs. Not just the list
     * I am testing it with.
     *
     *
     */
    public void insert(String data) {

        // TODO: Write code here
        if(top == null)
            top = new MyNode(data, null);
        else if(top.getElement().compareTo(data) > 0)
            top = new MyNode(data, top);
        else {
            MyNode temp = top;
            while (temp.getNext() != null && temp.getNext().getElement().compareTo(data) < 0)
                temp = temp.getNext();
            temp.setNext(new MyNode(data, temp.getNext()));
        }
    }

    @Override
    public String toString() {

        String s = "";
        MyNode temp = top;
        while (temp != null) {
            s += temp.getElement();
            temp = temp.getNext();
        }
        return  s;
    }
}