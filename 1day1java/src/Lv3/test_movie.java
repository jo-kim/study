package Lv3;

import java.util.Scanner;

public class test_movie {

	public static void main(String[] args) {
		// ��ȭ��
		int seat[] = new int[8];
		int money = 12000;
		int cnt = 0;
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("==== ��ȭ�� ====");
			for(int i=0; i<seat.length; i++) {
				if(seat[i] == 0) {
					System.out.print("[ ]");
				}
				else {
					System.out.print("[X]");
				}
			}
				System.out.println();
			System.out.println("1.�¼�����");
			System.out.println("2.����");
			int sel = sc.nextInt();
			if(sel==1) {
				System.out.print("�¼���ȣ : ");
				int pick = sc.nextInt()-1;
				if(seat[pick]==0) {
					seat[pick] = 1;
					cnt++;
					money*=cnt;
				}
				else {
					System.out.println("�̼���");
				}
				}
			else if(sel==2) {
				System.out.printf("�� ��� : %d�� �Դϴ�.\n",money);
				System.out.println("����");
				break;
			}
				
			}
		

	}

}
