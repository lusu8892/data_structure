/**
 * Created by sulu on 3/9/17.
 * Class CharCounter computes the count of each char in from a char array or file and stores
 * the result in a data structure.
 */

package com.sulu.huffmancoder;

import org.apache.commons.lang3.ArrayUtils;

import java.io.*;
import java.util.*;

public class CharCounter {


    public char [] getCharPrimArray () { return charPrimArray;}

    private char [] charPrimArray;

    public Character[] getCharObjArray() {
        return charObjArray;
    }

    private Character[] charObjArray;

    public LinkedList<Character> getCountedLLChar() {
        return countedLLChar;
    }

    private LinkedList<Character> countedLLChar = new LinkedList<>();

    public LinkedList<Integer> getCountLLInt() {
        return countLLInt;
    }

    private LinkedList<Integer> countLLInt = new LinkedList<>();

    public LinkedList<CharCount> getCountedCharAndCount() {
        return countedCharAndCount;
    }

    private LinkedList<CharCount> countedCharAndCount = new LinkedList<>();

    /**
     * A constructor with a Character array argument indicates that the counts are to be computed from that array.
     * @param inputCharPrimArray
     */
    public CharCounter (char [] inputCharPrimArray) {

        this.charObjArray = ArrayUtils.toObject(inputCharPrimArray);
        this.charPrimArray = inputCharPrimArray;
    }

    /**
     * A constructor with a String argument specifies the name of a file that the counts are to be computed from.
     * @param pathName
     */
    public CharCounter (String pathName) {
        this.charObjArray = readFileAsChar( pathName );

        this.charPrimArray = ArrayUtils.toPrimitive(charObjArray);
    }

    /**
     * Read file character-by-character
     * @param pathName
     * @return
     */
    private static Character[] readFileAsChar (String pathName) {
        Character [] charObjArray = null;

        try {
            File fileDir = new File(pathName);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(fileDir), "UTF8"));
            LinkedList<Character> LLChar = new LinkedList<>();
            int num = 0;
            while ( (num = in.read()) != -1 ) {
                LLChar.addLast((char)num);
            }

            in.close();
            charObjArray = LLChar.toArray(new Character[LLChar.size()]);
        }
        catch (UnsupportedEncodingException e)
        {
            System.out.println(e.getMessage());
//            return charObjArray;
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
//            return charObjArray;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
//            return charObjArray;
        }
        return charObjArray;
