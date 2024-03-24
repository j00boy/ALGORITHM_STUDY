package 순열;

public class 순열_재귀swap {
	
	static int[] arr;
	static int N;
	static int count = 0;
	
	public static void main(String[] args) {
		arr = new int[] {1, 2, 3, 4};
		N = arr.length;
		
		permutation(0);
		System.out.println(count);
	}
	
	public static void permutation(int idx) {
		if(idx >= N) {
			String tmp = "";
			for(int i = 0; i < N; i++) {
				tmp += arr[i] + " ";
			}
			System.out.println(tmp);
			count++;
			return;
		}
		
		for(int i = idx; i < N; i++) {
			swap(i, idx);
			permutation(idx + 1);
			swap(idx, i);
		}
	}
	
	
	static void swap(int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
}
