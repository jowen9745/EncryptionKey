/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.javaproject1;

/**
 *
 * @author justin.owen.1
 */
import java.util.Scanner;
import java.io.*;
import java.util.*;

public class Javaproject1 {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private static final int SHIFT = 3; 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the CSCI717 Encryption Machine Construction!");
        System.out.println("The program lets you encrypt a message");
        System.out.print("Enter your cryptographic key: ");
        String key = scanner.nextLine();
        String encryptedKey = encrypt(key);
        System.out.println("Encrypted Key: " + encryptedKey);
        System.out.println("Enjoy your Secret Conversation!");

        
        System.out.print("Enter the number of words in your message: ");
        int numWords = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numWords; i++) {
            System.out.print("Enter word " + (i + 1) + ": ");
            String word = scanner.nextLine();
            String encryptedWord = encrypt(word);
            System.out.println("Encrypted Word " + (i + 1) + ": " + encryptedWord);
        }

        scanner.close();
    }

    private static String encrypt(String input) {
        StringBuilder encrypted = new StringBuilder();
        for (char character : input.toCharArray()) {
            encrypted.append(encryptCharacter(character));
        }
        return encrypted.toString();
    }

    private static char encryptCharacter(char character) {
        int index = ALPHABET.indexOf(character);
        if (index == -1) {
            return character; 
        }
       
        int newIndex = (index + SHIFT) % ALPHABET.length();
        return ALPHABET.charAt(newIndex);
    }
}
