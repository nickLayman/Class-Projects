package Project4;

import java.io.Serializable;

/************************************************************************
 * This program creates a single Linked List. It has functions that allow
 * the user to add, remove, or get data from the linked list.
 *
 * @author Justin Von Kulajta Winn and Nick Layman
 *@version 1.9
 ***********************************************************************/

public class MySingleLinkedList implements Serializable
{
    /** this is Node that represents the top of the linked list */
    private Node top;

    /** this is Node that represents the bottom of the linked list */
    private Node tail;

    /** this is the integer that holds the size of the linked list */
    public int size;

    /************************************************************************
     * This constructor make an empty list and sets the size to 0
     ************************************************************************/
    public MySingleLinkedList() {
        top = null;
        size = 0;
    }

    /************************************************************************
     * This function returns the size of the linked list
     * @return size is the size of the linked list
     ************************************************************************/
    public int size() {
        return size;
    }

    /************************************************************************
     * This function clears the current linked list and sets the top to empty
     * and resets the size of the list
     ************************************************************************/
    public void clear () {
        top = null;
        size = 0;
    }

    /************************************************************************
     * This function adds an auto to the linked list. It will sort each
     * addition first by whether it is a car or truck, then it checks each
     * date. THe list goes from earliest bought cars to most recently bought
     * trucks
     * @param s is the auto being passed. It is either a car or truck
     ************************************************************************/
    public void add(Auto s) {
        //Case 0: No List exists therefore it is simply added to the top of the list
        if (top == null){
            top = tail = new Node(s, null);
            size++;
            return;
        }

        //If the item is a car, it will enter this 'if' statement
        if (s.getClass().getName().equalsIgnoreCase("Project4.Car")) {
            //Case 1 For Cars: No Previous Car Exists
            if (top.getData().getClass().getName().equals("Project4.Truck")) {
                top = new Node(s, top);
                size++;
                return;
            }

            //Case 2 For Cars: Passed Auto has earliest date so gets first spot
            if (top.getData().getBoughtOn().compareTo(s.getBoughtOn()) > 0){
                top = new Node(s, top);
                size++;
                return;
            }

            //Case 3 For Cars: Cars exist and next Node is not a truck
            Node temp = top;
            if (temp.getNext() == null){
                Node Insert;
                Insert = new Node(s, null);
                temp.setNext(Insert);
                tail = Insert;
                size++;
                return;
            }

            while (temp.getNext() != null &&
                    temp.getNext().getData().getClass().getName()
                            .equals("Project4.Car")) {
                //Case 4: The passed car's date is in the middle of the list
                if (temp.getNext().getData().getBoughtOn()
                        .compareTo(s.getBoughtOn()) > 0) {
                    Node InsertCar;
                    InsertCar = new Node(s, temp.getNext());
                    temp.setNext(InsertCar);
                    size++;
                    return;
                }
                temp = temp.getNext();
            }
            Node Insert;
            //Case 5: Reaches end of list and no trucks exist
            if (temp.getNext() == null){
                Insert = new Node(s, null);
                temp.setNext(Insert);
                tail = Insert;
                size++;
                return;
            }
            //Case 6: Reaches end of list and trucks exist
            else {
                Insert = new Node(s, temp.getNext());
                temp.setNext(Insert);
                size++;
                return;
            }


        }

        //If this is reached, the auto 's' is a truck
        else {
            Node temp2 = tail;

            //Case 7: Auto is a Truck and no other trucks exist
            if (temp2.getData().getClass().getName().equals("Project4.Car")){
                Node End = new Node(s, null);
                temp2.setNext(End);
                tail = End;
                size++;
                return;
            }

            //Case 8: Only 1 Truck exists in the list
            // it compares the incoming truck and the current trucks
            if (top.getNext() == null){
                if (top.getData().getBoughtOn().compareTo(s.getBoughtOn()) > 0)
                {
                    top = new Node(s, top);
                    size++;
                    return;
                }
                else {
                    Node Second = new Node(s, null);
                    top.setNext(Second);
                    size++;
                    return;
                }
            }

            Node temp = top;
            //This loop gets us to the last car in the list
            while (temp.getNext().getData().getClass().getName()
                    .equals("Project4.Car")){
                temp = temp.getNext();
            }

            //Case 9: If Incoming Truck was bought earlier than the first truck
            if (temp.getData().getClass().getName().equals("Project4.Car")){
                if (temp.getNext().getData().getBoughtOn()
                        .compareTo(s.getBoughtOn()) > 0){
                    Node Check = new Node(s, temp.getNext());
                    temp.setNext(Check);
                    size++;
                    return;
                }
            } else{
                if (temp.getData().getBoughtOn().compareTo(s.getBoughtOn()) > 0){
                    top = new Node(s, top);
                    size++;
                    return;
                }
            }



            while (temp.getNext() != null){
                //Case 10: Incoming Truck should be in the middle of the list
                if (temp.getNext().getData().getBoughtOn()
                        .compareTo(s.getBoughtOn()) > 0) {
                    Node InsertTruck;
                    InsertTruck = new Node(s, temp.getNext());
                    temp.setNext(InsertTruck);
                    size++;
                    return;
                }
                temp = temp.getNext();
            }

            //Case 11: Truck goes one the end of the list
            Node End = new Node(s, null);
            temp.setNext(End);
            tail = End;
            size++;
            return;
        }
        //  Order is: (First) List all Cars in bought by date order
        //  followed by (second) List all Trucks in bought by order.
    }

