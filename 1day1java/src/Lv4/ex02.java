package Lv4;

import java.util.Scanner;

public class ex02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * # �����̵�[2�ܰ�]
		 * 1. ����2�� ĳ�����̴�.
		 * 2. ����1�� �Է��ϸ�, ĳ���Ͱ� ��������
		 * 	    ����2�� �Է��ϸ�, ĳ���Ͱ� ���������� �̵��Ѵ�.
		 * 3. ��, �¿� ���� �������� ��, ����ó���� �ؾ��Ѵ�.
		 * 4. ���� 1�� ���̴�. ���� ������ �̵��� �� ����.
		 * 5. ��, ����3�� �Է��ϸ�, ���� ������ �� �ִ�.
		 */
		Scanner sc = new Scanner(System.in);
		int[] game = {0, 0, 1, 0, 2, 0, 0, 1, 0};
		int player = 0;
		
		while(true) {
			for(int i=0; i<game.length; i++) {
				if(game[i]==1) {
					System.out.print("_|_");
				}
				else if(game[i] == 2) {
					System.out.print("_��_");
					player = i;
				}
				else {
					System.out.print("__");
				}
			}
			System.out.println();
			System.out.print("[1]LEFT [2]RIGHT : ");
			int num = sc.nextInt();
			if(num == 1 && player-1>=0) {
				if(game[player-1]==1) {
					System.out.println("����? (1)Y (2)N");
					int punch = sc.nextInt();
					if(punch!=1) continue;
				}
				game[player-1] = 2;
				game[player] = 0;
				player--;
			}
			else if(num == 2 && player+1<game.length) {
				if(game[player+1] == 1) {
					System.out.println("����? (1)Y (2)N");
					int punch = sc.nextInt();
					if(punch!=1) continue;
				}
				game[player+1] = 2;
				game[player] = 0;
				player++;
			}
		}
	}

}
