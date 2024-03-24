package 부분집합;

public class 부분집합_반복문 {
	
	static String[] materials;
	static int[] selected;
	
	public static void main(String[] args) {
		materials = new String[] {"fish", "meat", "cucumber", "carrot"};
		selected = new int[materials.length];
		
		for(int i = 0; i < 2; i++) {
			selected[0] = i;
			for(int j = 0; j < 2; j++) {
				selected[1] = j;
				for(int k = 0; k < 2; k++) {
					selected[2] = k;
					for(int l = 0; l < 2; l++) {
						selected[3] = l;
						String tmp = "";
						for(int r = 0; r < 4; r++) {
							if(selected[r] == 1) {
								tmp += materials[r] + " ";
							}
						}
						System.out.println(tmp);
					}
				}
			}
		}
	}
}
