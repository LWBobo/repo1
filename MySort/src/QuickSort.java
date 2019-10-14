import java.util.ArrayList;
import java.util.Random;

public class QuickSort {
	
	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		Random ran = new Random();
		for(int i = 0 ; i < 20 ; ++i) {
			arr.add(ran.nextInt(100));
		}
		System.out.println("ÅÅÐòÇ°£º");
		for (int i = 0; i < arr.size(); i++) {
			System.out.print(+arr.get(i) + " " );
		}	
		System.out.println();
		quickSort(arr, 0, 19);
		System.out.println("ÅÅÐòºó£º");
		for (int i = 0; i < arr.size(); i++) {
			System.out.print(+arr.get(i) + " " );
		}	
	}
	public static void quickSort(ArrayList<Integer> arr,int low,int high) {
		int begin = low;
		int end = high;
		int temp = arr.get(low);
		if(low <0 || high > arr.size()) {
			return;
		}
		if(begin > end) {
			return;
		}
		while(begin < end) {
			while(end > begin && arr.get(end) >= temp) {
				end--;
			}
			while(begin < end && arr.get(begin) <= temp) {
				begin++;
			}
			if(begin < end) {
				int num = arr.get(end);
				arr.set(end, arr.get(begin));
				arr.set(begin, num);
			}		
		}
		arr.set(low, arr.get(begin));
		arr.set(begin, temp);
		temp = end;
		quickSort(arr, low, temp - 1);
		quickSort(arr, temp + 1, high);
//		try {
//			quickSort(arr, low, temp - 1);
//			quickSort(arr, temp + 1, high);
//		}catch (Exception e) {
//		}	
	}
}
