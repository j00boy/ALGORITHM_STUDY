package 순열구현;

public class 순열_반복문 {

	static int[] nums;
	static int N;
	
	public static void main(String[] args) {
		nums = new int[] {2, 4, 6, 8};
		N = nums.length;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(nums[i] != nums[j]) {
					for(int k = 0; k < N; k++) {
						if(nums[k] != nums[i] && nums[k] != nums[j]) {
							for(int l = 0; l < N; l++) {
								if(nums[l] != nums[i] && nums[l] != nums[j] && nums[l] != nums[k]) {
									System.out.printf("%d %d %d %d\n", nums[i], nums[j], nums[k], nums[l]);
								}
							}
						}
					}
				}
			}
		}
	}

}