    /************************************************************************
     * This function removes an auto from a linked list. It searches the
     * list for an identical auto within the list. It then removes said auto
     * @param auto is the auto being searched for in the list.
     ************************************************************************/
    public void remove(Auto auto){
        //Case 0: There is no list
        if (top == null)
            return;

        //Case 1: remove the top
        if (top.getData().equals(auto)) {
            top = top.getNext();
            size--;
            return;
        }

        //Case 3: remove from middle or end

        //find the auto before the one to remove
        Node temp = top;
        while(temp.getNext() != null && !temp.getNext().getData().equals(auto))
            temp = temp.getNext();

        if (temp.getNext() == null)
            return;
        else
            temp.setNext(temp.getNext().getNext());

        size--;
    }

    /************************************************************************
     * This function removes an auto from the list based on the index.
     * It will return the auto at the given index if the index is within
     * range of the size of the list
     * @param index is the location of the desired auto that is to be
     *              removed from the list
     * @throws IllegalArgumentException if given index is out of bounds
     * @return the auto being removed from the list
     ************************************************************************/
    public Auto remove(int index) {
        if (index < 0 || index >= size) {
            if (size == 0 && index == 0)
                return null;

            throw new IllegalArgumentException();
        }

        //valid index and list exists

        Auto data;

        //remove the top
        if (index == 0) {
            data = top.getData();
            top = top.getNext();
            size--;
            return data;
        }

        //remove anything else
        Node temp = top;
        for(int i = 0; i < index - 1; i++){
            temp = temp.getNext();
        }
        data = temp.getNext().getData();
        temp.setNext(temp.getNext().getNext());
        size--;
        return data;
    }

    /************************************************************************
     * This function gets the auto at the request index location. Unlike
     * the remove function that is based off of an index, it does not remove
     * the auto from the list
     * @param index is the location of the desired auto that is to be
     *              returned from the list
     * @throws IllegalArgumentException if the index is not within the size
     *                                  of the linked list
     * @return the auto at the index
     ************************************************************************/
    public Auto get(int index) {
        if (index < 0 || index >= size) {
            if (size == 0 && index == 0)
                return null;

            throw new IllegalArgumentException();
        }

        //valid index and list exists

        Node temp = top;
        for(int i = 0; i < index; i++){
            temp = temp.getNext();
        }
        return temp.getData();
    }

    /************************************************************************
     * This function was used to check the linked list. This is not used.
     ************************************************************************/
    public String toString() {
        return null;
    }
}
