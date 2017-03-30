package com.sulu.hashtable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Tokenizer {

    private ArrayList<String> wordList;

    public Tokenizer ( String[] input ) {
        this.wordList = new ArrayList<String>( 2 * input.length );
        for ( int i = 0; i < input.length; i++ ) {
            splitStr( input[i]) ;
        }
        wordList.trimToSize();
    }

    public Tokenizer( String fileName ) throws IOException {
        BufferedReader reader = new BufferedReader( new FileReader(fileName) );
        this.wordList = new ArrayList<String>();
        String line = null;
        while ( (line = reader.readLine()) != null ) {
            splitStr( line );
        }
        wordList.trimToSize();
    }

    /**
     * Split String into words
     * @param str
     */
    private void splitStr ( String str ) {
        StringTokenizer st = new StringTokenizer( str );
        while ( st.hasMoreTokens() ) {
            String normalizedStr = normalizer( st.nextToken() );
            if ( normalizedStr.equals("") ) {
                continue;
            }
            wordList.add( normalizedStr );
        }
    }

    /**
     * Convert words to lower case.
     * Remove leading and trailing whitespace.
     * Remove punctuation.
     * @param word
     */
    private String normalizer (String word) {
        return word.replaceAll("[^a-zA-z[^\\w][_]]", "").toLowerCase().trim();
    }

    public ArrayList<String> getWordList() {
        return wordList;
    }
}