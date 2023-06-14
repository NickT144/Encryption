package com.example.encryption;

//imported libraries
import java.util.ArrayList;

public class EncryptDecrypt {
private ArrayList<Character> text; //text to be encrypted/decrypted.

public EncryptDecrypt(ArrayList<Character> in){ //constructor that takes in the text that will be encrypted/decrypted
    text = in;
}
public ArrayList<Character> encrypt(ArrayList<Character> in, String key) { //method encrypts and decrypts the text with a given key
    ArrayList<Character> temp = in;
    ArrayList<Character> encode = new ArrayList<Character>();
    int length = key.length();
    for (int i = 0; i < temp.size(); i++) { //loops through text and encrypts/decrypts each character
        encode.add((char) (in.get(i) ^ key.charAt(i%length))); //encrypts/decrypts each character using ^ (XOR) operator.
    }
    return encode;
}


}