package Lv4;

public class ex07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * # �����ϱ�
		 * 1. �ε��� 0���� �������� �˻��Ѵ�.
		 * 2. ���� ū ���� ã�� ��ȯ�Ѵ�.
		 * 3. �ε��� 1�����Ѵ�.
		 * 4. [1~3]�� ������ �ݺ��Ѵ�.
		 * ��)
		 * 10, 50, 30, 40, 80, 7
		 * 80, 50, 30, 40, 10, 7
		 * 80, 50, 30, 40, 10, 7
		 * 80, 50, 40, 30, 10, 7
		 */
		
		int[] score = {10, 50, 30, 40, 80, 7};
		
		for(int i=0; i<score.length; i++) {
			System.out.print(score[i]+" ");
		}
		System.out.println();
		for(int i=0; i<score.length; i++) {
			int max = score[i];
			int idx = i;
		for(int j=i; j<score.length; j++) {
			if(max < score[j]) {
				max = score[j];
				idx = j;
			}
		}
		int temp = score[i];
		score[i] = score[idx];
		score[idx]  = temp;
		
		for(int k=0; k<score.length; k++) {
			System.out.print(score[k]+" ");
		}
		System.out.println();
		}
	}

}
