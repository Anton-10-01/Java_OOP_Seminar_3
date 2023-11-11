package Java_OOP_Seminar_3.Game;

import java.util.List;

/**
 * Game
 */
public interface Game {

    void start(Integer sizeWord, Integer maxTry);
    Answer inputValue(String value);
    GameStatus getGameStatus();
    void showGame(List<String> wordValue);
}