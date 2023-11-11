package Java_OOP_Seminar_3.Game;

import java.util.ArrayList;
import java.util.List;

/**
 * EngLangGame
 */
public class EngLangGame extends AbstractGame{

    @Override
    protected List<String> generateCharList() {
        List<String> result = new ArrayList<>();
        for (char c = 'A'; c <= 'z'; c++) {
            String s = "";
            s += c;
            result.add(s);
            if(c == 'Z') {
                c = 'a' - 1;
            }
        }
        return result;
    }

    
}