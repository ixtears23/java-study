package junseok.snr.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo {

    public static void main(String[] args) {
        List<List<List<String>>> fullList = new ArrayList<>();

        List<List<String>> list2_1 = new ArrayList<>();
        List<List<String>> list2_2 = new ArrayList<>();

        List<String> list1_1 = new ArrayList<>();

        list1_1.add("a");
        list1_1.add("b");
        list1_1.add("c");

        List<String> list1_2 = new ArrayList<>();
        list1_2.add("2_a1");
        list1_2.add("2_b1");
        list1_2.add("2_c1");


        List<String> list1_3 = new ArrayList<>();
        list1_3.add("3_a1");
        list1_3.add("3_b1");
        list1_3.add("3_c1");

        list2_1.add(list1_1);
        list2_1.add(list1_2);
        list2_2.add(list1_3);

        fullList.add(list2_1);
        fullList.add(list2_2);


        List<String> mixedList = fullList.stream()
                .flatMap(List::stream)
                .flatMap(List::stream)
                .toList();


        String mixedString = String.join(",", mixedList);

        System.out.println(mixedString);
    }
}
