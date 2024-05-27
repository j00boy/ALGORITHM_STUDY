package swea_1240_단순2진암호코드;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {

    static int N;
    static int M;
    static int result;

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/swea_1240_단순2진암호코드/input.txt");
        Scanner sc = new Scanner(file);
        // Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        // test case
        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            M = sc.nextInt();
            result = 0;

            int[][] password = new int[N][M];

            for (int r = 0; r < N; r++) {
                String str = sc.next();
                for (int c = 0; c < M; c++) {
                    password[r][c] = Character.getNumericValue(str.charAt(c));
                }
            }

            System.out.printf("#%d %d\n", tc, getNumericPassword(password));
        }
        // test case
    }

    public static int getNumericPassword(int[][] arr) {
        for (int k = 0; k < N; k++) {
            String ans = "";
            for (int i = 0; i < M; i += 7) {
                int cnt = 0;
                while (cnt != 8 && i + cnt < M) {
                    String digit = "";
                    for (int j = i; j < i + 7; j++) {
                        digit += arr[k][j];
                    }

                    switch (digit) {
                        case "0001101":
                            ans += "0";
                            break;
                        case "0011001":
                            ans += "1";
                            break;
                        case "0010011":
                            ans += "2";
                            break;
                        case "0111101":
                            ans += "3";
                            break;
                        case "0100011":
                            ans += "4";
                            break;
                        case "0110001":
                            ans += "5";
                            break;
                        case "0101111":
                            ans += "6";
                            break;
                        case "0111011":
                            ans += "7";
                            break;
                        case "0110111":
                            ans += "8";
                            break;
                        case "0001011":
                            ans += "9";
                            break;
                        default:
                            break;
                    }
                    cnt++;
                }
            }

            if (!ans.isEmpty()) {
                int sum = 0;
                for (int i = 0; i < 8; i++) {
                    if (i % 2 == 0) {
                        sum += Character.getNumericValue(ans.charAt(i)) * 3;
                    } else {
                        sum += Character.getNumericValue(ans.charAt(i));
                    }
                }

                if (sum % 10 == 0) {
                    // 현재 테스트 케이스에서 올바른 결과를 찾은 경우에만 result를 초기화
                    for (int i = 0; i < 8; i++) {
                        result += Character.getNumericValue(ans.charAt(i));
                    }
                    // 결과를 찾았으므로 바로 반환
                    return result;
                }
            }
        }

        return 0;
    }
}
