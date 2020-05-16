package com.aleksandrmishin;

import java.util.*;

public class Decoder {

    private char[] alphabet = "АаБбВвГгДдЕеЁёЖжЗзИиЙйКкЛлМмНнОоПпРрСсТтУуФфХхЦцЧчШшЩщЪъЫыЬьЭэЮюЯя".toCharArray();

    public static void main(String[] args) {

        System.out.println("Введите строку, которую необходимо расшифровать. Для расшифровки тестовой строки просто нажмите Enter.");
        Scanner scanner = new Scanner(System.in);
        String encryptText = scanner.nextLine();

        if (encryptText.isEmpty()) {
            encryptText = "Еъёчхф Вхзёюлх, адздёиу ф ждэщхб, црбх еёдюэчъщъгюъв южаижжзчх, ждчъёнъгжзчдв.\n" +
                    "Ъы зёюивй жёхчгюв бюнс ж ъы вдгивъгзхбсгрв аёхкдв. Зъеъёс вгъ дмъчющгд, мзд гъюэцъьгджзс тздшд аёхкх фчбфъзжф жбъщжзчюъв гъждчъёнъгжзчх мъбдчъмъжадшд югщючющиивх.\n" +
                    "Ф юэимюб чхни южздёюу ю чгыж юэвъгъгюф, здмгъъ дзёхэюч еджздфггиу юэвъгмючджзс мъбдчъмъжаюк едёдадч.\n" +
                    "Ю зъв гъ въгъъ, еджбъщдчхбх гъищхмх. Ф еёюнъб а чрчдщи, мзд чюгдя чжъви вдя югзъббъаз, х чдэвдьгд, вды мёъэвъёгдъ жзёъвбъгюъ ад чжъви шхёвдгюмгдви.\n" +
                    "Гхязю ёънъгюъ вгъ едвдшбх еёдшёхввх югзиюзючгдшд зюех, жеълюхбсгд ждэщхггхф щбф юэимъгюф деёъщъбъггрк жздёдг мъбдчъмъжадя щиню.\n" +
                    "Въгф вдьгд гхэчхзс дзлдв Вхзёюлр, х ъы, цъэ еёъичъбюмъгюф, вхзъёсу.\n";

            System.out.println("Тестовый текст: \n" + encryptText);
        }

        Decoder decoder = new Decoder();
        int shiftCount = 2;

        while (true) {
            String decryptedText = decoder.decodeText(encryptText, shiftCount);
            System.out.println(decryptedText);

            System.out.println("Текст расшифрован? (д/н)");
            String answer = scanner.nextLine();
            if (answer.equals("д")) {
                break;
            } else if (answer.equals("н")) {
                shiftCount += 2;
            } else {
                System.out.println("введите \"д\" если текст расшифрован и \"н\" , если нет.");
            }
        }
    }

    private String decodeText(String encryptText, int shiftCount) {

        StringBuilder decodedText = new StringBuilder(encryptText);

        for (int i = 0; i < encryptText.length(); i++) {

            if (!Character.isLetter(encryptText.charAt(i))) {
                continue;
            }

            int shiftedSymbol = getWordIndex(encryptText.charAt(i)) + shiftCount;

            if (shiftedSymbol >= alphabet.length) {
                shiftedSymbol -= alphabet.length;
            }
            decodedText.setCharAt(i, alphabet[shiftedSymbol]);
        }
        return decodedText.toString();
    }

    private int getWordIndex(char symbol) {
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] == symbol) {
                return i;
            }
        }
        return 0;
    }
}
