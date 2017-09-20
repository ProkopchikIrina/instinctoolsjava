import java.io.FileNotFoundException;

public class Main {
    public Main() {
    }

    public static void main(String[] args) throws FileNotFoundException {
        InputOutput io = new InputOutput();
        Text text = new Text();
        Brackets brackets = new Brackets();
        text.allText = io.FileRead();
        text.DeletePronounPreposConj(io.ReadDictionary());
        brackets.line = io.brackets;
        io.ConsoleOutput(text.Calculate(), brackets.AnalyzeBrackets());
    }
}