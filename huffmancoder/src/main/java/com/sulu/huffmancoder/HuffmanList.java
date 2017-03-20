package com.sulu.huffmancoder;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by sulu on 3/17/17.
 */
public class HuffmanList {

    private LinkedList<HuffmanNode> list;

    public HuffmanList (char [] charArray) throws Exception {
        list = new LinkedList<>();

        CharCounter counter = new CharCounter(charArray);
        counter.getCount (charArray);
        counter.setOrder("countInc");

        Character [] countCharAr = counter.getCountedLLChar().toArray(new Character[0]);
        Integer [] countAr = counter.getCountLLInt().toArray(new Integer[0]);

        for (int i = 0; i < countCharAr.length; i++) {
            if ( countAr[i] > 0 ) {
                list.addLast(new HuffmanNode( countCharAr[i], countAr[i] ));
            }
        }
    }

    public HuffmanList (String str) throws Exception{
        CharCounter counter = new CharCounter(str);
        counter.getCount ();
        counter.setOrder();

        Character [] countCharAr = counter.getCountedLLChar().toArray(new Character[0]);
        Integer [] countAr = counter.getCountLLInt().toArray(new Integer[0]);

        for (int i = 0; i < countCharAr.length; i++) {
            if ( countAr[i] > 0 ) {
                list.addLast(new HuffmanNode( countCharAr[i], countAr[i] ));
            }
        }
    }

    public HuffmanList (char [] charArray, int [] countArray) {

    }

    public ListIterator<HuffmanNode> listIterator () {
        return list.listIterator();
    }
}
