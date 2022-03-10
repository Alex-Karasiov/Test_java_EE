package by.test.task2;

import by.test.menu.IMenu;
import by.test.menu.Menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Task2 {
//    Создайте программу, которая будет вычислять и выводить на
//    экран простые множители, из которых состоит целое число,
//    введенное пользователем. Если введенное число не целое, то нужно
//    сообщать пользователю об ошибке.

    public static void primeFactors() throws IOException {
        extracted1();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] params1 = bufferedReader.readLine().split(" ");
        long numb, divisor = 2;
        numb = Integer.parseInt(params1[0]);
        while (divisor*divisor <= numb)
        {
            if (numb%divisor == 0)
            {
                getPrint(divisor);
                numb = numb / divisor;
                extracted();
                }
            else if (divisor == 2) divisor = 3;
            else divisor = divisor + 2;
        }
        extracted(numb);
        new Menu().start();
    }

    private static void extracted1() {
        System.out.println("введите целое число ");
    }
    private static void extracted(long numb) {
        System.out.print(numb +"\n" );
    }
    private static void extracted() {
        System.out.print('*');
    }
    private static void getPrint(long divisor) {
        System.out.print(divisor);
    }
}

