package boj_2170_선긋기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Line implements Comparable<Line> {
		int x;
		int y;

		public Line(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Line o) {
			if (this.x == o.x) {
				return this.y - o.y;
			}
			return this.x - o.x;
		}
	}

	static int N;
	static PriorityQueue<Line> pq;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		pq = new PriorityQueue<>();

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			pq.add(new Line(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		int left = Integer.MIN_VALUE;
		int right = Integer.MIN_VALUE;
		int sum = 0;

		Line line;

		while (!pq.isEmpty()) {
			line = pq.poll();
			if (line.x > right) {
				sum += Math.abs(line.y - line.x);
				left = line.x;
				right = line.y;
			} else {
				if (line.y <= right) {
					continue;
				} else {
					sum += Math.abs(line.y - right);
					right = line.y;
				}
			}
		}

		System.out.println(sum);

	}
}
