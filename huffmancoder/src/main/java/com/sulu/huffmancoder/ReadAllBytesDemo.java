package main; /**
 * Created by sulu on 3/7/17.
 */

// This is a demo for How to read file in Java using readAllBytes() method


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadAllBytesDemo {

    public static void main(String[] args) {
        String pathName = "/Users/sulu/IdeaProjects/HuffmanCoder/src/Pride and Prejudice.txt";

        Path doc_path = Paths.get(pathName);

        try {
            byte[] wikiArray = Files.readAllBytes(doc_path);

            String wikiString = new String(wikiArray);
            System.out.println(wikiString);
        } catch (IOException e) {
            System.out.println(e);
        }

    }
}
