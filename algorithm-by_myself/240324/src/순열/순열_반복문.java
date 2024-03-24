package 순열;

public class 순열_반복문 {
	
	static int[] arr;
	static int N;
	
	public static void main(String[] args) {
		arr = new int[] {1, 2, 3, 4};
		N = arr.length;
		int count = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(i != j) {
					for(int k = 0; k < N; k++) {
						if(i != k && j != k) {
							for(int l = 0; l < N; l++) {
								if(i != l && j != l && k != l) {
									System.out.println(arr[i] + " " + arr[j] + " " + arr[k] + " " + arr[l]);
									count++;
								}
							}
						}
					}
				}
			}
		}
		
		System.out.println(count);
		
	}
}
