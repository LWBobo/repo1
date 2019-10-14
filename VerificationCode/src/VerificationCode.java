import java.util.*;
public class VerificationCode {

	public static void main(String[] args) {
		Random num = new Random();
		System.out.printf("生成的验证码：%d",(num.nextInt(9)+1)*1000 + num.nextInt(10)*100+num.nextInt(10)*10+num.nextInt(10));

	}

}
