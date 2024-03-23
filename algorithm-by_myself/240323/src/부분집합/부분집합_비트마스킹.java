/*
 * 이거는 뭔지 모르겠다.
 */

package 부분집합;

public class 부분집합_비트마스킹 {
	
	public static void main(String[] args) {
		
		String[] materials = {"fish", "meat", "cucumber", "carrot"};
		int N = materials.length;
		
		int[] inputs = new int[materials.length];
		
		for(int i = 0; i < (1 << N); i++) {
			for(int j = 0; j < N; j++) {
				if ((i & (1 << j)) > 0) {
					System.out.print(materials[j] + " ");
				}
			}
			System.out.println();
		}
	}
}
