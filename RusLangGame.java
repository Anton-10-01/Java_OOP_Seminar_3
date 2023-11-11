package Java_OOP_Seminar_3.Game;

import java.util.ArrayList;
import java.util.List;

/**
 * RusLangGame
 */
public class RusLangGame extends AbstractGame{

    @Override
    protected List<String> generateCharList() {
        List<String> result = new ArrayList<>();
        for(char c = 'А'; c <= 'я'; c++) {
            String s = "";
            s += c;
            result.add(s);
            if(c == 'Я') {
                c = 'а' - 1;
            }
        }
        return result;
    }

    
}