/**
 * Created by sulu on 2/9/17.
 */

//import java.lang.Exception;

public class LinkListString {
    private StringNode head;
    private StringNode tail;
    private StringNode traNode;
    private int size;  //

    LinkListString () {
        head = null;
        tail = null;
        size = 0;  // new object of LinkListString size is zero
    }

    public Iterator iterator() {
        Iterator iter = new Iterator();
        return iter;
    }

    public StringNode getHeadNode() {
        return head;
    }

    public void printList() {
        traNode = head;
        while (traNode != null) {
            System.out.print(traNode.getData());
            traNode = traNode.getNext();  // move travNode down one node
        }
    }
    public void makeEmpty() {
        if (isEmpty()) {
            return;
        }
        else{
            head = null;
            tail = null;
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;  // return true is head == null, otherwise return false
    }


    public void addFirst (StringNode newNode) {
        if (newNode == null) {
            return;
        }
        else {
            size++;
            if (isEmpty()) {  // is LinkList is empty then set both head & tail node refer to newNode
                newNode.setLink(null);  // the newNode links to null since it is not both head and tail node
                head = newNode;  // head is newNode, they all refer to the same object(the new added node)
                tail = newNode;  // tail is newNode, they all refer to the same object(the new added node)
            }
            else {
//                newNode.next = head;  // Update the next link of a new node, to point to the current head node
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
            size++;
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

    public void insertAtPosition (StringNode newNode, int position) {

        if (newNode == null) {
            return;
        }

        else {
            if (position == 0) {  // insert the newNode at the first
                addFirst(newNode);
            }
            else if (position == size) {  // insert the newNode at the end
                addLast(newNode);
            }
            else  {
                StringNode tempCurrent = head.getNext();  // starting traverse from after-to-start node NOT FIRST NODE
                StringNode tempPrevious = head;  // / starting traverse from FIRST NODE
                for (int i = 1; i < size; i++) {

                    if (i == position) {
                        tempPrevious.setLink(newNode);
                        newNode.setLink(tempCurrent);
                        size++;
                        break;

                    }
                    tempPrevious = tempCurrent;
                    tempCurrent = tempCurrent.getNext();
                }
            }
        }
    }

    public void deleteFirst () {
        if (isEmpty()) {
            return;
        }
        else {
            size--;
            if (head == tail) {  // when linklist only has one node
                head = null;
                tail = null;
            }
            else {
                head = head.getNext();
            }
        }

    }

    public void deleteLast () {
        if (isEmpty()) {
            return;
        }
        else {
            size--;
            if (head == tail) {  // when linklist only has one node
                head = null;
                tail = null;
            }
            else {
                traNode = head;
                while (traNode.getNext() != tail) {
                    traNode = traNode.getNext();
                }  // after while block traNode now refers to the previous-to-last node
                tail = traNode;
                tail.setLink(null);
            }
        }
    }

    public void deleteAtPosition (int position) {
        if (position == 0) {  // delete FIRST node
            deleteFirst();
        } else if (position == size) {  // delete the node at the end
            deleteLast();
        } else {
            StringNode tempCurrent = head.getNext();  // starting traverse after-to-start node
            StringNode tempPrevious = head;  // / starting traverse from FIRST NODE
            for (int i = 1; i < size; i++) {

                if (i == position) {
                    tempCurrent = tempCurrent.getNext();  // set tempCurrent to after-to-delete node
                    tempPrevious.setLink(tempCurrent);  // set tempPrevious links to after-to-delete ndoe
//                    newNode.setLink(tempCurrent);
                    size--;
                    break;

                }
                tempPrevious = tempCurrent;
                tempCurrent = tempCurrent.getNext();
            }
        }
    }

    public void toUpperCaseAtPosition(int position) {
        traNode = head;

        for (int i = 0; i < size; i++) {
            if (i == position) {
                char data = traNode.getData();
                if (data >= 'a' && data < 'z') {
                    data += ('A' - 'a');
                    traNode.setData(data);
                }
                break;
            }
            traNode = traNode.getNext(); // forward traNode to next node
        }
    }

    public StringNode copy(StringNode headNode) {
        if (headNode == null) {
            return null;
        }
        // create the first node, copying the first char into it
        StringNode copyFirst = new StringNode(headNode.getData());

        // make a recursive call to get a copy of rest
        // and store the result in the first node's next field
        copyFirst.setLink(copy(headNode.getNext()));
        return copyFirst;
    }

    public class Iterator {
        private StringNode nextNode;
        private Iterator () {
            nextNode = head;
        }

        public boolean hasNext () {
            return (nextNode != null);
        }

        /**
         * it returns the character stored in the current node
         * and it advances the iterator so that it is ready to access the next node
         */
        public char next() throws Exception{
            if (nextNode == null) {
                throw new Exception("Falling off the list end");
//                System.out.println("Falling off the list end");
            }
            char ch = nextNode.getData();
            nextNode = nextNode.getNext();
            return ch;
        }
    }

}
