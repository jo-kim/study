package Lv4;

import java.util.Random;

public class ex04 {

	public static void main(String[] args) {
		
		/*
		 * # ���� �߱� ����
		 * 1. me�� 1~9 ������ ���� 3���� ����
		 *    (��, �ߺ��Ǵ� ���ڴ� ���� �Ұ�)
		 * 2. com�� me�� ���� ������ ���� ������ �ݺ�
		 * 3. ���ڿ� �ڸ��� ������ 		strike += 1
		 *    ���ڸ� ���� �ڸ��� Ʋ���� 	ball += 1
		 * ��)
		 * ���� : 1 7 3
		 * 3 1 5		: 2b
		 * 1 5 6		: 1s
		 * ...
		 */
		
		int com[] = {1,7,3};
		int me[] = new int[3];
		
		Random rn = new Random();
		
		for(int i=0; i<me.length; i++) {
			int r = rn.nextInt(9)+1;
			me[i] = r;
			int check = 1;
			for(int j=0; j<i; j++) {
				if(me[j] == r)
					check = -1;
			}
			if(check == 1)
				me[i] = r;
			else
				i--;
		}
		
		
		for(int i=0; i<me.length; i++) {
			System.out.print(me[i]+" ");
		}
		int strike =0;
		int ball =0;
		for(int i=0; i<me.length; i++) {
			for(int j=0; j<me.length; j++) {
				if(me[i] == com[j]) {
					if(i==j) {
						strike++;
					}
					else
						ball++;
				}
			}
		}
		
		System.out.printf("strike: %d , ball: %d",strike, ball);
	}

}
