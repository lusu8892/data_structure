/**
 * Created by sulu on 3/7/17.
 */

// This is a demo for How to read file in Java using BufferedReader

// Method 1: Using readLine() method of BufferedReader class. It reads a line of text.

// Method 2: Using read() method
// It reads a character of text. Since it returns an integer value,
// it needs to be explicitly cast as char for reading the content of file.

// Example: Here I have two txt files "Pride and Prejudice.txt" and "Pride and Prejudice.txt".
// In order to demonstrate both the ways to read file.
// I’m reading first file using readLine() method
// while the second file is being read using read() method.

//package beginnersbook.com;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderDemo {
    public static void main(String[] args) {

        BufferedReader br = null;
        BufferedReader br2 = null;

        String fileName = "/Users/sulu/IdeaProjects/huffmancoder/src/main/java/com/sulu/huffmancoder/Pride and Prejudice.txt";

        try{
            br = new BufferedReader(new FileReader(fileName));

            //One way of reading the file
            System.out.println("Reading the file using readLine() method:");
            String contentLine = br.readLine();
            while (contentLine != null) {
                System.out.println(contentLine);
                contentLine = br.readLine();
            }

            br2 = new BufferedReader(new FileReader(fileName));

            //Second way of reading the file
            System.out.println("Reading the file using read() method:");
            int num=0;
            char ch;
            while((num=br2.read()) != -1)
            {
                ch=(char)num;
                System.out.println(ch + ": " + num);
            }

        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
        finally
        {
            try {
                if (br != null)
                    br.close();
                if (br2 != null)
                    br2.close();
            }
            catch (IOException ioe)
            {
                System.out.println("Error in closing the BufferedReader");
            }
        }
    }
}
