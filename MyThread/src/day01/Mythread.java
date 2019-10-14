package day01;

public class Mythread {
	public static void main(String[] args) {
		Tv tv = new Tv();
		new Player(tv).start();
		new Wataher(tv).start();
	}

}

class Player extends Thread{
	Tv tv;
	
	public Player(Tv tv) {
		this.tv = tv;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			if(i % 2 == 0) {
				this.tv.play("奇葩说");
			}else {
				this.tv.play("圆桌派");
			}
		}
	}
}

class Wataher extends Thread{
	Tv tv;

	public Wataher(Tv tv) {
		this.tv = tv;
	}
	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			this.tv.watch();
		}
	}
	
}

class Tv{
	String voice;

	boolean flag = true;
	
	public synchronized void play(String voice) {
		if(!flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.voice = voice;
		System.out.println("表演了：" + voice);
		this.flag = !this.flag;
		this.notifyAll();
	}
	
	public synchronized void watch() {
		if(flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("观看了：" + voice);
		this.flag = !this.flag;
		this.notifyAll();
	}
	
}