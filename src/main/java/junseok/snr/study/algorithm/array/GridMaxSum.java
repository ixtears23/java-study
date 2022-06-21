package junseok.snr.study.algorithm.array;

import java.util.Scanner;

public class GridMaxSum {

    public int solution(int rowNumber, int[][] arr) {
        int answer = Integer.MIN_VALUE;
        int sum1, sum2;

        for (int i = 0; i < rowNumber; i++) {
            sum1 = sum2 = 0;
            for (int j = 0; j < rowNumber; j++) {
                sum1 += arr[i][j];
                sum2 += arr[j][i];
            }
            answer = Math.max(answer, sum1);
            answer = Math.max(answer, sum2);
        }

        sum1 = sum2 = 0;
        for (int i = 0; i < rowNumber; i++) {
            sum1 += arr[i][i];
            sum2 += arr[rowNumber - i - 1][i];
        }
        answer = Math.max(answer, sum1);
        answer = Math.max(answer, sum2);

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int rowNumber = sc.nextInt();
        int[][] arr = new int[rowNumber][rowNumber];
        for (int i = 0; i < rowNumber; i++) {
            for (int j = 0; j < rowNumber; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.print(new GridMaxSum().solution(rowNumber, arr));
    }
}
