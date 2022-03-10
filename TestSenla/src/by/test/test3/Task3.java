package by.test.test3;

import by.test.menu.Menu;

import java.io.IOException;

import static java.lang.Character.*;

public class Task3 {
    static String stringToProc= "привет таск 3";
//    Создайте программу, которая будет:
//            - подсчитывать количество гласных в словах
//            - выводить слова отсортированным списком по количеству
//    гласных (сначала те, у которых больше гласных)
//            - делать первую гласную букву в слове заглавной
//    Предложение вводится пользователем вручную русскими
//    буквами. Разделитель пробел (“ ”)

    public static void myString() throws IOException {


        int charCount = 0;
        String vowels = "'а', 'е', 'о', 'у', 'и', 'я', 'ю', 'є'";
        int counVow = 0;
        for (char charBox : stringToProc.toLowerCase().toCharArray()) {
            if (isLetter(charBox)) {
                charCount++;
                if (vowels.indexOf(charBox) != -1)
                    counVow++;
            }
        }
        extracted(charCount, counVow);

    }

    public static void firstUpperCase(String str){

            StringBuilder builder = new StringBuilder(str);
            //выставляем первый символ заглавным, если это буква
            if (isAlphabetic(str.codePointAt(0)))
                builder.setCharAt(0, toUpperCase(str.charAt(0)));

            for (int i = 1; i < str.length(); i++)
                if (isAlphabetic(str.charAt(i)) && isSpaceChar(str.charAt(i - 1)))
                    builder.setCharAt(i, toUpperCase(str.charAt(i)));
        System.out.println(builder);

            return;

    }
    private static void extracted(int charCount, int counVow) throws IOException {
        System.out.printf("Гласных = %d;%nСогласных = %d\n", counVow, charCount - counVow);
        firstUpperCase(stringToProc);
        new Menu().start();
    }
}
