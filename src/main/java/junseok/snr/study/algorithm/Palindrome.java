package junseok.snr.study.algorithm;

import java.util.*;

public class Palindrome {
    public String process(int N, int K) {
        List<Character> alphabetList = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            alphabetList.add(c);
        }
        Collections.shuffle(alphabetList);

        List<Character> chosenChars = alphabetList.subList(0, K);

        StringBuilder sb = new StringBuilder();

        while (sb.length() < N / 2) {
            for (int i = 0; i < K && sb.length() < N / 2; i++) {
                sb.append(chosenChars.get(i));
            }
        }

        String str = sb.toString();
        StringBuilder sb2 = new StringBuilder(str).reverse();

        if (N % 2 == 1) {
            str += chosenChars.get(0);
        }

        return str + sb2;
    }
    public static void main(String[] args) {
        Palindrome demo = new Palindrome();
        System.out.println(demo.process(5, 2));
        System.out.println(demo.process(8, 3));
        System.out.println(demo.process(3, 2));
    }
}