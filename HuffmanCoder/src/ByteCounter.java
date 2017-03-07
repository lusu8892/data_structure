/**
 * Created by sulu on 3/7/17.
 *
 * Clss ByteCounter computes the count of each byte in from a byte array or file and stores
 * the result in a data structure.
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ByteCounter {

    private byte [] byteArray;
    /**
     * A constructor with a byte array argument indicates that the counts are to be computed from that array.
     * @param b
     */
    ByteCounter (byte [] b) {
        this.byteArray = b;
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
    ByteCounter (String pathName) {
        this( (readFile(pathName) ));
    }

    private byte[] readFile (String pathName) {

        Path filePath = Paths.get(pathName);

        try {
            return Files.readAllBytes(filePath);
//            byte[] byteArray = Files.readAllBytes(filePath);
//            this.ByteCounter(byteArray);
//
//            String wikiString = new String(byteArray);
//            System.out.println(wikiString);

        } catch (IOException e) {
            System.out.println(e);
            return null;
        }
    }

    /**
     * Returns an integer array that contains the number of occurrences of the corresponding
     * bytes in the array b. The order of the array is specified by the current order defined below.
     * @param b
     * @return
     */
    public int[] getCount (byte [] b) {
        return null;
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
