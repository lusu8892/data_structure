/**
 * Created by sulu on 2/14/17.
 */
public class FBLinkList {

    private Person head;
    private Person tail;
    private int theSize;

    // represents the number of changes to Linklist since construction
    // each call to add(), remove(), or clear() will update modCount
    private int modCount = 0;

    FBLinkList () {
        doclear();
    }

    public int size () {
        return theSize;
    }

    public boolean isEmpty() { return size() == 0; }

    public void clear () {
        doclear();
    }


    public Person get( int idx ) { return getNode( idx ); }

    public Person set( int idx, Person newVal) {
        Person p = getNode( idx );
        Person oldVal = new Person(p, null);
        p.setData(newVal.getPersonName(), newVal.getPhoneNumber());
        return oldVal;
    }

    /**
     * Adds an item at the end of this collection.
     * @param x
     * @return return true if adding is successful
     */
    public boolean add( Person x ) {
        add( size( ), x );
        return true;
    }

    /**
     * Adds an item to this collection, at specified position p.
     * @param idx the position to add
     * @param x the item needs to be added
     */
    public void add (int idx, Person x) {
        if ( idx == 0 ) {
            addFisrt(x);
        }
        else if ( idx == size() ) {
            addLast(x);
        }
        else{
            addBefore(getNode(idx - 1, 0, size()), x);
        }
    }

    /**
     * Removes an item from this collection, after specific position p
     * @param idx the position to remove before
     * @return the item removed from this collection
     */
    public Person remove (int idx) {
        if (idx == 0) {
            return removeFirst();
        }
        else {
            return removeAfter(getNode(idx - 1));
        }
    }

    private void doclear () {
        theSize = 0;
        head = new Person (null, null, null);
        tail = new Person (null, null, null);
        tail = head;
        modCount++;
    }

    /**
     * Adds an item at the very beginning of this collection
     * @param x the item needs to be added
     */
    private void addFisrt (Person x) {
        if ( isEmpty() ) {
            Person newNode = new Person(x, null);
            head = newNode;
            tail = newNode;
        }
        else {
            Person newNode = new Person(x, head);
            head = newNode;
        }
        theSize++;
        modCount++;
    }

    private void addLast (Person x) {
        Person newNode = new Person(x, null);
        if ( isEmpty() ) {
            head = newNode;
            tail = newNode;
        }
        else {
            tail.setNext(newNode);
            tail = newNode;
        }
        theSize++;
        modCount++;
    }

    /**
     * Adds an item to this collection, at specified position p.
     * Items at or after that position are slid one position higher.
     * @param p Node to add before.
     * @param x Anything needs to be added
     * @throws IndexOutOfBoundsException if idx is not between 0 and size(),
     */
    private void addBefore (Person p, Person x) {

        // create a newNode for insert after Node p, set newNode's next link = Node p's old next Node
        Person newNode = new Person(x, p.getNext());
        p.setNext(newNode);  // set Node p's next link = current newNode
        theSize++;
        modCount++;
    }

    /**
     * Removes the first node
     * @return first node
     */
    private Person removeFirst () {
        if ( isEmpty() ) {
            return null;
        }
        else {
            theSize--;
            modCount++;
            Person firstNode = new Person(head, null);
            if (head == tail) {  // when linklist only has one node
                head = null;
                tail = null;
            }
            else {
                head = head.getNext();
            }
            return firstNode;
        }
    }

    /**
     * Remove an item from this collection, after specific position p
     * Items after that position are slide one position lower.
     * @param p Node to remove after
     * @return the removed node
     */
    private Person removeAfter (Person p) {
        Person nodeNeedRemove = new Person (p.getNext(), null);
        p.setNext(p.getNext().getNext());  // set Node p's next link = Node p's next next link
        theSize--;
        modCount++;
        return nodeNeedRemove;
    }

    public void reverseRecursion ( ) {
        callReverseRecursion(head, null);
    }

    private void callReverseRecursion (Person currentNode, Person prevNode) {
        if (currentNode == null) {
            tail = head; // reverse head and tail link
            head = prevNode;  // set new head
            return;
        }
        else {
            Person nextNode = currentNode.getNext();
//            nextNode = nextNode.getNext();
            currentNode.setNext(prevNode);
//            prevNode = currentNode;
            modCount++;

            callReverseRecursion(nextNode, currentNode);
        }
    }

