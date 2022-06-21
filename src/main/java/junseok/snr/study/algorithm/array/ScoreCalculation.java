package junseok.snr.study.algorithm.array;

import java.util.Scanner;

public class ScoreCalculation {

    public int solution(int numberCount, int[] arr) {

        int consecutiveScores = 0; // 연달아 맞힌 점수
        int totalScore = 0;

        for (int i = 0; i < numberCount; i++) {
            if (arr[i] == 1) {
                consecutiveScores++;
            } else {
                consecutiveScores = 0;
            }
            totalScore += consecutiveScores;
        }
        return totalScore;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int numberCount = scanner.nextInt();
        int arr[] = new int[numberCount];
        for (int i = 0; i < numberCount; i++) {
            arr[i] = scanner.nextInt();
        }
        ScoreCalculation sc = new ScoreCalculation();
        System.out.print(sc.solution(numberCount, arr));
    }
}
