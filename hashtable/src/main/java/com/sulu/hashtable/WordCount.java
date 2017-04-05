package com.sulu.hashtable;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by sulu on 4/3/17.
 */
public class WordCount {

    private Tokenizer tk;

    private HashTable wordHashTable;

    private ArrayList<String> wordList;

    public WordCount ( String fileName ) throws IOException {
        this.tk = new Tokenizer( fileName );
        this.wordList = tk.getWordList();
        executeWordHash();
    }

    public WordCount ( String [] input ) {
        this.tk = new Tokenizer( input );
        this.wordList = tk.getWordList();
        executeWordHash();
    }

    public double getLoadFactor () {
        return wordHashTable.getLoadFactor();
    }

    public String getWordStat () {
        StringBuilder strBuilder = new StringBuilder();

        for ( HashEntry item : wordHashTable.toArray() ) {
            strBuilder.append( item.getKey() );
            strBuilder.append( item.getValue() );
            strBuilder.append(" ");
        }
        return strBuilder.toString();
    }

    private void executeWordHash () {

//        if (this.wordList.size() < 5000){
//            this.wordHashTable = new HashTable(wordList.size());
//        }else{
//            this.wordHashTable = new HashTable(10000);
//        }
        this.wordHashTable = new HashTable();

        for ( String str : this.wordList) {
            wordHashTable.insert( str, 1 );
        }
    }

    public static void main ( String [] args ) throws IOException {

        String fileName = "/Users/sulu/IdeaProjects/huffmancoder/src/main/java/com/sulu/huffmancoder/Pride and Prejudice.txt";
//        String fileName = "/Users/sulu/IdeaProjects/hashtable/src/main/java/com/sulu/hashtable/test.txt";

        WordCount wc = new WordCount( fileName );

        System.out.println ( wc.getLoadFactor() );

        System.out.println ( wc. getWordStat() );
        return;

    }
}
