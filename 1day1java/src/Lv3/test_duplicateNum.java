package Lv3;

import java.util.Random;

public class test_duplicateNum {

	public static void main(String[] args) {
		/*
		 * # �ߺ����� ����[1�ܰ�]
		 * 1. 0~4 ������ ���ڸ� arr�迭�� �����Ѵ�.
		 * 2. ��, �ߺ��Ǵ� ���ڴ� ����� �Ѵ�.
		 * ��Ʈ) ���� ���ڸ� check�迭�� �ε����� Ȱ���Ѵ�.
		 * 
		 * ��)
		 * �������� : 1
		 * check = {0, 1, 0, 0, 0}
		 * arr   = {1, 0, 0, 0, 0}
		 * �������� : 3
		 * check = {0, 1, 0, 1, 0}
		 * arr   = {1, 3, 0, 0, 0}
		 * �������� : 2
		 * check = {0, 1, 1, 1, 0}
		 * arr   = {1, 3, 2, 0, 0}
		 */
		Random rn = new Random();
		
		int[] check = new int[5];
		int[] arr = new int[5];
		
		for(int i=0; i<arr.length; i++) {
			int r = rn.nextInt(5);
			arr[i] = r;
			if(check[r] == 0) {
				check[r] = 1;
			}
			else 
				i--;
		}
		
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		
	}
	

}
