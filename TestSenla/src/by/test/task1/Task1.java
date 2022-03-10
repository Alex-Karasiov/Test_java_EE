package by.test.task1;

import by.test.menu.Menu;

import java.io.IOException;
import java.util.Scanner;

public abstract class Task1 {
    // Напишите программу, которая возвращает сумму цифр, присутствующих в данной строке.
    // Если цифр нет, то возвращаемая сумма должна быть равна 0.

    // сдесь фишка методы ввода вывода отдельно
    public static void sunString() throws IOException {

        String str = getString();
        char[] chars = str.toCharArray();
        int sum = 0;
        for (int i = 0; i < chars.length; i++) {
            if ((byte) chars[i] >= 0x30 && (byte) chars[i] <= 0x39)
                sum += (byte) chars[i] - 0x30;
        }
        extracted(sum);
        new Menu().start();
    }

    private static void extracted(int sum) {
        if (sum == 0) {
            System.out.println("0");
        } else {
            System.out.println(sum);
        }
    }

    private static String getString() {
        System.out.print("Введите строку: ");
        Scanner line = new Scanner(System.in);
        String str = line.nextLine();
        return str;
    }

}
