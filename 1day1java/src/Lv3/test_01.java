package Lv3;

public class test_01 {

	public static void main(String[] args) {
		// for�� ����ؼ� Ǯ�����
		// ����4) 50���� 100���� �ڿ����߿��� 9�� ����� ������ ��� # �� : 6 (54,63,72,81,90,99)
		int cnt = 0;
		for(int i=50; i<=100; i++) {
			if(i%9==0)
				cnt++;
		}
		System.out.println(cnt +"��");
		// ����5) 28�� ��� �߿��� ���� ū ���ڸ� ���� ��� ==> �� : 980
		int max = 0;
		for(int i=1; i<1000; i++) {
			if(i%28==0) {
				if(i>max)
					max = i;
			}
		}
		System.out.println(max);
		
		// ����6) 8�� ����� ���������� 5�� ��� ==> �� : 0,8,16,24,32
		cnt = 0;
		for(int i=0; i<100; i++) {
			if(i%8==0) {
				cnt++;
			if(cnt<=5) {
					System.out.println(i);
				}
			}
			
		}
		
		
	}

}
