package Lv4;

import java.util.Scanner;

public class ex02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * # 숫자이동[2단계]
		 * 1. 숫자2는 캐릭터이다.
		 * 2. 숫자1을 입력하면, 캐릭터가 왼쪽으로
		 * 	    숫자2를 입력하면, 캐릭터가 오른쪽으로 이동한다.
		 * 3. 단, 좌우 끝에 도달했을 때, 예외처리를 해야한다.
		 * 4. 숫자 1은 벽이다. 벽을 만나면 이동할 수 없다.
		 * 5. 단, 숫자3을 입력하면, 벽을 격파할 수 있다.
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
					System.out.print("_옷_");
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
					System.out.println("격파? (1)Y (2)N");
					int punch = sc.nextInt();
					if(punch!=1) continue;
				}
				game[player-1] = 2;
				game[player] = 0;
				player--;
			}
			else if(num == 2 && player+1<game.length) {
				if(game[player+1] == 1) {
					System.out.println("격파? (1)Y (2)N");
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
