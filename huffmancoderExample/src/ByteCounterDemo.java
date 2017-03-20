import java.io.IOException;

/**
 * Created by sulu on 3/17/17.
 */
public class ByteCounterDemo {

    public static void main (String [] args) throws IOException {
        String inputFile = "/Users/sulu/IdeaProjects/huffmancoder/src/main/java/com/sulu/" +
                "huffmancoder/Pride and Prejudice.txt";

        ByteCounter counter = new ByteCounter(inputFile);

        counter.setOrder("countInc");

        byte[] byteValue = counter.getElements();

        int[] count = counter.getCount(byteValue);

        counter.setOrder("countDec");

        byteValue = counter.getElements();

        count = counter.getCount(byteValue);
        return;

    }
}
