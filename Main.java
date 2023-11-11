package Java_OOP_Seminar_3.Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        NumberGame numberGame = new NumberGame();
        numberGame.start(4, 6);

        EngLangGame engLangGame = new EngLangGame();
        engLangGame.start(5, 6);

        RusLangGame rusLangGame = new RusLangGame();
        rusLangGame.start(5, 6);

        List<String> value;

        try (Scanner scanner = new Scanner(System.in, "Cp866")) {
            boolean f = true;
            while(f) {
                System.out.println("1. Игра с цифрами");
                System.out.println("2. Игра с англйским алфавитом");
                System.out.println("3. Игра с руским алфавитом");                
                System.out.println("4. Выход");

                System.out.printf("Введите пункт: ");

                String x = scanner.nextLine();
                switch (x) {
                    case "1":
                        value = new ArrayList<>();
                        while (numberGame.getGameStatus().equals(GameStatus.ACTIVE)) {
                            System.out.printf("Ваше слово: ");
                            String s = scanner.nextLine();
                            Answer answer = numberGame.inputValue(s);
                            System.out.println(answer);
                            value.add(s);
                        }
                        if (numberGame.getGameStatus().equals(GameStatus.WIN)) {
                            System.out.println("Вы выиграли!");
                        } else {
                            System.out.println("Вы проиграли!");
                        }

                        System.out.println("Хотите посмотреть историю?"
                                + "\n1. Да"
                                + "\n2. Нет");

                        String countNum = scanner.nextLine();
                        switch (countNum) {
                            case "1":
                                numberGame.showGame(value);
                                break;
                        }
                        break;
                    case "2":
                        value = new ArrayList<>();
                        while (engLangGame.getGameStatus().equals(GameStatus.ACTIVE)) {
                            System.out.printf("Ваше слово: ");
                            String s = scanner.nextLine();
                            Answer answer = engLangGame.inputValue(s);
                            System.out.println(answer);
                            value.add(s);
                        }
                        if (engLangGame.getGameStatus().equals(GameStatus.WIN)) {
                            System.out.println("Вы выиграли!");
                        } else {
                            System.out.println("Вы проиграли!");
                        }
                        System.out.println("Хотите посмотреть историю?"
                                + "\n1. Да"
                                + "\n2. Нет");
                        String countEng = scanner.nextLine();
                        switch (countEng) {
                            case "1":
                                engLangGame.showGame(value);
                                break;
                        }
                        break;
                    case "3":
                        value = new ArrayList<>();
                        while (rusLangGame.getGameStatus().equals(GameStatus.ACTIVE)) {
                            System.out.printf("Ваше слово: ");
                            String s = scanner.nextLine();
                            value.add(s);
                            Answer answer = rusLangGame.inputValue(s);
                            System.out.println(answer);
                        }
                        if (rusLangGame.getGameStatus().equals(GameStatus.WIN)) {
                            System.out.println("Вы выиграли!");
                        } else {
                            System.out.println("Вы проиграли!");
                        }
                        System.out.println("Хотите посмотреть историю?"
                                + "\n1. Да"
                                + "\n2. Нет");
                        String countRus = scanner.nextLine();
                        switch (countRus) {
                            case "1":
                                rusLangGame.showGame(value);
                                break;
                        }
                        break;
                    case "4":
                        f = false;
                        break;
                    default:
                        System.out.println("Вы ввели неверный пункт!");
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}