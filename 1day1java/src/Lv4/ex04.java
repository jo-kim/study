package Lv4;

import java.util.Random;

public class ex04 {

	public static void main(String[] args) {
		
		/*
		 * # 숫자 야구 게임
		 * 1. me에 1~9 사이의 숫자 3개를 저장
		 *    (단, 중복되는 숫자는 저장 불가)
		 * 2. com과 me를 비교해 정답을 맞출 때까지 반복
		 * 3. 숫자와 자리가 같으면 		strike += 1
		 *    숫자만 같고 자리가 틀리면 	ball += 1
		 * 예)
		 * 정답 : 1 7 3
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
