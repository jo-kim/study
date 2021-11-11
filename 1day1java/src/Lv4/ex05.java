package Lv4;

import java.util.Random;
import java.util.Scanner;

public class ex05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* 
		 * # 1 to 50을 ==> 1 to 18
		 * 1. 구글에서 1 to 50 이라고 검색한다.
		 * 2. 1 to 50 순발력 게임을 선택해 게임을 실습해본다.
		 * 3. 위 게임을 숫자범위를 좁혀 1 to 18로 직접 구현한다.
		 * 4. 숫자 1~9는 front 배열에 저장하고,
		 *    숫자 10~18은 back 배열에 저장한다.
		 */
	    Random rn = new Random();
	    Scanner sc = new Scanner(System.in);
			final int SIZE = 9;
			int[] front = new int[SIZE];
			int[] back  = new int[SIZE];
			
			int n = 1;
			for(int i=0; i<SIZE; i++) {
				front[i] = n;
				back[i] = SIZE+n;
				n++;
			}
			
			for(int i=0; i<1000; i++) {
				int r = rn.nextInt(SIZE);
				
				int temp = front[0];
				front[0] = front[r];
				front[r] = temp;
				
				r = rn.nextInt(SIZE);
				temp = back[0];
				back[0] = back[r];
				back[r] = temp;
			}
			
			
			n=1;
			while (true) {
				for (int i = 0; i < SIZE; i++) {
					System.out.print(front[i] + " ");
					if (i % 3 == 2)
						System.out.println();
				}
				if (n > SIZE * 2) {
					System.out.println("GAME CLEAR");
					break;
				}
				System.out.printf("입력[1~%d]: ", SIZE);
				int num = sc.nextInt() - 1;
				if (num >= 0 && num < SIZE && front[num] == n) {
					front[num] = back[num];
					back[num] = 0;
					n++;
				}
			}
	}

}
