package swea_9280_진용이네주차타워;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {

		File file = new File("src/swea_9280_진용이네주차타워/input.txt");
		Scanner sc = new Scanner(file);

		int tc = sc.nextInt();

		// test case
		for (int test_case = 1; test_case <= tc; test_case++) {
			int N = sc.nextInt(); // n개의 주차 공간
			int M = sc.nextInt(); // 주차장을 이용할 m대의 차량

			int[] cost = new int[N + 1];
			int[] carWeight = new int[M + 1];

			for (int i = 1; i <= N; i++) {
				cost[i] = sc.nextInt();
			}

			for (int i = 1; i <= M; i++) {
				carWeight[i] = sc.nextInt();
			}

			Queue<Integer> queueIn = new LinkedList<>();
			Queue<Integer> queueOut = new LinkedList<>();

			int[] parkingLots = new int[N + 1];
			
			for (int i = 0; i < 2 * M; i++) {
				int target = sc.nextInt();

				if (target > 0) {
					queueIn.add(target);
				} else {
					queueOut.add(target);
				}
			}
			
			boolean isFull = false;
			int earning = 0;
			while(queueIn.size() != 0 && queueOut.size() != 0) {
				if(isFull == false) {
					for(int i = 1; i <= N; i++) {
						if(parkingLots[i] == 0) {
							parkingLots[i] = queueIn.poll();
							break;
						}
					}					
				} else {
					int out = -(queueOut.poll());
					for(int i = 1; i <= N; i++) {
						if(parkingLots[i] != 0) {
							earning += cost[i] * carWeight[out];
							parkingLots[i] = 0;
						}
					}
				}
				
				int cnt = 0;
				for(int i = 1; i <= N; i++) {
					if(parkingLots[i] != 0) {
						cnt++;
					}
				}
				
				if(cnt == N) {
					isFull = true;
				}
			}
			
			System.out.printf("#%d %d\n", test_case, earning);

		}
		// test case

	}

}
