package boj_17471_게리맨더링;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	static int[][] cities;
	static int N;
	static boolean[] sel;
	static int count;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		count = 0;
		N = sc.nextInt();

		cities = new int[N][2];
		sel = new boolean[N];

		for (int i = 0; i < N; i++) {
			cities[i][0] = i + 1;
			cities[i][1] = sc.nextInt();
		}

		powerset(0);

	}

	public static void powerset(int idx) {
		if (idx >= N) {
			List<Integer> list1 = new ArrayList<>();
			List<Integer> list2 = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				if (sel[i]) {
					list1.add(cities[i][0]);
				} else {
					list2.add(cities[i][0]);
				}
			}
			
			if(list1.isEmpty() || list2.isEmpty()) {
				return;
			} else {
				System.out.println(list1 + " " + list2);
				return;
			}
		}

		sel[idx] = false;
		powerset(idx + 1);

		sel[idx] = true;
		powerset(idx + 1);
	}

}