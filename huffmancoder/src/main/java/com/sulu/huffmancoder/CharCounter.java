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

    private LinkedList<Character> getCountedLLChar() {
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
     * @param inputCharObjArray
     */
    public CharCounter (Character [] inputCharObjArray) {

        this.charObjArray = inputCharObjArray;
        this.charPrimArray = ArrayUtils.toPrimitive( inputCharObjArray );
    }

    /**
     * A constructor with a String argument specifies the name of a file that the counts are to be computed from.
     * @param pathName
     */
    public CharCounter (String pathName) {
        this ( readFileAsChar(pathName) );
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

    /**
     * returns an integer array that contains the number of occurrences of the corresponding
     * char in the array char. The order of the array is specified by the current order defined below.
     * @param charArray
     * @return
     */
    public int [] getCount ( char [] charArray ) {

        Character [] charObjArray = ArrayUtils.toObject( charArray );
        Integer [] countObjArray = getCount( charObjArray );

        return ArrayUtils.toPrimitive(countObjArray);
    }

    /**
     * Private helper method
     * @param charObjArray
     * @return
     */
    private Integer [] getCount ( Character [] charObjArray ) {
        Arrays.sort(charObjArray);

        LinkedList<Character> LLChar = new LinkedList(Arrays.asList(charObjArray)); // construct a LLChar by sorted Array

        // create a linkedlist to store number of occurrences of the corresponding byte
        LinkedList<Integer> LLCount = new LinkedList<>();

        int count = 0;

        while ( !LLChar.isEmpty() ) {
            Character chObj = LLChar.getFirst();
            count = numOccur(LLChar, chObj);
            if ( count != 0 ) {
                LLCount.addLast( count );
            }
        }

        return LLCount.toArray(new Integer[0]);
    }

    /**
     * returns an integer value that contains the number of occurrences of char ch.
     * @param ch
     * @return
     */
    public int getCount ( char ch ) {
        Arrays.sort(charObjArray);
        LinkedList<Character> LLChar = new LinkedList(Arrays.asList(charObjArray));

        return numOccur( LLChar, ch );
    }


    /**
     * Returns number of occurrence of certain Char type argument
     * @param LLChar input source of linkedList the number of occurrence from which is counted
     * @param ch the argument wanted to count
     * @return
     */
    private int numOccur (LinkedList<Character> LLChar, Character ch) {

        int count = 0;

        if ( LLChar.contains(ch) && !countedLLChar.contains(ch) ) {
//            Iterator iterator = LLChar.iterator();
//            while (iterator.hasNext()) {
//                if (ch == iterator.next()) {
//                    count++;
//                    iterator.remove();  // once found one remove it from linkedlist
//                }
//            }

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
        } else if ( !LLChar.contains(ch) ) {
            System.out.println ("The input source does NOT contain " + ch);
        } else if ( countedLLChar.contains(ch) ) {
            count = getCountFromCharAndCountLL( ch );
            System.out.println ("The char: " + ch +
                    " has been counted and the count is " + count);
        }
        return count;  //  if no such element in LLChar then count is 0.
    }

    private Integer getCountFromCharAndCountLL (char chInQ) {

        Integer count = null;
        if ( countedCharAndCount.isEmpty() ) {
            count = null;
        } else {
            Iterator<CharCount> iterator = countedCharAndCount.iterator();
            while ( iterator.hasNext() ) {
                CharCount oneChCount = iterator.next();
                if ( oneChCount.ch == chInQ ) {
                    count = oneChCount.count;
                    break;
                }
            }
        }
        return count;
    }

    /**
     * Returns a char array of the bytes that have been counted, i.e. those with non-zero counts.
     * @return
     */
    public char[] getElements() {
        LinkedList<Character> LLChar = getCountedLLChar();

        char [] countedCharPrimArray = ArrayUtils.toPrimitive( LLChar.toArray(new Character[0]) );

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

//        AnyType [] array = linkedList.toArray((AnyType[]) new Object[0]);

        ListIterator<CharCount> liCharCount = countedCharAndCount.listIterator();
        ListIterator<Character> liCh = countedLLChar.listIterator();
        ListIterator<Integer> liInt  = countLLInt.listIterator();

        if ( order == "char" ) {
            countedLLChar.clear();
            countLLInt.clear();
            CharCount charCount;
            while ( liCharCount.hasNext() ) {
                charCount = liCharCount.next();
                countedLLChar.addLast( charCount.ch );
                countLLInt.addLast( charCount.count );
            }
            return;
        }
        else if ( order == "countInc" ) {
            
            return;
        }
        else if ( order == "countDec" ) {

            return;
        }
        else {
            throw new Exception("Error: The order sequence specified is wrong");
        }
    }


    /**
     *
     * @param count
     * @return
     */
    private char countMapToChar (int count) {
        Character ch = null;
        ListIterator<CharCount> listIterator = countedCharAndCount.listIterator();
        while ( listIterator.hasNext() ) {
            CharCount countInfo = listIterator.next();
            if ( count == countInfo.count ) {
                ch = countInfo.ch;
                break;
            }
        }
        return ch;
    }

    private int charMapToCount (char ch) {
        Integer count = null;
        ListIterator<CharCount> listIterator = countedCharAndCount.listIterator();
        while ( listIterator.hasNext() ) {
            CharCount countInfo = listIterator.next();
            if ( ch == countInfo.ch ) {
                count = countInfo.count;
                break;
            }
        }
        return count;
    }
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

        String charCountInfo = null;

        if ( countedLLChar.size() == countLLInt.size() ) {
            ListIterator<Character> liCh = countedLLChar.listIterator();
            ListIterator<Integer> liInt = countLLInt.listIterator();

            charCountInfo = new String();
            String countInfo;
            char ch;
            int count;

            while (liCh.hasNext() && liInt.hasNext()) {
                ch = liCh.next();
                count = liInt.next();
                countInfo = new String(ch + ":" + count + "  ");
                charCountInfo = charCountInfo.concat(countInfo);
            }
        }
        return charCountInfo;
//        ListIterator<CharCount> listIterator = countedCharAndCount.listIterator();
//        String charCountInfo = new String();
//        while ( listIterator.hasNext() ) {
//            charCountInfo = charCountInfo.concat(listIterator.next().countInfo );
//            charCountInfo = charCountInfo.concat("  ");
//        }
//        return charCountInfo;
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
}
