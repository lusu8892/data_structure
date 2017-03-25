package com.sulu.huffmancoder;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by sulu on 3/6/17.
 */
public class HuffmanCode {

    private HuffmanList huffmanList;

    private HuffmanNode root;

    private LinkedList<HuffmanNode>  list;

    private static final int row = 2;
    private static final int col = 128;

    // A 2-D 2-by-128 String Matrix
    private String [][] table = new String[row][col];


    /**
     * Constructor
     */
    public HuffmanCode ( char [] charAr) {
        this.huffmanList = new HuffmanList( charAr );
        this.list = huffmanList.getList();

        this.root = buildHuffmanTree();

        buildTable(table, root, new String());
    }

    public HuffmanCode ( String str ) throws java.io.IOException {
        this.huffmanList= new HuffmanList( str );
        this.list = huffmanList.getList();

        this.root = buildHuffmanTree();

        buildTable(table, root, new String());

    }

    public HuffmanCode ( char [] charAr, int [] countAr) throws IllegalArgumentException {
        this.huffmanList = new HuffmanList( charAr, countAr);
        this.list = huffmanList.getList();

        this.root = buildHuffmanTree();

        buildTable(table, root, new String());

    }

    private HuffmanNode buildHuffmanTree () {
        while ( list.size() > 1 ) {
            HuffmanNode nodeToInsert = mergeNodes();
            insertNode ( nodeToInsert );
        }
        return list.getFirst();  // return the root of the built Huffman Tree
    }

    /**
     * help method to find the correct position to insert merged node
     * @param nodeToInsert the node to insert
     */
    private void insertNode ( HuffmanNode nodeToInsert) {
        ListIterator<HuffmanNode> listIterator = list.listIterator();
        while ( listIterator.hasNext() ) {
            int index = listIterator.nextIndex();
            if ( listIterator.next().count > nodeToInsert.count ) {
                list.add( index, nodeToInsert);
                break;
            }
        }

        // this means if current entire list does NOT have any count > nodeToInsert.count
        // than just append this nodeToInsert at the end of the list
        if ( !listIterator.hasNext() ) {
            list.add( nodeToInsert );
        }
    }

    /**
     * help method to merge two nodes less frequent is left child
     * @return
     */
    private HuffmanNode mergeNodes () {
        HuffmanNode leftChildNode = list.pollFirst();
        HuffmanNode rightRightNode = list.pollFirst();

        int sumCount = leftChildNode.count + rightRightNode.count;
        HuffmanNode newParentNode = new HuffmanNode( null, sumCount, leftChildNode, rightRightNode);

        return newParentNode;
    }

    public String toString () {
        return buildString();
    }

    private String buildString () {
        StringBuilder strBuilder = new StringBuilder();
        for ( int i = 0; i < table[0].length; i++) {
            if ( table[0][i] != null) {
                strBuilder.append( (char) i );
                strBuilder.append(": ");
                strBuilder.append( table[0][i] );  // the char's corresponding encoding
                strBuilder.append(": ");
                strBuilder.append( table[1][i] );  // the char's corresponding count
                strBuilder.append( "\n" );
            }
        }
        return strBuilder.toString();
    }

    /**
     * Look for the character ch's encoding bits
     * @param ch the input character
     * @return its corresponding encoding bits
     */
    public String lookForEncoding ( char ch ) {
        return codeString( ch );
    }

    public String codeString ( char ch ) throws IllegalArgumentException {
        if ( table [0][ ch ] == null) {
            throw new IllegalArgumentException("The character's encoding not existing" );
        }else{
            return table [0][ ch ];
        }
    }

    // make a lookup table from symbols and their encodings
    // This buildTable () method implement the postorder Traversal

    /**
     * Make a lookup table from symbols and their encodings.
     * This buildTable () method implement the postorder Traversal
     * @param table the lookup table
     * @param root root
     * @param encoding the encoding for specific character
     */
    private void buildTable ( String [][] table, HuffmanNode root, String encoding ) {
        if ( !root.isLeaf() ) { // if node is not leaf than
            buildTable( table, root.left, encoding + "0" );
            buildTable( table, root.right, encoding + "1");
        } else {
            table [0][root.ch] = encoding; // the char's encoding is at ( 1, (int) root.ch )
            table [1][root.ch] = String.valueOf( root.count );  // the char's count is at ( 0, (int) root.ch )
        }
    }

}
