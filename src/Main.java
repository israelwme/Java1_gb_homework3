import java.util.Random;
import java.util.Scanner;


public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Написать программу, которая загадывает случайное число от 0 до 9, и пользователю дается 3 попытки угадать это число.
        // При каждой попытке компьютер должен сообщить больше ли указанное пользователем число чем загаданное, или меньше.
        // После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
        System.out.println("Ваша задача угадать число.");
        doGuess();
        System.out.println("Game over");
        scanner.close();

    }

    private static void doGuess() {
        Random random = new Random();
        int number = random.nextInt(10);
        int tryCount;
        int maxTryCount = 3;

        for(tryCount=0; tryCount<=maxTryCount; tryCount++) {
            if (tryCount < maxTryCount) {
                System.out.println("Угадайте число от 0 до 9");
                int input_number = scanner.nextInt();
                if (input_number == number) {
                    System.out.println("Вы выиграли!!!");
                    break;
                } else if (input_number > number) {
                    System.out.println("Загаданное число меньше");
                } else {
                    System.out.println("Загаданное число больше");
                }
            } else {
                System.out.println("Вы проиграли");
            }
        }


        int ask;
        do {
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
            ask = scanner.nextInt();
            if (ask == 1) {
                doRestart();
            }

        } while (ask < 0 || ask > 1);

    }

    private static void doRestart() {
        doGuess();
    }

}