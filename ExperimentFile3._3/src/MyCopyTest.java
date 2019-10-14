import java.io.File;

public class MyCopyTest {

	public static void main(String[] args) {
		
		MyCopy c = new MyCopy(MyCopy.choicefFile());
		long begantime ;
		long endtime;
		begantime = System.currentTimeMillis();
		if(c.copy(MyCopy.choicetFileDir())) {
			endtime = System.currentTimeMillis();
			System.out.println("”√ ±£∫" + (endtime - begantime) + "ms");
			c.show();
		}else {
			System.out.println("∏¥÷∆ ß∞‹£°£°£°");
		}

	}

}