//
//        BufferedReader br = null;
//
//        try {
//            br = new BufferedReader( new FileReader(pathName) );
//            int num = 0;
//            while((num=br.read()) != -1)
//            {
//                LLChar.addFirst((char)num);
//            }
//
//            return LLChar.toArray(new Character[LLChar.size()]);
//
//        }
//        catch (IOException ioe)
//        {
//            ioe.printStackTrace();
//            return null;
//        }
//
//        File file = new File(pathName);
//
//        try {
//            FileInputStream fis = new FileInputStream(file);
//            while (fis.available() > 0 ) {
//                    LLChar.addFirst((char)fis.read());
//            }
//            return LLChar.toArray(new Character[LLChar.size()]);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
    }


    public int [] getCount () {
        return getCount (charPrimArray);
    }

    /**
     * returns an integer array that contains the number of occurrences of the corresponding
     * char in the array char. The order of the array is specified by the current order defined below.
     * @param charArray
     * @return
     */
    public int [] getCount ( char [] charArray ) {

//        Character [] charObjArray = ArrayUtils.toObject( charArray );
        return getCountSub( charArray );
    }

    /**
     * Private helper method
     * @param charAr
     * @return
     */
    private int [] getCountSub ( char [] charAr ) {
        Character [] charObjAr = ArrayUtils.toObject( charAr );
        Arrays.sort(charObjAr);

        LinkedList<Character> LLChar = new LinkedList(Arrays.asList(charObjAr)); // construct a LLChar by sorted Array

        // create a linkedlist to store number of occurrences of the corresponding byte
        LinkedList<Integer> LLCount = new LinkedList<>();

        while ( !LLChar.isEmpty() ) {
            Character chObj = LLChar.getFirst();
            int count = numOccur(LLChar, chObj);
            if ( count != 0 ) {
                LLCount.addLast( count );
            }
        }

        return ArrayUtils.toPrimitive(LLCount.toArray(new Integer[0]));
    }

    /**
     * returns an integer value that contains the number of occurrences of char ch.
     * @param ch
     * @return
     */
    public int getCount ( char ch ) {

        int count = 0;

        ListIterator<CharCount> listIt = countedCharAndCount.listIterator();

        while ( listIt.hasNext() ) {
            CharCount charCount = listIt.next();
            if ( ch == charCount.ch ) {
                count = charCount.count;
                break;
            }
        }

        return count;
    }

    /**
     * Returns number of occurrence of certain Char type argument
     * @param LLChar input source of linkedList the number of occurrence from which is counted
     * @param ch the argument wanted to count
     * @return
     */
    private int numOccur (LinkedList<Character> LLChar, Character ch) {

        int count = 0;
//        if ( LLChar.contains(ch) && !countedLLChar.contains(ch) ) {
//
//            int startIndex = LLChar.indexOf( ch );
//
//            ListIterator listIterator = LLChar.listIterator( startIndex );
//            while ( listIterator.hasNext() ) {
//                if (ch == listIterator.next()) {
//                    count++;
//                    listIterator.remove();  // once found one remove it from linkedlist
//                }
//                else {
//                    break;  // jump out from loop
//                }
//            }
//
//            countedLLChar.addLast( ch );  // append ch to countedLLChar linkedlist
//            countLLInt.addLast( count );  // append count to countLL linkedlist
//
//            // append ch and its corresponding count to countedCharAndCount linkedlist
//            countedCharAndCount.addLast( new CharCount( ch, count) );
//        } else if ( !LLChar.contains(ch) ) {
//            System.out.println ("The input source does NOT contain " + ch);
//        } else if ( countedLLChar.contains(ch) ) {
//            count = getCountFromCharAndCountLL( ch );
//            System.out.println ("The char: " + ch +
//                    " has been counted and the count is " + count);
//        }
        if ( LLChar.contains( ch ) ) {
            int startIndex = LLChar.indexOf( ch );

            ListIterator listIterator = LLChar.listIterator( startIndex );
            while ( listIterator.hasNext() ) {
                if (ch == listIterator.next()) {
                    count++;
                    listIterator.remove();  // once found one remove it from linkedlist
                }
                else {
                    break;  // jump out from loop
                }
            }

            countedLLChar.addLast( ch );  // append ch to countedLLChar linkedlist
            countLLInt.addLast( count );  // append count to countLL linkedlist

            // append ch and its corresponding count to countedCharAndCount linkedlist
            countedCharAndCount.addLast( new CharCount( ch, count) );
        } else {
            System.out.println ("The input source does NOT contain " + ch);
        }

        return count;  //  if no such element in LLChar then count is 0.
    }

//    private Integer getCountFromCharAndCountLL (char chInQ) {
//
//        Integer count = null;
//        if ( countedCharAndCount.isEmpty() ) {
//            count = null;
//        } else {
//            Iterator<CharCount> iterator = countedCharAndCount.iterator();
//            while ( iterator.hasNext() ) {
//                CharCount oneChCount = iterator.next();
//                if ( oneChCount.ch == chInQ ) {
//                    count = oneChCount.count;
//                    break;
//                }
//            }
//        }
//        return count;
//    }

    /**
     * Returns a char array of the bytes that have been counted, i.e. those with non-zero counts.
     * @return
     */
    public char[] getElements() {
//        LinkedList<Character> LLChar = getCountedLLChar();

        char [] countedCharPrimArray = ArrayUtils.toPrimitive( countedLLChar.toArray(new Character[0]) );

        return countedCharPrimArray;
    }


    /**
     * Defines the order for the current object, which controls the ordering of the arrays returned by toString.
     * If order equals char (the default) the ordering is in terms of increasing char value.
     * If order equals countInc or countDec the order is in terms of increasing or decreasing count, respectively.
     * For counts that are equal, the order should be in increasing char order.
     * If order is not one of char, countInc, or countDec throw an exception.
     * @throws Exception
     */
    public void setOrder() throws Exception {
        setOrder("char");
    }

    /**
     * The default setOrder method which is overloading method setOrder( String order ),
     * by invoking the method with string "byte" as default argument value.
     * @throws Exception
     */
    public void setOrder (String order) throws Exception {

        if (order.equals("char")) {
            Collections.sort(countedCharAndCount, new countChar());
//            sortDefault();
        } else if (order.equals("countInc")) {

            Collections.sort(countedCharAndCount, new countInc());
//            sortCountInc();
            return;
        } else if (order.equals("countDec")) {
            Collections.sort(countedCharAndCount, new countDec());
//            sortCountDec();
            return;
        } else {
            throw new IllegalArgumentException();
        }
    }

