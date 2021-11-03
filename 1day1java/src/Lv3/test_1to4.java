package Lv3;

import java.util.Random;
import java.util.Scanner;

public class test_1to4 {

	public static void main(String[] args) {
		/*
		 * #  1 to 4
		 * 1. arr배열에 1~4 사이의 숫자를 중복없이 저장한다.
		 * 2. 사용자는 1부터 순서대로 해당 위치 값을 입력한다.
		 * 3. 정답을 맞추면 해당 값은 9로 변경되어 모든 값이 9가 되면 게임은 종료된다.
		 * 예)
		 * 4 2 3 1
		 * 입력 : 3
		 * 4 2 3 9
		 * 입력 : 1
		 * 4 9 3 9
		 * ...
		 */
		int arr[] = new int[4];
		int check[] = new int[4];
		Random rn = new Random();
		Scanner sc = new Scanner(System.in);
		
		// rn
		for(int i=0; i<arr.length; i++) {
			int r = rn.nextInt(4)+1;
			
			if(check[r-1] == 0) {
				arr[i] = r;
				check[r-1] = 1;
			}
			else i--;
		}
		int cnt = 0;
		int n = 1;
		while (cnt < 4) {
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}

			System.out.print("입력: ");
			int num = sc.nextInt() - 1;
			if (arr[num] == n) {
				arr[num] = 9;
				n++;
				cnt++;
			}
		}
		if (cnt == 4) {
			System.out.println("GAME CLEAR");

		}
	}

}
