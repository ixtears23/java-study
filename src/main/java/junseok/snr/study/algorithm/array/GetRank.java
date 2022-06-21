package junseok.snr.study.algorithm.array;

import java.util.Scanner;

public class GetRank {

    private int[] solution(int numbers, int[] arr) {

        int[] answer = new int[numbers];
        int rank = 1;

        for (int i = 0; i < numbers; i++) {

            for (int j = 0; j < numbers; j++) {
                if (arr[i] < arr[j]) {
                    rank++;
                }
            }
            answer[i] = rank;
            rank = 1;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int numbers = sc.nextInt();
        int arr[] = new int[numbers];
        for (int i = 0; i < numbers; i++) {
            arr[i] = sc.nextInt();
        }
        final int[] answer = new GetRank().solution(numbers, arr);
        for (int j : answer) {
            System.out.print(j + " ");
        }
    }
}
