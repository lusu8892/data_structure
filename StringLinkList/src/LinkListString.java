/**
 * Created by sulu on 2/9/17.
 */
public class LinkListString {
    private StringNode head;
    private StringNode tail;
    private int theSize;  //

    LinkListString () {
        head = null;
        tail = null;
        theSize = 0;  // new object of LinkListString size is zero
    }

    public boolean isEmpty() {
        return head == null;  // return true is head == null, otherwise return false
    }

    public void addFirst (StringNode newNode) {
        if (newNode == null) {
            return;
        }
        else {
            if (isEmpty()) {  // is LinkList is empty then set both head & tail node refer to newNode
                newNode.setLink(null);  // the newNode links to null since it is not both head and tail node
                head = newNode;  // head is newNode, they all refer to the same object(the new added node)
                tail = newNode;  // tail is newNode, they all refer to the same object(the new added node)
            }
            else {
                newNode.next = head;  // Update the next link of a new node, to point to the current head node
                newNode.setLink(head);  // same as above
                head = newNode;  // head and newNode now they all refer to the same node object (i.e., the
                // first node (Update head link to point to the new node)

            }
        }
    }

    public void addLast (StringNode newNode) {
        if (newNode == null) {
            return;
        }
        else {
            // no matter in what case (empty or non-empty linklist), the newly added node needs to link to null
            newNode.setLink(null);
            if (isEmpty()) {
//                newNode.setLink(null);
                head = newNode;
                tail = newNode;
            }
            else {
//                newNode.setLink(null);
                tail.setLink(newNode);  // Update the next link of the current tail node, to point to the new node.
                tail = newNode;  // Update tail link to point to the new node.
            }
        }

    }

    public void insertAtPosition (StringNode previousNode, StringNode newNode) {

    }

    public void deleteFirst () {

    }

}
