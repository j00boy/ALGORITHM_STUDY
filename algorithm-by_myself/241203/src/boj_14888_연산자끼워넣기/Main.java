package boj_14888_연산자끼워넣기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static int N;
    static int[] arr;
    static int[] operator;  // +, -, *, /
    static int min, max;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        operator = new int[4];

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        calculate(1, arr[0]);

        System.out.println(max);
        System.out.println(min);
    }

    public static void calculate(int idx, int result) {
        if(idx >= N) {
            // TODO: 계산
            min = Math.min(min, result);
            max = Math.max(max, result);
            return;
        }

        for(int i = 0; i < 4; i++) {
            int nextResult = result;
            if(operator[i] != 0) {
                if(i == 0) {
                    nextResult = result + arr[idx];
                } else if(i == 1) {
                    nextResult = result - arr[idx];
                } else if(i == 2) {
                    nextResult = result * arr[idx];
                } else {
                    if(result < 0) {
                        nextResult = Math.abs(result) / arr[idx];
                        nextResult = -nextResult;
                    } else {
                        nextResult = result / arr[idx];
                    }
                }
                operator[i]--;
                calculate(idx+1, nextResult);
                operator[i]++;
            }
        }
    }
}
