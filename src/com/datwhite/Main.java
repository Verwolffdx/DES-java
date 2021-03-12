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

            Random random = new Random();
            byte[] init_vector_enc = new byte[8];
            random.nextBytes(init_vector_enc);
            byte[] init_vector_dec = new byte[8];
            System.arraycopy(init_vector_enc, 0, init_vector_dec, 0, 8);

            enc = DES.encrypt_CBC(text.getBytes(), k.getBytes(), init_vector_enc);
            System.out.println("Зашифрованный текст (CBC): " + new String(enc, UTF8_CHARSET));
            dec = DES.decrypt_CBC(enc, k.getBytes(), init_vector_dec);
            System.out.println("Расшифрованный текст (CBC): " + new String(dec, UTF8_CHARSET));
            System.out.println("-------------------");



        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public static byte hexToByte(String hexString) {
        int firstDigit = toDigit(hexString.charAt(0));
        int secondDigit = toDigit(hexString.charAt(1));
        return (byte) ((firstDigit << 4) + secondDigit);
    }

    public static String byteToHex(byte num) {
        char[] hexDigits = new char[2];
        hexDigits[0] = Character.forDigit((num >> 4) & 0xF, 16);
        hexDigits[1] = Character.forDigit((num & 0xF), 16);
        return new String(hexDigits);
    }

    private static int toDigit(char hexChar) {
        int digit = Character.digit(hexChar, 16);
        if(digit == -1) {
            throw new IllegalArgumentException(
                    "Invalid Hexadecimal Character: "+ hexChar);
        }
        return digit;
    }
}
