package Lv3;

import java.util.Scanner;

public class test_tictactoe {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int game[] = new int[9];
		int turn = 1;
		int win = 0;
		
		while(true) {
		System.out.println("==== ∆Ω≈√≈‰ ====");
		
		for(int i=0; i<game.length; i++) {
			if(game[i] == 1) { 
				System.out.print("[O] ");
			}
			else if(game[i] == 2) {
				System.out.print("[X] ");
			}
			else {
				System.out.print("[ ] ");
			}
			if(i%3==2)
				System.out.println();
		}
		if(win!=0) {
			System.out.printf("[P%d] Ω¬∏Æ",win);
			break;
		}
		System.out.printf("[P%d] ¿‘∑¬(1~9): ",turn);
		int num = sc.nextInt()-1;
		if(game[num] == 0) {
			game[num] = turn;
		}
		else 
			continue;
		/*
		 * 0 1 2
		 * 3 4 5
		 * 6 7 8
		 */
		// -
		for(int i=0; i<game.length; i+=3) {
			int cnt = 0;
			for(int j=0; j<3; j++) {
				if(game[i+j] == turn)
					cnt++;
			}
			if(cnt == 3)
				win = turn;
		}
		// |
		for(int i=0; i<3; i++) {
			int cnt =0;
			for(int j = 0; j<3; j++) {
				if(game[i+3*j] == turn)
					cnt++;
			}
			if(cnt == 3)
				win = turn;
		}
		
		// /
		int cnt =0;
		for(int i=1; i<=3;i++) {
			if(game[i*2] == turn)
				cnt++;
			if(cnt ==3) win = turn;
		}
		
		// \
		 cnt =0;
		for(int i=0; i<3; i++) {
			if(game[i*4] == turn )
				cnt ++;
			if(cnt == 3) win = turn;
		}
		
		turn = turn == 1 ? 2 : 1;
	}
		
	}

}
