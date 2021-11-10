package Lv4;

import java.util.Random;

public class ex03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * # 중복숫자 금지[2단계]
		 * 1. arr배열에 1~10 사이의 랜덤 숫자 5개를 저장한다.
		 * 2. 단 중복되는 숫자가 없어야 한다.
		 */
		
		Random rn = new Random();
		int arr[] = new int[5];
		
		for (int i = 0; i < 5; i++) {
			int r = rn.nextInt(10) + 1;
			arr[i] = r;
			int check = 1;
			for (int j = 0; j < i; j++) {
				if (arr[j] == r)
					check = -1;
			}
			if (check == 1)
				arr[i] = r;
			else
				i--;
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
