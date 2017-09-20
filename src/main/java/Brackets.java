import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Irina on 18.09.2017.
 */
class Brackets {
    StringBuilder line;
    static final Set<Character> PUNCT_SET = new HashSet<Character>(Arrays.asList(
            '(', ')', '[', ']', '{', '}'
    ));

    //функция, анализирующая правильность расстановки скобок
    String AnalyzeBrackets()
    {
        String str =line.toString();
        while(true)
        {
            if(str.contains("()"))
            {
                str=str.replace("()","");
            }
            if(str.contains("[]"))
            {
                str=str.replace("[]","");
            }
            if(str.contains("{}"))
            {
                str=str.replace("{}","");
            }
            if((!str.contains("[]"))&&(!str.contains("()"))&&(!str.contains("{}")))
            {
                break;
            }
        }
        if(str.length()==0)
        {
            return "correct";
        }
        else
        {
            return "incorrect";
        }
    }
}
