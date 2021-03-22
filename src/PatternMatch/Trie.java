/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatternMatch;

import java.util.Scanner;

/**
 *
 * @author 1
 */
public class Trie {

    private static final int ALPHABET_SIZE = 26;
    private static TrieNode root;

    private static class TrieNode {

        TrieNode[] children = new TrieNode[ALPHABET_SIZE];

        boolean isEndOfWord;

        TrieNode() {
            isEndOfWord = false;
            for (int i = 0; i < ALPHABET_SIZE; i++) {
                children[i] = null;
            }
        }
    };

    private static void insert(String key) {
        int level;
        int length = key.length();
        int index;

        TrieNode pCrawl = root;

        for (level = 0; level < length; level++) {
            index = key.charAt(level) - 'a';
            if (pCrawl.children[index] == null) {
                pCrawl.children[index] = new TrieNode();
            }

            pCrawl = pCrawl.children[index];
        }
        pCrawl.isEndOfWord = true;
    }

    private static boolean search(String key) {
        int level;
        int length = key.length();
        int index;
        TrieNode pCrawl = root;

        for (level = 0; level < length; level++) {
            index = key.charAt(level) - 'a';

            if (pCrawl.children[index] == null) {
                return false;
            }
            pCrawl = pCrawl.children[index];
        }

        return (pCrawl != null && pCrawl.isEndOfWord);
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string");
        String txt = sc.nextLine();

       
      
        String keys[] = txt.split(" ");
     
        root = new TrieNode();
        
        int i;
        for (i = 0; i < keys.length; i++) {
            insert(keys[i]);
        }
        
        String output[] = {"Not present in trie", "Present in trie"};
        String wrd = ""; 
        while (wrd != "-1"){
            System.out.println("Enter word to search(-1 to exit)");
            wrd = sc.nextLine();

            if(search(wrd))
                System.out.println("The word : " + wrd + " is present");
            else
                 System.out.println("The word : " + wrd + " is abbsent");
        }
    }
}
