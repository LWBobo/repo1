public class _6{
public static	int Findmaxnum(int []arr) {
		int num = Integer.MIN_VALUE;
		for(int i = 0 ; i < arr.length ; ++i) {
			if(arr[i] > num) {
				num = arr[i];
			}
		}
		return num;
	}
	public static void main(String[] args) {
		int numarr[] = {5,7,1,6,9,12,51,42};
		int num1arr[] = {45,78,65,32,15,65,78,98,145};
		System.out.println("��һ����������ֵΪ��" + Findmaxnum(numarr));
		System.out.println("�ڶ�����������ֵΪ��" + Findmaxnum(num1arr));
	}
}