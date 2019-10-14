import java.util.*;

import javax.swing.JOptionPane;

public class PrintCalendar {
	public static void main(String[] args) {
		Calendar cal =  Calendar.getInstance();
		int year,month;
		int flag = 0;
		int count = 0;
		 String y = JOptionPane.showInputDialog("Please input Year");
		 year = Integer.parseInt(y);
		 String m = JOptionPane.showInputDialog("Please input Month");
		 month = Integer.parseInt(m);	 
		cal.set(year,month-1,1);
		System.out.printf("%-11s%-11s%-11s%-11s%-11s%-11s%-11s\n","日","一","二","三","四","五","六","");
		for(int i = 0 ; i <= cal.getActualMaximum(Calendar.DAY_OF_MONTH); ++i){
			if(count++%7 == 0) {
				System.out.print("\n");
			}
			if((i < cal.get(Calendar.DAY_OF_WEEK)-1) && flag == 0) {
				System.out.printf("%-4s"," ");
			}else {
				if(flag == 0) {
					i -= i-1;
					flag = 1;
				}
				System.out.printf("%-4d",i
						);
			}
		}
	}
}
