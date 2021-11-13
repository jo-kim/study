package Lv4;

import java.util.Scanner;

public class ex06 {

	public static void main(String[] args) {
	
		/*
		 * # ATM[4단계] : 전체 기능구현
		 * 1. 회원가입
		 * . id와 pw를 입력받아 가입
		 * . 가입 시 돈 1000원 부여
		 * . id 중복체크
		 * 2. 회원탈퇴
		 * . 로그인시에만 이용가능
		 * 3. 로그인
		 * . id와 pw를 입력받아 로그인
		 * . 로그아웃 상태에서만 이용가능
		 * 4. 로그아웃
		 * . 로그인시에만 이용가능
		 * 5. 입금
		 * . 로그인시에만 이용가능
		 * 6. 이체
		 * . 로그인시에만 이용가능
		 * 7. 잔액조회
		 * . 로그인시에만 이용가능
		 */
			
				Scanner sc = new Scanner(System.in);
				int MAX = 5;
				int[] arId = new int[MAX];
				int[] arPw = new int[MAX];
				int[] arMoney = new int[MAX];
				int cnt = 0;
				int log = -1;
				
				String menu = "=== ATM ===\n";
				menu += "1.회원가입\n2.회원탈퇴\n3.로그인\n4.로그아웃\n";
				menu += "5.입금\n6.이체\n7.잔액조회\n0.종료";
				while(true) {
					if(cnt!=0) {
						for(int i=0; i<cnt; i++) {
						System.out.printf("%d : %d : %d원\n",arId[i],arPw[i],arMoney[i]);
						}
					}
					System.out.println(menu);
				int sel = sc.nextInt();
				if(sel==1 && cnt<MAX) {
					if(cnt == MAX) {
						System.out.println("Max account is Five");
					}
					if(log==-1) {
						System.out.print("[Sign-Up] ID: ");
						int id = sc.nextInt();
						System.out.print("[Sign-Up] PW: ");
						int pw = sc.nextInt();
						int check = 1;
						
						for(int i=0; i<arId.length; i++) {
							if(id == arId[i]) {
								check = -1;
							}
						}
						if(check != -1) {
							arId[cnt] = id;
							arPw[cnt] = pw;
							arMoney[cnt] = 1000;
							cnt++;
						}
						else {
							System.out.println("Sorry, ID is already in use.");
						}
					}
					else {
						System.out.println("Logout first");
					}
				}
				else if(sel==2) {
					if(log==-1) {
						System.out.println("Login first");
					}
					else {
						System.out.print("[Sign-Out] Pw: ");
						int pw = sc.nextInt();
						if(arPw[log] == pw) {
							for(int i=log; i<cnt-1; i++) {
								arId[i] = arId[i+1];
								arPw[i] = arPw[i+1];
								arMoney[i] = arMoney[i+1];
							}
							arId[cnt-1] = 0;
							arPw[cnt-1] = 0;
							arMoney[cnt-1] = 0;
							cnt--;
							log = -1;
							System.out.println("Complete");
						}
					}
				}
				else if(sel==3) {
					if(log==-1) {
						System.out.print("[Login] Id: ");
						int id = sc.nextInt();
						System.out.print("[Login] Pw: ");
						int pw = sc.nextInt();
						
						for(int i=0; i<cnt; i++) {
							if(arId[i] == id && arPw[i] == pw) {
								log = i;
							}
						}
						if(log !=-1) {
							System.out.println("[Login] Complete");
						}
						else {
							System.out.println("Wrong Information");
						}
					}
					else {
						System.out.println("Logout first");
					}
				}
				else if(sel==4) {
					if(log!=-1) {
						System.out.println("[Logout] Complete");
						log = -1;
					}else {
						System.out.println("Login First");
					}
				}
				else if(sel==5) {
					if(log ==-1) {
						System.out.println("Login First");
					}else {
						System.out.print("Input Money : ");
						int cash = sc.nextInt();
						if(cash>0) {
							arMoney[log] += cash;
							System.out.println("Complete");
						}
						else {
							System.out.println("Please, check your money");
						}
					}
				}
				else if(sel==6) {
					if(log ==-1) {
						System.out.println("Login First");
					}else {
						System.out.print("[Withdrawal] Id : ");
						int id =sc.nextInt();
						int check = -1;
						for(int i=0; i<cnt; i++) {
							if(id == arId[i] && i!=log) {
								check = i;
							}
						}
						if(check != -1) {
							System.out.print("[Withdrawal] money : ");
							int cash = sc.nextInt();
							if(cash>0 && arMoney[log]>=cash) {
								arMoney[log] -= cash;
								arMoney[check] += cash;
								System.out.println("Complete");
							}
							else {
								System.out.println("Please, check your money");
							}
						}
						else {
							System.out.println("Wrong Information");
						}
					}
				}
				else if(sel==7) {
					if(log ==-1) {
						System.out.println("Login First");
					}else {
						System.out.printf("Money : %d원\n",arMoney[log]);
					}
				}
				else if(sel==0) {
					System.out.println("Bye -");
					break;
				}
				}
				
	}

}
