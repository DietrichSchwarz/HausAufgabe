package MethodsTest;

import org.dima12.Methods;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class MethodTest {
    @Test
    public void countOccurrenceTest(){
        List<String> list = Arrays.asList("One","Two","Three","Four","Five","One","Six","One");
        String str = "One";
        int actualResult = Methods.countOccurance(list,str);

        Assertions.assertEquals(3,actualResult);
    }
    @Test
    public void toListTest(){
        int[] arr = {1,2,3,4};
        List<int[]> expected = Arrays.asList(arr);
        List<int[]> actual = Methods.toList(arr);
        Assertions.assertEquals(expected,actual);
    }
    @Test
    public void findUnique(){
        List<Integer>list = Arrays.asList(1,2,3,4,5,6,7,8,2,3,4,5,1,2,3,4,5,9,10);
        List<Integer> expectedList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        List<Integer> actualList = Methods.findUnique(list);
        Assertions.assertEquals(expectedList,actualList);
    }
    @Test
    public void calcOccuranceTest(){
        List<String>list =Arrays.asList("Toyota","Reno","Kia","BMW","Mersedes","Lanos","Reno","Lanos");
        Map<String, Integer> expected = new HashMap<>();
        expected.put("Lanos", 2);
        expected.put("Reno",2);
        expected.put("Toyota",1);
        expected.put("Kia",1);
        expected.put("BMW",1);
        expected.put("Mersedes",1);
        Map<String,Integer>actual = Methods.calcOccurance(list);
        Assertions.assertEquals(expected,actual);

    }
    @Test
    public void findOccuranceTest(){
        List<String>list =Arrays.asList("Toyota","Reno","Kia","BMW","Mersedes","Lanos","Reno","Lanos");
        List<Methods.FindOccuran> expected = Arrays.asList(
                new Methods.FindOccuran("Lanos",2),
                new Methods.FindOccuran("Reno",2),
                new Methods.FindOccuran("Toyota",1),
                new Methods.FindOccuran("Kia",1),
                new Methods.FindOccuran("BMW",1),
                new Methods.FindOccuran("Mersedes",1));
        Comparator<Methods.FindOccuran> comparator = Comparator.comparing(Methods.FindOccuran::getWords);
        Collections.sort(expected,comparator);
        List<Methods.FindOccuran> actual = Methods.findOccurans(list);
        Collections.sort(actual,comparator);
        Assertions.assertEquals(expected,actual);

    }

}

