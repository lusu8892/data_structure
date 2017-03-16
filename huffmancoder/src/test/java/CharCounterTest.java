import com.sulu.huffmancoder.CharCounter;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by sulu on 3/10/17.
 */
public class CharCounterTest {

    private String pathName = "/Users/sulu/IdeaProjects/huffmancoder/src/main/java/com/sulu/" +
            "huffmancoder/Pride and Prejudice.txt";


//    private String pathName = "/Users/sulu/IdeaProjects/huffmancoder/src/main/java/com/sulu/" +
//            "huffmancoder/test.txt";
    private CharCounter counter = new CharCounter(pathName);

    @Test
    public void getCharPrimArray() throws Exception {

        char [] charArray = counter.getCharPrimArray();
        Arrays.sort(charArray);
        System.out.println(charArray);

        return;

    }

    @Test
    public void getCharObjArray() throws Exception {
        Character [] charArray = counter.getCharObjArray();
        Arrays.sort(charArray);
        System.out.println(charArray);

        return;
    }

    @Test
    public void getCount() throws Exception {
        char [] charArray = counter.getCharPrimArray();

//        Arrays.sort(charArray);

        int [] countArray = counter.getCount( charArray );

        charArray = counter.getCharPrimArray();

        char [] countedChar = counter.getElements();

        return;
    }

    @Test
    public void testGetCount() throws Exception {

        Character ch = '“';

        int count = counter.getCount( ch );

        return;
    }

    @Test
    public void getElements() throws Exception {
        int i = counter.getCount ( '好' );
            i = counter.getCount('b');
            i = counter.getCount('a');
            i = counter.getCount('b');
        char [] chArray = counter.getElements();

        return;

    }

    @Test
    public void setOrder() throws Exception {

    }

    @Test
    public void testCharCount () throws Exception {
        char ch = 'a';
        int count = 2;

//        String countInfo = new String (ch + ": " + count );
//
//        return;
    }

    @Test
    public void testToString () throws Exception {
        char [] charArray = counter.getCharPrimArray();

//        Arrays.sort(charArray);

        int [] countArray = counter.getCount( charArray );

        System.out.println( counter.toString() );

        return;
    }

    @Test
    public void testSetOrder () throws Exception {
        char [] charArray = counter.getCharPrimArray();

//        Arrays.sort(charArray);

        int [] countArray = counter.getCount( charArray );

//        counter.setOrder( counter.getCountLLInt(), "char");
//        char ch = counter.countMapToChar(4);

        return;
    }
}