package Lv4;

import java.util.Scanner;

public class ex01 {

	public static void main(String[] args) {
		/*
		 * # �ִ밪 ���ϱ�
		 * 1. ���� ū ���� ã�� �Է��Ѵ�.
		 * 2. �����̸� �ش� ���� 0���� �����Ѵ�.
		 * 3. arr�迭�� ��� ���� 0���� ����Ǹ� ���α׷��� ����ȴ�.
		 * ��)
		 * 11, 87, 42, 100, 24
		 * �Է� : 100
		 * 
		 * 11, 87, 42, 0, 24
		 * �Է� : 87
		 * 
		 * 
		 * 11, 0, 42, 0, 24
		 */
	        Scanner sc =new Scanner(System.in);
			int[] arr = {11, 87, 42, 100, 24};
			int cnt = 0;
			int idx = 0;
			
			while(true) {
				for(int i=0; i<arr.length; i++) {
					System.out.print(arr[i]+" ");
				}
				int max = 0;
				for(int i=0; i<arr.length; i++) {
					if(arr[i]>max) {
						max = arr[i];
						idx = i;
					}
				}
				System.out.print("num : ");
				int num = sc.nextInt();
				if(num == max) {
					arr[idx] = 0;
					cnt++;
				}
				if(cnt == 5) {
					System.out.println("GAME CLEAR");
					break;
				}
			}
	}

}
