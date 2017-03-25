import com.sulu.huffmancoder.CharCounter;
import com.sulu.huffmancoder.HuffmanCode;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by sulu on 3/24/17.
 */
public class HuffmanCoder {

    private CharCounter counter;

    private HuffmanCode coder;

    private char [] inputCharAr;

    private String outputFile;

    private static final int fixLength = 8;

    public HuffmanCoder ( String inputFile, String outputFile ) throws IOException {
        this.coder = new HuffmanCode( inputFile );
        this.counter = new CharCounter( inputFile );
        this.inputCharAr = counter.getCharPrimArray();
        this.outputFile = outputFile;
    }

    public void compress () {
        StringBuilder strBuilder = new StringBuilder();

        double saving = 0;
        for ( char ch : inputCharAr ) {
            String encoding = coder.lookForEncoding( ch );

            saving = saving + ( fixLength - encoding.length() );
            strBuilder.append( encoding );
        }

        writeFile( outputFile, strBuilder.toString() );

        System.out.println (" The space reduction is " + (saving/ (fixLength * 1024)) + "KB");
    }

    private void writeFile ( String outputFile, String compressedStr) {
        try{
            //Specify the file name and path here
            File file = new File( outputFile );

    	    /** This logic is to create the file if the
    	     * file is not already present
             */
            if(!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file);
            //BufferedWriter writer give better performance
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write( compressedStr );
            //Closing BufferedWriter Stream
            bw.close();

            System.out.println("Data successfully written to the file");

        } catch (IOException ioe) {
            System.out.println("Exception occurred:");
            ioe.printStackTrace();
        }
    }
}

