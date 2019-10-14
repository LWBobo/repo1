import java.util.Random;
public class MergeSort {
	public static void main(String[] args) {
		mergeSort.test();
	}
public static class mergeSort {
    public static void merge(int []a,int left,int mid,int right){
        int []tmp=new int[a.length];
        int p1=left,p2=mid+1,k=left;

        while(p1<=mid && p2<=right){
            if(a[p1]<=a[p2])
                tmp[k++]=a[p1++];
            else
                tmp[k++]=a[p2++];
        }
        while(p1<=mid) tmp[k++]=a[p1++];
        while(p2<=right) tmp[k++]=a[p2++];
        for (int i = left; i <=right; i++) 
            a[i]=tmp[i];
    }
    public static  void mergeSort(int [] a,int start,int end){
        if(start<end){
            int mid=(start+end)/2;
            mergeSort(a, start, mid);
            mergeSort(a, mid+1, end);
            merge(a, start, mid, end);
        }
    }
    public static void test(){
        int[] a  = new int[20];
        for (int i = 0; i < 20; i++) {
			a[i] = new Random().nextInt(100);
		}
        System.out.println("ÅÅÐòÇ°£º");
        for (int e : a)
            System.out.print(e+" ");
        System.out.println();
        mergeSort(a, 0, a.length-1);
        System.out.println("ÅÅÐòºó£º");
        for (int e : a)
            System.out.print(e+" ");
    }
}
}