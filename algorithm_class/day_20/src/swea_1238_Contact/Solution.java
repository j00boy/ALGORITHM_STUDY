package swea_1238_Contact;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
//		Scanner sc = new Scanner(new File("src/swea_1238_Contact/input.txt"));

		for (int tc = 1; tc <= 10; tc++) {

			int N = sc.nextInt();
			int origin = sc.nextInt();
			int leng = N / 2;
			int[] start = new int[leng];
			int[] end = new int[leng];

			for (int i = 0; i < N; i++) {
				int input = sc.nextInt();
				if (i % 2 == 0) {
					start[i / 2] = input;
				} else {
					end[i / 2] = input;
				}
			}

			ArrayList<Integer>[] adjList = new ArrayList[101];
			for (int i = 0; i < 101; i++) {
				adjList[i] = new ArrayList<>();
			}

			for (int i = 0; i < leng; i++) {
				adjList[start[i]].add(end[i]);
			}

			boolean[] visited = new boolean[101];
			visited[origin] = true;

			Queue<Integer> queue = new LinkedList<>();

			for (int i = 0; i < adjList[origin].size(); i++) {
				queue.add(adjList[origin].get(i));
				queue.add(1);
			}

			List<Integer> depth = new ArrayList<>();
			int rank = 1;
			
			while (!queue.isEmpty()) {
				int Node = queue.poll();
				int now_depth = queue.poll();
				if(now_depth < rank) {
					continue;
				} else if(now_depth == rank) {
					depth.add(Node);
				} else {
					rank++;
					depth = new ArrayList<>();
					depth.add(Node);
				}

				for (int i = 0; i < adjList[Node].size(); i++) {
					if (!visited[adjList[Node].get(i)]) {
						visited[adjList[Node].get(i)] = true;
						queue.add(adjList[Node].get(i));
						queue.add(now_depth + 1);
					}
				}
			}

			int max = 0;
			for (int i : depth) {
				max = Math.max(max, i);
			}
			
			System.out.printf("#%d %d\n", tc, max);
		}
	}
}