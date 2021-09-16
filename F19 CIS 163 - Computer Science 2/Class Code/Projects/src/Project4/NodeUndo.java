package Project4;


import java.io.Serializable;

/************************************************************************
 * This program creates a Node that is used in the second linked list.
 * It holds 3 pieces of data. The auto, the Next NodeUndo, and a variable
 * that represents the action done within the primary linked list.
 *
 * @author Justin Von Kulajta Winn and Nick Layman
 *@version 1.9
 ***********************************************************************/

public class NodeUndo implements Serializable {

    /** this is the auto being held by each NodeUndo */
    private Auto dataU;

    /** This is the next NodeUndo in the linked list */
    private NodeUndo nextU;

    /** This represents the action done within the primary linked list */
    private int RemoveOrAdd;

    /************************************************************************
     * This is a constructor that sets the class' variables equal to the
     * passed variables.
     * @param data is the auto that is to be set to the NodeUndo's data
     * @param next is the NodeUndo that the current NodeUndo points to
     * @param ROA is the integer that represents the action done in the
     *            primary code
     ***********************************************************************/
    public NodeUndo(Auto data, NodeUndo next, int ROA) {
        this.dataU = data;
        this.nextU = next;
        this.RemoveOrAdd = ROA;
    }

    /************************************************************************
     * This function returns the auto being held in the current NodeUndo
     * @return the auto within the current NodeUndo
     ***********************************************************************/
    public Auto getDataU() {
        return dataU;
    }

    /************************************************************************
     * This function sets the auto being held in the current NodeUndo
     * @param dataU is the auto that is to be held in the current NodeUndo
     ***********************************************************************/
    public void setDataU(Auto dataU) {
        this.dataU = dataU;
    }

    /************************************************************************
     * This function returns the NodeUndo that the current NodeUndo is
     * pointing to.
     * @return the NodeUndo that is pointed to
     ***********************************************************************/
    public NodeUndo getNextU() {
        return nextU;
    }

    /************************************************************************
     * This function sets the NodeUndo that current NodeUndo is pointing to.
     * @param nextU is the NodUNdo that current NodeUndo is to be pointed to
     ***********************************************************************/
    public void setNextU(NodeUndo nextU) {
        this.nextU = nextU;
    }

    /************************************************************************
     * This function returns the value of the RemoveOrAdd of the current
     * NodeUndo
     * @return the value of RemoveOrAdd
     ***********************************************************************/
    public int getRemoveOrAdd() {
        return RemoveOrAdd;
    }

    /************************************************************************
     * This function sets the value of the RemoveOrAdd
     * @param removeOrAdd is the value that is to be set to the RemoveOrAdd
     ***********************************************************************/
    public void setRemoveOrAdd(int removeOrAdd) {
        RemoveOrAdd = removeOrAdd;
    }
}
