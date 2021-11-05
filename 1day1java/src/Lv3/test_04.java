package Lv3;

import java.util.Scanner;

public class test_04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[] = {0,2,0,3,4,0,0,5,0};
		int left[] = new int[arr.length];
		int right[] = new int[arr.length];
		// 아래 번호를 입력받고 각방향 으로 0 이아닌숫자를 모으시요.
		// 1)left 2)right 
		
		// 예) 1) left ==> arr = {2,3,4,5,0,0,0,0,0};
		// 예) 1) right ==> arr = {0,0,0,0,0,2,3,4,5};
		
		
		System.out.print("[1]LEFT [2]RIGHT  ");
		int sel = sc.nextInt();
		if (sel == 1) {
			int idx = 0;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] != 0) {
					left[idx] = arr[i];
					idx++;
				}
			}

			for (int i = 0; i < left.length; i++) {
				System.out.print(left[i] + " ");
			}
		} else if (sel == 2) {
			int idx = 0;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == 0) {
					idx++;
				}
			}
			int j = idx;
			for (int i = 0; i < right.length; i++) {
				if (arr[i] != 0) {
					right[j] = arr[i];
					j++;
				}
			}
			for (int i = 0; i < right.length; i++) {
				System.out.print(right[i] + " ");
			}
		}

	}

}
