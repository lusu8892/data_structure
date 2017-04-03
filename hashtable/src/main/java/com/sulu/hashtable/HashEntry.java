package com.sulu.hashtable;

/**
 * Created by sulu on 4/1/17.
 */
public class HashEntry {

    public String getKey() {
        return key;
    }

    private String key;

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    private int value;

    HashEntry ( String key, int value ) {
        this.key = key;
        this.value = value;
    }
}
