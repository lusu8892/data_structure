/**
 * Created by sulu on 2/9/17.
 */
public class StringNode {
    public char data;
    public StringNode next;  // the reference or the so-called link to refer to next StringNode object


    /**
     * Constructor
     */
    StringNode() {
//        data = null;
        next = null;
    }

    /**
     * Constructor
     * @param myCh input char data
     */
    StringNode(char myCh) {
        data = myCh;
        next = null;  // refers to nothing until being set to object
    }

    /**
     * Function to set link (reference: since the variable next is reference (type)
     * and it refers to a StringNode Object) to next StringNode object
     */
    public void setLink (StringNode node) {
        next = node;
    }

    /**
     * Function so set data/value to the current node object
     * @param inputChar
     */
    public void setData (char inputChar) {
        data = inputChar;
    }

    /**
     * Function to get the next node reference (the address NOT the actual Object)
     * @return the next StringNode
     */
    public StringNode getNext () {
        return next;
    }

    /**
     * Function to get the current node data
     * @return the current node data
     */
    public char getData () {
        return data;
    }
}
