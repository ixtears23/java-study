package junseok.snr.study.algorithm.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InvertedPrime {

    public boolean isPrime(int number) {
        if (number == 1) return false;
        for (int i = 2; i < number; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    public List<Integer> solution(int numberCount, int[] numbers) {
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < numberCount; i++) {
            int number = numbers[i]; // 처음 숫자
            int result = 0; // 뒤집어 지는 숫자 하나씩 증가함

            while (number > 0) {
                int temp = number % 10; // 숫자의 마지막 자리(첫 번째 자리로 올 숫자)
                result = result * 10 + temp;
                number = number / 10; // 이렇게 해야 한번 검사한 숫자는 없앰(마지막 부터 처음으로 순서)
            }
            if (isPrime(result)) answer.add(result);
        }
        return answer;
    }

    public static void main(String[] args){
        InvertedPrime T = new InvertedPrime();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        List<Integer> answer = T.solution(n, arr);
        for (int i = 0; i < answer.size(); i++) {
            System.out.print(answer.get(i) + " ");
        }
    }
}
