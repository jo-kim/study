package Lv3;

import java.util.Random;
import java.util.Scanner;

public class test_1to4 {

	public static void main(String[] args) {
		/*
		 * #  1 to 4
		 * 1. arr�迭�� 1~4 ������ ���ڸ� �ߺ����� �����Ѵ�.
		 * 2. ����ڴ� 1���� ������� �ش� ��ġ ���� �Է��Ѵ�.
		 * 3. ������ ���߸� �ش� ���� 9�� ����Ǿ� ��� ���� 9�� �Ǹ� ������ ����ȴ�.
		 * ��)
		 * 4 2 3 1
		 * �Է� : 3
		 * 4 2 3 9
		 * �Է� : 1
		 * 4 9 3 9
		 * ...
		 */
		int arr[] = new int[4];
		int check[] = new int[4];
		Random rn = new Random();
		Scanner sc = new Scanner(System.in);
		
		// rn
		for(int i=0; i<arr.length; i++) {
			int r = rn.nextInt(4)+1;
			
			if(check[r-1] == 0) {
				arr[i] = r;
				check[r-1] = 1;
			}
			else i--;
		}
		int cnt = 0;
		int n = 1;
		while (cnt < 4) {
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}

			System.out.print("�Է�: ");
			int num = sc.nextInt() - 1;
			if (arr[num] == n) {
				arr[num] = 9;
				n++;
				cnt++;
			}
		}
		if (cnt == 4) {
			System.out.println("GAME CLEAR");

		}
	}

}
