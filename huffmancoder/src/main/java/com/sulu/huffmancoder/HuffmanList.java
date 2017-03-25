package com.sulu.huffmancoder;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by sulu on 3/17/17.
 */
public class HuffmanList {

    public LinkedList<HuffmanNode> getList() {
        return list;
    }

    private LinkedList<HuffmanNode> list;

    public HuffmanList (char [] charAr) {
        list = new LinkedList<>();

        CharCounter counter = new CharCounter(charAr);
        counter.countChar ();
        counter.setOrder("countInc");

        char [] countCharAr = counter.getElements();
        int [] countAr = counter.getCount();

        for (int i = 0; i < countCharAr.length; i++) {
            if ( countAr[i] > 0 ) {
                list.addLast(new HuffmanNode( countCharAr[i], countAr[i] ));
            }
        }
    }

    public HuffmanList (String str) throws java.io.IOException{

        list = new LinkedList<>();

        CharCounter counter = new CharCounter(str);
        counter.countChar ();
        counter.setOrder("countInc");

        char [] countCharAr = counter.getElements();
        int [] countAr = counter.getCount();

        for (int i = 0; i < countCharAr.length; i++) {
            if ( countAr[i] > 0 ) {
                list.addLast(new HuffmanNode( countCharAr[i], countAr[i] ));
            }
        }
    }

    public HuffmanList (char [] charAr, int [] countAr) throws IllegalArgumentException{
        boolean[] existed = new boolean[128];
        int zero = 0;
        list = new LinkedList<>();

        for(int i = 0; i < existed.length; i++){
            existed[i] = false;
        }

        for(int i = 0; i < countAr.length; i++){
            if ( ( existed[ (int) charAr[i]] ) || ( ( countAr[i] < 0) ) )
                throw new IllegalArgumentException();
            else{
                existed[ (int) charAr[i]] = true;
                if (countAr[i]>0)
                    list.add(new HuffmanNode(charAr[i], countAr[i]));
                if (countAr[i] == 0)
                    zero++;
            }
        }
    }

    public ListIterator<HuffmanNode> listIterator () {
        return list.listIterator();
    }


}
