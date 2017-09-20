import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by Irina on 16.09.2017.
 */
class InputOutput {
    StringBuilder brackets = new StringBuilder();
    //чтение содержимого файла
    ArrayList<String> FileRead() throws FileNotFoundException {
        Text text=new Text();
        Scanner scanner = new Scanner(System.in);
        String[] lineSplit;
        String path;
        System.out.println("Введите путь к расположению файла: ");
        path=scanner.nextLine();
        File file=new File(path);
        scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line=scanner.nextLine();
            lineSplit=line.split(" ");
            for (String s:lineSplit
                    ) {
                text.allText.add(s.toLowerCase().replaceAll("[^а-я]",""));
                for (int i = 0; i < s.length(); i++) {
                    char c = s.charAt(i);
                    if (Brackets.PUNCT_SET.contains(c)) {
                        brackets.append(c);
                    }
                }
            }
        }
        scanner.close();
        return text.allText;
    }

    //чтение из файла местоимений, предлогов и союзов, которые необходимо исключить из статистики
    ArrayList<String> ReadDictionary() throws FileNotFoundException {
        ArrayList<String> list=new ArrayList<String>();
        String[] lineSplit = new String[1000];
        String path="dictionary.txt";
        File file=new File(path);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line=scanner.nextLine();
            lineSplit=line.split(" ");
            Collections.addAll(list, lineSplit);
        }
        scanner.close();
        return list;
    }

    //консольный вывод результатов
    void ConsoleOutput(ArrayList<String> text, String result)
    {
        System.out.println("Топ-10 наиболее часто встречающихся слов (в порядке убывания частоты): ");
        for(int i=0;i<10;i++) {
            System.out.println(text.get(i)+" ");
        }
        System.out.println("\nРезультат проверки правильности расстановки скобок: ");
        System.out.println(result);
    }

    //запись результатов в файл
 /* void FileOutput(ArrayList<String> text,String result) {
        try(FileWriter writer = new FileWriter("newFile.txt", false))
        {
            writer.write("Топ-10 наиболее часто встречающихся слов (в порядке убывания частоты): ");
            for(int i=0;i<10;i++)
            {
                writer.write("\n"+text.get(i));
            }
            writer.write("\nРезультат проверки правильности расстановки скобок: ");
            writer.write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    } */

}
