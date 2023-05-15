package com.example.encryption;


import java.util.ArrayList;

public class EncryptDecrypt {
private ArrayList<Character> text;

public EncryptDecrypt(ArrayList<String> in){
    text = in;
}
public ArrayList<String> encrypt(String key) {
    ArrayList<Character> temp = text;
    int length = key.length();
    ArrayList<String> encode = new ArrayList<String>();
    for (int i = 0; i < text.size(); i++) {
        encode.add( String.format("%02x",(byte) (temp.get(i) ^ key.charAt(i%length))));

    }

}

    public ArrayList<String> decrypt( ArrayList<String> encrypt, String key) {

        int length = key.length();
        ArrayList<String> decode = new ArrayList<String>();
        for (int i = 0; i < encrypt.size(); i++) {
            decode.add("" + (char) (( Integer.parseInt(encrypt.get(i), 16) ^  key.charAt(i%length))));
        }
        return decode;
    }


}