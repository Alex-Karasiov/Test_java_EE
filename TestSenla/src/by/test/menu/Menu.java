package by.test.menu;

import java.io.IOException;
import java.util.Scanner;

import static by.test.task1.Task1.sunString;
import static by.test.task2.Task2.primeFactors;
import static by.test.test3.Task3. myString;
import static by.test.test4.Test4.numberOfPtint;
import static by.test.test5.Task5.startCase;

public class Menu implements IMenu {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_PURPLE = "\u001B[35m";

    @Override
    public void start() throws IOException {
        System.out.println("Выберете тест (1-5) ");
        System.out.println(ANSI_PURPLE + "Вызод введите 6 " + ANSI_RESET);
        System.out.print(" -$ ");

        Scanner scanner = new Scanner(System.in);
        String in = scanner.nextLine();
        switch (in) {
            case ("1"):
                sunString();
                break;
            case ("2"):
                primeFactors();
                break;
            case ("3"):
                myString();
                break;
            case ("4"):
                numberOfPtint();
                break;
            case ("5"):
                startCase();
                break;
            case ("6"):
                return;

            default:
                System.out.println("Не верный выбор");
                start();

        }
    }
}

