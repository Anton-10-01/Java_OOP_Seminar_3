package Java_OOP_Seminar_3.Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * AbstractGame
 */
public abstract class AbstractGame implements Game{

    private Integer sizeWord;
    private Integer maxTry;
    private GameStatus status;
    private String word;
    private List<Integer> cow = new ArrayList<>();
    private List<Integer> bull = new ArrayList<>();


    @Override
    public GameStatus getGameStatus() {
        return status;
    }

    @Override
    public Answer inputValue(String value) {
        maxTry--;
        Integer cointCow = 0;
        Integer cointBull = 0;

        for (int i = 0; i < value.length(); i++) {
            Character ch = value.charAt(i);
            if(word.contains(ch.toString())) {
                cointCow++;
                if(ch.equals(word.charAt(i))) {
                    cointBull++;
                }
            }
        }
        cow.add(cointCow);
        bull.add(cointBull);

        if(cointBull.equals(word.length())) {
            status = GameStatus.WIN;
            return new Answer(maxTry, cointCow, cointBull);
        }

        if(maxTry == 0) {
            status = GameStatus.LOSE;
            return new Answer(maxTry, cointCow, cointBull);
        }
        return new Answer(maxTry, cointCow, cointBull);
    }

    @Override
    public void start(Integer sizeWord, Integer maxTry) {
        this.sizeWord = sizeWord;
        this.maxTry = maxTry;
        status = GameStatus.ACTIVE;
        word = generateWord(sizeWord);
    }

    private String generateWord(Integer sizeWord) {
        List<String> alf = generateCharList();
        String resultWord = "";
        for (int i = 0; i < sizeWord; i++) {
            Integer index = new Random().nextInt(alf.size());
            resultWord += alf.get(index);
            alf.remove(index);
        }
        return resultWord;
    }

    protected abstract List<String> generateCharList();

    @Override
    public void showGame(List<String> wordValue) {
        System.out.println("------------");
        System.out.println("Слово которое загадал компьютер: " + word);
        System.out.println("Слова которое вы написали: ");
        for (int i = 0; i < wordValue.size(); i++) {
            String s = "";
            s += i + 1;
            System.out.println(s + ". "+ wordValue.get(i) + "\nКоров = " + cow.get(i) + " Быков = " + bull.get(i));
        }
        System.out.println("------------");
    }
}