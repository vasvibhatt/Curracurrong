/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package au.edu.sydney.Curracurrong.runtime;

import java.util.Vector;


/**
 * This class manages the input queues of stream operators
 *
 * @author Saeed Attar
 * The University of Sydney
 */
public class InputQueue {

    /**
     * input channel
     */
    private Vector queue;

    /**
     * unique input channel id
     */
    private int queueID;

    /**
     * data type for the queue
     */
    private String type;

    /**
     * sender operator for channel
     */
    private int senderOperatorID;

    /**
     * receiver operator for channel
     */
    private int receiverOperatorID;

    /**
     * construct a new vector and assign senderOperatorID
     * @param senderOp indicate the sender operator ID to this queue
     */
    public InputQueue(int senderOp, int receiveOp, int id, String dataType) {
        queue = new Vector();
        senderOperatorID = senderOp;
        receiverOperatorID = receiveOp;
        queueID = id;
        type = dataType;
    }

    /**
     * Add items to the end of vector
     * @param x the item to add
     */
    public void push(Object x) {
        queue.addElement(x);
    }

    /**
     * Removes an item from the head of the vector
     * @return the removed item
     */
    public Object pop() {
        Object element;
        element = queue.firstElement();
        queue.removeElementAt(0);
        return element;
    }

    /**
     * This method returns the specified item
     * @param index vector index
     * @return specified element
     */
    public Object peek(int index) {
        Object element = null;
        if(queue.size() > index){
            element = queue.elementAt(index);
        }
        return element;
    }
    /**
     * Check is the queue empty or no
     * @return boolean result of isEmpty
     */
    public boolean isEmpty() {
        if (queue.isEmpty() == true)
            return true;
        else
            return false;
    }

    /**
     * Get the number of elements in the queue
     * @return number of elements in the queue
     */
    public int size() {
        return queue.size();
    }

    /**
     * Get the sender operator ID to this queue
     * @return sender operator ID
     */
    public int getSenderOperatorID() {
        return senderOperatorID;
    }

    /**
     * Get the receiver operator ID to this queue
     * @return receiver operator ID
     */
    public int getReceiverOperatorID() {
        return receiverOperatorID;
    }

    /**
     * Get data type of input queue
     * @return input queue data type
     */
    public String getDataType() {
        return type;
    }

    /**
     * Get the queue ID of the queue
     * @return queue ID
     */
    public int getQueueID() {
        return queueID;
    }
}
