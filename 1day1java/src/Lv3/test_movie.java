package Lv3;

import java.util.Scanner;

public class test_movie {

	public static void main(String[] args) {
		// 영화관
		int seat[] = new int[8];
		int money = 12000;
		int cnt = 0;
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("==== 영화관 ====");
			for(int i=0; i<seat.length; i++) {
				if(seat[i] == 0) {
					System.out.print("[ ]");
				}
				else {
					System.out.print("[X]");
				}
			}
				System.out.println();
			System.out.println("1.좌석예매");
			System.out.println("2.종료");
			int sel = sc.nextInt();
			if(sel==1) {
				System.out.print("좌석번호 : ");
				int pick = sc.nextInt()-1;
				if(seat[pick]==0) {
					seat[pick] = 1;
					cnt++;
					money*=cnt;
				}
				else {
					System.out.println("이선좌");
				}
				}
			else if(sel==2) {
				System.out.printf("총 요금 : %d원 입니다.\n",money);
				System.out.println("종료");
				break;
			}
				
			}
		

	}

}
