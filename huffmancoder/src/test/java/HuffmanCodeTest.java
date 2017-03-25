import com.sulu.huffmancoder.HuffmanCode;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by sulu on 3/23/17.
 */
public class HuffmanCodeTest {
    private String pathName = "/Users/sulu/IdeaProjects/huffmancoder/src/main/java/com/sulu/huffmancoder/test.txt";

    private HuffmanCode coder = new HuffmanCode( pathName );


    public HuffmanCodeTest() throws IOException {
        HuffmanCode coder = new HuffmanCode( pathName );

        return;
    }

    @Test
    public void huffmanCoder() throws Exception {

    }

    @Test
    public void buildHuffmanTree() throws Exception {
//        int i = coder.getTable().length;
        System.out.println ( coder.toString() );
//        HuffmanNode root = coder.buildHuffmanTree();
//        String encoding = coder.codeString( 'c');
//        boolean bool = coder.code('a');
//        coder.code('a');
//        coder.preorderTraversal(root);

        return;
    }

}