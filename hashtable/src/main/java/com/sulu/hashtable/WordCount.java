package com.sulu.hashtable;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by sulu on 4/3/17.
 */
public class WordCount {

    private Tokenizer tk;

    private HashTable hashTable;

    private ArrayList<String> wordList;

    public WordCount ( String fileName ) throws IOException {
        this.tk = new Tokenizer( fileName );
        this.wordList = tk.getWordList();
        this.hashTable = new HashTable();  // initialize by calling default constructor
    }

    public WordCount ( String [] input ) {
        this.tk = new Tokenizer( input );
        this.wordList = tk.getWordList();
        this.hashTable = new HashTable();  // initialize by calling default constructor
    }

    public void insertWordsToHashTable () {
        for ( String str : this.wordList) {
            hashTable.insert( str, 1 );
        }
    }

    public static void main ( String [] args ) throws IOException {

        String fileName = "/Users/sulu/IdeaProjects/huffmancoder/src/main/java/com/sulu/huffmancoder/Pride and Prejudice.txt";
//        String fileName = "/Users/sulu/IdeaProjects/hashtable/src/main/java/com/sulu/hashtable/test.txt";

        WordCount wc = new WordCount( fileName );

        wc.insertWordsToHashTable();

        return;

    }
}
