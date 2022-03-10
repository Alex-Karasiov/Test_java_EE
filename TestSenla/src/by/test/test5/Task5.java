package by.test.test5;
import by.test.menu.Menu;

import java.io.IOException;
import java.util.Scanner;

public class Task5 {
//    Есть набор предметов, задаваемый заранее, предметы могут
//    повторяться. Предмет имеет 2 параметра (обязательных, остальные
//            добавлять на усмотрение): объем (целое значение) и ценность (целое
//    значение). Предметы неделимы. Также задаётся сейф с обязательным
//    параметром его объёма (целое значение).
//    Нужно написать программу, которая наполняет сейф набором
//    предметов таким образом, чтобы ценность этого набора была
//    максимальной.
        // N представляет количество объектов, V представляет нагрузку
// N представляет количество объектов, V представляет нагрузку
    int N,V;
    // Используется для хранения веса каждого объекта
    private int[] weight;
    // Сохраняем доход каждого объекта
    private int[] value;
    // Двумерный массив, используемый для сохранения максимальной прибыли в каждом состоянии
    private int[][] F;


    // решения F [0 .. N] [0 .. V],

    public void ZeroOnePackNonRecursive() {

        for(int j = 0; j <= V; j++) {
            F[0][j] = 0;
        }

        for(int i = 1; i <= N; i++) {
            for(int j = 0; j <= V; j++) {
                // j i-й объект
                if(j >= weight[i]) {
                    F[i][j] = Math.max(F[i - 1][j - weight[i]] + value[i], F[i - 1][j]);
                }else {
                    F[i][j] = F[i - 1][j];
                }
            }
        }


        for(int i = 0; i <= N; i++) {
            for(int j = 0; j <= V; j++) {
                System.out.print(F[i][j] + " ");
            }
            System.out.println();
        }
    }



    public void printResult(int n, int v) {
        boolean[] isAdd = new boolean[n + 1];

        for(int i = n; i >= 1; i--) {
            if(F[i][v] == F[i-1][v])
                isAdd[i] = false;
            else {
                isAdd[i] = true;
                v -= weight[i];
            }
        }

        for(int i = 1; i <= n; i++) {
            System.out.print(isAdd[i] + " ");
        }
        System.out.println();
    }

    public void init() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        V = sc.nextInt();

        weight = new int[N + 1];
        value = new int[N + 1];
        F = new int [N + 1] [V + 1];
        for(int i = 1; i <= N; i++) {
            weight[i] = sc.nextInt();
        }

        for(int i = 1; i <= N; i++) {
            value[i] = sc.nextInt();
        }
    }

    public static void startCase() throws IOException {
        System.out.println("* Формат ввода:");
        System.out.println(" 5 10");
        System.out.println("2 2 6 5 4");
        System.out.println(" 6 3 5 4 6");

        Task5 ins = new Task5();
        ins.init();
        ins.ZeroOnePackNonRecursive();
        ins.printResult(ins.N,ins.V);
        new Menu().start();
        }

    }

