package com.sulu.hashtable;

import java.util.StringTokenizer;

/**
 * Created by sulu on 3/29/17.
 */
public class TokenizerTrial {
    public static void main(String[] args) {

        String str = "This is String's , split by StringTokenizer, created by mkyong";
        StringTokenizer st = new StringTokenizer(str);

        System.out.println("---- Split by space ------");
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken(
            ));
        }

//        System.out.println("---- Split by comma ',' ------");
//        StringTokenizer st2 = new StringTokenizer(str, ",");
//
//        while (st2.hasMoreElements()) {
//            System.out.println(st2.nextElement());
//        }
    }
}
