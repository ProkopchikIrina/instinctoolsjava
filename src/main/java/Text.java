
import java.util.*;

/**
 * Created by Irina on 17.09.2017.
 */
class Text {
    ArrayList<String> allText = new ArrayList<String>();

    //удаление местоимений, предлогов и союзов из коллекции слов
    void DeletePronounPreposConj(ArrayList dictionary) {
        allText.removeAll(dictionary);
        allText.remove("");
    }

    //поиск наиболее часто встречающихся слов
    ArrayList<String> Calculate() {
        Map<String, Integer> words = new TreeMap<String, Integer>();
        for (String s : allText
                ) {
            if (words.containsKey(s)) {
                int value = words.get(s) + 1;
                words.put(s, value);
            } else {
                words.put(s, 1);
            }
        }
        ArrayList<String> result = new ArrayList<String>();
        int i=0;
        for (Map.Entry<String, Integer> entry  : entriesSortedByValues(words))
        {
            result.add(entry.getKey());i++;
            if(i>=10)break;
        }
        return result;
    }
    //сортировка списка по убыванию
    private static <K, V extends Comparable<? super V>> SortedSet<Map.Entry<K, V>> entriesSortedByValues(Map<K, V> map) {
        SortedSet<Map.Entry<K, V>> sortedEntries = new TreeSet<Map.Entry<K, V>>(
                new Comparator<Map.Entry<K, V>>() {
                    public int compare(Map.Entry<K, V> e1, Map.Entry<K, V> e2) {
                        int res = e2.getValue().compareTo(e1.getValue());
                        return res != 0 ? res : 1;
                    }
                }
        );
        sortedEntries.addAll(map.entrySet());
        return sortedEntries;
    }
}