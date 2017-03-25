import org.junit.Test;

/**
 * Created by sulu on 3/24/17.
 */
public class HuffmanCoderTest {

    @Test
    public void compress() throws Exception {
        String inputFile = "/Users/sulu/IdeaProjects/huffmancoder/src/main/java/com/sulu/huffmancoder/longtest.txt";
        String outputFile = "/Users/sulu/IdeaProjects/huffmancoder/src/main/java/com/sulu/huffmancoder/compressedlongtest.txt";

        HuffmanCoder coder = new HuffmanCoder( inputFile, outputFile );

        coder.compress();

        return;
    }

}