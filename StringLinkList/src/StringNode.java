/**
 * Created by sulu on 2/9/17.
 */
public class StringNode {
    private char data;
    private StringNode next;

    StringNode(char myCh) {
        data = myCh;
        next = null;
    }

    /**
     * Function to set link (reference: since the variable next is reference (type)
     * and it refers to a StringNode Object) to next StringNode object
     */
    public void setLink (StringNode newNode) {
        next = newNode;
    }

    /**
     * Function so set data/value to the current node object
     * @param newNode
     */
    public void setValue (StringNode newNode) {
        data = newNode.data;
    }

    /**
     * Function to get the next node
     * @return the next StringNode
     */
    public StringNode next () {
        return next;
    }

    /**
     * Function to get the current node data
     * @return the current node data
     */
    public char ch () {
        return data;
    }
}
