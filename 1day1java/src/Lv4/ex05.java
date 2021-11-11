package Lv4;

import java.util.Random;
import java.util.Scanner;

public class ex05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* 
		 * # 1 to 50�� ==> 1 to 18
		 * 1. ���ۿ��� 1 to 50 �̶�� �˻��Ѵ�.
		 * 2. 1 to 50 ���߷� ������ ������ ������ �ǽ��غ���.
		 * 3. �� ������ ���ڹ����� ���� 1 to 18�� ���� �����Ѵ�.
		 * 4. ���� 1~9�� front �迭�� �����ϰ�,
		 *    ���� 10~18�� back �迭�� �����Ѵ�.
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
				System.out.printf("�Է�[1~%d]: ", SIZE);
				int num = sc.nextInt() - 1;
				if (num >= 0 && num < SIZE && front[num] == n) {
					front[num] = back[num];
					back[num] = 0;
					n++;
				}
			}
	}

}
