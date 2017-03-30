package com.sulu.hashtable;

import java.io.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegexTestHarness {

    public static void main(String[] args) throws IOException {
//        Console console = System.console();
//        if (console == null) {
//            System.err.println("No console.");
//            System.exit(1);
//        }

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        while (true) {
//            String line = bufferedReader.readLine();

            System.out.print("\nEnter your regex: ");
            Pattern pattern =
                    Pattern.compile(br.readLine());

            System.out.print("\nEnter input string to search: ");
            Matcher matcher =
                    pattern.matcher(br.readLine());

            boolean found = false;
            while (matcher.find()) {
//            matcher.find();
                System.out.format("I found the text" +
                                " \"%s\" starting at " +
                                "index %d and ending at index %d.%n",
                        matcher.group(),
                        matcher.start(),
                        matcher.end());
//                System.out.print(matcher.group());
                found = true;
            }
            if(!found){
                System.out.format("No match found.%n");
            }
        }
    }
}