    public void reverseIteration () {
        if (isEmpty()) {
            return;
        }
        else {

            if (head == tail) {  // only one node so no need to reverse
                return;
            }
            else {
//                Person pointer = head;
//                Person previous = null, current = null;
//                while (pointer != null) {
//                    current = pointer;
//                    pointer = pointer.getNext();
//
//                    // reverse the link
//                    current.setNext(previous);
//                    previous = current;
//                    head = current;
//                    modCount++;
//                }
//                Person prevNode = null;
//                Person currentNode = head;
//                Person nextNode;
//
//                while (currentNode != null) {
//                    nextNode = currentNode.getNext();  // nextNode advance to next one
//                    currentNode.setNext(prevNode);  // reverse link
//
//                    prevNode = currentNode;
//                    currentNode = nextNode;  // set nextNode as currentNode
//                    modCount++;
//                }
//                tail = head; // reverse head and tail link
//                head = prevNode;  // set new head
                Person prevNode = null, currentNode = null;
                Person nextNode = head;

                while (nextNode != null) {
                    currentNode = nextNode;  // set nextNode as currentNode
                    nextNode = nextNode.getNext();  // nextNode advance to next one

                    currentNode.setNext( prevNode ); // reverse link
                    prevNode = currentNode;  // set prevNode == currentNode

                    modCount++;
                }
                tail = head; // reverse head and tail link
                head = prevNode;  // set new head
            }
        }
    }

    /**
     * Gets the Node at position idx, which must range from 0 to size() - 1.
     * @param idx index to search at.
     * @return  internal node corresponding to idx
     * @throws IndexOutOfBoundsException if idx is not
     *         between 0 and size() - 1, inclusive.
     */
    private Person getNode (int idx) {
        return getNode(idx, 0, size() - 1);
    }

    /**
     * Gets the Node at position idx, which must range from lower to upper.
     * @param idx index to search at.
     * @param lower lowest valid index.
     * @param upper highest valid index.
     * @return internal node corresponding to idx.
     * @throws IndexOutOfBoundsException if idx is not
     *         between lower and upper, inclusive.
     */
    private Person getNode (int idx, int lower, int upper) {
        if (idx < lower || idx > upper) {
            throw new IndexOutOfBoundsException();
        }
        else {
            Person p = head;
            for (int i = lower; i < idx; i++) {
                p = p.getNext();
            }
            return p;
        }
    }

    public FBIterator iterator () {
        return new LinkListIterator();
    }

    private class LinkListIterator implements FBIterator {

        private Person current;
        private int expectedModCount;
        private boolean okToRemove;

        /**
         * Constructor
         */
        private LinkListIterator () {
            current = head;
            expectedModCount = modCount;
            okToRemove = false;
        }

        public boolean hasNext () {
            return (current != null);
        }

        public Person next() {
            if (modCount != expectedModCount) {
                throw new java.util.ConcurrentModificationException();
            }
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }

            Person personToBeReturn = new Person (current, null);
            current = current.getNext();
            okToRemove = true;

            return personToBeReturn;
        }

        public void remove() {
            if (modCount != expectedModCount) {
                throw new java.util.ConcurrentModificationException();
            }
            if (!okToRemove) {
                throw new java.lang.IllegalStateException();
            }
            FBLinkList.this.removeAfter( current );
            expectedModCount++;
            okToRemove = false;
        }

    }

    public static void print (FBLinkList inputLinkList) {
        FBIterator iterator = inputLinkList.iterator();
        while (iterator.hasNext()) {
            Person person = iterator.next();
            System.out.println (person.getPersonName() + " " + person.getPhoneNumber());
        }
    }

    public static void main ( String [] args) {

        FBLinkList fbLinkList = new FBLinkList();

        String[] personName = {"Tom", "Jack", "Alex", "Andy", "Jason", "Will"};
        Long[] phoneNumbers = {7892456789L, 48956241267L, 4653192724L, 9337789455L, 9223668009L, 7154028889L};

//        String[] personName = {"Tom", "Jack"};
//        Long [] phoneNumbers = {7892456789L, 48956241267L};

//        String[] personName = {"Tom"};
//        Long [] phoneNumbers = {7892456789L};

        for (int i = 0; i < personName.length; i++) {
            fbLinkList.add(new Person (personName[i], phoneNumbers[i], null));
        }

//        print(fbLinkList);

//        fbLinkList.reverseIteration();
        fbLinkList.reverseRecursion();
        print(fbLinkList);
    }
}
