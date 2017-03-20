package com.sulu.huffmancoder;

/**
 * Created by sulu on 3/6/17.
 */
public class HuffmanCoder {
    /**
     * Constructor
     */
    public HuffmanCoder () {

    }


    public String huffmanCoder ( String inputFileName, String outputFileName ) {
        if (inputFileName == null) {
            return "Input is Error";
        }
        return outputFileName;
    }

    /**
     * Read file in
     * @return
     */
    private String readFile () {
        return null;
    }


    private static class HuffmanNode {

        char ch;
        int count;
        public HuffmanNode left;
        public HuffmanNode right;

        /**
         *  a boolean array representing the binary encoding for byte b.
         *  This is only defined for leaf nodes and ignored for interior nodes.
         */
        public boolean[] code;

        /**
         * Constructor
         * @param ch
         * @param count
         * @param left
         * @param right
         */
        public HuffmanNode (char ch, int count, HuffmanNode left, HuffmanNode right) {
            this.ch = ch;
            this.count = count;
            this.left = left;
            this.right = right;
        }

        /**
         * Constructor
         * @param ch
         * @param count
         */
        public HuffmanNode (char ch, int count) {
            this (ch, count, null, null);
        }

    }
}
