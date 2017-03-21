import com.sulu.huffmancoder.CharCounter;
import com.sulu.huffmancoder.HuffmanList;
import org.junit.Test;

/**
 * Created by sulu on 3/20/17.
 */
public class HuffmanListTest {

    private String pathName = "/Users/sulu/IdeaProjects/huffmancoder/src/main/java/com/sulu/" +
            "huffmancoder/Pride and Prejudice.txt";

    public HuffmanListTest() throws Exception {

    }

    @Test
    public void testConstructor() throws Exception {

        CharCounter charCount = new CharCounter( pathName );
        charCount.countChar();

        char[] chAr = charCount.getElements();
        int [] count = charCount.getCount();

        HuffmanList newList = new HuffmanList( chAr, count );
    }
}