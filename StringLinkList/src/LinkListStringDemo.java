/**
 * Created by sulu on 2/12/17.
 */


public class LinkListStringDemo {
    public static int numOccurance (LinkListString list, char ch){

        int num = 0;
        LinkListString.Iterator iter = list.iterator();  // create a iterator

        while(iter.hasNext()) {
            char c = iter.next();
            if (c == ch) {
                num++;
            }
        }
        return num;
    }

    public static void main(String[] args) {

        LinkListString list1 = new LinkListString();
        LinkListString.Iterator iter = list1.iterator();  // create a iterator

        System.out.println(list1.isEmpty());

        System.out.println(list1.getSize());

        char [] charAarray = {'a', 'b', 'c', 'd'};

        for (int i = 0; i < charAarray.length; i++) {
            list1.insertAtPosition(new StringNode(charAarray[i]), i);
        }

        list1.printList();

        list1.insertAtPosition(new StringNode('e'), 3);

        list1.addLast(new StringNode('f'));
        int num = numOccurance(list1,'t');


//        list1.toUpperCaseAtPosition(2);

//        list1.copy(list1.getHeadNode());
//        System.out.println();
//        list1.printList();
////        list1.makeEmpty();
//        list1.deleteAtPosition(4);
//        System.out.println();
//        list1.printList();
//
//        list1.deleteAtPosition(0);
//        System.out.println();
//        list1.printList();
//
//        list1.deleteAtPosition(3);
//        System.out.println();
//        list1.printList();
    }
}
