import com.sulu.hashtable.Tokenizer;

import java.io.IOException;

/**
 * Created by sulu on 3/29/17.
 */
public class TokenizerTest {

    private String fileName = "/Users/sulu/IdeaProjects/huffmancoder/src/main/java/com/sulu/huffmancoder/Pride and Prejudice.txt";

    private Tokenizer tker = new Tokenizer( fileName );

    public TokenizerTest() throws IOException {
    }

    @org.junit.Test
    public void getWordList() throws Exception {
        tker.getWordList();

//        System.out.println( 1 % 9);
        return;
    }

}