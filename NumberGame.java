package Java_OOP_Seminar_3.Game;

import java.util.ArrayList;
import java.util.List;

/**
 * NumberGame
 */
public class NumberGame extends AbstractGame{

    @Override
    protected List<String> generateCharList() {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String s = "";
            s += i;
            result.add(s);
        }
        return result;
    }
}