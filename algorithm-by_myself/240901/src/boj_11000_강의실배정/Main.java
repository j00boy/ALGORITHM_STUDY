package boj_11000_강의실배정;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 
		 int N = sc.nextInt();
		 List<int[]> schedule = new ArrayList<>();
		 
		 for(int i = 0; i < N; i++) {
			 int start = sc.nextInt();
			 int end = sc.nextInt();
			 
			 schedule.add(new int[] {start, end});
		 }
		 
		 Collections.sort(schedule, new Comparator<int[]>() {

			public int compare(int[] arr1, int[] arr2) {
				if(arr1[0] == arr2[0]) return arr1[1] - arr2[1];
				return arr1[0] - arr2[0];
			}
			 
		 });
		 
//		 for(int[] arr : schedule) {
//			 System.out.println(Arrays.toString(arr));
//		 }
		 
		 int idx = 0;
		 
		 PriorityQueue<Integer> pq = new PriorityQueue<>();
		 
		 while(idx < N) {
			 
			 if(pq.isEmpty()) {
				 pq.add(schedule.get(idx)[1]);
			 } else {
				 int endTime = pq.poll();
				 if(schedule.get(idx)[0] < endTime) {
					 pq.add(schedule.get(idx)[1]);
					 pq.add(endTime);
				 } else {
					 pq.add(schedule.get(idx)[1]);
				 }
			 }
			 idx++;
		
		 }
		 
		 
		 
		 System.out.println(pq.size());
	}
}