//    private void sortDefault () {
//        countedLLChar.clear();
//        countLLInt.clear();
//        ListIterator<CharCount> liCharCount = countedCharAndCount.listIterator();
//
//        while (liCharCount.hasNext()) {
//            CharCount charCount = liCharCount.next();
//            countedLLChar.addLast(charCount.ch);
//            countLLInt.addLast(charCount.count);
//        }
//        return;
//    }
//
//    private void sortCountInc () {
//        Integer [] countArray = countLLInt.toArray(new Integer[0]);
//
//        Arrays.sort(countArray);  // sort countArray increasingly
//        countLLInt = new LinkedList(Arrays.asList(countArray));
//
//        countedLLChar.clear();
//        for (Integer count : countArray) {
//            ListIterator<CharCount> liCharCount = countedCharAndCount.listIterator();
//            while (liCharCount.hasNext()) {
//                CharCount charCount = liCharCount.next();
//                if (count.equals(charCount.count)) {
//                    if (!countedLLChar.contains(charCount.ch)) {
//                        countedLLChar.addLast(charCount.ch);
//                        break;
//                    }
//                }
//            }
//        }
//
//        return;
//    }
//
//    private void sortCountDec () {
//        sortCountInc();
//
//        Integer [] countArray = countLLInt.toArray(new Integer[0]);
//        Character [] charArray = countedLLChar.toArray(new Character[0]);
//
//        reverseArray(countArray, 0, countArray.length - 1);
//        reverseArray(charArray, 0, charArray.length - 1);
//
//        countLLInt = new LinkedList(Arrays.asList(countArray));
//        countedLLChar = new LinkedList(Arrays.asList(charArray));
//
//        return;
//    }
//
//    private <AnyType> void reverseArray ( AnyType [] array, int left, int right) {
//        if ( left >= right ) {
//            return;  // base case
//        } else {
//
//            // swap the two ends: array[left] and array[right]
//            AnyType temp = array[left];
//            array[left] = array[right];
//            array[right] = temp;
//
//            // reverse the "middle"
//            reverseArray( array, left + 1, right - 1);
//        }
//    }

    /**
     * Returns a String containing the current bytes and counts in the current order.
     * It should have the format byte:count, separated by spaces, with no leading or trailing spaces.
     * The byte should be formatted as a (signed) integer.
     * For example 32:3 44:1 63:1 72:1 97:1 101:2 104:1 108:2 111:3 114:1 117:1 119:1 121:1
     *
     * Note that in Java bytes are signed (and there is no unsigned byte),
     * so that the implicit integer range of a byte is [−128, 127].
     * When you convert a byte to the integer, it should be negative for byte values 0x80 to 0xFF.
     *
     * @return
     */
    public String toString () {

//        String charCountInfo = null;
//
//        if ( countedLLChar.size() == countLLInt.size() ) {
//            ListIterator<Character> liCh = countedLLChar.listIterator();
//            ListIterator<Integer> liInt = countLLInt.listIterator();
//
//            charCountInfo = new String();
//            while (liCh.hasNext() && liInt.hasNext()) {
//                char ch = liCh.next();
//                int count = liInt.next();
//                String countInfo = new String(ch + ":" + count + "  ");
//                charCountInfo = charCountInfo.concat(countInfo);
//            }
//        }
//        return charCountInfo;
        ListIterator<CharCount> listIterator = countedCharAndCount.listIterator();
        String charCountInfo = new String();
        while ( listIterator.hasNext() ) {
            charCountInfo = charCountInfo.concat(listIterator.next().countInfo );
            charCountInfo = charCountInfo.concat("  ");
        }
        return charCountInfo;
    }

    private static class CharCount {

        public CharCount (Character ch, Integer count) {
            this.ch = ch;
            this.count = count;
            this.countInfo = new String (ch + ":" + count );
        }

        public CharCount () {
            this (null, null);
        }

        public Character ch;
        public Integer count;
        public String countInfo;

    }

    private class countChar implements Comparator<CharCount> {
        @Override
        public int compare(CharCount o1, CharCount o2) {
            return o1.ch.compareTo(o2.ch);
        }
    }

    private class countInc implements Comparator<CharCount> {

        @Override
        public int compare(CharCount o1, CharCount o2) {

            // if result > 0 o1.count is bigger than o2.count
            // if result < 0 o1.count is less than o2.count
            // if result = 0 o1.count is equal to o2.count

            int result = o1.count.compareTo(o2.count);
            if ( result == 0 ) {
                return o1.ch.compareTo(o2.ch);
            }
            return result;
        }
    }

    private class countDec implements Comparator<CharCount> {
        @Override
        public int compare(CharCount o1, CharCount o2) {
            int result = o2.count.compareTo(o1.count);
            if ( result == 0 ) {
                return o2.ch.compareTo(o1.ch);
            }
            return result;
        }
    }
}
