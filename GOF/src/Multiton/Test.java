package Multiton;

public class Test {
	public static void main(String[] args) {
//		for(int i = 0 ; i < 10 ; i++) {
//			Money m = Money.getInstance();
//			System.out.println(m);
//		}
			
		
		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					Money m = Money.getInstance_safe();
					System.out.println(m);
					
				}
			}).start();
		}
		
	}
}
