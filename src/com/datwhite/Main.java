package com.datwhite;

import java.util.Base64;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите текст: ");
            String text = scanner.nextLine();

            //DES
            System.out.print("Введите ключ: ");
            String k = scanner.nextLine();
//            GenerateKey keyGen = new GenerateKey(8);
//            k = keyGen.generate();
            System.out.println("KEY " + k);

            System.out.println("-------------------");
            byte[] enc = DES.encrypt(text.getBytes(), k.getBytes());
            String encodedString = Base64.getEncoder().encodeToString(enc);

            System.out.println("Зашифрованный текст (ECB): " + encodedString);
            byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
            byte[] dec = DES.decrypt(decodedBytes, k.getBytes());

            String strDec = new String(dec);
            System.out.println("Расшифрованный текст (ECB): " + strDec);
            System.out.println("-------------------");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
