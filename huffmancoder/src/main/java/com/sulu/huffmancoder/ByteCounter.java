/**
 * Created by sulu on 3/7/17.
 *
 * Clss ByteCounter computes the count of each byte in from a byte array or file and stores
 * the result in a data structure.
 */

import com.sun.jdi.connect.spi.TransportService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Iterator;


public class ByteCounter {

    public byte[] getBytePrimArray() {
        return bytePrimArray;
    }

    private byte [] bytePrimArray;

    public char [] getCharPrimArray () { return charPrimArray;}

    private char [] charPrimArray;

//    private Byte [] byteObjArray;

    /**
     * A constructor with a byte array argument indicates that the counts are to be computed from that array.
     * @param inputBytePrimArray
     */
    private ByteCounter (byte [] inputBytePrimArray) {
        this.bytePrimArray = inputBytePrimArray;
//        this.byteObjArray = toObject (this.bytePrimArray);
    }

    /**
     * A constructor with a char array argument indicates that the counts are to be computed from that array.
     * @param inputCharPrimArray
     */
    private ByteCounter (char [] inputCharPrimArray) {
        this.charPrimArray = inputCharPrimArray;
    }

    /**
     * A constructor with a String argument specifies the name of a file that the counts are to be computed from.
     *
     * The file could be text or binary, but you must read it in binary mode regardless of its form.
     * Otherwise there could be problems comparing results on different platforms.
     * In Java, a convenient way to read a file into a byte array is the readAllBytes method in the Files class.
     * You can use the Paths class to obtain the system path to a local file.
     * You should throw an exception (and print an appropriate error message) if the file doesn’t exist.
     * @param pathName
     */
//    public ByteCounter (String readMode, String pathName) {
//        this ( )
//    }

    public static ByteCounter makeByteCounter(String readMode, String pathName) {
        if (readMode == "byte") {
            return new ByteCounter(readFileAsByte(pathName));
        }
        else if (readMode == "char") {
            return new ByteCounter(readFileAsChar(pathName));
        }
        return null;
    }
//    public Byte[] getByteObjArray() {
//        return byteObjArray;
//    }

    /**
     * Declared as private static method is because, this method is used inside the ByteCounter Class constructor
     * So this function need to be built by compiler before the ByteCounter Class constructed.
     * If just declared as private function, there will be chicken egg issue
     * Private access level only restrict the method access outside from ByteCounter Class
     * It does NOT have any control over when this method will be built
     * Only Static key word makes this method built before the ByteCounter Class built
     * @param pathName
     * @return
     */
    private static byte[] readFileAsByte (String pathName) {

        Path filePath = Paths.get(pathName);

        try {
            return Files.readAllBytes(filePath);

        } catch (IOException e) {
            System.out.println(e);
            return null;
        }
    }

    /**
     * Read file character-by-character
     * @param pathName
     * @return
     */
    private static char[] readFileAsChar (String pathName) {
        BufferedReader br = null;

        try {
            br = new BufferedReader( new FileReader(pathName) );

            LinkedList<Character> LLChar = new LinkedList<>();
            int num = 0;
            while((num=br.read()) != -1)
            {
                LLChar.add(LLChar.size(), (char)num);
            }

            return toPrimitive(LLChar.toArray(new Character[LLChar.size()]));

        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
        finally
        {
            try {
                if (br != null);
                    br.close();
            }
            catch (IOException ioe)
            {
                System.out.println("Error in closing the BufferedReader");
            }
        }
        return null;
    }

    /**
     * Convert byte[] to Byte[]
     * @param bytePrimArray
     * @return
     */
    private Byte[] toObject (byte[] bytePrimArray) {
        Byte [] byteObjArray = new Byte[bytePrimArray.length];

        int i = 0;
        for (byte b : bytePrimArray) {
            byteObjArray[i++] = b; // Autoboxing
        }
        return  byteObjArray;
    }

    private static char [] toPrimitive (Character[] charObjArray) {
        char [] charPrimArray = new char[charObjArray.length];

        int i = 0;
        for (Character ch: charObjArray) {
            charPrimArray[i++] = ch; // Autoboxing
        }
        return charPrimArray;
    }

    /**
     * Sorts the specified array into ascending numerical order. O(nlog(n))
     * @param unsortedByteArray
     */
    private void sortByteArray (byte[] unsortedByteArray) {
        Arrays.sort(unsortedByteArray);
    }

    /**
     * Convert byte [] type array to LinkedList<Byte> type linkedlist
     * @param bytePrimArray
     * @return
     */
    private LinkedList<Byte> getLLByte (byte [] bytePrimArray) {
        Byte[] byteObjArray = toObject(bytePrimArray);
        LinkedList<Byte> LLByte = new LinkedList(Arrays.asList(byteObjArray));
        return LLByte;
    }

    /**
     * Returns an integer array that contains the number of occurrences of the corresponding
     * bytes in the array bytePrimArray. The order of the array is specified by the current order defined below.
     * @param bytePrimArray
     * @return
     */
    public int[] getCount (byte [] bytePrimArray) {

        sortByteArray(bytePrimArray);

        LinkedList<Byte> LLByte = getLLByte(bytePrimArray);  // construct a LLByte by sorted Array
        Iterator iterator = LLByte.iterator();

        // create a linkedlist to store number of occurrences of the corresponding byte
        LinkedList<Integer> LLCount = new LinkedList<>();

        while (iterator.hasNext()) {
            Byte arg = (Byte) iterator.next();
            LLCount.add(LLCount.size(), numOccur(LLByte, arg));
        }

        return null;
    }

    /**
     * Returns number of occurrence of certain Byte type argument
     * @param LLByte input source of linkedList the number of occurrence from which is counted
     * @param arg the argument wanted to count
     * @return
     */
    public int numOccur (LinkedList<Byte> LLByte, Byte arg) {

        Iterator iterator = LLByte.iterator();
        int count = 0;
//        byte argByte = (byte)arg;  // convert char type arg to byte type

        while (iterator.hasNext()) {
            if (arg == iterator.next()) {
                count++;
                iterator.remove();  // once found one remove it from linkedlist
            }
        }
        return count;
    }

    /**
     * Returns a byte array of the bytes that have been counted, i.e. those with non-zero counts.
     * @return
     */
    public byte[] getElements() {
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
