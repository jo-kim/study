package Lv4;

import java.util.Scanner;

public class ex06 {

	public static void main(String[] args) {
	
		/*
		 * # ATM[4�ܰ�] : ��ü ��ɱ���
		 * 1. ȸ������
		 * . id�� pw�� �Է¹޾� ����
		 * . ���� �� �� 1000�� �ο�
		 * . id �ߺ�üũ
		 * 2. ȸ��Ż��
		 * . �α��νÿ��� �̿밡��
		 * 3. �α���
		 * . id�� pw�� �Է¹޾� �α���
		 * . �α׾ƿ� ���¿����� �̿밡��
		 * 4. �α׾ƿ�
		 * . �α��νÿ��� �̿밡��
		 * 5. �Ա�
		 * . �α��νÿ��� �̿밡��
		 * 6. ��ü
		 * . �α��νÿ��� �̿밡��
		 * 7. �ܾ���ȸ
		 * . �α��νÿ��� �̿밡��
		 */
			
				Scanner sc = new Scanner(System.in);
				int MAX = 5;
				int[] arId = new int[MAX];
				int[] arPw = new int[MAX];
				int[] arMoney = new int[MAX];
				int cnt = 0;
				int log = -1;
				
				String menu = "=== ATM ===\n";
				menu += "1.ȸ������\n2.ȸ��Ż��\n3.�α���\n4.�α׾ƿ�\n";
				menu += "5.�Ա�\n6.��ü\n7.�ܾ���ȸ\n0.����";
				while(true) {
					if(cnt!=0) {
						for(int i=0; i<cnt; i++) {
						System.out.printf("%d : %d : %d��\n",arId[i],arPw[i],arMoney[i]);
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
						System.out.printf("Money : %d��\n",arMoney[log]);
					}
				}
				else if(sel==0) {
					System.out.println("Bye -");
					break;
				}
				}
				
	}

}
