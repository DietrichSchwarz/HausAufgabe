package org.dima12;

import lombok.Value;

import java.util.*;

public class Methods {
    /* Створити метод countOccurance, що приймає на вхід рядковий список як параметр і довільний рядок.
    Список заповнений довільними словами 10-20 штук, які можуть повторюватись у необмеженій кількості.
     Порахувати скільки разів зустрічається переданий рядок як другий аргумент.*/

    public static int countOccurance(List<String> lists, String str){
        int count = 0 ;
        for (String word :lists) {
            if (word.equals(str)){
                count++;
            }
        }
        return count;
    }

     /*

     Створити метод toList, що приймає на вхід цілісний масив довільної довжини.
Конвертувати масив у список відповідного типу даних та повернути з методу.
Наприклад:
Було Array [1, 2, 3]
Стало List [1, 2, 3]

*/

    public static List<int[]> toList (int[]arr){
        List <int[]> list = Arrays.asList(arr);
        return list;
    }

    /*

    Створити метод findUnique, що приймає на вхід числовий список, що складається з довільних значень,
 які можуть повторюватися в необмеженій кількості. Необхідно повернути новий числовий список,
  що містить тільки унікальні числа.

  */

    public static List<Integer> findUnique (List<Integer>list){
        Set<Integer> newList = new HashSet<>(list);
        return new ArrayList<>(list);
    }



    /* ** Створити метод calcOccurance, який приймає на вхід рядковий список як параметр.
Список заповнений довільними словами 10-20 штук, які можуть повторюватись у необмеженій кількості.
Обчислити скільки разів трапляється кожне слово. Результат вивести у консоль.
Наприклад:
bird: 2
fox: 1
cat: 1
*/
    public static Map<String,Integer> calcOccurance(List<String>list){
        Map<String,Integer>wordCount = new HashMap<>();
        for (String word: list) {
            if (wordCount.containsKey(word)){
                wordCount.put(word,wordCount.get(word)+1);
            }else
                wordCount.put(word,1);

        }
        return wordCount;
    }



    /* *** Створити метод findOccurance, що приймає на вхід рядковий список як параметр.
Список заповнений довільними словами 10-20 штук, які можуть повторюватись у необмеженій кількості.
Обчислити скільки разів трапляється кожне слово. Результат повернути у вигляді списку структур,
що описують повторення кожного окремого взятого слова.
Наприклад:
[
   {name: "bird", occurrence: 2},
   {name: "fox", occurrence: 1},
   {name: "cat", occurrence: 1}
]
*/
    @Value
    public static class FindOccuran implements Comparable<FindOccuran>{
        String words;
        int count;



        @Override
        public int compareTo(FindOccuran o) {
            return this.words.compareTo(o.words);
        }
    }
    public static List<FindOccuran> findOccurans(List<String>list){
        Map<String,Integer> wordsCount = new HashMap<>();
        for (String word : list) {if (wordsCount.containsKey(word)) {
            wordsCount.put(word, wordsCount.get(word) + 1);
        } else {
            wordsCount.put(word, 1);
        }
        }
        List<FindOccuran> occurans = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordsCount.entrySet()){
            FindOccuran findOccuran = new FindOccuran(entry.getKey(),entry.getValue());
            occurans.add(findOccuran);
        }
        return occurans;

    }
}
