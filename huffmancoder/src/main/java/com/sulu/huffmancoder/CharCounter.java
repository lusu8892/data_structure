/**
 * Created by sulu on 3/9/17.
 * Clss ByteCounter computes the count of each byte in from a char array or file and stores
 * the result in a data structure.
 */

package com.sulu.huffmancoder;

import org.apache.commons.lang3.*;

import java.io.*;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class CharCounter {

    public char [] getCharPrimArray () { return charPrimArray;}

    private char [] charPrimArray;

    public Character[] getCharObjArray() {
        return charObjArray;
    }

    private Character[] charObjArray;

    /**
     * A constructor with a Character array argument indicates that the counts are to be computed from that array.
     * @param inputCharObjArray
     */
    public CharCounter (Character [] inputCharObjArray) {

        this.charObjArray = inputCharObjArray;
        this.charPrimArray = objToPrim( inputCharObjArray );
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
        LinkedList<Character> LLChar = new LinkedList<>();
        try {
            File fileDir = new File(pathName);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(fileDir), "UTF8"));
            int num = 0;
            while ( (num = in.read()) != -1 ) {
                LLChar.addLast((char)num);
            }

            in.close();
            return LLChar.toArray(new Character[LLChar.size()]);
        }
        catch (UnsupportedEncodingException e)
        {
            System.out.println(e.getMessage());
            return null;
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
            return null;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
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
     * A private static method to convert Character [] to char []
     * * @param charObjArray
     * @return
     */
    private static char[] objToPrim (Character [] charObjArray) {
        char[] charPrimArray = new char[charObjArray.length];

        int i = 0;
        for (Character charObj : charObjArray) {
            charPrimArray[i++] = charObj;
        }

        return charPrimArray;
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

    private Integer [] getCount ( Character [] charObjArray ) {
        Arrays.sort(charObjArray);

        LinkedList<Character> LLChar = new LinkedList(Arrays.asList(charObjArray)); // construct a LLByte by sorted Array
        Iterator iterator = LLChar.iterator();

        // create a linkedlist to store number of occurrences of the corresponding byte
        LinkedList<Integer> LLCount = new LinkedList<Integer>();

        while ( !LLChar.isEmpty() ) {
            Character chObj = (Character) LLChar.getFirst();
            LLCount.addLast(numOccur(LLChar, chObj));
        }

        return LLCount.toArray(new Integer[0]);
    }

    /**
     * returns an integer value that contains the number of occurrences of char ch.
     * @param ch
     * @return
     */
    public int getCount ( char ch ) {
        LinkedList<Character> LLChar = new LinkedList(Arrays.asList(charObjArray));
        return numOccur( LLChar, ch);
    }


    /**
     * Returns number of occurrence of certain Char type argument
     * @param LLChar input source of linkedList the number of occurrence from which is counted
     * @param ch the argument wanted to count
     * @return
     */
    private int numOccur (LinkedList<Character> LLChar, Character ch) {

        int count = 0;

        if ( LLChar.contains(ch) ) {
            Iterator iterator = LLChar.iterator();
//            int count = 0;
            while (iterator.hasNext()) {
                if (ch == iterator.next()) {
                    count++;
                    iterator.remove();  // once found one remove it from linkedlist
                }
            }
            return count;
        } else {
            return count;  //  if no such element in LLChar then count is 0.
        }
    }

//    private Integer [] getCount (Character [] sortedCharObjArray) {
//        LinkedList<Character> LLChar = new LinkedList(Arrays.asList(charObjArray)); // construct a LLByte by sorted Array
//
//    }


    /**
     * Returns a char array of the bytes that have been counted, i.e. those with non-zero counts.
     * @return
     */
    public char[] getElements() {
        return null;
    }

    /**
     * Defines the order for the current object, which controls the ordering of the arrays returned by toString.
     * If order equals byte (the default) the ordering is in terms of increasing byte value.
     * If order equals countInc or countDec the order is in terms of increasing or decreasing count, respectively.
     * For counts that are equal, the order should be in increasing byte order.
     * If order is not one of byte, countInc, or countDec throw an exception.
     * @param order
     * @throws Exception
     */
    public void setOrder(String order) throws Exception {
        if ( order == "byte") {
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
     * The default setOrder method which is overloading method setOrder( String order ),
     * by invoking the method with string "byte" as default argument value.
     * @throws Exception
     */
    public void setOrder () throws Exception {
        setOrder("byte");
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
        return null;
    }

    /**
     * If format equals char, returns a String containing the counts formatted as above,
     * but with the bytes as ASCII characters.
     * For example (using the same ASCII values above): :3 ,:1 ?:1 H:1 a:1 e:2 h:1 l:2 o:3 r:1 u:1 w:1 y:1
     *
     * Note that 32 is the ASCII value for a space.
     *
     * @param format
     * @return
     */

    public String toString (String format) {
        return null;
    }

    /**
     * Returns an integer value that contains the number of occurrences of b
     * @param b
     * @return
     */
    private int getCount (byte b) {
        int count = 0;
        return count;
    }
}
