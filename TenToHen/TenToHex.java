import java.util.Scanner;

public class TenToHex{
	public static void main(String [] args) {
		System.out.println("dfhfgh");
		Scanner iput = new Scanner(System.in); 
		int num = iput.nextInt();
		String str1 = TTH(num);
		System.out.println(str1);
	
	}


public static String TTH(int num) {
	String str = "";
	int ss;
		while(num != 0) {
			ss = num %16;
			if(ss >= 10) {
				str = (char)(ss - 10 + 'A') + str;
			}
			else {
				str = ss + str;
			}
		 num /= 16;
		}
	return str;
}


}