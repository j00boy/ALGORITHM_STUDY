package 부분집합;

public class 부분집합_반복문 {
	public static void main(String[] args) {
		
		String[] materials = {"fish", "meat", "cucumber", "carrot"};
		
		int[] inputs = new int[materials.length];
		int count = 0;
		
		for(int i = 0; i < 2; i++) {
			inputs[0] = i;
			for(int j = 0; j < 2; j++) {
				inputs[1] = j;
				for(int k = 0; k < 2; k++) {
					inputs[2] = k;
					for(int l = 0; l < 2; l++) {
						inputs[3] = l;
						for(int m = 0; m < materials.length; m++) {
							if(inputs[m] == 1) {
								System.out.print(materials[m] + " ");
							}
						}
						System.out.println();
						count++;
					}
				}
			}
		}
		
		System.out.println("총 경우의 수: " + count);
	}

}
