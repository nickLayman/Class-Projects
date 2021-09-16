package Project4;

import java.io.Serializable;

/************************************************************************
 * This program creates a block of memory. It holds an auto and points
 * to the a Node that follows itself in a linked list
 *
 * @author Justin Von Kulajta Winn and Nick Layman
 * @version 1.9
 ************************************************************************/

public class Node implements Serializable {

    /** this is auto that a node holds */
    private Auto data;

    /** this is that Node that this points to */
    private Node next;

    /************************************************************************
     * This constructor creates a node with the passed info.
     * @param data is the auto that is set within the current Node
     * @param next is the Node that current Node is pointing to
     ************************************************************************/
    public Node(Auto data, Node next) {
        this.data = data;
        this.next = next;
    }

    /************************************************************************
     * This function returns the auto within the current Node
     * @return the auto within the current Node
     ************************************************************************/
    public Auto getData() {
        return data;
    }

    /************************************************************************
     * This function overwrites the current data within the Node and replaces
     * it with the passed auto.
     * @param data is the auto that the data is set to
     ************************************************************************/
    public void setData(Auto data) {
        this.data = data;
    }

    /************************************************************************
     * This function returns the Node that this Node is pointing to.
     * @return the Node that is being pointed to by the current Node
     ************************************************************************/
    public Node getNext() {
        return next;
    }

    /************************************************************************
     * This function sets the pointed to Node to the incoming Node
     * @param next is the Node that the current Node is to be pointed to
     ************************************************************************/
    public void setNext(Node next) {
        this.next = next;
    }
}
