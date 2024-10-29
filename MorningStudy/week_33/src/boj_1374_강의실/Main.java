package boj_1374_강의실;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Section implements Comparable<Section> {

		int start;
		int end;

		@Override
		public int compareTo(Section s) {
			if (this.start == this.end) {
				return this.end - s.end;
			}
			return this.start - s.start;
		}

		public Section(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	static StringTokenizer st;
	static ArrayList<Section> list;
	static PriorityQueue<Section> pq;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		
		// end ASC
		pq = new PriorityQueue<>(new Comparator<Section>() {
			@Override
			public int compare(Section s1, Section s2) {
				if (s1.end == s2.end) {
					return s1.start - s2.start;
				}
				return s1.end - s2.end;
			}
		});

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			list.add(new Section(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		Collections.sort(list);	// start ASC, end ASC
		pq.add(list.get(0));
		int max = 1;

		for (int i = 1; i < N; i++) {
			Section now = list.get(i);
			Section ing = pq.poll();
			
			if (ing.end <= now.start) {
				pq.add(new Section(ing.start, now.end));
			} else {
				pq.add(ing);
				pq.add(now);
				max = Math.max(max, pq.size());
			}
		}

		System.out.println(max);
	}
}
