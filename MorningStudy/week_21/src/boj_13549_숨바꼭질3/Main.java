package boj_13549_숨바꼭질3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int subin;
	static int sister;
	static int time;
	static int[] arr;
	static Queue<Integer> queue;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		queue = new LinkedList<>();
		arr = new int[100001]; // 1 ~ 100,000, index 통일을 위해 +1

		subin = sc.nextInt();
		sister = sc.nextInt();


		Arrays.fill(arr, -1);
		queue.add(subin);
		queue.add(0);

		// BFS같은 느낌(무조건 빠른 시간을 먼저 계산해야 하기 때문임
		while (!queue.isEmpty()) {
			int now = queue.poll();
			int add = now;
			int time = queue.poll();

			while (now < 100001) {
				if (arr[now] != -1) {
					break;
				}

				arr[now] = time;
				
				if(now == sister) {
					break;
				}
				
				queue.add(now * 2);
				queue.add(time);

			}

			if (now - 1 <= 100000 && now - 1 >= 0 && arr[now - 1] == -1) {
				queue.add(now - 1);
				queue.add(time + 1);
			}

			if (now + 1 <= 100000 && arr[now + 1] == -1) {
				queue.add(now + 1);
				queue.add(time + 1);
			}

		}

		System.out.println(arr[sister]);
//		System.out.println(Arrays.toString(arr));
	}

}
