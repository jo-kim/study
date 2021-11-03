package Lv3;

public class test_03 {

	public static void main(String[] args) {
		int arr[] = {10,20,30,40,50};	
		int b[] = new int[5];
		// arr의 값중 4의 배수만 b에 거꾸로저장
	    // 예) b = {0,0,0,40,20};
		int idx = 0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i] % 4 ==0) {
				b[4-idx] = arr[i];
				idx++;
			}
		}
		
		for(int i=0; i<b.length; i++) {
			System.out.println(b[i]);
		}
		
		
	}

}
