package 人民币转大写;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class RMB {
	String count;

	public RMB(String count) {
		this.count = count;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}
	public void RmbToUper() {
		  Map<Long , String> map = new TreeMap<Long, String>();
			ArrayList<String> arr = new ArrayList<String>();
			map.put(1L, "壹");map.put(2L, "贰");map.put(3L, "叁");map.put(4L, "肆");map.put(5L, "伍");map.put(6L, "陆");map.put(7L, "柒");
			map.put(8L, "八");map.put(9L, "久");map.put(0L, "零");
			arr.add("");arr.add("");arr.add("百");arr.add("千");arr.add("万");arr.add("亿");
			String unit[] = {"十","百","千"};
			
			int a;
			StringBuffer uper = new StringBuffer();
			String []nums = null;
			 if(( a =count.indexOf(".")) > 0) {
				  System.out.println(a);
				 nums = count.split("\\.");
			 }
			if(nums[0] != null) {
				String s = nums[0];
				System.out.println(s);
				long num1 = Long.parseLong(s);
				int len = calclen(num1);
				System.out.println("len:" + len);
				int row = len / 4;
				System.out.println("row:" + row);
				int begin = len%4;
				System.out.println("begin:" + begin);
				
			for(int i = 0 ; i < nums[0].length() ; i++) {
				uper.append(map.get(Long.parseLong(s.substring(i, i+1))));
				if(begin == 0 && i== 0) { //????4?????λ
					begin = 4;
					uper.append(arr.get(begin));
					begin --;
				}else {
					if(begin == 1 ) {
						if(len > 4) {
						uper.append(unit[len/4 -1]);
						}
						begin = 4;
					}else if (begin != 1){
						uper.append(arr.get(begin));
						begin --;
					}
				}
				
			len --;	
			}
			}
			uper.append("元");
			if(nums[1] != null) {
				String ss[] = {"角","分"};
				String s = nums[1];
				for(int i = 0 ; i < nums[1].length() ; i++) {
					uper.append(map.get(Long.parseLong(s.substring(i, i+1))));
					uper.append(ss[i]);
				}
				
			}
				System.out.println(uper.toString());
	}
	
	public int calclen(long num1) {
		int len = 0;
		while(num1 >0) {
			len++;
			num1 = num1 / 10;
		}
		return len;
	}
	
}
