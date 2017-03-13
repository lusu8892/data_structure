import com.sulu.huffmancoder.CharCounter;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by sulu on 3/10/17.
 */
public class CharCounterTest {

    private String pathName = "/Users/sulu/IdeaProjects/huffmancoder/src/main/java/com/sulu/" +
            "huffmancoder/Pride and Prejudice.txt";
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

        int [] countArray = counter.getCount( charArray );

        charArray = counter.getCharPrimArray();

        return;
    }

    @Test
    public void testGetCount() throws Exception {

        char ch = '#';

        int count = counter.getCount( ch );

        return;
    }

    @Test
    public void getElements() throws Exception {

    }

    @Test
    public void setOrder() throws Exception {

    }

}