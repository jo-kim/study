package Lv4;

import java.util.Random;

public class ex03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * # �ߺ����� ����[2�ܰ�]
		 * 1. arr�迭�� 1~10 ������ ���� ���� 5���� �����Ѵ�.
		 * 2. �� �ߺ��Ǵ� ���ڰ� ����� �Ѵ�.
		 */
		
		Random rn = new Random();
		int arr[] = new int[5];
		
		for (int i = 0; i < 5; i++) {
			int r = rn.nextInt(10) + 1;
			arr[i] = r;
			int check = 1;
			for (int j = 0; j < i; j++) {
				if (arr[j] == r)
					check = -1;
			}
			if (check == 1)
				arr[i] = r;
			else
				i--;
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
