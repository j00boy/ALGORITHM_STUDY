package boj_18111_마인크래프트;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main2 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st1 = new StringTokenizer(br.readLine()); 
		int N = Integer.parseInt(st1.nextToken());
		int M = Integer.parseInt(st1.nextToken());
		int B = Integer.parseInt(st1.nextToken()); // 인벤토리에 이미 있는 블록의 갯수

		int[][] site = new int[N][M]; // 땅 부지 생성

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				site[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int minTime = Integer.MAX_VALUE; // 최소 시간
		int highestBlock = Integer.MIN_VALUE; // 최대 높이의 블럭

		// 총 작업시간을 구하는 함수
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				
				int inven = B;
				int time = 0;
				int standard = site[i][j];

				for (int r = 0; r < N; r++) {
					for (int c = 0; c < M; c++) {
						if (site[r][c] > standard) {
							time += 2 * (site[r][c] - standard);
						} else if (site[r][c] < standard) {
							inven -= standard - site[r][c];
							if (inven < 0) {
								break;
							} else {
								time += standard - site[r][c];
							}
						}
					}
				}

				if (time < minTime && time >= 0 && standard > highestBlock && standard >= 0) {
					minTime = time;
					highestBlock = standard;
				}
			}
		}

		System.out.println(minTime + " " + highestBlock);

	}
}