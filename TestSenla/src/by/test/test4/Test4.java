package by.test.test4;
import by.test.menu.Menu;

import java.io.IOException;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test4 {
//    Создайте программу, которая будет получать число и печатать
//    его в следующем формате (формы цифр можно придумать свои,
//    главное, чтобы они читались на экране):

        String[] lines;

        public Test4(String... lines) {
            this.lines = lines;
        }



    public static Test4[] createDigits(String... lines) {
            int height = lines.length;
            int width = (lines[0].length() - 9) / 10;
            return IntStream
                    .range(0, 10)  // Stream из цифр 0-9,
                    .mapToObj(digit ->
                            new Test4(Stream
                                    .of(lines)
                                    .map(line -> line.substring(digit * (width + 1), (digit + 1) * (width + 1) - 1))
                                    .toArray(String[]::new))
                    ).toArray(Test4[]::new);
        }


    public static void numberOfPtint() throws IOException {
        Test4[] digits = Test4.createDigits(
                "  ###      #     #####   #####  #       #######  #####  #######  #####   ##### ",
                " #   #    ##    #     # #     # #    #  #       #     # #    #  #     # #     #",
                "#     #  # #          #       # #    #  #       #           #   #     # #     #",
                "#     #    #     #####   #####  #    #  ######  ######     #     #####   ######",
                "#     #    #    #             # #######       # #     #   #     #     #       #",
                " #   #     #    #       #     #      #  #     # #     #   #     #     # #     #",
                "  ###    #####  #######  #####       #   #####   #####    #      #####   ##### "
        );
        int height = digits[0].lines.length;

        // ввод числа с клавы
        System.out.println("Введите число ");
        Scanner sc = new Scanner(System.in);
        long Res = sc.nextInt();

        String str = Long.toString(Res);
        String[]numb=str.split("");
        int number[] = new int[numb.length];
        for (int i = 0; i < numb.length; i++) {
            number[i] = Integer.parseInt(numb[i]);
        }

        IntStream.range(0, height).forEachOrdered(i -> {
            for (int digit : number) {
                System.out.print(digits[digit].lines[i] + " ");
            }
            System.out.println();
        });
        new Menu().start();
    }

}
