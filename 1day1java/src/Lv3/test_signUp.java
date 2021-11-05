package Lv3;

import java.util.Scanner;

public class test_signUp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * # 회원가입 
		 * 1. 가입
		 * . 아이디 와 비밀번호를 입력받아 가입
		 * . 아이디 중복검사
		 * 2. 탈퇴
		 * . 아이디 를 입력받아 탈퇴
		 */
		Scanner sc = new Scanner(System.in);
		int[] ids = { 1001, 1002, 0, 0, 0 };
		int[] pws = { 1111, 2222, 0, 0, 0 };
		int cnt = 2;
		while (true) {
			for (int i = 0; i < ids.length; i++) {
				System.out.printf("Id: %d Pw: %d\n", ids[i], pws[i]);
			}
			System.out.println(" ==== 사 이 트 ===");
			System.out.println("[1].Join");
			System.out.println("[2].Leave");
			System.out.print(": ");
			int sel = sc.nextInt();
			if (sel == 1) {
				if (cnt < 5) {
					System.out.print("Id : ");
					int id = sc.nextInt();
					System.out.print("Pw: ");
					int pw = sc.nextInt();

					int check = -1;
					for (int i = 0; i < ids.length; i++) {
						if (id == ids[i]) {
							check = i;
						}
					}
					if (check == -1) {
						ids[cnt] = id;
						pws[cnt] = pw;
						cnt++;
						System.out.println("Sign-Up Complete!");
					} else {
						System.out.println("Sorry, Id is already in use.");
					}
				} else {
					System.out.println("Sorry, Sign-up system is now out of space.");
				}
			} else if (sel == 2) {
				System.out.print("[Delete] Id: ");
				int id = sc.nextInt();
				System.out.print("[Delete] Pw: ");
				int pw = sc.nextInt();
				int check = -1;
				for (int i = 0; i < ids.length; i++) {
					if (id == ids[i] && pw == pws[i]) {
						check = i;
					}
				}
				if (check != -1) {
					for (int i = check; i < cnt - 1; i++) {
						ids[i] = ids[i + 1];
						pws[i] = pws[i + 1];
					}
					ids[cnt - 1] = 0;
					pws[cnt - 1] = 0;
					cnt--;
					System.out.println("Bye, see you again.");

				} else {
					System.out.println("Check your Information");
				}
			}
		}
	}

}
