package com.datwhite;

import javax.swing.text.Segment;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Random;
import java.util.Scanner;
import java.util.SortedMap;

public class Main {

//    private static final Charset UTF8_CHARSET = Charset.forName("UTF-8");

    /**
     * @param args
     */

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
//            SortedMap<String,Charset> charsets = Charset.availableCharsets();
//            System.out.println(charsets);
//
//            Charset currentCharset = Charset.defaultCharset();
//            System.out.println(currentCharset);

//            String originalInput = "test input";
//            String encodedString = Base64.getEncoder().encodeToString(originalInput.getBytes());
//
//            byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
//            String decodedString = new String(decodedBytes);
//
//            System.out.println(decodedString);

//            Scanner scanner = new Scanner(System.in);
//            System.out.print("Введите текст: ");
//            String text = scanner.nextLine();
//
//            //DES
//            System.out.print("Введите ключ: ");
//            String k = scanner.nextLine();//5qw8sd4h
            String text = "йцуQWE";
            String k = "DESkey56";
            GenerateKey keyGen = new GenerateKey(8);
            k = keyGen.generate();
            System.out.println("KEY " + k);

            System.out.println("-------------------");
            byte[] enc = DES.encrypt(text.getBytes(), k.getBytes());
            String encodedString = Base64.getEncoder().encodeToString(enc);

            String strEnc = new String(enc);
            String s = strEnc;

            System.out.println("Зашифрованный текст (ECB): " + s);
            byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
            byte[] dec = DES.decrypt(decodedBytes, k.getBytes());


            String strDec = new String(dec);
            System.out.println("Расшифрованный текст (ECB): " + strDec);
            System.out.println("-------------------");

        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
