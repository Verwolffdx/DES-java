package com.datwhite;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static final Charset UTF8_CHARSET = Charset.forName("UTF-8");

    /**
     * @param args
     */

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите текст: ");
            String text = scanner.nextLine();

            //DES
            System.out.print("Введите ключ: ");
            String k = scanner.nextLine();//5qw8sd4h

            System.out.println("-------------------");
            byte[] enc = DES.encrypt(text.getBytes(), k.getBytes());
            System.out.println("Зашифрованный текст (ECB): " + new String(enc, UTF8_CHARSET));
            byte[] dec = DES.decrypt(enc, k.getBytes());
            System.out.println("Расшифрованный текст (ECB): " + new String(dec, UTF8_CHARSET));
            System.out.println("-------------------");

        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
