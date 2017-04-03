package com.sulu.hashtable;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

import static java.lang.Math.abs;

/**
 * Created by sulu on 4/2/17.
 */
public class HashTable {

    private static final int DEFAULT_TABLE_SIZE = 10007;
    private ArrayList< LinkedList<HashEntry> > hashTable;

    private int tableSize;  // the capacity of hash table

    // current size of the hash table, reflecting how many separate chainings in the current table
    private int currentSize = 0;

    private double loadFactorThreshold = 0.9;

    // to remember where is key located at
    private int inChainIndex = 0;

    /**
     * Default Constructor
     */
    public HashTable () {
        this( DEFAULT_TABLE_SIZE );
    }

    /**
     * Constructor for user specified initial table size
     * @param tableSize
     */
    public HashTable ( int tableSize ) {
        this.tableSize = nextPrime( tableSize ) ;
        hashTable = new ArrayList< LinkedList<HashEntry> >( this.tableSize );

        for ( LinkedList<HashEntry> list: hashTable ) {
            // for each HashTable cell creating an empty LinkedList (that is the chain) for it
            list = new LinkedList<HashEntry>();
        }
    }

    /**
     * Store the key-value pair in the hash table
     * @param key input key
     * @param value its additional data field, the value
     */
    public void insert ( String key, int value ) {
        if ( !contain( key ) ) {
            int index = hashFunction(key);
            hashTable.get( index ).add( new HashEntry(key, value) );

            currentSize++;
            if ( (currentSize / tableSize) > loadFactorThreshold ) {
                rehash();
            }
        } else {
            update ( key, value);
        }
    }

    public void remove ( String key ) throws IllegalArgumentException {
        if ( contain( key) ) {
            int index = hashFunction(key);
            LinkedList<HashEntry> whichList = hashTable.get(index);
            whichList.remove(this.inChainIndex);
            currentSize--;
        } else {
            throw new IllegalArgumentException("No such key in current hash table.");
        }
    }

//    public void insert ( String key, int value, int hashCode ) {}

    /**
     * Update certain key's value
     * @param key the key to update
     * @param value the value to update with certain key
     */
    public void update ( String key, int value ) {
        if ( contain(key) ) {
            int index = hashFunction(key);
            LinkedList<HashEntry> whichList = hashTable.get(index);
            HashEntry item = whichList.get(this.inChainIndex);
            item.setValue(item.getValue() + value);
        } else {
            insert( key, value);
        }
    }

    /**
     * Get value for certain key
     * @param key the key to get
     * @return key's value
     */
    public int get ( String key ) {
        if ( contain( key ) ) {
            int index = hashFunction( key );
            LinkedList<HashEntry> whichList = hashTable.get( index );
            return whichList.get( this.inChainIndex ).getValue();
        } else {
            return -1;
        }
    }

    /**
     * Find an item in the hash table.
     * @param key the item to search for.
     * @return true if key is found.
     */
    public boolean contain ( String key ) {
        int index = hashFunction( key );
        boolean found = false;
        if ( !hashTable.get( index ).isEmpty() ) {
            LinkedList<HashEntry> whichList = hashTable.get( index );
            ListIterator<HashEntry> listIterator = whichList.listIterator();
            while ( listIterator.hasPrevious() ) {
                HashEntry item = listIterator.previous();
                if ( key.equals( item.getKey() ) ) {
                    this.inChainIndex = whichList.indexOf( item );  // remember this special index
                    found = true;
                    break;
                }
            }
        }
        return found;
    }

    /**
     * Rehashing the hash table
     */
    private void rehash () {
        ArrayList< LinkedList<HashEntry> > oldHashTable = hashTable;

        // create new double size new empty hashTable
        // re-assign new tableSize as the first prime number which is 2 times bigger than old tableSize
        this.tableSize = nextPrime( 2 * this.tableSize );
        // create new hash table based on new tableSize
        hashTable = new ArrayList< LinkedList<HashEntry> >( this.tableSize );
        for ( LinkedList<HashEntry> list : hashTable ) {
            list = new LinkedList<HashEntry>();
        }

        // copy old hash table content to new hash table
        this.currentSize = 0; // reset to zero
        for ( LinkedList<HashEntry> list : oldHashTable ) {
            if ( !list.isEmpty() ) {
                for ( HashEntry item : list) {
                    insert( item.getKey(), item.getValue() );
                }
            }
        }


    }

    /**
     * The hash function which maps (unique) key of item into index
     * @param key the String key
     * @return the position to insert item
     */
    private int hashFunction ( String key ) {
        int index;
        if ( key.hashCode() < 0) {
            index = abs(key.hashCode()) % tableSize;
        } else {
            index = key.hashCode() % tableSize;
        }

        return index;
    }

    /**
     * Make the hash table logically empty.
     */
    public void makeEmpty( )
    {
        for( int i = 0; i < tableSize; i++ )
            hashTable.get(i).clear( );
        currentSize = 0;
    }

    /**
     * Internal method to find a prime number at least as large as n.
     * @param n the starting number (must be positive).
     * @return a prime number larger than or equal to n.
     */
    private static int nextPrime( int n )
    {
        if( n % 2 == 0 )
            n++;

        for( ; !isPrime( n ); n += 2 )
            ;

        return n;
    }

    /**
     * Internal method to test if a number is prime.
     * Not an efficient algorithm.
     * @param n the number to test.
     * @return the result of the test.
     */
    private static boolean isPrime( int n )
    {
        if( n == 2 || n == 3 )
            return true;

        if( n == 1 || n % 2 == 0 )
            return false;

        for( int i = 3; i * i <= n; i += 2 )
            if( n % i == 0 )
                return false;

        return true;
    }

}
